package com.github.mseleng.iv122.assignment1

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.isPrime
import com.github.mseleng.iv122.util.svgFileWithName
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color

/**
 * @suppress
 */
fun run(path: String) {
    // A
    print("-> Four-way gradient......")
    getFourWayGradient(2500, Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA).writeTo(fileWithName(path, 1, "gradient.png"))
    print(" ✓ (assignment1/gradient.png)\n-> A star......")
    getStar(28, 50).writeTo(svgFileWithName(path, 1, "star"))
    print(" ✓ (assignment1/star.svg)\n-> An \"inside-out\" star......")
    getInsideOutStarSVG(28, 50).writeTo(svgFileWithName(path, 1, "weird-star"))
    print(" ✓ (assignment1/weird-star.svg)\n==========\n-> The Ulam's spiral I.(prime numbers)......")

    //B
    // display all x such that (x is prime)
    getUlamsSpiral(99999, Int::isPrime).writeTo(fileWithName(path, 1, "ulamsSpiral-[prime].png"))
    print(" ✓ (assignment1/ulamsSpiral-[prime].png)\n-> The Ulam's spiral II.(x mod 5 > 1)......")
    // display all x such that (x mod 5 > 1)
    getUlamsSpiral(99999, { it.rem(5) > 1 }).writeTo(fileWithName(path, 1, "ulamsSpiral-[mod5>1].png"))
    print(" ✓ (assignment1/ulamsSpiral-[mod5>1].png)\n-> The Ulam's spiral III.(x*e mod π >= 2).......")
    // display all x such that (((x * E) mod PI) >= 2)
    getUlamsSpiral(99999, { it.times(Math.E).rem(Math.PI) >= 2 }).writeTo(fileWithName(path, 1, "ulamsSpiral-[*EmodPI>=2].png"))
    print(" ✓ (assignment1/ulamsSpiral-[*EmodPI>=2].png)\n==========\n-> The Collatz's sequence......")

    //C
    collatz(8000).writeToPNG(fileWithName(path, 1, "collatz.png"), 1000, 1000)
    print(" ✓ (assignment1/collatz.png)\n-> The Collatz's sequence (the maximum numbers)......")
    collatzWithMax(8000).writeToPNG(fileWithName(path, 1, "collatz-max.png"), 1000, 1000)
    print(" ✓ (assignment1/collatz-max.png)\n==========\n-> The Euclidean gcd algorithm (modulo variant)......")

    //D
    getChartOfModulo(500, 500).writeToPNG(fileWithName(path, 1, "euclid-[modulus].png"), 2000, 2000)
    print(" ✓ (assignment1/euclid-[modulus].png)\n-> The Euclidean gcd algorithm (subtraction variant)......")
    getChartOfSubtraction(500, 500).writeToPNG(fileWithName(path, 1, "euclid-[subtraction].png"), 2000, 2000)
    println(" ✓ (assignment1/euclid-[subtraction].png)")
}
