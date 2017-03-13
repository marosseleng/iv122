package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.util.pow
import java.util.*

/**
 * Class representing an interval, within which the value of π is. This is used just in the Archimedes method
 *
 * @param inscribed the perimeter of the inscribed polygon
 * @param circumscribed the perimeter of the circumscribed polygon
 */
data class ArchimedesπRange(val inscribed: Double, val circumscribed: Double) {
    override fun toString() = "$inscribed < π < $circumscribed"
}

/**
 * Approximates the value of π using the [Monte Carlo](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Summing_a_circle.27s_area) method
 *
 * You can pass different implementations of [square] and [sqrt] functions to see the difference in the accuracy
 *
 * @param interval_ms the time interval, which the value be approximated in
 * @param square a function that squares a number
 * @param sqrt a function that computes the square root of a number
 * @return an approximated value of π
 */
fun pi_MonteCarlo(interval_ms: Long, square: (Double) -> Double, sqrt: (Double) -> Double): Double {
    val xRandom = Random()
    val yRandom = Random()
    var totalPoints = 0
    var insidePoints = 0
    val startTime = System.currentTimeMillis()
    do {
        val x = xRandom.nextDouble()
        val y = yRandom.nextDouble()
        totalPoints = totalPoints.inc()
        if (sqrt(square(x).plus(square(y))) <= 1) {
            insidePoints = insidePoints.inc()
        }
    } while (System.currentTimeMillis() - startTime <= interval_ms)
    return 4.times(insidePoints.div(totalPoints.toDouble()))
}

/**
 * Approximates the value of π using the [Gregory-Leibniz](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Gregory.E2.80.93Leibniz_series) series
 *
 * @param interval_ms the time interval, which the value be approximated in
 * @return an approximated value of π
 */
fun pi_GregoryLeibniz(interval_ms: Long): Double {
    var n = 1
    var result = 1.0
    val startTime = System.currentTimeMillis()
    do {
        result += (-1).pow(n).div(2.times(n).plus(1).toDouble())
        n = n.inc()
    } while (System.currentTimeMillis() - startTime <= interval_ms)
    return result.times(4)
}

/**
 * Approximates the value of π using the [Archimedes'](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Polygon_approximation_to_a_circle) method
 *
 * You can pass different implementations of the [sqrt] function to see the difference in the accuracy
 *
 * @param interval_ms the time interval, which the value be approximated in
 * @param sqrt a function that computes the square root of a number
 * @return an approximated value of π
 */
fun pi_Archimedes(interval_ms: Long, sqrt: (Double) -> Double): ArchimedesπRange {
    val sqrtOfPointFive = sqrt(0.5)
    var currentSides = 4
    var currentInscribed = currentSides.times(sqrtOfPointFive)
    var currentCircumscribed = currentSides.times(1.0)
    val startTime = System.currentTimeMillis()
    do {
        val circumscribed = 2.times(currentInscribed).times(currentCircumscribed)
                .div(currentInscribed.plus(currentCircumscribed))
        val inscribed = sqrt(currentInscribed.times(circumscribed))
        currentCircumscribed = circumscribed
        currentInscribed = inscribed
        currentSides = currentSides.times(2)
    } while (System.currentTimeMillis() - startTime <= interval_ms)
    return ArchimedesπRange(currentInscribed, currentCircumscribed)
}
