package com.github.mseleng.iv122.assignment11

import com.github.mseleng.iv122.assignment7.newtonColors
import com.github.mseleng.iv122.util.Chart
import com.github.mseleng.iv122.util.Coordinates
import org.jfree.data.xy.XYSeries
import java.awt.Color
import java.awt.Paint
import java.io.File
import java.util.*

/**
 * Finds and draws the points and colors them by the cluster they belong to
 *
 * Uses the k-means algorithm
 *
 * @param points the points to divide to clusters
 * @param n the number of clusters
 * @param targetFile the function that should return the file for each chart saved
 */
fun findClustersKMeans(points: List<Coordinates>, n: Int, chartName: String, targetFile: (Int) -> File) {
    val initialPointsSeries = XYSeries("points")
    points.forEach {
        initialPointsSeries.add(it.x, it.y)
    }
    var i = 0
    Chart(chartName, mapOf(Color.BLACK to initialPointsSeries), emptyList())
            .writeToPNG(targetFile(i++), 1000, 1000)
    val initCenters = computeCenters(points, n)
    var currentCenters = initCenters
    var clusters: Map<Coordinates, List<Coordinates>>

    do {
        val dataMap = mutableMapOf<Paint, XYSeries>()
        val oldCenters = currentCenters
        clusters = kMeansIteration(currentCenters, points)
        var j = 0
        clusters.forEach { key, value ->
            val color = newtonColors[j % newtonColors.count()]
            val series = XYSeries("cluster${j++}")
            value.forEach { series.add(it.x, it.y) }
            dataMap.put(color, series)
        }
        currentCenters = clusters.keys
        Chart(chartName, dataMap, emptyList()).writeToPNG(targetFile(i++), 1000, 1000)
    } while (oldCenters != currentCenters)
}

/**
 * Computes the initial centers by randomly choosing centers from the points
 *
 * @param points the list of points
 * @param n the number of clusters (centers to find)
 * @return the initial centers
 */
fun computeCenters(points: List<Coordinates>, n: Int): Set<Coordinates> {
    val result = mutableSetOf<Coordinates>()
    val random = Random()
    do {
        result.add(points[random.nextInt(points.count())])
    } while (result.count() != n)

    return result
}

/**
 * Performs one iteration of the k-means algorithm
 *
 * @param centers the "old" centers
 * @param points the list of points
 * @return the new division of points between the new centers
 */
fun kMeansIteration(centers: Set<Coordinates>, points: List<Coordinates>): Map<Coordinates, List<Coordinates>> {
    val preResult = mutableMapOf<Coordinates, MutableList<Coordinates>>()
    for (center in centers) {
        preResult.put(center, mutableListOf())
    }
    for (point in points) {
        // for each point compute the center which the point belongs to
        val closestCenter = centers.minBy { Math.pow(point.euclideanDistanceFrom(it), 2.0) } ?: centers.first()
        preResult[closestCenter]?.add(point)
    }
    val realResult = mutableMapOf<Coordinates, List<Coordinates>>()
    // now compute the new centers
    for (list in preResult.values) {
        val x = list.sumByDouble { it.x } / list.count()
        val y = list.sumByDouble { it.y } / list.count()
        realResult.put(Coordinates(x, y), list)
    }
    return realResult
}
