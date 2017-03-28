package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.*

/**
 * Creates a fractal with the shape of a branch
 *
 * @param depth the depth of a recursion
 * @return the list of SVG [Line]s representing the branch
 */
fun branch(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(250, 550))
    turtle.left(90.0)
    branchRecursive(turtle, 300.0, depth)
    return turtle.lines
}

private fun branchRecursive(turtle: Turtle, a: Double, depth: Int) {
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

/**
 * Creates a Koch's flake
 *
 * @param depth the depth of a recursion
 * @return the list of SVG [Line]s representing the flake
 */
fun flake(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(50, 100))
    flakeRecursive(turtle, 100.0, depth)
    turtle.right(120.0)
    flakeRecursive(turtle, 100.0, depth)
    turtle.right(120.0)
    flakeRecursive(turtle, 100.0, depth)
    return turtle.lines
}

private fun flakeRecursive(turtle: Turtle, d: Double, depth: Int) {
    if (depth == 1) {
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

/**
 * Creates a Sierpiński's triangle
 *
 * @param depth the depth of a recursion
 * @return the list of SVG [Line]s representing the triangle
 */
fun sierpinski(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(0, 1000))
    sierpinskiRecursive(turtle, 1024.0, depth)
    return turtle.lines
}

private fun sierpinskiRecursive(turtle: Turtle, length: Double, depth: Int) {
    if (depth == 1) {
        turtle.forward(length)
        turtle.left(120.0)
        turtle.forward(length)
        turtle.left(120.0)
        turtle.forward(length)
        turtle.currentDirection = 0.0
        return
    }
    sierpinskiRecursive(turtle, length / 2, depth - 1)
    turtle.penUp()
    turtle.forward(length / 2)
    turtle.penDown()
    sierpinskiRecursive(turtle, length / 2, depth - 1)
    turtle.penUp()
    turtle.forward(length / 2)
    turtle.left(120.0)
    turtle.forward(length)
    turtle.left(120.0)
    turtle.forward(length / 2)
    turtle.left(120.0)
    turtle.penDown()
    sierpinskiRecursive(turtle, length / 2, depth - 1)
    turtle.penUp()
    turtle.right(120.0)
    turtle.forward(length / 2)
    turtle.currentDirection = 0.0
    turtle.penDown()
}

/**
 * Creates a pentagon-shaped flake
 *
 * @param depth the depth of a recursion
 * @return the list of SVG [Line]s representing the flake
 */
fun pentagonFlake(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(300, 50))
    turtle.right(36.0)
    pentagonFlakeRecursive(turtle, depth, 300.0)
    return turtle.lines
}

private fun pentagonFlakeRecursive(turtle: Turtle, depth: Int, borderEdgeLength: Double, printInner: Boolean = false, eachTh: Int = 3) {
    if (depth <= 1) {
        5.timesRepeat {
            turtle.forward(borderEdgeLength)
            turtle.right(72.0)
        }
        return
    }

    // 2 * smallerLength + gapSize == length
    val smallerLength = borderEdgeLength / (2 * (1 + Math.sin(Math.toRadians(18.0))))
    val gapSize = 2 * smallerLength * Math.sin(Math.toRadians(18.0))
    5.timesRepeat { i ->
        pentagonFlakeRecursive(turtle, depth - 1, smallerLength, true)

        // we need to print the "core", a "mirrored pentagon"
        if (i == eachTh && printInner) {
            turtle.penUp()
            turtle.forward(smallerLength)
            turtle.right(180.0)
            turtle.penDown()
            pentagonFlakeRecursive(turtle, depth - 1, smallerLength, true, 4)
            turtle.penUp()
            turtle.forward(smallerLength)
            turtle.right(180.0)
            turtle.penDown()
        }

        turtle.penUp()
        turtle.forward(2 * smallerLength + gapSize)
        turtle.right(72.0)
        turtle.penDown()
    }
}
