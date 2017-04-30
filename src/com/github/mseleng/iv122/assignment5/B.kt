package com.github.mseleng.iv122.assignment5

/*
fun main(args: Array<String>) {
    convexCover(70, 6).writeTo(fileWithName(assignmentNo = 5, name = "points.svg"))
}

fun convexCover(imgSize: Int, numOfPoints: Int): SVG {
    val svg = SVG()
    val points = /*listOf(Coordinates(46, 70), Coordinates(26, 27), Coordinates(35, 30), Coordinates(19, 40), Coordinates(29, 28), Coordinates(25, 6)).sortedBy { it.x }*/randomPoints(numOfPoints, imgSize, imgSize)
    points.forEach {
        svg.point(it)
    }

    val usedPoints = mutableListOf<Coordinates>()
    val leftMost = points.minBy { it.x } ?: points.first()
    var last = leftMost




//    points.forEach { point ->
//        points.forEach {
//            println("Polar angle from $point to $it = ${point.polarAngleTo(it)}")
//        }
//        println("****************************")
//    }



    do {
        val current = points.minus(usedPoints).filter { last.polarAngleTo(it) != 0.0 }.minBy { last.polarAngleTo(it) + 90 } ?: last
        println("$last -> $current (angle = ${last.polarAngleTo(current)})")
        svg.line(last, current)
        last = current
        usedPoints.add(last)
    } while (last != leftMost)
    return svg
}
*/
