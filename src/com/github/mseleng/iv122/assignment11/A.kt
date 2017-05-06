package com.github.mseleng.iv122.assignment11

import com.github.mseleng.iv122.util.Chart
import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.timesRepeat
import org.jfree.chart.renderer.xy.XYDotRenderer
import org.jfree.data.function.LineFunction2D
import org.jfree.data.general.DatasetUtilities
import org.jfree.data.xy.XYSeries
import java.awt.Color
import java.io.File

/**
 * Computes the linear regression analytically (using a formula)
 */
fun regressionAnalytical(data: List<Coordinates>): Chart {
    val series = XYSeries("points")

    val n = data.count()
    var sumXY = 0.0
    var sumX = 0.0
    var sumY = 0.0
    var sumXPow = 0.0
    data.forEach { (x, y) ->
        sumXY += x * y
        sumX += x
        sumY += y
        sumXPow += x * x
        series.add(x, y)
    }

    val avgX = data.sumByDouble { it.x } / n
    val avgY = data.sumByDouble { it.y } / n

    val a = (n * sumXY - sumX * sumY) / (n * sumXPow - (sumX * sumX))
    val b = avgY - a * avgX

    val minX = data.minBy { it.x }?.x ?: 0.0
    val maxX = data.maxBy { it.x }?.x ?: 1.0

    val format = if (b < 0) {
        "y=%.4fx %.4f"
    } else if (b > 0) {
        "y=%.4fx + %.4f"
    } else {
        "y=%.4fx"
    }

    // LineFunction2D uses y = b*x + a
    val lineFunction2D = LineFunction2D(b, a)
    val lineSeries = DatasetUtilities.sampleFunction2DToSeries(lineFunction2D, minX, maxX, 1000, String.format(format, a, b))

    return Chart(
            "Linear regression - analytical solution",
            mapOf(Color.BLACK to series, Color.GREEN to lineSeries),
            listOf(null, XYDotRenderer()),
            true)
}

/**
 * Computes the linear regression using the gradient-descent algorithm
 */
fun gradientDescent(initialA: Double, initialB: Double, points: List<Coordinates>, learningRate: Double, numOfIterations: Int = 50, targetFile: (Int) -> File) {
    var result = Pair(initialA, initialB)
    val format: (Double) -> String = {
        if (it < 0) {
            "y=%.4fx %.4f"
        } else if (it > 0) {
            "y=%.4fx + %.4f"
        } else {
            "y=%.4fx"
        }
    }
    numOfIterations.timesRepeat { i ->
        result = gradientDescentStep(result.first, result.second, points, learningRate)

        val pointsSeries = XYSeries("points")
        points.forEach {
            pointsSeries.add(it.x, it.y)
        }

        val (a, b) = result
        val minX = points.minBy { it.x }?.x ?: 0.0
        val maxX = points.maxBy { it.x }?.x ?: 1.0

        val lineFunction2D = LineFunction2D(b, a)
        val lineSeries = DatasetUtilities.sampleFunction2DToSeries(lineFunction2D, minX, maxX, 1000, String.format(format(b), a, b))

        Chart("Linear regression - gradient descent",
                mapOf(Color.BLACK to pointsSeries, Color.GREEN to lineSeries),
                listOf(null, XYDotRenderer()),
                true).writeToPNG(targetFile(i), 1000, 1000)
    }
}

/**
 * Performs one step of the gradient-descent algorithm
 */
fun gradientDescentStep(a: Double, b: Double, points: List<Coordinates>, learningRate: Double): Pair<Double, Double> {
    val aDiff = -points.sumByDouble { it.x * (it.y - (a * it.x + b)) }
    val bDiff = -points.sumByDouble { it.y - (a * it.x + b) }

    return Pair(a - (learningRate * aDiff), b - (learningRate * bDiff))
}