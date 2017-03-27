## Vektorová grafika
[Home](../)

Témou tretej úlohy bola jednoduchá vektorová grafika, hlavne práca s tzv. želví grafikou.

V prvej časti bolo za úlohu vytvoriť jednoduchú knižnicu na prácu s "želví" grafikou. Pre tento účel som si vytvoril triedu [`Turtle`](../javadoc/iv122/com.github.mseleng.iv122.util/-turtle).

Ďalšou úlohou bolo vykresliť niekoľko obrazcov za pomoci "želví" grafiky a pomocou tzv. absolútneho vykresľovania (priamo pomocou SVG).

<div align="center" style="width:90%">
    <img src="../iv122_outputs/assignment3/nestedsquare2.svg" width="24%"/>
    <img src="../iv122_outputs/assignment3/nestedsquare3.svg" width="24%"/>
    <img src="../iv122_outputs/assignment3/nestedTriangle2.svg" width="24%"/>
    <img src="../iv122_outputs/assignment3/flower.svg" width="24%"/>
</div>

Jednoduché fraktály vykreslené pomocou "želví" grafiky:

    + Kochova vločka: 

<div align="center" style="width:90%">
    <img src="../iv122_outputs/assignment3/koch-flake-1.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/koch-flake-3.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/koch-flake-5.svg" width="32%"/>
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

    + Sierpińského trojuholník:

<div align="center" style="width:90%">
    <img src="../iv122_outputs/assignment3/sierpinski-triangle-2.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/sierpinski-triangle-4.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/sierpinski-triangle-8.svg" width="32%"/>
</div>

    + Päťuholníková vločka:

<div align="center" style="width:90%">
    <img src="../iv122_outputs/assignment3/penta-flake-2.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/penta-flake-4.svg" width="32%"/>
    <img src="../iv122_outputs/assignment3/penta-flake-6.svg" width="32%"/>
</div>

    + Ker:
    
<p align="center"><img src="../iv122_outputs/assignment3/branch.svg" width="90%"/></p>

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

    
#### Všetky ostatné kódy k tejto úlohe sa nachádzajú na [Github-e](https://github.com/mseleng/iv122/tree/gh-pages/src/com/github/mseleng/iv122/assignment3)
#### Dokumentácia ku kódu sa nachádza [tu](../javadoc/iv122/com.github.mseleng.iv122.assignment3)
