package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.Line
import com.github.mseleng.iv122.util.Turtle

/**
 * Creates a "regular multistar" (a star-like shape inscribed into a [n]-edges regular polygon with the size of an edge [a]
 *
 * @param n the number of edges of the border polygon
 * @param a the length of an edge of the border polygon
 * @return the list of [Line]s representing the "regular multistar"
 */
fun multistar(n: Int, a: Int): List<Line> {
    val perimeterAngle = 180.0 / n
    // the radius of the circumscribed circle
    val radius = a / (2 * Math.sin(Math.toRadians(perimeterAngle)))
    // the length of the "inner" edge
    val x = 2 * radius * Math.sin(Math.toRadians(n / 2 * perimeterAngle))

    // the inner angle of a vertex
    val vertexInnerAngle = (180 - ((n - 2) * 180.0) / n) / 2
    val firstAngle = (180 - vertexInnerAngle) / 2
    val otherAngle = 180 - vertexInnerAngle
    val turtle = Turtle(Coordinates(n / 3 * a, 0))
    turtle.right(firstAngle)
    for (i in 1..n) {
        turtle.forward(x)
        turtle.right(otherAngle)
    }
    return turtle.lines
}

/**
 * Creates a regular polygon with [n] edges of the length [a]
 *
 * @param n the number of edges
 * @param a the lenght of an edge
 * @return the list of [Line]s representing the regular polygon
 */
fun polygon(n: Int, a: Int): List<Line> {
    val turtle = Turtle(Coordinates(n / 3 * a, 0))
    val innerAngleDegrees = ((n - 2) * 180.0) / n
    val firstAngle = (180 - innerAngleDegrees) / 2
    turtle.right(firstAngle)
    val otherAngles = 180 - innerAngleDegrees
    for (i in 1..n) {
        turtle.forward(a)
        turtle.right(otherAngles)
    }
    return turtle.lines
}

/**
 * Creates a polygon by "connecting the given [points]"
 *
 * @param points the points to connect
 * @return the list of [Line]s reprezenting the polygon
 */
fun polygonFromPoints(points: List<Coordinates>): List<Line> {
    var current = points.last()

    return points.map {
        val tmp = current
        current = it
        Line(tmp, current)
    }
}