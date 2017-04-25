package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color

/**
 * The lime-purple color scheme
 */
val limePurple = listOf(
        Color.decode("0x4a148c"), Color.decode("0x6a1b9a"), Color.decode("0x7b1fa2"), Color.decode("0x8e24aa"), Color.decode("0x9c27b0"), Color.decode("0xab47bc"), Color.decode("0xba68c8"), Color.decode("0xce93d8"), Color.decode("0xe1bee7"), Color.decode("0xf3e5f5"),
        Color.decode("0xf9fbe7"), Color.decode("0xf0f4c3"), Color.decode("0xe6ee9c"), Color.decode("0xdce775"), Color.decode("0xd4e157"), Color.decode("0xcddc39"), Color.decode("0xc0ca33"), Color.decode("0xafb42b"), Color.decode("0x9e9d24"), Color.decode("0x827717"))

/**
 * Inner colors nicely matching the lime-purple combination
 */
val innerForLinePurple = Pair(Color.decode("0xe91e63"), Color.BLUE)

/**
 * The light blue-brown color scheme
 */
val lightBlueBrown = listOf(
        Color.decode("0x3e2723"), Color.decode("0x5d4037"), Color.decode("0x795548"), Color.decode("0xa1887f"), Color.decode("0xd7ccc8"), Color.decode("0xefebe9"),
        Color.decode("0xb2dfdb"), Color.decode("0x80cbc4"), Color.decode("0x26a69a"), Color.decode("0x00897b"), Color.decode("0x00695c"), Color.decode("0x004d40"))

/**
 * Inner colors nicely matching the lightblue-brown combination
 */
val innerForLightBlueBrown = Pair(Color.decode("0x9e9e9e"), Color.decode("0xff6d00"))

/**
 * The indigo-gray color scheme
 */
val indigoGray = listOf(
        Color.decode("0x212121"), Color.decode("0x424242"), Color.decode("0x616161"), Color.decode("0x757575"), Color.decode("0x9e9e9e"), Color.decode("0xbdbdbd"), Color.decode("0xe0e0e0"), Color.decode("0xeeeeee"), Color.decode("0xf5f5f5"), Color.decode("0xfafafa"),
        Color.decode("0xe8eaf6"), Color.decode("0xc5cae9"), Color.decode("0x9fa8da"), Color.decode("0x7986cb"), Color.decode("0x5c6bc0"), Color.decode("0x3f51b5"), Color.decode("0x3949ab"), Color.decode("0x303f9f"), Color.decode("0x283593"), Color.decode("0x1a237e"))

/**
 * Inner colors nicely matching the indigo-gray combination
 */
val innerForIndigoGray = Pair(Color.decode("0xa1887f"), Color.decode("0x76ff03"))

/**
 * @suppress
 */
fun run(path: String) {
    print("-> Mandelbrot set (not zoomed)......")
    //4500x3000
    mandelbrot(1500, 1000, Pair(-2.0, 1.0), Pair(-1.0, 1.0), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-2_00|1_00=-1_00|1_00=.png"))
    print(" ✓ (assignment7/mandelbrot=-2_00|1_00=-1_00|1_00=.png)\n-> Mandelbrot set (r∈[-1.5;-1.2], i∈[-0.1;0.1])......")
    //4500x3000
    mandelbrot(1500, 1000, Pair(-1.5, -1.2), Pair(-0.1, 0.1), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-1_50|-1_20=-0_10|0_10=.png"))
    print(" ✓ (assignment7/mandelbrot=-1_50|-1_20=-0_10|0_10=.png)\n-> Mandelbrot set (r∈[-1.456;-1.336], i∈[-0.06;0.06])......")
    //4500x4500
    mandelbrot(1500, 1500, Pair(-1.456, -1.336), Pair(-0.06, 0.06), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-1_456|-1_336=-0_06|0_06=.png"))
    print(" ✓ (assignment7/mandelbrot=-1_456|-1_336=-0_06|0_06=.png)\n-> Mandelbrot set (r∈[-2.0;1.0], i∈[0.0;1.0])......")
    //4500x1500
    mandelbrot(1500, 500, Pair(-2.0, 1.0), Pair(0.0, 1.0), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-2_00|1_00=0_00|1_00=.png"))
    print(" ✓ (assignment7/mandelbrot=-2_00|1_00=0_00|1_00=.png)\n-> Mandelbrot set (r∈[-0.5;-0.4], i∈[0.55;0.65])......")
    //3500x3500
    mandelbrot(1000, 1000, Pair(-0.5, -0.4), Pair(0.55, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_40=0_55|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_40=0_55|0_65=.png)\n-> Mandelbrot set (r∈[-0.5;-0.45], i∈[0.6;0.65])......")
    //3500x3500
    mandelbrot(1000, 1000, Pair(-0.5, -0.45), Pair(0.6, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_45=0_60|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_45=0_60|0_65=.png)\n-> Mandelbrot set (r∈[-0.5;-0.475], i∈[0.625;0.65])......")
    //3500x3500
    mandelbrot(1000, 1000, Pair(-0.5, -0.475), Pair(0.625, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_475=0_625|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_475=0_625|0_65=.png)\n==========\n")
}

fun main(args: Array<String>) {
    run("iv122_outputs")
}
