---
title: pi_Archimedes - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment2](index.md) / [pi_Archimedes](.)

# pi_Archimedes

`fun pi_Archimedes(interval_ms: Long, sqrt: (Double) -> Double): `[`ArchimedesπRange`](-archimedesπ-range/index.md)

Approximates the value of π using the [Archimedes'](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Polygon_approximation_to_a_circle) method

You can pass different implementations of the [sqrt](pi_-archimedes.md#com.github.mseleng.iv122.assignment2$pi_Archimedes(kotlin.Long, kotlin.Function1((kotlin.Double, )))/sqrt) function to see the difference in the accuracy

### Parameters

`interval_ms` - the time interval, which the value be approximated in

`sqrt` - a function that computes the square root of a number

**Return**
an approximated value of π

