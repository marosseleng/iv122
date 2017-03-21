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

* Ďalšou úlohou bolo napísať funkciu na približné umocňovanie. Ja som implementoval len metódu, ktorá racionálny exponent zapíše v tvare zlomku a následne odmocňuje. Funkciu n-tej odmocniny som implementoval pomocou bisekcie:

```kotlin
fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double {
    val mid: Double = from.plus(to).div(2)
    val midValidated = validate(mid)
    if (midValidated.isAlmostEqual(num, eps)) {
        return mid
    } else if (midValidated < num) {
        return bisection(num, mid.plus(eps), to, eps, validate)
    } else {
        return bisection(num, from, mid.minus(eps), eps, validate)
    }
}

fun nthRoot_approx_bisection(num: Double, order: Long, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.0001)
        = bisection(num, from, to, eps) { it.integralPow(order) }

fun rationalPower_1(base: Double, exp: Double): Double {
    if (exp.isWhole()) {
        return base.integralPow(exp.toLong())
    } else {
        val (int, frac) = exp.toFraction().toDecimalFraction()
        return base.integralPow(int) * (nthRoot_approx_bisection(base.integralPow(frac.part), frac.whole))
    }
}
```
Tieto funckie sa nachádzajú v súbore [`NumberUtils.kt`](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/util/NumberUtils.kt), respektíve [`C.kt`](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment2/C.kt) a ich dokumentácia je [tu](../javadoc/iv122/com.github.mseleng.iv122.util), respektíve [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment2)

* Poslednou úlohou bolo napísať funkcie na aproximáciu čísla π; Pre mňa bola najzaujímavejšia Archimedova aproximácia a to hlavne z dôvodu, že Archimedes dokázal pomerne presne určiť hodnotu π bez použitia akýchkoľvek moderných vynálezov. Táto metóda spočíva v tom, že kružnicu najskôr opíšeme štvorcom s dĺžkou hrany 1 a vpíšeme do nej ďalší štvorec tak, že vrcholy vnútorného budú v poloviciach hrán opísaného štvorca. Takto vieme povedať, že obvod kružnice bude niekde medzi obvodom vonkajšieho a vnútorného štvorca (polygónu).

```kotlin
fun pi_Archimedes(interval_ms: Long, sqrt: (Double) -> Double): ArchimedesπRange {
    val sqrtOfPointFive = sqrt(0.5)
    var currentSides = 4
    var currentInscribed = currentSides.times(sqrtOfPointFive)
    var currentCircumscribed = currentSides.times(1.0)
    val startTime = System.currentTimeMillis()
    do {
        val circumscribed = 2.times(currentInscribed).times(currentCircumscribed)
                .div(currentInscribed.plus(currentCircumscribed))
        val inscribed = sqrt(currentInscribed.times(circumscribed))
        currentCircumscribed = circumscribed
        currentInscribed = inscribed
        currentSides = currentSides.times(2)
    } while (System.currentTimeMillis() - startTime <= interval_ms)
    return ArchimedesπRange(currentInscribed, currentCircumscribed)
}
```
##### Výstup z konsole po spustení jar archívu sa nachádza [tu](./console-output.md)
##### Všetky ostatné obrázky(výstupy) k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment2)
##### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment2)
##### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment2)