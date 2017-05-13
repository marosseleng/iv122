package com.github.mseleng.iv122.util

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Data class representing the coordinates of a single point in the 2D space
 *
 * @param x the horizontal part
 * @param y the vertical part
 * @constructor creates the coordinates with the given values
 * @property x the horizontal part
 * @property y the vertical part
 */
data class Coordinates(val x: Double, val y: Double) {

    /**
     * A constructor that accepts the integral values
     */
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

    /**
     * Says whether this coordinates are out of the given range
     *
     * @param width the width of a 2D grid
     * @param height the height of a 2D grid
     * @return true iff this coordinates are out of the given range, false otherwise
     */
    fun isOutOfRange(width: Int, height: Int) = (x >= width || y >= height || x < 0 || y < 0)

    /**
     * Trims this decimal number, so there is no scientific exponentiation in toString()
     *
     * @param n the desired scale
     * @return this number scaled
     */
    fun trimToNDecimalPoints(n: Int): Coordinates {
        return copy(BigDecimal(x).setScale(n, RoundingMode.HALF_EVEN).toDouble(), BigDecimal(y).setScale(n, RoundingMode.HALF_EVEN).toDouble())
    }

    /**
     * Returns the polar angle between this and other
     */
    fun polarAngleTo(other: Coordinates): Double {
        return Math.toDegrees(Math.atan2(other.y - this.y, other.x - this.x))
    }

    /**
     * Returns the (0;0) based vector from this to other
     */
    fun vectorTo(other: Coordinates): Coordinates {
        return Coordinates(this.x - other.x, this.y - other.y)
    }

    /**
     * Returns true if this lays on the parametric line
     */
    fun laysOnLine(line: ParametricLine, tolerance: Double) = line.substituteCoordinates(this) in -tolerance..tolerance

    /**
     * Returns true if this lays on the parametric line within its bounds
     */
    fun laysOnLineStrict(line: ParametricLine, tolerance: Double): Boolean {
        if (line.substituteCoordinates(this) !in -tolerance..tolerance) {
            return false
        }
        val first = line.first
        val second = line.second
        // hacky a bit
        val xTmp = listOf(first.x, second.x).sorted()
        val yTmp = listOf(first.y, second.y).sorted()
        return x in xTmp[0]..xTmp[1] && y in yTmp[0]..yTmp[1]
    }

    /**
     * Returns true if this lays above the [line]
     */
    fun laysAboveLine(line: ParametricLine) = line.substituteCoordinates(this) > 0.0

    /**
     * Returns true if this lays below the [line]
     */
    fun laysBelowLine(line: ParametricLine) = line.substituteCoordinates(this) < 0.0

    /**
     * Computes the euclidean distance between this and [other]
     *
     * @param other the other point
     * @return the Euclidean distance between two points
     */
    fun euclideanDistanceFrom(other: Coordinates) = Math.sqrt(Math.pow(this.x - other.x, 2.0) + Math.pow(this.y - other.y, 2.0))

    /**
     * @suppress
     */
    operator fun plus(other: Coordinates?) = copy(x.plus(other?.x ?: 0.0), y.plus(other?.y ?: 0.0))

    /**
     * @suppress
     */
    operator fun minus(other: Coordinates) = Coordinates(x.minus(other.x), y.minus(other.y))

    /**
     * @suppress
     */
    operator fun times(other: Int): Coordinates = copy(x.times(other), y.times(other))

    /**
     * @suppress
     */
    operator fun times(other: Double): Coordinates = copy(x.times(other), y.times(other))

    /**
     * @suppress
     */
    operator fun div(other: Int) = copy(x / other, y / other)

    /**
     * Returns the coordinates represented as the triple (for homogeneous transformations)
     */
    fun toTriple(): Triple<Double, Double, Double> = Triple(x, y, 1.0)

    /**
     * @suppress
     */
    override fun toString() = "[$x ; $y]"
}

