---
title: fractal - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment7](index.md) / [fractal](.)

# fractal

`fun fractal(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, outerColors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, innerColors: <ERROR CLASS><`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, autoBalance: Boolean = true, numOfThreads: Int = 1, colorByComplexResult: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> Boolean = { c -> c.re != Double.NaN && c.im != Double.NaN && c.abs() < 2.0 }, iterate: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> <ERROR CLASS><`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, Int>): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)

This serves as a load balancer, eg. if we don't want parallelism, we will not create ExecutorService.

### Parameters

`colorByComplexResult` - function returning boolean according to which we say whether we want to distance-paint the image (default is used for mandelbrot/julia sets)