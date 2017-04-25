package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.*
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    //Color.decode("0x00897b"), Color.decode("0x3e2723")
    mandelbrot(1500, 1000, Pair(-2.0, 1.0), Pair(-1.0, 1.0), limePurple, innerForLinePurple).writeTo(fileWithName(assignmentNo = 7, name = "mandelexperiment.png"))
//    newton(1000, 1000, Pair(-1.5, 1.5), Pair(-1.5, 1.5), limePurple.reversed()).writeTo(fileWithName(assignmentNo = 7, name = "newton-experiment.png"))
}

fun mandelbrot(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    return mandelbrotJulia(width, height, realRange, imaginaryRange, outerColors, innerColors, autoBalance, numOfThreads) { c ->
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

fun newton(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    val solutions = listOf(Complex(1, 0), Complex(-0.5, Math.sqrt(3.0) / 2), Complex(-0.5, -Math.sqrt(3.0) / 2))
    return mandelbrotJulia(width, height, realRange, imaginaryRange, outerColors, innerColors, autoBalance, numOfThreads) { z ->
        var current = z
        var someInt = 0
        for (i in 1..30) {
            current = (current * current * current) - Complex(0.01, 0.01)
            if (someInt == 0 && current.abs() > 2) {
                someInt = i
            }
        }
        Pair(current, someInt)
    }
}


fun julia(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        c: Complex,
        autoBalance: Boolean = true, numOfThreads: Int = 1): BufferedImage {
    return mandelbrotJulia(width, height, realRange, imaginaryRange, outerColors, innerColors, autoBalance, numOfThreads) { z ->
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
 */
fun mandelbrotJulia(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        autoBalance: Boolean = true, numOfThreads: Int = 1,
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
        singleThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate)
    } else {
        multiThreadFractal(width, height, realRange, imaginaryRange, outerColors, innerColors, iterate, actualThreads)
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

private fun singleThreadFractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>): BufferedImage {

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
            iterate).call()

    return img
}

private fun multiThreadFractal(
        width: Int, height: Int,
        realRange: Pair<Double, Double>, imaginaryRange: Pair<Double, Double>,
        outerColors: List<Color>,
        innerColors: Pair<Color, Color>,
        iterate: (Complex) -> Pair<Complex, Int>,
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
                iterate)
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
                iterate))
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
        iterate: (Complex) -> Pair<Complex, Int>): Callable<Unit> {

    return Callable {
        for (x in from..to) {
            val real = computeReal(x)
            for (y in height - 1 downTo 0) {
                val newY = height - (y + 1)
                val imaginary = computeImaginary(newY)

                val (complex, steps) = iterate(Complex(real, imaginary))
                if (complex.re != Double.NaN && complex.im != Double.NaN && complex.abs() < 2.0) {
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
