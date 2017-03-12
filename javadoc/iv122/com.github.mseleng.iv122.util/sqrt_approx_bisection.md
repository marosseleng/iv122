---
title: sqrt_approx_bisection - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [sqrt_approx_bisection](.)

# sqrt_approx_bisection

`fun sqrt_approx_bisection(num: Double, from: Double = 0.0, to: Double = Math.floor(num.div(2.0)).plus(1), eps: Double = 0.0001): Double?`

Approximates (using the bisection) the square root of the given number

### Parameters

`num` - the number, whose square root we want to approximate

`from` - the lower bound of the interval (default = 0.0)

`to` - the upper bound of the interval (default ⌊([num](sqrt_approx_bisection.md#com.github.mseleng.iv122.util$sqrt_approx_bisection(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/num) / 2)⌋ + 1; as (x/2 + 1) grows faster than sqrt(x))

`eps` - the desired accuracy (default = 0.000001)

**Return**
see [bisection](bisection.md)

