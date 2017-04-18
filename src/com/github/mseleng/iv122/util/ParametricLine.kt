package com.github.mseleng.iv122.util

/**
 * Class representing a line in Carthesian system, more specificaly its parametric representation
 *
 * Each point p of this line l must suit the equation y = a*x + b
 *
 * @property first the first point, that lays on this line
 * @property second the second point, that lays on this line
 * @property a
 * @property b
 * @constructor computes [a] and [b] for the line given by the points [first] and [second]
 */
data class ParametricLine(val first: Coordinates, val second: Coordinates) {
    val a: Double = (second.y - first.y) / (second.x - first.x)
    val b: Double = (first.x * second.y - first.y * second.x) / (first.x - second.x)

    /**
     * @param svgLine the svg representation of a line (2 points)
     * @constructor creates the parametric line from the SVG one
     */
    constructor(svgLine: Line) : this(svgLine.first, svgLine.second)

    /**
     * Substitutes the coordinates in the equation a*x + b - y.
     * Returns the result, which is usable for determining the position of the given point relative to the line
     *
     * @param point the coordinates to substitute
     * @return the result of the equation
     */
    fun substituteCoordinates(point: Coordinates) = a * point.x + b - point.y

    /**
     * Finds and returns (if exists) the intersection between this and other line
     *
     * @param other the line to find the intersection with
     * @return the intersection found or null if the lines are parallel
     */
    fun intersectionWith(other: ParametricLine): Coordinates? {
        return if (this.a - other.a == 0.0) {
            null
        } else {
            val newX = (other.b - this.b) / (this.a - other.a)
            val newY = this.a * newX + this.b
            if ((newX >= minOf(this.first.x, this.second.x)) &&
                    (newX <= maxOf(this.first.x, this.second.x)) &&
                    (newY <= maxOf(this.first.y, this.second.y)) &&
                    (newY >= minOf(this.first.y, this.second.y)) &&
                    (newX >= minOf(other.first.x, other.second.x)) &&
                    (newX <= maxOf(other.first.x, other.second.x)) &&
                    (newY <= maxOf(other.first.y, other.second.y)) &&
                    (newY >= minOf(other.first.y, other.second.y))) {
                Coordinates(newX, newY)
            } else {
                null
            }
        }
    }

    fun isAscending() = a > 0
    fun isDescending() = b < 0
    fun isHorizontal() = a == 0.0

    /**
     * @suppress
     */
    override fun toString() = "y = ${a}x + $b"
}
