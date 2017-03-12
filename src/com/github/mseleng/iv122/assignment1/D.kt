package com.github.mseleng.iv122.assignment1

import com.github.mseleng.iv122.util.Chart
import org.jfree.data.xy.XYSeries
import java.awt.Color
import java.awt.Paint

/**
 * Class representing tuple of two numbers (gcd and the number of steps needed to get it)
 *
 * @param gcd the resulting greatest common divisor
 * @param steps the number of steps needed to calculate that gcd
 * @constructor creates a simple tuple/pair
 */
data class EuclidSolution(val gcd: Long, val steps: Int)

/**
 * Computes the greatest common divisor of two given integers
 */
fun gcd(first: Int, second: Int): Long {
    return gcd(first.toLong(), second.toLong())
}

/**
 * Computes the greatest common divisor of two given long integers
 */
fun gcd(first: Long, second: Long): Long {
    return euclidMod(first, second).gcd
}

/**
 * Returns the [Chart] visualizing the number of steps needed to compute the gcd of two numbers (x,y)
 *
 * The resulting [Chart] vizualizes the computation using the modulo-based method
 *
 * @param maxX the maximum number on the x-axis
 * @param maxY the maximum number on the y-axis
 * @return a [Chart] visualizing the number of steps of computing the gcd
 */
fun getChartOfModulo(maxX: Int, maxY: Int): Chart {
    // setting the colors
    val result = mutableMapOf(
            NumberOfSteps.ONE_TO_THREE to XYSeries("1-3"),
            NumberOfSteps.FOUR_TO_FIVE to XYSeries("4-5"),
            NumberOfSteps.SIX_TO_EIGHT to XYSeries("6-8"),
            NumberOfSteps.NINE_TO_TEN to XYSeries("9-10"),
            NumberOfSteps.MORE_THAN_TEN to XYSeries("10<"))
    for (x in 1..maxX) {
        for (y in 1..maxY) {
            val (_, steps) = euclidMod(x, y)
            result[getNumberOfStepsEnum(steps)]?.add(x, y)
        }
    }
    return Chart("The number of steps needed to compute GCD of two numbers using the Euclid's modulus algorithm.",
            result.mapKeys { it.key.getPaint() }, true)
}

/**
 * @suppress
 */
private fun euclidMod(x: Int, y: Int): EuclidSolution {
    return euclidMod(x.toLong(), y.toLong())
}

/**
 * @suppress
 */
private fun euclidMod(x: Long, y: Long): EuclidSolution {
    if (y == 0L) {
        return EuclidSolution(x, 1)
    } else {
        return euclidMod(y, x.rem(y)).let { EuclidSolution(it.gcd, it.steps + 1) }
    }
}

/**
 * Returns the [Chart] visualizing the number of steps needed to compute the gcd of two numbers (x,y)
 *
 * The resulting [Chart] visualizes the computation using the subtraction-based method
 *
 * @param maxX the maximum number on the x-axis
 * @param maxY the maximum number on the y-axis
 * @return a [Chart] visualizing the number of steps of computing the gcd
 */
fun getChartOfSubtraction(maxX: Int, maxY: Int): Chart {
    // setting the colors
    val result = mutableMapOf(
            NumberOfSteps.ONE_TO_THREE to XYSeries("1-3"),
            NumberOfSteps.FOUR_TO_FIVE to XYSeries("4-5"),
            NumberOfSteps.SIX_TO_EIGHT to XYSeries("6-8"),
            NumberOfSteps.NINE_TO_TEN to XYSeries("9-10"),
            NumberOfSteps.MORE_THAN_TEN to XYSeries("10<"))
    for (x in 1..maxX) {
        for (y in 1..maxY) {
            val (_, steps) = euclidSub(x, y)
            result[getNumberOfStepsEnum(steps)]?.add(x, y)
        }
    }
    return Chart("The number of steps needed to compute GCD of two numbers using the Euclid's subtraction algorithm.",
            result.mapKeys { it.key.getPaint() }, true)
}

/**
 * @suppress
 */
private fun euclidSub(x: Int, y: Int): EuclidSolution {
    val bigger = maxOf(x, y)
    val smaller = minOf(x, y)
    if (bigger == smaller) {
        return EuclidSolution(smaller.toLong(), 1)
    } else {
        return euclidSub(bigger - smaller, smaller).let { EuclidSolution(it.gcd, it.steps + 1) }
    }
}

/**
 * An enum class representing the different colors of the graph
 *
 * @suppress
 */
private enum class NumberOfSteps(val from: Int, val to: Int) {
    ONE_TO_THREE(1, 3) {
        override fun getPaint(): Paint = Color.RED
    },
    FOUR_TO_FIVE(4, 5) {
        override fun getPaint(): Paint = Color.ORANGE
    },
    SIX_TO_EIGHT(6, 8) {
        override fun getPaint(): Paint = Color.YELLOW
    },
    NINE_TO_TEN(9, 10) {
        override fun getPaint(): Paint = Color.GREEN
    },
    MORE_THAN_TEN(11, Int.MAX_VALUE) {
        override fun getPaint(): Paint = Color.BLUE
    };

    abstract fun getPaint(): Paint
}

/**
 * A helper function that 'parses' the given int to the enum
 *
 * @suppress
 */
private fun getNumberOfStepsEnum(steps: Int) = NumberOfSteps.values().filter { steps >= it.from && steps <= it.to }.first()
