## Čísla
[Home](../)

Témou druhého cvičenia boli čísla, konkrétne kombinatorika a rôzne aproximácie.

* Prvou úlohou bolo napísať funkcie na generovanie permutácií, variácií a kombinácií. Tieto funkcie sa dali napísať veľmi jednoducho využitím rekurzie. Na funkciu generujúcu kombinácie som využil možnosti jazyka a riešenie som troch "ohackoval". Moje riešenie kombinácií spočívalo v tom, že som si najskôr vygeneroval príslušné variácie (kombinácie sú podmnožinou príslušných variácií), následne som tieto variácie (vo forme reťazcov) abecedne zoradil (v rámci reťazcov) a takýto zoznam zoradených reťazcov som vložil do množiny. Tu som využil skutočnosti, že v množine sa nebudú vyskytovať duplicitné prvky.

```kotlin
fun permutations(numbers: List<Int>): List<String> {
    val result = mutableListOf<String>()
    for (number in numbers) {
        val midResult = permutations(numbers.minus(number))
        if (midResult.isEmpty()) {
            result.add("$number")
        } else {
            midResult.mapTo(result) { "$number$it" }
        }
    }
    return result
}

fun variations(numbers: List<Int>, k: Int, allowRepetition: Boolean): List<String> {
    val result = mutableListOf<String>()
    if (k == 0) {
        return emptyList()
    }
    for (number in numbers) {
        val subList = if (allowRepetition) { numbers } else { numbers.minus(number) }
        val midResult = variations(subList, k - 1, allowRepetition).filter { it.length < k }
        if (midResult.isEmpty()) {
            result.add("$number")
        } else {
            midResult.mapTo(result) { "$number$it" }
        }
    }
    return result
}

fun combinations(numbers:List<Int>, k: Int, allowRepetition: Boolean) = variations(numbers, k, allowRepetition).map(String::sorted).toSet()
```

* Nasledujúca úloha bola vizualizovať Pascalov trojuholník s rôznym ofarbením prvkov. Na tejto úlohe bolo asi najťažšie vymyslieť ako zobrazovať trojuholník v 2D mriežke. Výstupy z tejto podúlohy sa nachádzajú v zložke [`iv122_outputs/assignment2`](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment2)

* 

    
#### Výstup z konsole po spustení jar archívu sa nachádza [tu](./console-output.md)
#### Všetky ostatné obrázky(výstupy) k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment1)
#### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment2)
#### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment2)