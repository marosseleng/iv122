---
title: newton - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment7](index.md) / [newton](.)

# newton

`fun newton(width: Int, height: Int, realRange: <ERROR CLASS><Double, Double>, imaginaryRange: <ERROR CLASS><Double, Double>, function: (`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`) -> `[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`, solutions: List<`[`Complex`](../com.github.mseleng.iv122.util/-complex/index.md)`>, colors: List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>, autoBalance: Boolean = true, numOfThreads: Int = 1): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)

Generates the Newton fractal for the given equation and respective solutions within the given ranges

### Parameters

`function` - Newton's method of approximating numbers (containing only f(z)/f'(z) part)

`solutions` - the solutions of the [function](newton.md#com.github.mseleng.iv122.assignment7$newton(kotlin.Int, kotlin.Int, ((kotlin.Double, )), ((kotlin.Double, )), kotlin.Function1((com.github.mseleng.iv122.util.Complex, )), kotlin.collections.List((com.github.mseleng.iv122.util.Complex)), kotlin.collections.List((java.awt.Color)), kotlin.Boolean, kotlin.Int)/function)