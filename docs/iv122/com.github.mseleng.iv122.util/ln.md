---
title: ln - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [ln](.)

# ln

`fun ln(x: Double, eps: Double = 0.000001): Double`

Approximates the natural logarithm of the given [x](ln.md#com.github.mseleng.iv122.util$ln(kotlin.Double, kotlin.Double)/x)

ln(x) = 2 * SUM(n in [0,inf](#)) ((1/(2n+1)) * (((x-1)/(x+1))^(2n+1)))
WIKI: https://en.wikipedia.org/wiki/Logarithm#Calculation

### Parameters

`x` - the number, whose logarithm we are approximating

`eps` - the desired accuracy (default = 0.000001)

**Return**
the natural logarithm of [x](ln.md#com.github.mseleng.iv122.util$ln(kotlin.Double, kotlin.Double)/x)

