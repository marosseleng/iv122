package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.*
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by mseleng on 3/7/17.
 */
fun Double.toPlainString(): String = BigDecimal(this).setScale(2, RoundingMode.HALF_EVEN).toPlainString()
fun main(args: Array<String>) {
    val turtle = Turtle(Coordinates(300, 0))
    turtle.right(60.0)
    turtle.forward(100)
    turtle.right(120.0)
    turtle.forward(100)
    turtle.right(120.0)
    turtle.forward(100)
    SVG().lines(turtle.lines).writeTo(fileWithName("outputs", 3, "turtle.svg"))

    SVG().lines(pentagram(500)).writeTo(fileWithName("outputs", 3, "pentagram.svg"))
}

fun pentagram(length: Int): List<Line> {
    val innerLineLength = Math.sin(Math.toRadians(52.5)).times(length).times(2)
    val turtle = Turtle(Coordinates(500, 0))
    turtle.right(36.0)
    turtle.forward(length)
    turtle.right(72.0)
    turtle.forward(length)
    turtle.right(72.0)
    turtle.forward(length)
    turtle.right(72.0)
    turtle.forward(length)
    turtle.right(72.0)
    turtle.forward(length)
    turtle.right(108.0)
    turtle.forward(innerLineLength)
    return turtle.lines
}
