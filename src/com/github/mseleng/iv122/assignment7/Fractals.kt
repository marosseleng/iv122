package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.Complex
import com.github.mseleng.iv122.util.bitmapImage
import com.github.mseleng.iv122.util.timesRepeat
import com.github.mseleng.iv122.util.writeTo
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Generates the Newton fractal for the given equation and respective solutions within the given ranges
 *
 * @param function Newton's method of approximating numbers (containing only f(z)/f'(z) part)
 * @param solutions the solutions of the [function]
 */
fun newton(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        function: (Complex) -> Complex,
        solutions: List<Complex>,
        colors: List<Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    return fractal(width, height, realRange, imaginaryRange, colors, Pair(Color.BLACK, Color.BLACK), autoBalance, numOfThreads, { false }) { z ->
        var current = z
        for (i in 1..20) {
            current -= function(current)
        }
        val someInt = solutions.indexOf(solutions.minBy { (current - it).abs() })
        Pair(current, someInt)
    }
}

/**
 * Generates (and writes) the series of zoomed Mandelbrot fractals within the given ranges
 *
 * Always starts displaying the whole Mandelbrot's set
 *
 * @param center a point to be in the center while zooming
 * @param zoomFactor the amount to divide the current interval
 * @param iterations the number of images to generate/write
 * @param targetFile a function that generates the output file (is dependent on the image number)
 */
fun zoomedMandelbrot(imgSize: Int = 1200, center: Complex, zoomFactor: Double = 5.0, iterations: Int = 20, outerColors: List<Color>, targetFile: (Int) -> File) {
    val innerColors = Pair(Color.BLACK, Color.BLACK)
    var realRange = Pair(-2.0, 1.0)
    var imaginaryRange = Pair(-1.5, 1.5)
    iterations.timesRepeat {
        mandelbrot(imgSize, imgSize, realRange, imaginaryRange, outerColors, innerColors).writeTo(targetFile(it))
        val realDst = (realRange.second - realRange.first) / zoomFactor
        realRange = Pair(center.re - realDst / 2, center.re + realDst / 2)
        val imagDst = (imaginaryRange.second - imaginaryRange.first) / zoomFactor
        imaginaryRange = Pair(center.im - imagDst / 2, center.im + imagDst / 2)
    }
}

/**
 * Generates the Mandelbrot set/fractal within the given ranges
 */
fun mandelbrot(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    return fractal(width, height, realRange, imaginaryRange, outerColors, innerColors, autoBalance, numOfThreads) { c ->
        var current = Complex(0, 0)
        var someInt = 0
        for (i in 1..30) {
            current = (current * current) + c
            if (someInt == 0 && current.abs() > 2) {
                someInt = i
            }
        }
        if (someInt == 0) {
            // map values [0;2] to [0;100]
            someInt = Math.round(current.abs() * 50).toInt()
        }
        Pair(current, someInt)
    }
}

/**
 * Generates the Julia set/fractal within the given ranges
 */
fun julia(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        c: Complex,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    return fractal(width, height, realRange, imaginaryRange, outerColors, innerColors, autoBalance, numOfThreads) { z ->
        var current = z
        var someInt = 0
        for (i in 1..30) {
            current = (current * current) + c
            if (someInt == 0 && current.abs() > 2) {
                someInt = i
            }
        }
        if (someInt == 0) {
            // map values [0;2] to [0;100]
            someInt = Math.round(current.abs() * 50).toInt()
        }
        Pair(current, someInt)
    }
}

/**
 * This serves as a load balancer, eg. if we don't want parallelism, we will not create ExecutorService.
 *
 * @param colorByComplexResult function returning boolean according to which we say whether we want to distance-paint the image (default is used for mandelbrot/julia sets)
 */
fun fractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1,
        colorByComplexResult: (Complex) -> Boolean = { c -> c.re != Double.NaN && c.im != Double.NaN && c.abs() < 2.0 },
        iterate: (Complex) -> Pair<Complex, Int>): BufferedImage {

    // this is the minimum (number of threads) we may use (this make the computation as parallel as possible)
    val availableCores = Runtime.getRuntime().availableProcessors()

    // computing the real amount of thread needed 750_000 was chosen by the real experience
    var threadsNeeded = availableCores
    while (height * width / threadsNeeded > 750_000) {
        threadsNeeded++
    }

    val actualThreads = if (autoBalance) {
        maxOf(availableCores, threadsNeeded)
    } else {
        numOfThreads
    }
    return if (numOfThreads == 1) {
        singleThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate, colorByComplexResult)
    } else {
        multiThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate, colorByComplexResult, actualThreads)
    }
}

