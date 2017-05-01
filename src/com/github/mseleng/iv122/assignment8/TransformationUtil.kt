package com.github.mseleng.iv122.assignment8

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.Line
import com.github.mseleng.iv122.util.timesRepeat

/**
 * Represents the transformation matrix
 */
typealias Transformation = Array<Triple<Double, Double, Double>>

/**
 * Returns the item from matrix at position (x, y) where x is column
 */
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

/**
 * Returns the [n]-th column of this matrix
 */
fun Transformation.getColumn(n: Int): Triple<Double, Double, Double> {
    val resultList = map { it.toList() }.map { it[n] }
    assert(resultList.count() == 3)
    return Triple(resultList[0], resultList[1], resultList[2])
}

/**
 * Combine multiple transformations into one resulting
 */
fun combine(vararg transformations: Transformation) = combine(transformations.toList())

/**
 * Combine multiple transformations into one resulting
 */
fun combine(transformations: List<Transformation>) = transformations.reversed().fold(identity(), Transformation::times)

/**
 * Multiplies two transformations (matrices)
 */
operator fun Transformation.times(other: Transformation): Transformation {
    var i = 0
    val result = mutableListOf<Triple<Double, Double, Double>>()
    for (row in this) {
        // column from other matrix
        val arrayToTriple = mutableListOf<Double>()
        3.timesRepeat { x ->
            val otherCol = other.getColumn(x - 1)
            arrayToTriple.add(row * otherCol)
        }
        assert(arrayToTriple.count() == 3)
        result.add(Triple(arrayToTriple[0], arrayToTriple[1], arrayToTriple[2]))
        i += 1
    }
    return result.toTypedArray()
}

/**
 * Applies the transformation to the given coordinates. Returns the Coordinates
 */
operator fun Transformation.times(point: Coordinates) = times(point.toTriple()).toCoordinates()

/**
 * Applies the transformation to the given point (multiplies two matrices). Returns the Triple
 */
operator fun Transformation.times(point: Triple<Double, Double, Double>): Triple<Double, Double, Double> {
    return Triple(
            get(0) * point,
            get(1) * point,
            get(2) * point)
}

/**
 * Multiplies (and sums) two rows of the matrix
 */
operator fun Triple<Double, Double, Double>.times(other: Triple<Double, Double, Double>): Double {
    return toList().zip(other.toList()) { f, s -> f * s }.reduce { acc, d -> acc + d }
}

/**
 * Converts the Triple to Coordinates (useful for homogeneous transformations
 */
fun Triple<Double, Double, Double>.toCoordinates() = Coordinates(first, second)

/**
 * Applies this transformation on the given lines
 */
fun Transformation.applyOn(lines: List<Line>) = lines.map { (start, end) ->
    Line(this * start, this * end)
}

/**
 * Applies the given transformations to the given lines [iterations]-times. Offsets the result
 */
fun applyTransformations(lines: List<Line>, offset: Coordinates, iterations: Int, vararg transformations: Transformation): List<Line> {
    var current = lines
    val result = mutableListOf<Line>()
    result.addAll(current)
    iterations.timesRepeat {
        current = combine(transformations.toList()).applyOn(current)
        result.addAll(current)
    }
    return result.offsetTo(offset)
}

/**
 * Offsets each line by the given amount
 */
fun List<Line>.offsetTo(point: Coordinates) = map { (start, end) ->
    Line(start + point, end + point)
}

/**
 * Returns an identity matrix
 */
fun identity(): Transformation {
    return arrayOf(
            Triple(1.0, 0.0, 0.0),
            Triple(0.0, 1.0, 0.0),
            Triple(0.0, 0.0, 1.0))
}

/**
 * Returns the matrix representing the rotation by the given [angle]
 */
fun rotation(angle: Double): Transformation {
    val angleRads = Math.toRadians(angle)
    val cos = Math.cos(angleRads)
    val sin = Math.sin(angleRads)
    return arrayOf(
            Triple(cos, -sin, 0.0),
            Triple(sin,  cos, 0.0),
            Triple(0.0,  0.0, 1.0))
}

/**
 * Returns the matrix representing the translation by the given amount
 */
fun translation(x: Double, y: Double): Transformation = translation(Coordinates(x, y))

/**
 * Returns the matrix representing the translation by the given amount
 */
fun translation(target: Coordinates): Transformation {
    return arrayOf(
            Triple(1.0, 0.0, target.x),
            Triple(0.0, 1.0, target.y),
            Triple(0.0, 0.0,      1.0))
}

/**
 * Returns the matrix representing the scaling
 */
fun scaling(newWidth: Double, newHeight: Double): Transformation {
    return arrayOf(
            Triple(newWidth,       0.0, 0.0),
            Triple(     0.0, newHeight, 0.0),
            Triple(     0.0,       0.0, 1.0))
}

/**
 * Returns the matrix representing the mirroring by the y-axis
 */
fun mirrorY(): Transformation {
    return arrayOf(
            Triple(-1.0, 0.0, 0.0),
            Triple( 0.0, 1.0, 0.0),
            Triple( 0.0, 0.0, 1.0))
}

/**
 * Returns the matrix representing the mirroring by the x-axis
 */
fun mirrorX(): Transformation {
    return arrayOf(
            Triple(1.0, -1.0, 0.0),
            Triple(0.0,  0.0, 0.0),
            Triple(0.0,  0.0, 1.0))
}

/**
 * Returns the matrix representing the shear by the given coefficient
 */
fun shear(k: Double): Transformation {
    return arrayOf(
            Triple(1.0,  -k, 0.0),
            Triple(0.0, 1.0, 0.0),
            Triple(0.0, 0.0, 1.0))
}

/**
 * Returns the list of lines defining a square with its center in (0;0) and with edge length = 2*[size]
 */
fun square(size: Double): List<Line> {
    return listOf(
            Line(Coordinates(-size / 2, -size / 2), Coordinates(size / 2, -size / 2)),
            Line(Coordinates(size / 2, -size / 2), Coordinates(size / 2, size / 2)),
            Line(Coordinates(size / 2, size / 2), Coordinates(-size / 2, size / 2)),
            Line(Coordinates(-size / 2, size / 2), Coordinates(-size / 2, -size / 2)))
}

/**
 * Pretty prints the given transformation matrix
 */
fun Transformation.prettyPrint(): String {
    val firstRow = this[0]
    val secondRow = this[1]
    val thirdRow = this[2]
    return firstRow.prettyPrint() + "\n" +
            secondRow.prettyPrint() + "\n" +
            thirdRow.prettyPrint()
}

/**
 * Pretty prints the given row
 */
fun Triple<Double, Double, Double>.prettyPrint(): String {
    return "| ${String.format("%.04f", first)} | ${String.format("%.04f", second)} | ${String.format("%.04f", third)} |"
}
