package com.github.mseleng.iv122.assignment3

import com.github.mseleng.iv122.util.Line

/**
 * Created by mseleng on 3/15/17.
 */


fun pentagram(n: Int, length: Int): List<Line> {
    val border = polygon(n, length)
    val innerStar = multistar(n = n, a = length)
    val retList = mutableListOf<Line>()
    retList.addAll(border)
    retList.addAll(innerStar)
    return retList
}
