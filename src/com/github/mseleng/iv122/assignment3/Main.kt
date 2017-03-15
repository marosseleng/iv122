package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.SVG
import com.github.mseleng.iv122.util.fileWithName

/**
 * @suppress
 */
fun run(args: Array<String>) {
    //A
    SVG().lines(polygon(7, 200)).writeTo(fileWithName(assignmentNo = 3, name = "polygon7.svg"))
    SVG().lines(polygon(9, 200)).writeTo(fileWithName(assignmentNo = 3, name = "polygon9.svg"))
    SVG().lines(polygon(17, 100)).writeTo(fileWithName(assignmentNo = 3, name = "polygon17.svg"))
    SVG().lines(multistar(n = 9, a = 80)).writeTo(fileWithName(assignmentNo = 3, name = "multistar9.svg"))
    SVG().lines(multistar(n = 5, a = 80)).writeTo(fileWithName(assignmentNo = 3, name = "multistar5.svg"))

    //B
    SVG().lines(pentagram(135, 100)).writeTo(fileWithName(assignmentNo = 3, name = "pentagram.svg"))

    //C

    //D
}
