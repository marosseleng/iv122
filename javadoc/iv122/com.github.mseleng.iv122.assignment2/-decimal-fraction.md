---
title: DecimalFraction - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment2](index.md) / [DecimalFraction](.)

# DecimalFraction

`typealias DecimalFraction = <ERROR CLASS><Long, `[`Fraction`](-fraction/index.md)`>`

A typealias representing the "decimal fraction", in other words numbers like 3(27/29)

If we take the PI as 3.14, we could write 3.14 == 314/100 == 157/50 == 3(7/50)

This "type" just helps us to prevent stack overflow when doing high exponentiations like 2^157

