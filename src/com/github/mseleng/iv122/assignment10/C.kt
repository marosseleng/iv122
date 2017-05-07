package com.github.mseleng.iv122.assignment10

import com.github.mseleng.iv122.util.Chart
import com.github.mseleng.iv122.util.timesRepeat
import org.jfree.data.xy.XYSeries
import java.awt.Color
import java.util.*

/**
 * @suppress
 */
enum class CLTExperimentStrategy { JUST_A, EACH_TOSS_RANDOM, EACH_ITERATION_RANDOM }

/**
 * Uses the central limit theorem to compute the distribution of averages of the cube tosses
 *
 * @param n the amount of tosses per iteration
 * @param k the amount of iterations
 * @param strategy the strategy to choose (just A, choose before each toss or choose before each iteration)
 * @return a chart visualizing the results (should look like the normal distribution)
 */
fun clt(n: Int, k: Int, strategy: CLTExperimentStrategy): Chart {
    val ranges = listOf((1..1), (2..3), (4..6), (7..10), (11..15), (16..21)) // probabilities (1/21, 2/21, 3/21, 4/21, 5/21, 6/21)
    val kA = ranges // cube that prefers larger values
    val kB = ranges.reversed() // cube that prefers smaller values

    val random = Random()
    val averages = mutableListOf<Double>()
    k.timesRepeat {
        val avg = when (strategy) {
            CLTExperimentStrategy.JUST_A -> {
                (1..n)
                        .map { random.nextInt(21) + 1 }
                        .map { rand ->
                            kA.indexOf(kA.first { rand in it }) + 1
                        }
            }
            CLTExperimentStrategy.EACH_TOSS_RANDOM -> {
                (1..n)
                        .map { random.nextInt(21) + 1 }
                        .map { rand ->
                            val usedCube = if (random.nextInt(2) == 0) { kA } else { kB }
                            usedCube.indexOf(usedCube.first { rand in it }) + 1
                        }
            }
            CLTExperimentStrategy.EACH_ITERATION_RANDOM -> {
                val usedCube = if (random.nextInt(2) == 0) { kA } else { kB }
                (1..n)
                        .map { random.nextInt(21) + 1 }
                        .map { rand ->
                            usedCube.indexOf(usedCube.first { rand in it }) + 1
                        }
            }
        }.sumBy { it } / n.toDouble()
        averages.add(avg)
    }
    
    val series = XYSeries("Averages")
    averages.groupBy { it }
            .mapValues { entry -> entry.value.count() }
            .forEach { x, y -> series.add(x, y.toDouble()) }

    return Chart("Central limit theorem", mapOf(Color.BLACK to series))
}
