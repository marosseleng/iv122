import util.*
import java.awt.Color

/**
 * Created by mseleng on 2/23/17.
 */

private typealias UlamSpiralCondition = (Int) -> Boolean

fun main(args: Array<String>) {
    // display all x such that (x is prime)
    ulam(99999, Int::isPrime, "ulam-[prime].png")
    // display all x such that (x mod 5 > 1)
    ulam(99999, { it.rem(5) > 1 }, "ulam-[mod5>1].png")
    // display all x such that (((x * E) mod PI) >= 2)
    ulam(99999, { it.times(Math.E).rem(Math.PI) >= 2 }, "ulam-[*EmodPI>=2].png")
}

fun ulam(n: Int, condition: UlamSpiralCondition, fileName: String) {
    val dimensions = computeDimensions(n)
    bitmapImage(dimensions.first, dimensions.second) {
        val center = computeCenter(dimensions.first, dimensions.second)
        var lastCoordinates: Coordinates? = null
        var lastDirection: Direction? = null
        for (i in 1..n) {
            val rgb = if (condition(i)) { Color.BLACK.rgb } else { Color.WHITE.rgb }
            val (coords, dir) = getNextMove(center, lastCoordinates, lastDirection)
            lastCoordinates = coords
            lastDirection = dir
            if (lastCoordinates.isOutOfRange(dimensions.first, dimensions.second)) {
                continue
            }
            setRGB(lastCoordinates.x, lastCoordinates.y, rgb)
        }
    }.writeTo(fileWithName(fileName))
}

fun computeDimensions(n: Int): Pair<Int, Int> {
    val x = Math.sqrt(n.toDouble())
    if (x.rem(1) == 0.toDouble()) {
        // sqrt is a whole number
        return Pair(x.toInt(), x.toInt())
    } else {
        // x has some decimals
        val height = Math.round(x).toInt()
        val width = Math.ceil(x).toInt()
        return Pair(width, height)
    }
}

fun computeCenter(width: Int, height: Int): Coordinates {
    return Coordinates(width.div(2), height.div(2))
}

/**
 *
 */
fun getNextMove(center: Coordinates, lastCoordinates: Coordinates?, lastDirection: Direction?): Pair<Coordinates, Direction?> {
    if (lastCoordinates == null) {
        return Pair(center, null)
    }
    // we need to compute the coordinates of the last point as if the center was [0,0]
    val centeredCoordinates = lastCoordinates.minus(center)
    val a = Math.abs(centeredCoordinates.x) - Math.abs(centeredCoordinates.y)
    val newDirection = getNextDirection(a, lastDirection)
    val newCoordinates = getNextCoordinates(newDirection, lastCoordinates)
    return Pair(newCoordinates, newDirection)
}

/**
 * Computes the next direction.
 *
 * @param a a relative position of the next number (used to determine whether we are on the diagonal and therefore we should change direction or we should keep the actual direction)
 * @param lastDirection the last used direction
 * @return the direction which the next number should be put in
 */
fun getNextDirection(a: Int, lastDirection: Direction?): Direction {
    return when (lastDirection) {
        null -> Direction.EAST
        Direction.EAST -> {
            if (a > 0) {
                Direction.NORTH
            } else {
                Direction.EAST
            }}
        else -> {
            if (a == 0) {
                lastDirection.next()
            } else {
                lastDirection
            }
        }
    }
}

/**
 * Computes the coordinates for the next number.
 *
 * @param direction the direction which to move in
 * @param lastCoordinates the coordinates of the previous number
 * @return the coordinates for the next number
 */
fun getNextCoordinates(direction: Direction, lastCoordinates: Coordinates): Coordinates {
    return when (direction) {
        Direction.EAST -> lastCoordinates.copy(x = lastCoordinates.x + 1)
        Direction.NORTH -> lastCoordinates.copy(y = lastCoordinates.y - 1)
        Direction.WEST -> lastCoordinates.copy(x = lastCoordinates.x - 1)
        Direction.SOUTH -> lastCoordinates.copy(y = lastCoordinates.y + 1)
    }
}
enum class Direction {
    EAST {
        override fun next() = NORTH
    }, NORTH {
        override fun next() = WEST
    }, WEST {
        override fun next() = SOUTH
    }, SOUTH {
        override fun next() = EAST
    };
    abstract fun next(): Direction
}