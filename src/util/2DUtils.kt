package util

/**
 * Created by mseleng on 2/25/17.
 */
data class Coordinates(val x: Int, val y: Int) {
    fun isOutOfRange(width: Int, height: Int): Boolean {
        return (x >= width || y >= height || x < 0 || y < 0)
    }

    operator fun minus(other: Coordinates): Coordinates {
        return Coordinates(x.minus(other.x), y.minus(other.y))
    }
}

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

