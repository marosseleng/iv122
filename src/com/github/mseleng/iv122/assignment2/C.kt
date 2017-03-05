package com.github.mseleng.iv122.assignment2

import com.github.mseleng.iv122.util.pow

fun main(args: Array<String>) {
    println(rationalPower_1(2.0, 0.5))
    println(rationalPower_1(3.0, 0.5))
    println(rationalPower_1(3.0, 3.14))
}

fun rationalPower_1(base: Double, exponent: Double): Double {
    return base.pow(exponent)
}