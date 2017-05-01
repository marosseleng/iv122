## Lineárna algebra a transformácie v 2D
[Home](../)

Táto úloha bola zameraná na pochopenie a implementáciu transformovania rovinných útvarov pomocou matíc.

V prvej časti som naimplementoval lineárne transformácie. Vytvoril som [`typealias Transformation`](https://github.com/mseleng/iv122/blob/master/src/com/github/mseleng/iv122/assignment8/TransformationUtil.kt):

```kotlin
typealias Transformation = Array<Triple<Double, Double, Double>>
```
tento alias reprezentuje maticu 3x3, ktorá predstavuje transformáciu v rovine. Následne som implementoval funkcie, ktoré generujú niektoré bežné transformácie:

```kotlin
fun identity(): Transformation {
    return arrayOf(
            Triple(1.0, 0.0, 0.0),
            Triple(0.0, 1.0, 0.0),
            Triple(0.0, 0.0, 1.0))
}

fun rotation(angle: Double): Transformation {
    val angleRads = Math.toRadians(angle)
    val cos = Math.cos(angleRads)
    val sin = Math.sin(angleRads)
    return arrayOf(
            Triple(cos, -sin, 0.0),
            Triple(sin,  cos, 0.0),
            Triple(0.0,  0.0, 1.0))
}

fun translation(target: Coordinates): Transformation {
    return arrayOf(
            Triple(1.0, 0.0, target.x),
            Triple(0.0, 1.0, target.y),
            Triple(0.0, 0.0,      1.0))
}

fun scaling(newWidth: Double, newHeight: Double): Transformation {
    return arrayOf(
            Triple(newWidth,       0.0, 0.0),
            Triple(     0.0, newHeight, 0.0),
            Triple(     0.0,       0.0, 1.0))
}
```

Súbor [`TransformationUtils.kt`](https://github.com/mseleng/iv122/blob/master/src/com/github/mseleng/iv122/assignment8/TransformationUtil.kt) obsahuje aj ďalšie pomocné funkcie, napr. funkciu pre násobenie matíc, resp. rôzne preťažené funkcie na násobenie matice s bodom.

Funkčnosť týchto funkcií som si overil vygenerovaním niekoľkých obrázkov:

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment8/spiral.svg"><img src="../iv122_outputs/assignment8/spiral.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/spiral-2.svg"><img src="../iv122_outputs/assignment8/spiral-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/squares.svg"><img src="../iv122_outputs/assignment8/squares.svg" width="22%"/></a>
</div>


V druhej časti som implementoval systém MRCM:

```kotlin
class Wrapper(val lines: List<Line>)

typealias WrapperApplication = (Wrapper) -> List<Wrapper>

class MRCM(initialWrapper: Wrapper, val offset: Coordinates, val application: WrapperApplication) {
    var current = listOf(initialWrapper)

    fun apply(n: Int): List<Line> {
        n.timesRepeat {
            current = current.flatMap(application)
        }
        return current.flatMap(Wrapper::lines).offsetTo(offset)
    }
}
```

V tomto systéme som videl podobnosť s L-systémami z predchádzajúcich úloh v tom, že je treba jednotlivé obrazce paralelne "prepisovať", respektíve ich nahrádzať novými. Vyššie je uvedená trieda MRCM, ktorá slúži na prácu s týmto systémom. Konštruktor tejto triedy má tri parametre:
  - `initialWrapper` tzv. wrapper (predstavuje jeden obrazec, alebo množinu hrán, ktoré tento obrazec definujú), ktorým sa generovanie začína
  - `offset` smer, ktorým sa po generovaní posunú všetky body (z dôvodu prevodu klasického karteziánskeho systému na ten obrazovkový)
  - `application` je funkcia, ktorá popisuje, aký útvar/útvary vzniknú z aktuálneho
  
Bohužiaľ, nepodarilo sa mi vygenerovať zložitejšie obrázky (hviezdu, alebo papradie), kvôli problému, ktorý sa mi nepodarilo identifikovať. Aj napriek korektne zadaným maticiam transformácii (zo slajdov), generovaný obrázok nevyzeral ako žiadúci.

Nasledujú niektoré obrázky, ktoré som pomocou MRCM vygeneroval:

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment8/christmas-tree.svg"><img src="../iv122_outputs/assignment8/christmas-tree.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/dragon.svg"><img src="../iv122_outputs/assignment8/dragon.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/sierpinski.svg"><img src="../iv122_outputs/assignment8/sierpinski.svg" width="22%"/></a>
</div>

Niektoré príbuzného Sierpinského:

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment8/sierpinski-2.svg"><img src="../iv122_outputs/assignment8/sierpinski-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/sierpinski-4.svg"><img src="../iv122_outputs/assignment8/sierpinski-4.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment8/sierpinski-5.svg"><img src="../iv122_outputs/assignment8/sierpinski-5.svg" width="22%"/></a>
</div>

##### Výstup z konsole po spustení jar archívu sa nachádza [tu](./console-output.md)
##### Všetky ostatné obrázky(výstupy) k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment8)
##### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment8)
##### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment8)