/**
 * Used to test the performance of multi-thread implementation
 */
private fun testMultithreadedPerformance() {
    val sizes = listOf(Pair(300, 200), Pair(900, 600), Pair(1500, 1000), Pair(3000, 2000), Pair(6000, 4000))
    val threads = listOf(1, 2, 4, 8)
    val xRange = Pair(-2.0, 1.0)
    val yRange = Pair(-1.0, 1.0)

    for ((width, height) in sizes) {
        for (thread in threads) {
            print("$width x $height; $thread threads:\t")
            val time = measureTimeMillis {
                mandelbrot(width, height, xRange, yRange, limePurple, Pair(Color.decode("0x3e2723"), Color.decode("0xe91e63")), false, thread)
            }
            println("$time ms")
        }
    }
}

/**
 * Performs the generation on the single thread
 */
private fun singleThreadFractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>,
        colorByComplexResult: (Complex) -> Boolean): BufferedImage {

    val img = bitmapImage(width, height)
    val xStep = (realRange.second - realRange.first) / (width - 1)
    val yStep = (imaginaryRange.second - imaginaryRange.first) / (height - 1)

    val colorsCount = outerColors.count()

    getTask(
            0, width - 1, height,
            { it * xStep + realRange.first },
            { it * yStep + imaginaryRange.first },
            img,
            { outerColors[it % colorsCount].rgb },
            innerColors,
            iterate,
            colorByComplexResult).call()

    return img
}

/**
 * Performs the generation on the given number of threads
 */
private fun multiThreadFractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>,
        colorByComplexResult: (Complex) -> Boolean,
        numOfThreads: Int): BufferedImage {
    val img = bitmapImage(width, height)
    val xStep = (realRange.second - realRange.first) / (width - 1)
    val yStep = (imaginaryRange.second - imaginaryRange.first) / (height - 1)

    val colorsCount = outerColors.count()

    val pool = Executors.newFixedThreadPool(numOfThreads)

    val portion = width / numOfThreads
    var left = width
    var start = 0
    var end = start + portion - 1

    val tasks = mutableListOf<Callable<Unit>>()

    numOfThreads.timesRepeat {
        val task = getTask(
                start, end, height,
                { it * xStep + realRange.first },
                { it * yStep + imaginaryRange.first },
                img,
                { outerColors[it % colorsCount].rgb },
                innerColors,
                iterate,
                colorByComplexResult)
        tasks.add(task)
        left -= portion
        start = end + 1
        end = start + portion - 1
    }

    if (left != 0) {
        tasks.add(getTask(
                start, start + left - 1, height,
                { it * xStep + realRange.first },
                { it * yStep + imaginaryRange.first },
                img,
                { outerColors[it % colorsCount].rgb },
                innerColors,
                iterate,
                colorByComplexResult))
    }

    pool.invokeAll(tasks)
    pool.shutdown()
    pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)

    return img
}

/**
 * Creates a callable that fills the BufferedImage
 */
private fun getTask(
        from: Int, to: Int, height: Int,
        computeReal: (Int) -> Double,
        computeImaginary: (Int) -> Double,
        img: BufferedImage,
        getOuterColor: (Int) -> Int,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>,
        colorByComplexResult: (Complex) -> Boolean): Callable<Unit> {

    return Callable {
        for (x in from..to) {
            val real = computeReal(x)
            for (y in height - 1 downTo 0) {
                val newY = height - (y + 1)
                val imaginary = computeImaginary(newY)

                val (complex, steps) = iterate(Complex(real, imaginary))
                if (colorByComplexResult(complex)) {
                    val firstColorRatio = steps / 100.0
                    val secondColorRatio = 1.00 - firstColorRatio
                    val newColor = Color(
                            (firstColorRatio * innerColors.first.red).toInt() + (secondColorRatio * innerColors.second.red).toInt(),
                            (firstColorRatio * innerColors.first.green).toInt() + (secondColorRatio * innerColors.second.green).toInt(),
                            (firstColorRatio * innerColors.first.blue).toInt() + (secondColorRatio * innerColors.second.blue).toInt())
                    img.setRGB(x, y, newColor.rgb)
                } else {
                    img.setRGB(x, y, getOuterColor(steps))
                }
            }
        }
        Unit
    }
}
