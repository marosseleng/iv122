---
title: pi_MonteCarlo - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment2](index.md) / [pi_MonteCarlo](.)

# pi_MonteCarlo

`fun pi_MonteCarlo(interval_ms: Long, square: (Double) -> Double, sqrt: (Double) -> Double): Double`

Approximates the value of π using the [Monte Carlo](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Summing_a_circle.27s_area) method

You can pass different implementations of [square](pi_-monte-carlo.md#com.github.mseleng.iv122.assignment2$pi_MonteCarlo(kotlin.Long, kotlin.Function1((kotlin.Double, )), kotlin.Function1((kotlin.Double, )))/square) and [sqrt](pi_-monte-carlo.md#com.github.mseleng.iv122.assignment2$pi_MonteCarlo(kotlin.Long, kotlin.Function1((kotlin.Double, )), kotlin.Function1((kotlin.Double, )))/sqrt) functions to see the difference in the accuracy

### Parameters

`interval_ms` - the time interval, which the value be approximated in

`square` - a function that squares a number

`sqrt` - a function that computes the square root of a number

**Return**
an approximated value of π

