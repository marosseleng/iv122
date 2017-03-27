package com.github.mseleng.iv122.assignment5

import com.github.mseleng.iv122.util.*
import java.util.*

fun main(args: Array<String>) {
    SVG().lines(generateLines(100, 1000, 1000, 250.0)).writeTo(fileWithName(assignmentNo = 5, name = "lines.svg"))
}

fun generateLines(n: Int, maxX: Int, maxY: Int, length: Double): List<Line> {
    val randomX = Random()
    val randomY = Random()
    val lines = mutableListOf<Line>()

    n.timesRepeat {
        val start = Coordinates(randomX.nextDouble() * maxX, randomY.nextDouble() * maxY)
        var coords: Coordinates
        do {
            val randomDegree = randomX.nextDouble() * 360
            val x = length * Math.cos(Math.toRadians(randomDegree))
            val y = length * Math.sin(Math.toRadians(randomDegree))
            coords = Coordinates(start.x + x, start.y + y)
        } while (coords.isOutOfRange(maxX, maxY))
        lines.add(Line(start, coords))
    }

    return lines
}

fun Coordinates.inOnLine(line: Line): Boolean {
    val ab = computeAB(line)
    return y == ab.first * x + ab.second
}

fun computeAB(line: Line): Pair<Double, Double> {
    val r = line.first
    val s = line.second
    val a = (r.y - s.y) / (r.x - s.x)
    val b = (s.x * r.y - r.x * s.y) / (s.x - r.x)
    return Pair(a, b)
}