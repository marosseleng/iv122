---
title: nthRoot_approx_bisection - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [nthRoot_approx_bisection](.)

# nthRoot_approx_bisection

`fun nthRoot_approx_bisection(num: Double, order: Long, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.0001): Double`

Approximates (using the bisection) the [order](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/order)-th root of [num](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/num)

### Parameters

`num` - the number, whose root we want to approximate

`order` - the order of the root

`from` - the lower bound of the interval (default = 0.0)

`to` - the upper bound of the interval (default ⌊([num](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/num) / [order](nth-root_approx_bisection.md#com.github.mseleng.iv122.util$nthRoot_approx_bisection(kotlin.Double, kotlin.Long, kotlin.Double, kotlin.Double, kotlin.Double)/order))⌋ + 1; as linear function grows faster than the root function)

`eps` - the desired accuracy (default = 0.000001)

**Return**
see [bisection](bisection.md)

