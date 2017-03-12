package com.github.mseleng.iv122.assignment1

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.isPrime
import com.github.mseleng.iv122.util.svgFileWithName
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color

fun run(args: Array<String>) {
    val path = args.getOrElse(0) { "outputs" }
    // A
    getFourWayGradient(2500, Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA).writeTo(fileWithName(path, 1, "gradient.png"))
    getStar(28, 50).writeTo(svgFileWithName(path, 1, "star"))
    getInsideOutStarSVG(28, 50).writeTo(svgFileWithName(path, 1, "weird-star"))

    //B
    // display all x such that (x is prime)
    getUlamsSpiral(99999, Int::isPrime).writeTo(fileWithName(path, 1, "ulamsSpiral-[prime].png"))
    // display all x such that (x mod 5 > 1)
    getUlamsSpiral(99999, { it.rem(5) > 1 }).writeTo(fileWithName(path, 1, "ulamsSpiral-[mod5>1].png"))
    // display all x such that (((x * E) mod PI) >= 2)
    getUlamsSpiral(99999, { it.times(Math.E).rem(Math.PI) >= 2 }).writeTo(fileWithName(path, 1, "ulamsSpiral-[*EmodPI>=2].png"))

    //C
    collatz(8000).writeToPNG(fileWithName(path, 1, "collatz.png"), 1000, 1000)
    collatzWithMax(8000).writeToPNG(fileWithName(path, 1, "collatz-max.png"), 1000, 1000)

    //D
    getChartOfModulo(500, 500).writeToPNG(fileWithName(path, 1, "euclid-[modulus].png"), 2000, 2000)
    getChartOfSubtraction(500, 500).writeToPNG(fileWithName(path, 1, "euclid-[subtraction].png"), 2000, 2000)
}
