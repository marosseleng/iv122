package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.*

/**
 * Creates a fractal with the shape of a branch
 *
 * @param depth the depth of a recursion
 * @return the list of SVG [Line]s representing the fractal
 */
fun branch(depth: Int): List<Line> {
    val turtle = Turtle(Coordinates(300, 550))
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