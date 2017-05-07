package com.github.mseleng.iv122.assignment10

import com.github.mseleng.iv122.util.timesRepeat
import java.util.*

/**
 * @suppress
 */
enum class MontyHallChoice { STAY, CHANGE, WHATEVER }

/**
 * Simulates the Monty-Hall problem
 *
 * @param iterations the number of iterations to perform
 * @param choice the choice to choose
 * @return the rate of successful tries to the all tries
 */
fun montyHall(iterations: Int, choice: MontyHallChoice): Double {
    var successful = 0
    iterations.timesRepeat {
        val doorWithPrize = Random().nextInt(3)
        val yourChoice = Random().nextInt(3)
        // host opens the door...
        when (choice) {
            MontyHallChoice.STAY -> {
                if (doorWithPrize == yourChoice) {
                    successful++
                }
            }
            MontyHallChoice.CHANGE -> {
                if (doorWithPrize != yourChoice) {
                    successful++
                }
            }
            MontyHallChoice.WHATEVER -> {
                if (Random().nextInt(2) == 0) {
                    successful++
                }
            }
        }
    }

    return successful.toDouble() / iterations
}
