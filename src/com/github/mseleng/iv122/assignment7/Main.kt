package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.Complex
import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo

/**
 * @suppress
 */
fun run(path: String) {
    print("-> Mandelbrot set (not zoomed)......")
    mandelbrot(4500, 3000, Pair(-2.0, 1.0), Pair(-1.0, 1.0), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-2_00|1_00=-1_00|1_00=.png"))
    print(" ✓ (assignment7/mandelbrot=-2_00|1_00=-1_00|1_00=.png)\n-> Mandelbrot set (r∈[-1.5;-1.2], i∈[-0.1;0.1])......")
    mandelbrot(4500, 3000, Pair(-1.5, -1.2), Pair(-0.1, 0.1), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-1_50|-1_20=-0_10|0_10=.png"))
    print(" ✓ (assignment7/mandelbrot=-1_50|-1_20=-0_10|0_10=.png)\n-> Mandelbrot set (r∈[-1.456;-1.336], i∈[-0.06;0.06])......")
    mandelbrot(4500, 4500, Pair(-1.456, -1.336), Pair(-0.06, 0.06), limePurple, innerForLinePurple)
            .writeTo(fileWithName(path, 7, "mandelbrot=-1_456|-1_336=-0_06|0_06=.png"))
    print(" ✓ (assignment7/mandelbrot=-1_456|-1_336=-0_06|0_06=.png)\n-> Mandelbrot set (r∈[-2.0;1.0], i∈[0.0;1.0])......")
    mandelbrot(4500, 1500, Pair(-2.0, 1.0), Pair(0.0, 1.0), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-2_00|1_00=0_00|1_00=.png"))
    print(" ✓ (assignment7/mandelbrot=-2_00|1_00=0_00|1_00=.png)\n-> Mandelbrot set (r∈[-0.5;-0.4], i∈[0.55;0.65])......")
    mandelbrot(3500, 3500, Pair(-0.5, -0.4), Pair(0.55, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_40=0_55|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_40=0_55|0_65=.png)\n-> Mandelbrot set (r∈[-0.5;-0.45], i∈[0.6;0.65])......")
    mandelbrot(3500, 3500, Pair(-0.5, -0.45), Pair(0.6, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_45=0_60|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_45=0_60|0_65=.png)\n-> Mandelbrot set (r∈[-0.5;-0.475], i∈[0.625;0.65])......")
    mandelbrot(3500, 3500, Pair(-0.5, -0.475), Pair(0.625, 0.65), indigoGray, innerForIndigoGray)
            .writeTo(fileWithName(path, 7, "mandelbrot=-0_50|-0_475=0_625|0_65=.png"))
    print(" ✓ (assignment7/mandelbrot=-0_50|-0_475=0_625|0_65=.png)\n-> Mandelbrot set (zoom to (0+i))......")
    zoomedMandelbrot(700, Complex(0.0, 1.0), 1.25, 120, indigoGray) { i -> fileWithName(path, 7, "top${String.format("%03d", i)}.png") }
    print(" ✓ (assignment7/top%03d[1-120].png)\n-> Mandelbrot set (zoom to (-1.75))......")
    zoomedMandelbrot(700, Complex(-1.75, 0.0), 1.15, 25, indigoGray) { i -> fileWithName(path, 7, "mini${String.format("%03d", i)}.png") }
    print(" ✓ (assignment7/mini%03d[1-25].png)\n-> Mandelbrot set (zoom to (-1.25))......")
    zoomedMandelbrot(700, Complex(-1.25, 0.0), 1.15, 15, limePurple.reversed()) { i -> fileWithName(path, 7, "stem${String.format("%03d", i)}.png") }
    print(" ✓ (assignment7/stem%03d[1-15].png)\n-> Mandelbrot set (zoom to (-0.1528 + 1.0397i))......")
    zoomedMandelbrot(700, Complex(-0.1528, 1.0397), 1.15, 30, lightBlueBrown) { i -> fileWithName(path, 7, "Feigenbaum${String.format("%03d", i)}.png") }
    print(" ✓ (assignment7/Feigenbaum%03d[1-30].png)\n-> Mandelbrot set (zoom to (-0.1011 + 0.9563i))......")
    zoomedMandelbrot(700, Complex(-0.1011, 0.9563), 1.2, 50, indigoGray) { i -> fileWithName(path, 7, "Misiurewicz${String.format("%03d", i)}.png") }
    print(" ✓ (assignment7/Misiurewicz%03d[1-50].png)\n==========\n")

    print("-> Julia set (c = (-0.8 + 0.156i), r∈[-2.0;1.0], i∈[-1.0;1.0])......")
    julia(4500, 2000, Pair(-2.0, 2.0), Pair(-1.0, 1.0), lightBlueBrown, innerForLightBlueBrown, Complex(-0.8, 0.156))
            .writeTo(fileWithName(path, 7, "julia.png"))
    print(" ✓ (assignment7/julia.png)\n==========\n")

    print("-> Newton's fractal (z^3-1)......")
    newton(3000, 3000,
            Pair(-3.0, 3.0), Pair(-3.0, 3.0),
            { c -> (c * c * c - 1) / (c * c * 3) },
            listOf(Complex(1, 0), Complex(-0.5, Math.sqrt(3.0) / 2), Complex(-0.5, -Math.sqrt(3.0) / 2)),
            newtonColors)
            .writeTo(fileWithName(assignmentNo = 7, name = "newton-classic.png"))
    print(" ✓ (assignment7/newton-classic.png)\n-> Newton's fractal (z^3 - 2z + 2)......")
    newton(3000, 3000,
            Pair(-3.0, 3.0), Pair(-3.0, 3.0),
            { c ->
                (c * c * c - c * 2 + 2) / (c * c * 3 -2)
            },
            listOf(Complex(-1.7693, 0.0), Complex(0.88465, -0.58974), Complex(0.88465, 0.58974)),
            newtonColors).writeTo(fileWithName(assignmentNo = 7, name = "newton-other.png"))
    print(" ✓ (assignment7/newton-other.png)\n-> Newton's fractal (z^5 - 3iz + 5)......")
    newton(3000, 3000,
            Pair(-3.0, 3.0), Pair(-3.0, 3.0),
            { c ->
                (c * c * c * c * c - c * Complex(0.0, 1.0) * 3 - 5) / (c * c * c * c * 5 - Complex(0.0, 1.0) * 3)
            },
            listOf(Complex(-1.31855, -0.771061), Complex(-0.890889, 0.923646), Complex(0.256703, 1.10257), Complex(0.535574, -1.47678), Complex(1.41716, 0.221627)),
            newtonColors)
            .writeTo(fileWithName(assignmentNo = 7, name = "newton-six.png"))
    println(" ✓ (assignment7/newton-six.png)")
}
