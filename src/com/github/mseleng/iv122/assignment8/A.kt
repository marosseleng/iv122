package com.github.mseleng.iv122.assignment8

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.Line
import com.github.mseleng.iv122.util.timesRepeat

fun main(args: Array<String>) {
    val t1 = arrayOf(
            Triple(-1.0, 3.0, 0.0),
            Triple( 0.0, 1.0, 0.0),
            Triple( 0.0, 6.0, 1.0))

    val t2 = arrayOf(
            Triple( 0.0, 0.0, 3.0),
            Triple( 0.0, 1.0, 0.0),
            Triple( 4.0, 0.0, 2.0))
    t1.combineWith(t2)
}



typealias Transformation = Array<Triple<Double, Double, Double>>

operator fun Triple<Double, Double, Double>.times(other: Triple<Double, Double, Double>): Double {
    return this.first*other.first + this.second*other.second + this.third*other.third
}
operator fun Transformation.get(x: Int, y: Int): Double {
    val (a, b, c) = this[y]
    if (x == 0) {
        return a
    } else if (x == 1) {
        return b
    } else {
        return c
    }
}

fun Transformation.getColumn(n: Int): Triple<Double, Double, Double> {
    val resultList = map { it.toList() }.map { it[n] }
    assert(resultList.count() == 3)
    return Triple(resultList[0], resultList[1], resultList[2])
}

fun Transformation.combineWith(other: Transformation): Transformation {
    var i = 0
    val result = mutableListOf<Triple<Double, Double, Double>>()
    for (row in this) {
        // column from other matrix
        val arrayToTriple = mutableListOf<Double>()
        3.timesRepeat { x ->
            val otherCol = other.getColumn(x-1)
            arrayToTriple.add(row * otherCol)
        }
        assert(arrayToTriple.count() == 3)
        result.add(Triple(arrayToTriple[0], arrayToTriple[1], arrayToTriple[2]))
        i += 1
    }
    return result.toTypedArray()
}

fun rotation(angle: Double): Transformation {
    val angleRads = Math.toRadians(angle)
    val cos = Math.cos(angleRads)
    val sin = Math.sin(angleRads)
    return arrayOf(
            Triple(cos, -sin, 0.0),
            Triple(sin,  cos, 0.0),
            Triple(0.0,  0.0, 1.0))
}

fun move(target: Coordinates): Transformation {
    return arrayOf(
            Triple(0.0, 0.0, target.x),
            Triple(0.0, 0.0, target.y),
            Triple(0.0, 0.0,      1.0))
}

fun scaling(newWidth: Double, newHeight: Double): Transformation {
    return arrayOf(
            Triple(newWidth,       0.0, 0.0),
            Triple(     0.0, newHeight, 0.0),
            Triple(     0.0,       0.0, 1.0))
}

fun mirrorY(): Transformation {
    return arrayOf(
            Triple(-1.0, 0.0, 0.0),
            Triple( 0.0, 1.0, 0.0),
            Triple( 0.0, 0.0, 1.0))
}

fun mirrorX(): Transformation {
    return arrayOf(
            Triple(1.0, -1.0, 0.0),
            Triple(0.0,  0.0, 0.0),
            Triple(0.0,  0.0, 1.0))
}

fun List<Line>.apply(transformation: Transformation): List<Line> {
    val result = mutableListOf<Line>()
    for (line in this) {
        val firstTriple = Triple(line.first.x, line.first.y, 1.0)
        val secondTriple = Triple(line.second.x, line.second.y, 1.0)
        val newFirst = Coordinates(transformation[0] * firstTriple, transformation[1] * firstTriple)
        val newSecond = Coordinates(transformation[1] * secondTriple, transformation[1] * secondTriple)
        result.add(Line(newFirst, newSecond))
    }
    return result
}