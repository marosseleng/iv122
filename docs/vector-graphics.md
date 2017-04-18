## Vektorová grafika
[Home](../)

Témou tretej úlohy bola jednoduchá vektorová grafika, hlavne práca s tzv. želví grafikou.

V prvej časti bolo za úlohu vytvoriť jednoduchú knižnicu na prácu s "želví" grafikou. Pre tento účel som si vytvoril triedu [`Turtle`](../javadoc/iv122/com.github.mseleng.iv122.util/-turtle).

Zvyšok úlohy pozostával z vykreslenia niekoľkých obrazcov a fraktálov. Niektoré výstupy sú zobrazené nižšie. Výstupy, ktoré nie sú zobrazené tu je možné nájsť na [GitHube](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment3) alebo si ich vygenerovať lokálne spustením dostupného jar archívu.

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment3/nested-square-2.svg"><img src="../iv122_outputs/assignment3/nested-square-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/nested-square-3.svg"><img src="../iv122_outputs/assignment3/nested-square-3.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/nested-triangle-2.svg"><img src="../iv122_outputs/assignment3/nested-triangle-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/flower.svg"><a href="../iv122_outputs/assignment3/flower.svg"><img src="../iv122_outputs/assignment3/flower.svg" width="22%"/></a>
</div>

Jednoduché fraktály vykreslené pomocou "želví" grafiky:

  - Kochova vločka (hĺbka zanorenia postupne: 1, 3, 5): 

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment3/koch-flake-1.svg"><img src="../iv122_outputs/assignment3/koch-flake-1.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/koch-flake-3.svg"><img src="../iv122_outputs/assignment3/koch-flake-3.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/koch-flake-5.svg"><img src="../iv122_outputs/assignment3/koch-flake-5.svg" width="22%"/></a>
</div>

```kotlin
fun flake(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(50, 100))
    flakeRecursive(turtle, 100.0, depth)
    turtle.right(120.0)
    flakeRecursive(turtle, 100.0, depth)
    turtle.right(120.0)
    flakeRecursive(turtle, 100.0, depth)
    return turtle.lines
}

fun flakeRecursive(turtle: Turtle, d: Double, depth: Int) {
    if (depth == 1) {
        turtle.forward(d)
        turtle.left(60.0)
        turtle.forward(d)
        turtle.right(120.0)
        turtle.forward(d)
        turtle.left(60.0)
        turtle.forward(d)
        return
    }
    flakeRecursive(turtle, d / 3, depth - 1)
    turtle.left(60.0)
    flakeRecursive(turtle, d / 3, depth - 1)
    turtle.right(120.0)
    flakeRecursive(turtle, d / 3, depth - 1)
    turtle.left(60.0)
    flakeRecursive(turtle, d / 3, depth - 1)
}
```

  - Sierpińského trojuholník (hĺbka zanorenia postupne: 2, 4, 8):

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment3/sierpinski-triangle-2.svg"><img src="../iv122_outputs/assignment3/sierpinski-triangle-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/sierpinski-triangle-4.svg"><img src="../iv122_outputs/assignment3/sierpinski-triangle-4.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/sierpinski-triangle-8.svg"><img src="../iv122_outputs/assignment3/sierpinski-triangle-8.svg" width="22%"/></a>
</div>

  - Päťuholníková vločka (hĺbka zanorenia postupne: 2, 4, 6):

<div align="center" style="width:90%">
    <a href="../iv122_outputs/assignment3/penta-flake-2.svg"><img src="../iv122_outputs/assignment3/penta-flake-2.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/penta-flake-4.svg"><img src="../iv122_outputs/assignment3/penta-flake-4.svg" width="22%"/></a>
    <a href="../iv122_outputs/assignment3/penta-flake-6.svg"><img src="../iv122_outputs/assignment3/penta-flake-6.svg" width="22%"/></a>
</div>

  - Ker:
    
<p align="center"><a href="../iv122_outputs/assignment3/branch.svg"><img src="../iv122_outputs/assignment3/branch.svg" width="90%"/></a></p>

```kotlin
fun branch(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(250, 550))
    turtle.left(90.0)
    branchRecursive(turtle, 300.0, depth)
    return turtle.lines
}

fun branchRecursive(turtle: Turtle, a: Double, depth: Int) {
    if (depth == 0) {
        return
    }
    turtle.forward(a)
    turtle.left(45.0)
    branchRecursive(turtle, a / 2, depth - 1)
    turtle.right(90.0)
    branchRecursive(turtle, a / 2, depth - 1)
    turtle.left(45.0)
    turtle.penUp()
    turtle.backward(a)
    turtle.penDown()
}
```

Veci, ktoré by som ešte chcel spraviť: Hilbertovu alebo Sierpinského krivku a Anklet.

##### Výstup z konsole po spustení jar archívu sa nachádza [tu](./console-output.md)
##### Všetky ostatné obrázky(výstupy) k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/iv122_outputs/assignment3)
##### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment3)
##### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment3)
