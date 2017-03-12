---
title: bisection - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [bisection](.)

# bisection

`fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double?`

Approximates the number using bisection

As this function cannot take a parameter representing the number that we want to approximate (because we do not know
the value of that number, that's why we want to approximate) one should provide the "validation function", which takes
the actual approximated number as a parameter and test whether that "validated" value is near enough to the target.

Let's say, we want to approximate the square root of 5 (√5); we pass 5 to the [num](bisection.md#com.github.mseleng.iv122.util$bisection(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Function1((kotlin.Double, )))/num) parameter and the squaring function
to the [validate](bisection.md#com.github.mseleng.iv122.util$bisection(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Function1((kotlin.Double, )))/validate) parameter

### Parameters

`num` - the "target" number; This is not he number that we want to approximate; this is the number,
close to which we want to get by applying [validate](bisection.md#com.github.mseleng.iv122.util$bisection(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Function1((kotlin.Double, )))/validate) on the approximated one

`from` - the lower bound of the interval

`to` - the upper bound of the interval

`eps` - the desired accuracy (default = 0.000001)

`validate` - the validation function

**Return**
null, iff the value with the given accuracy could not be found within the given interval, or the approximated value otherwise

