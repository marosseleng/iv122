package com.github.mseleng.iv122.assignment1

import com.github.mseleng.iv122.util.Chart
import com.github.mseleng.iv122.util.fileWithName
import org.jfree.data.xy.XYSeries
import java.awt.Color

/**
 * @suppress
 */
fun main(args: Array<String>) {
    collatz(8000)
    collatzWithMax(8000)
}

/**
 * Creates a chart containing data about Collatz's sequence
 *
 * x-axis represents the number, which the sequence starts in
 * y-axis shows the amount of steps until the x is equal to 1
 *
 * @param n the maximum number to show on the graph ((1..n) interval will be shown)
 */
fun collatz(n: Int) {
    val result = XYSeries("")
    for (number in 1..n) {
        var mutableNumber = number
        var steps = 1
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            steps++
        }
        result.add(number, steps)
    }
    Chart("", mapOf(Color.BLACK to result)).writeToPNG(fileWithName(1, "collatz.png"), 1000, 1000)
}

/**
 * Creates a chart containing data about Collatz's sequence
 *
 * x-axis represents the number, which the sequence starts in
 * y-axis represents the maximum number that could be reached when the sequence starts in that particular x
 *
 * @param n the maximum number to show on the graph ((1..n) interval will be shown)
 */
fun collatzWithMax(n: Int) {
    val result = XYSeries("")
    for (number in 1..n) {
        var mutableNumber = number
        var max = mutableNumber
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            max = maxOf(mutableNumber, max)
        }
        result.add(number, max)
    }
    Chart("", mapOf(Color.BLACK to result)).writeToPNG(fileWithName(1, "collatz-max.png"), 1000, 1000)
}