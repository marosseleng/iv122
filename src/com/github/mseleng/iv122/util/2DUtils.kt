package com.github.mseleng.iv122.util

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Data class representing the coordinates of a single point in the 2D space
 *
 * @param x the horizontal part
 * @param y the vertical part
 * @constructor creates the coordinates with the given values
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

    operator fun plus(other: Coordinates?) = copy(x.plus(other?.x ?: 0.0), y.plus(other?.y ?: 0.0))
    operator fun minus(other: Coordinates) = Coordinates(x.minus(other.x), y.minus(other.y))
    operator fun times(other: Int): Coordinates = copy(x.times(other), y.times(other))
    operator fun times(other: Double): Coordinates = copy(x.times(other), y.times(other))
}

/**
 * Enum representing directions in a 2D grid
 */
enum class Direction {
    /**
     * Direction to the right (3 o'clock)
     */
    EAST {
        override fun counterClockwiseNext() = NORTH
    },
    /**
     * Direction to the top (12 o'clock)
     */
    NORTH {
        override fun counterClockwiseNext() = WEST
    },
    /**
     * Direction to the left (9 o'clock)
     */
    WEST {
        override fun counterClockwiseNext() = SOUTH
    },
    /**
     * Direction to the bottom (6 o'clock)
     */
    SOUTH {
        override fun counterClockwiseNext() = EAST
    };

    /**
     * Returns the counter-clockwise next direction
     *
     * @return the next [Direction]
     */
    abstract fun counterClockwiseNext(): Direction
}

