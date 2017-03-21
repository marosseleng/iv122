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
}
