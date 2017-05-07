package com.github.mseleng.iv122.assignment10

import com.github.mseleng.iv122.util.timesRepeat
import java.util.*

/**
 * Computes the probability using the experiment
 *
 * @param n the number of cubes in the bag
 * @param x the amount of throws
 * @param iterations the number of iterations to perform
 * @return the probability
 */
fun experimentForCubes(n: Int, x: Int, iterations: Int): Double {
    var successes = 0
    val random = Random()
    val badCube = random.nextInt(n) // which one is bad
    iterations.timesRepeat {
        // one iteration is an equivalent of choosing a cube from the bag
        val randomCube = random.nextInt(n) // randomly choose a cube
        // check if all x throws gave 6s (in our case 5, because 0->5)
        if ((1..x).map { random.nextInt(6) }.all { it == 5 } && badCube != randomCube) {
            successes++
        }
    }
    return successes.toDouble() / iterations
}

/**
 * Computes the probability using the Bayes' formula
 *
 * @param n the number of cubes in the bag
 * @param x the amount of throws
 * @return the probability
 */
fun bayesForCubes(n: Int, x: Int): Double {
    // probability that Cube is good * probability of "always-six" iff Cube is good
    val numerator = Math.pow(1.0 / 6, x.toDouble()) * ((n - 1) / n.toDouble())
    // probability of "always-six" (when the Cube is good + when the Cube is bad)
    val denominator = numerator + 1.0 / n
    return numerator / denominator
}
