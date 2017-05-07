package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.*

/**
 * Creates the regular polygon with [n] edges with the inner star
 *
 * @param n the number of edges
 * @param length the length of polygon's edges
 * @return the list of [Line]s representing the polygon with its inner star
 */
fun anygram_turtle(n: Int, length: Int): List<Line> {
    val result = mutableListOf<Line>()
    result.addAll(polygon(n, length))
    result.addAll(multistar(n, length))
    return result
}

/**
 * Creates the square that has inner squares
 *
 * @param length the length of the edge of the first square
 * @param offset coordinates of the top-left corner of the first square
 * @param depth the maximum number of squares
 * @param proportion the proportion which to divide the square's edges in (1:4, 2:9, etc.)
 * @param skip which lines to skip (skip == 5 means that every fifth line will not be printed; skip == 0 means every line will be printed)
 * @return the list of SVG [Line]s
 */
fun nestedSquare(length: Double, offset: Coordinates, depth: Int, proportion: Pair<Int, Int>, skip: Int): List<Line> {
    val denominator = proportion.first + proportion.second
    val turtle = Turtle(Turtle.State(position = offset))
    var mutableLength = length
    val firstAngle = Math.toDegrees(Math.atan(proportion.first.toDouble() / proportion.second))
    depth.timesRepeat { i ->
        val adjacentLength = proportion.second * mutableLength / denominator
        val oppositeLength = proportion.first * mutableLength / denominator
        if (skip > 0 && i % skip == 0) {
            turtle.penUp()
        } else {
            turtle.penDown()
        }
        for (j in 1..4) {
            turtle.forward(mutableLength)
            turtle.right(90.0)
        }
        turtle.forward(oppositeLength)
        turtle.right(firstAngle)
        mutableLength = Math.sqrt(Math.pow(oppositeLength, 2.0) + Math.pow(adjacentLength, 2.0))
    }
    return turtle.lines
}

/**
 * Creates the triangle with nested ones
 *
 * @param length the length of the edge of the first triangle
 * @param offset the coordinates of the top vertex of the triangle
 * @param depth the number of nested triangles
 * @param skip which lines to skip (skip == 5 means that every fifth line will not be printed; skip == 0 means every line will be printed)
 * @return the list of SVG [Line]s
 */
fun nestedTriangle(length: Double, offset: Coordinates, depth: Int, skip: Int): List<Line> {
    // base turning point (180 - 60)
    val regularAngle = 120.0
    // when in the top vertex, turn to the "south"
    val startingAngle = 30.0
    var mutableLength = length
    val height = Math.sqrt(Math.pow(mutableLength, 2.0) - (Math.pow(mutableLength, 2.0) / 4))
    // two thirds of the height (used to compute the next edge's length)
    var twoThirdsOfHeight = 2 * height / 3
    // the gap between the vertices of the two adjacent triangles
    val gap = twoThirdsOfHeight / (depth - 1)

    val turtle = Turtle(Turtle.State(position = offset))
    turtle.right(90.0)

    depth.timesRepeat { i ->
        if (skip > 0 && i % skip == 0) {
            turtle.penUp()
        } else {
            turtle.penDown()
        }
        turtle.left(startingAngle)
        for (j in 1..3) {
            turtle.forward(mutableLength)
            turtle.right(regularAngle)
        }
        turtle.right(startingAngle)
        turtle.penUp()
        turtle.forward(gap)
        mutableLength = 2 * (Math.cos(Math.toRadians(startingAngle)) * (twoThirdsOfHeight - gap))
        twoThirdsOfHeight -= gap
    }
    return turtle.lines
}

/**
 * Creates the "flower" of 12 dodekagons
 * @param length the length of the polygon's edge
 * @param offset the coordinates of the top-left vertex
 * @return the list of SVG [Line]s
 */
fun flower(length: Int, offset: Coordinates): List<Line> {
    // firstly, we compute the first dodekagon whose vertices would serve as the offsets for other 11
    val first = dodekagon(length, offset)
    val lines = polygonFromPoints(first).toMutableList()
    for (point in first.takeLast(first.size - 1)) {
        lines += polygonFromPoints(dodekagon(length, point))
    }
    return lines
}

private fun dodekagon(a: Int, offset: Coordinates): List<Coordinates> {
    var current = offset
    val retList = mutableListOf(offset)
    val degrees = listOf(0, 30, 60, 90, 60, 30, 0, 30, 60, 90, 60).map(Int::toDouble).map { Math.toRadians(it) }
    var yLength = a
    var xLength = a
    var xModulo = 4
    var counter = 1
    for (degree in degrees) {
        if (counter > 1 && counter % 6 == 1) {
            // we need to change the x-sign at the 7-th vertex
            yLength = yLength.unaryMinus()
        }
        if (counter > 1 && counter % xModulo == 1) {
            // we need to change the x sign at the 5-th and 11-th vertex
            xLength = xLength.unaryMinus()
            xModulo = 2 * xModulo + 1
        }
        current += Coordinates(xLength * Math.cos(degree), yLength * Math.sin(degree))
        retList.add(current)

        counter = counter.inc()
    }
    return retList
}

/**
 * Creates a circle that is filled with horizontal and vertical lines
 *
 * @param imgSize the size of the output image
 * @param lineSeparation the gap between the lines
 * @return a list of SVG lines representing the image
 */
fun linedCircle(imgSize: Int, lineSeparation: Int): List<Line> {
    val center = imgSize / 2.0
    val radius = 0.95 * center
    val result = mutableListOf<Line>()

    for (xy in 0 until imgSize step lineSeparation) {
        val a = 1.0
        val b = -2 * center

        // horizontal lines
        val cX = center.square() - radius.square() + (xy - center).square()
        val (x1, x2) = quadraticEquation(a, b, cX)
        result.add(Line(Coordinates(x1, xy.toDouble()), Coordinates(x2, xy.toDouble())))

        // vertical lines
        val cY = center.square() - radius.square() + (xy - center).square()
        val (y1, y2) = quadraticEquation(a, b, cY)
        result.add(Line(Coordinates(xy.toDouble(), y1), Coordinates(xy.toDouble(), y2)))
    }

    return result.filter { line ->
        line.first.x != Double.NEGATIVE_INFINITY && line.first.y != Double.NEGATIVE_INFINITY
                && line.second.x != Double.NEGATIVE_INFINITY && line.second.y != Double.NEGATIVE_INFINITY
    }
}