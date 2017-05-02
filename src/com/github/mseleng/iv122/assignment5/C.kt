package com.github.mseleng.iv122.assignment5

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.fileWithName

fun convexHull(imgSize: Int, n: Int): Pair<List<Coordinates>, List<Coordinates>> {
    val inputPoints = randomPoints(n, imgSize, imgSize)

    val hull = mutableListOf<Coordinates>()
    val leftMost = inputPoints.minBy { it.x } ?: inputPoints.first()

    // Start from leftmost point, keep moving counterclockwise
    // until reach the start point again.  This loop runs O(h)
    // times where h is number of points in result or output.
    var p = leftMost
    var q: Int
    do {
        // Add current point to result
        hull.add(p)

        // Search for a point 'q' such that orientation(p, x,
        // q) is counterclockwise for all points 'x'. The idea
        // is to keep track of last visited most counterclock-
        // wise point in q. If any point 'i' is more counterclock-
        // wise than q, then update q.
        val iP = inputPoints.indexOf(p)
        q = (iP + 1) % n
        (0..n - 1)
                .asSequence()
                .filter {
                    // If i is more counterclockwise than current q, then
                    // update q
                    orientation(inputPoints[iP], inputPoints[it], inputPoints[q]) == 2
                }
                .forEach { q = it }

        // Now q is the most counterclockwise with respect to p
        // Set p as q for next iteration, so that q is added to
        // result 'hull'
        p = inputPoints[q]

    } while (p != leftMost)  // While we don't come to first point
    return Pair(inputPoints, hull)
}

fun orientation(p: Coordinates, q: Coordinates, r: Coordinates): Int {
    val value = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)

    return if (value == 0.0) {
        // colinear
        0
    } else if (value > 0) {
        // clockwise
        1
    } else {
        //counterclock wise
        2
    }
}
