package com.github.mseleng.iv122.util

/**
 * Data class representing the coordinates of a single point in the 2D space
 *
 * @param x the horizontal part
 * @param y the vertical part
 * @constructor creates the coordinates with the given values
 */
data class Coordinates(val x: Int, val y: Int) {

    /**
     * Says whether this coordinates are out of the given range
     *
     * @param width the width of a 2D grid
     * @param height the height of a 2D grid
     * @return true iff this coordinates are out of the given range, false otherwise
     */
    fun isOutOfRange(width: Int, height: Int): Boolean {
        return (x >= width || y >= height || x < 0 || y < 0)
    }

    operator fun minus(other: Coordinates): Coordinates {
        return Coordinates(x.minus(other.x), y.minus(other.y))
    }
}

/**
 * Enum representing directions in a 2D grid
 */
enum class Direction {
    EAST {
        override fun counterClockwiseNext() = NORTH
    }, NORTH {
        override fun counterClockwiseNext() = WEST
    }, WEST {
        override fun counterClockwiseNext() = SOUTH
    }, SOUTH {
        override fun counterClockwiseNext() = EAST
    };
    abstract fun counterClockwiseNext(): Direction
}

