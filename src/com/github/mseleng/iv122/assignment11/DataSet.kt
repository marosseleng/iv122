package com.github.mseleng.iv122.assignment11

import com.github.mseleng.iv122.assignment6.generateRegularNPolygon
import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.timesRepeat
import org.jfree.data.function.LineFunction2D
import java.io.File
import java.util.*

/**
 * Generates the regression dataset around the function y = a*x + b
 *
 * @param a parameter defining the line
 * @param b parameter defining the line
 * @param deviation controls the deviation of the values
 * @param interval the x interval
 * @param n number of x values generated
 * @return list of points in the dataset representing the regression
 */
fun generateRegressionDataSet(a: Double, b: Double, deviation: Double, interval: Pair<Double, Double>, n: Int): List<Coordinates> {
    val line = LineFunction2D(b, a)

    return (1..n).map {
        val random = Random()
        val randX = interval.first + random.nextDouble() * (interval.second - interval.first)
        Coordinates(randX, random.nextGaussian() * deviation + line.getValue(randX))
    }
}

/**
 * Generates the dataset for the clustering
 *
 * @param n the number of clusters
 * @param radius the radius of the circle that the centers lay on
 * @param center the center of the circle that the centers lay on
 * @param clusterRadius the maximum distance between a point that belongs to a cluster and the cluster's center
 * @param totalPoints the number of points to generate
 * @return the list of generated points
 */
fun generateClustersDataSet(n: Int, radius: Double, center: Coordinates, clusterRadius: Double, totalPoints: Int): List<Coordinates> {
    val centersRandom = Random()
    val otherRandom = Random()
    val centers = generateRegularNPolygon(n, radius, center)
    val result = mutableListOf<Coordinates>()
    totalPoints.timesRepeat {
        val whichCenter = centersRandom.nextInt(n)
        val targetCenter = centers[whichCenter]
        val randomAngle = otherRandom.nextDouble() * 360
        val angleRadians = Math.toRadians(randomAngle)
        val distance = clusterRadius * otherRandom.nextDouble()
        result.add(Coordinates(targetCenter.x + distance * Math.sin(angleRadians), targetCenter.y + distance*Math.cos(angleRadians)))
    }
    return result
}

/**
 * Reads the dataset from the file. The format must be:
 * x-value y-value\n
 *
 * @param file file to read
 * @return list of points in the dataset representing the regression
 */
fun readDataSet(file: File) = file.readLines()
        .map { line ->
            Coordinates(
                    line.substringBefore(' ').toDoubleOrNull() ?: 0.0,
                    line.substringAfter(' ').toDoubleOrNull() ?: 0.0)
        }
