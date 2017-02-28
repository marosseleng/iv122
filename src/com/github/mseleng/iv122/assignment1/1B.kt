package com.github.mseleng.iv122.assignment1

import com.github.mseleng.iv122.util.*
import java.awt.Color

private typealias UlamSpiralCondition = (Int) -> Boolean

/**
 * @suppress
 */
fun main(args: Array<String>) {
    // display all x such that (x is prime)
    ulam(99999, Int::isPrime, "ulam-[prime].png")
    // display all x such that (x mod 5 > 1)
    ulam(99999, { it.rem(5) > 1 }, "ulam-[mod5>1].png")
    // display all x such that (((x * E) mod PI) >= 2)
    ulam(99999, { it.times(Math.E).rem(Math.PI) >= 2 }, "ulam-[*EmodPI>=2].png")
}

/**
 * Creates the file containing the Ulam's spiral.
 *
 * @param n the maximum number we want to have in the spiral
 * @param condition the condition of numbers coloring (if the number meets this condition, its pixel is colored)
 * @param fileName the name of the resulting file
 */
fun ulam(n: Int, condition: UlamSpiralCondition, fileName: String) {
    val dimensions = computeDimensions(n)
    bitmapImage(dimensions.first, dimensions.second) {
        val center = computeCenter(dimensions.first, dimensions.second)
        var lastCoordinates: Coordinates? = null
        var lastDirection: Direction? = null
        for (i in 1..n) {
            val rgb = if (condition(i)) { Color.BLACK.rgb } else { Color.WHITE.rgb }
            val (coordinates, direction) = getNextMove(center, lastCoordinates, lastDirection)
            lastCoordinates = coordinates
            lastDirection = direction
            if (lastCoordinates.isOutOfRange(dimensions.first, dimensions.second)) {
                continue
            }
            setRGB(lastCoordinates.x, lastCoordinates.y, rgb)
        }
    }.writeTo(fileWithName(1, fileName))
}

/**
 * Computes the minimum grid dimension for the given [n]
 *
 * The function tries to compute a square-like grid
 *
 * @param n the maximum number that we want to have in the spiral
 * @return the dimensions of the grid
 */
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

/**
 * Computes the coordinates for the center point (one containing the number 1)
 *
 * @param width the width of the grid
 * @param height the height of the grid
 * @return the center coordinates
 */
fun computeCenter(width: Int, height: Int) = Coordinates(width.div(2), height.div(2))

/**
 * Computes the next move (where to place the next number on a spiral)
 *
 * @param center the coordinates of the center pixel (where number 1 is)
 * @param lastCoordinates the coordinates of the place with the last number (if the current number is i, then this param represents the coordinates of (x-1))
 * @param lastDirection the direction which we moved from the number (i-2) to (i-1)
 * @return a pair containing the coordinates and the direction to the current number (i)
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
                lastDirection.counterClockwiseNext()
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
fun getNextCoordinates(direction: Direction, lastCoordinates: Coordinates) = when (direction) {
        Direction.EAST -> lastCoordinates.copy(x = lastCoordinates.x + 1)
        Direction.NORTH -> lastCoordinates.copy(y = lastCoordinates.y - 1)
        Direction.WEST -> lastCoordinates.copy(x = lastCoordinates.x - 1)
        Direction.SOUTH -> lastCoordinates.copy(y = lastCoordinates.y + 1)
}
