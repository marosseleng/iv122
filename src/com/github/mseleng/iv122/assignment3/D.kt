package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.Line
import com.github.mseleng.iv122.util.Turtle

fun creativeTurtle(depth: Int, iterativeFunction: Turtle.() -> Unit, initialFunction: Turtle.() -> Unit): List<Line> {
    val turtle = Turtle(Coordinates(100, 100))


    return turtle.lines
}

fun creativeTUrtleRecursive(turtle: Turtle, depth: Int, iterativeFunction: Turtle.() -> Unit, initialFunction: Turtle.() -> Unit) {
    if (depth <= 1) {
        initialFunction(turtle)
        return
    }
}

fun main(args: Array<String>) {

}