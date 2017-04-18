package com.github.mseleng.iv122.assignment5

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.text.DecimalFormat
import java.util.*

/**
 * Returns the SVG containing lines and their intersections (possibly) highlighted
 *
 * @param imgSize the size of the image
 * @param numOfLines the number of lines
 * @param lineLength the length of lines
 * @param highlightIntersections true for highlighted intersections
 * @return and SVG containing the lines and theri intersections
 */
fun linesAndIntersections(imgSize: Int, numOfLines: Int, lineLength: Int, highlightIntersections: Boolean = false): SVG {
    val svg = SVG()
    val lines = randomLines(numOfLines, imgSize, imgSize, lineLength.toDouble())
    svg.lines(lines)
    if (highlightIntersections) {
        findIntersections(lines).forEach { (x, y) ->
            svg.square(x.toInt() - 2, y.toInt() - 2, 5, Style(Color.ORANGE, 1, null))
        }
    }
    return svg
}

/**
 * Returns the list of Coordinates representing the intersections of the given lines
 */
fun findIntersections(lines: List<Line>): List<Coordinates> {
    return lines
            .map(::ParametricLine)
            .flatMap { line ->
                lines.mapNotNull {
                    ParametricLine(it).intersectionWith(line)
                }
            }
            .roughlyDistinct { DecimalFormat("#.##").format(it).toDoubleOrNull() ?: 0.0 }
}

/**
 * Returns the list of random points in the given space
 *
 * @param n the number of points to generate
 * @param maxX
 * @param maxY
 * @return the list of generated points
 */
fun randomPoints(n: Int, maxX: Int, maxY: Int): List<Coordinates> {
    val randomX = Random()
    val randomY = Random()
    return (1..n).asIterable()
            .map { Coordinates(randomX.nextDouble() * maxX, randomY.nextDouble() * maxY) }
}

/**
 * Randomly generates lines within the given space
 *
 * @param n the number of lines to generate
 * @param maxX
 * @param maxY
 * @param length the length of the lines; must be less than maxX and less than maxY
 * @return the list of generated lines
 */
fun randomLines(n: Int, maxX: Int, maxY: Int, length: Double): List<Line> {
    val degreeRandom = Random()

    return randomPoints(n, maxX, maxY)
            .map {
                var coords: Coordinates
                do {
                    val randomDegree = degreeRandom.nextDouble() * 360
                    val x = length * Math.cos(Math.toRadians(randomDegree))
                    val y = length * Math.sin(Math.toRadians(randomDegree))
                    coords = Coordinates(it.x + x, it.y + y)
                } while (coords.isOutOfRange(maxX, maxY))
                Line(it, coords)
            }
}

private fun List<Coordinates>.roughlyDistinct(trimFn: (Double) -> Double): List<Coordinates> {
    return map { (x, y) ->
        Coordinates(trimFn(x), trimFn(y))
    }.distinct()
}
