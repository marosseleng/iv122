## Komplexné čísla a fraktály
[Home](../)

Ďalšie cvičenie zamerané na fraktály, tentokrát však v súvislosti s komplexnými číslami. 

Hlavná časť úlohy bola o tom napísať funkcie generujúce Mandelbrotovu, Juliovu a Newtonovu množinu. Túto časť som sa snažil spraviť čo najviac generickú a všeobecnú, čo myslím, že sa mi podarilo.

Všetok kód k tejto úlohe som ponechal v jednom súbore, a síce [Fractals.kt](https://github.com/mseleng/iv122/blob/master/src/com/github/mseleng/iv122/assignment7/Fractals.kt). Srdcom mojej implementácie je funkcia `getTask()`:
```kotlin
fun getTask(
        from: Int, to: Int, height: Int,
        computeReal: (Int) -> Double,
        computeImaginary: (Int) -> Double,
        img: BufferedImage,
        getOuterColor: (Int) -> Int,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>,
        colorByComplexResult: (Complex) -> Boolean): Callable<Unit> {

    return Callable {
        for (x in from..to) {
            val real = computeReal(x)
            for (y in height - 1 downTo 0) {
                val newY = height - (y + 1)
                val imaginary = computeImaginary(newY)

                val (complex, steps) = iterate(Complex(real, imaginary))
                if (colorByComplexResult(complex)) {
                    val firstColorRatio = steps / 100.0
                    val secondColorRatio = 1.00 - firstColorRatio
                    val newColor = Color(
                            (firstColorRatio * innerColors.first.red).toInt() + (secondColorRatio * innerColors.second.red).toInt(),
                            (firstColorRatio * innerColors.first.green).toInt() + (secondColorRatio * innerColors.second.green).toInt(),
                            (firstColorRatio * innerColors.first.blue).toInt() + (secondColorRatio * innerColors.second.blue).toInt())
                    img.setRGB(x, y, newColor.rgb)
                } else {
                    img.setRGB(x, y, getOuterColor(steps))
                }
            }
        }
        Unit
    }
}
```
táto funkcia vracia 'Task'. Task je v mojom ponímaní úloha vykresliť určitú časť fraktálu. Táto funkcia konkrétne vracia javovský objekt `Callable` a to z dôvodu jeho využitia pri paralelnej implementácii. Táto funkcia má viac parametrov:
  - `from, to, height` označujú, akú časť obrázku má tento Task vyplniť
  - `computeReal, computeImaginary` sú funkcie, ktoré prevádzajú súradnice z Karteziánskeho systému do komplexných čísel
  - `img` je obrázok, ktorý sa bude vytvárať
  - `getOuterColor` je funkcia, ktorá vráti `rgb` farby, ktorou sa má zafarbiť bod s danou vlastnosťou (typicky počet krokov na tzv. escape)
  - `innerColors` pár farieb, ktoré sa použijú na vyplnenie vnútra (interpoláciou)
  - `iterate` iteračná funkcia pre daný typ fraktálu
  - `colorByComplexResult` funkcia, ktorá bola pridaná kvôli Newtonovmu fraktálu; táto funkcia vráti hodnotu `true`/`false` podľa toho, či chceme fraktál ofarbovať podľa počtu krokov na tzv. escape (pre Newtonov fraktál vracia vždy `false`)
  
  
Keďže som si ako rozšírenie základnej funkčnosti vybral zvýšenie rýchlosti generovania obrázkov, chcem predstaviť svoj nápad:

V mojej implementácii sa spolieham na paralelizmus tak, že každé vlákno, ktoré vytvorím ma dopredu určený rozsah v obrázku, ktorý bude napĺňať. Pre rozdelenie práce som sa rozhodol rozdeliť výsledný obrázok na n častí s rovnakou výškou (n je počet vytvorených vláken) tak, že každé vlákno bude pristupovať len do tejto časti.


Vstupným bodom do mojej paralelnej implementácie je funkcia `fractal()`:
```kotlin
fun fractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1,
        colorByComplexResult: (Complex) -> Boolean = { c -> c.re != Double.NaN && c.im != Double.NaN && c.abs() < 2.0 },
        iterate: (Complex) -> Pair<Complex, Int>): BufferedImage {

    // this is the minimum (number of threads) we may use (this make the computation as parallel as possible)
    val availableCores = Runtime.getRuntime().availableProcessors()

    // computing the real amount of thread needed 750_000 was chosen by the real experience
    var threadsNeeded = availableCores
    while (height * width / threadsNeeded > 750_000) {
        threadsNeeded++
    }

    val actualThreads = if (autoBalance) {
        maxOf(availableCores, threadsNeeded)
    } else {
        numOfThreads
    }
    return if (numOfThreads == 1) {
        singleThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate, colorByComplexResult)
    } else {
        multiThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate, colorByComplexResult, actualThreads)
    }
}
```
Táto funkcia má opäť viac parametrov, ale keďže väčšina z nich má rovnakú úlohu ako rovnomenné parametre vo funkcii `getTask()` popísanej vyššie, popíšem len nové parametre:
  - `autoBalance, numOfThreads` prvý parameter je `boolean` a hovorí, či si prajeme nechať program, aby záťaž vybalansoval automaticky; druhý parameter je počet vlákien, ktoré sa majú vytvoriť za predpokladu, že prvý parameter je `false`
  
Funkcia `fractal()` slúži ako "load balancer", ktorý rozhoduje koľko vláken bude vytvorených tak, aby bola práca vykonaná čo najrýchlejšie a bez zbytočného overheadu (napr. pri vytvorení príliš veľkého množstva vláken).
Konštanta `750_000`, ktorá sa v programe používa bola určená ako najoptimálnejšia pre moju konfiguráciu.
Ďalej je vidno, že podľa toho, či bude výpočet prebiehať na jednom alebo viacerých vláknach, sa volajú dve rôzne funkcie:
  - `singleThreadFractal()` je funkcia, ktorá neobsahuje vytváranie Thread pool-u (pre jedno vlákno nie je nutné, funkcia použije hlavné vlákno) a s tým spojenú pamäťovú náročnosť``
  - `multiThreadFractal()` obsahuje už samotnú paralelnú implementáciu, tj. stará sa o vytvorenie daného počtu vlákien a o generovanie samotné
  
Nižšie uvádzam tabuľku s prehľadom, koľko času trvalo generovanie toho istého obrázka na jednom vlákne a potom na dvoch, štyroch a ôsmych:

| threads\size | 300x200 | 900x600 | 1500x1000 | 3000x2000 | 6000x4000 |
|--------------|---------|---------|-----------|-----------|-----------|
| **1**        | 861     | 4195    | 11268     | 44522     | 177340    |
| **2**        | 582     | 2556    | 7499      | 29184     | 114729    |
| **4**        | 406     | 2299    | 6240      | 24854     | 99169     |
| **8**        | 328     | 1824    | 4841      | 18905     | 77086     |

Čas uvedený v tabuľke nezahŕňa ukladanie obrázku na disk.

Z tabuľky je vidieť, že pri použití štyroch vláken namiesto jedného sa podarilo potrebný čas zredukovať takmer na polovicu.

Konfigurácia, na ktorej program bežal má dvojjadrový procesor, ktorý podporuje Hyper-threading, kde každé fyzické jadro zvládne naraz spracovávať dve vlákna. Tomuto odpovedajú aj dosiahnuté výsledky. Používanie väčšieho počtu vláken už neprinášalo dobré výsledky, pretože sa zvyšoval čas potrebný na samotné spravovanie vláken.

###### Toto použitie paralelizmu umožnilo "stiahnuť" čas potrebný na vygenerovanie obrázkov v zložke `iv122_outputs/assignment7` (okrem gif-ov) takmer o tretinu, z 50 minút na 35.



povedat, ze na pouzitie autobalancovania skratilo cas generovania tych obrazkov, co mam ulozene (okrem gifov) skoro o tretinu. 50 -> 35

##### Výstup z konsole po spustení jar archívu sa nachádza [tu](./console-output.md)
##### Všetky ostatné obrázky(výstupy) k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment7)
##### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment7)
##### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment7)