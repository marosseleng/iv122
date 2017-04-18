package com.github.mseleng.iv122.assignment7

import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo

fun run(path: String) {
    print("-> Mandelbrot set (not zoomed)......")
    mandelbrot().writeTo(fileWithName(path, 7, "mandelbrot.png"))
    print(" ✓ (assignment7/mandelbrot.png)\n==========\n")
}
