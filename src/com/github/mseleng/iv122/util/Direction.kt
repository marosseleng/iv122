package com.github.mseleng.iv122.util

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

