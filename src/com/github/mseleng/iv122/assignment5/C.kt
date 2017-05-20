package com.github.mseleng.iv122.assignment5

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.fileWithName

/**
 * Implementation of the gift-wrapping algorithm to find the complex hull
 * I needed the Internet's help for this one
 */
fun convexHull(imgSize: Int, n: Int): Pair<List<Coordinates>, List<Coordinates>> {
    val inputPoints = randomPoints(n, imgSize, imgSize)

    val hull = mutableListOf<Coordinates>()
    val leftMost = inputPoints.minBy { it.x } ?: inputPoints.first()

    // Start from leftmost point, keep moving counterclockwise
    var p = leftMost
    var q: Int
    do {
        // Add current point to result
        hull.add(p)

        val iP = inputPoints.indexOf(p)
        q = (iP + 1) % n
        (0..n - 1)
                .asSequence()
                .filter {
                    orientation(inputPoints[iP], inputPoints[it], inputPoints[q]) == 2
                }
                .forEach { q = it }

        p = inputPoints[q]

    } while (p != leftMost)  // While we don't come to first point
    return Pair(inputPoints, hull)
}

/**
 * Returns the orientation, which are the input points located in
 *
 * @return 0 if the points are collinear, 1 if they are in clockwise order, 2 else
 */
fun orientation(p: Coordinates, q: Coordinates, r: Coordinates): Int {
    val value = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)

    return if (value == 0.0) {
        // collinear
        0
    } else if (value > 0) {
        // clockwise
        1
    } else {
        // counterclockwise
        2
    }
}
