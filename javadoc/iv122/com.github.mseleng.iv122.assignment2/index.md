---
title: com.github.mseleng.iv122.assignment2 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment2](.)

## Package com.github.mseleng.iv122.assignment2

### Types

| [ArchimedesπRange](-archimedesπ-range/index.md) | `data class ArchimedesπRange : Any`<br>Class representing an interval, within which the value of π is. This is used just in the Archimedes method |
| [Fraction](-fraction/index.md) | `data class Fraction : Any`<br>A class representing rational numbers as the fraction in the format [part](-fraction/part.md)/[whole](-fraction/whole.md) |

### Type Aliases

| [DecimalFraction](-decimal-fraction.md) | `typealias DecimalFraction = <ERROR CLASS><Long, `[`Fraction`](-fraction/index.md)`>`<br>A typealias representing the "decimal fraction", in other words numbers like 3(27/29) |

### Extensions for External Classes

| [kotlin.Double](kotlin.-double/index.md) |  |
| [kotlin.String](kotlin.-string/index.md) |  |

### Functions

| [combinations](combinations.md) | `fun combinations(numbers: List<Int>, k: Int, allowRepetition: Boolean): <ERROR CLASS>`<br>Returns the list of [k](combinations.md#com.github.mseleng.iv122.assignment2$combinations(kotlin.collections.List((kotlin.Int)), kotlin.Int, kotlin.Boolean)/k)-combinations of the given numbers |
| [main](main.md) | `fun main(args: Array<String>): Unit` |
| [permutations](permutations.md) | `fun permutations(numbers: List<Int>): List<String>`<br>Returns the list of permutations of the given numbers |
| [pi_Archimedes](pi_-archimedes.md) | `fun pi_Archimedes(interval_ms: Long, sqrt: (Double) -> Double): `[`ArchimedesπRange`](-archimedesπ-range/index.md)<br>Approximates the value of π using the [Archimedes'](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Polygon_approximation_to_a_circle) method |
| [pi_GregoryLeibniz](pi_-gregory-leibniz.md) | `fun pi_GregoryLeibniz(interval_ms: Long): Double`<br>Approximates the value of π using the [Gregory-Leibniz](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Gregory.E2.80.93Leibniz_series) series |
| [pi_MonteCarlo](pi_-monte-carlo.md) | `fun pi_MonteCarlo(interval_ms: Long, square: (Double) -> Double, sqrt: (Double) -> Double): Double`<br>Approximates the value of π using the [Monte Carlo](https://en.wikipedia.org/wiki/Approximations_of_%CF%80#Summing_a_circle.27s_area) method |
| [rationalPower_1](rational-power_1.md) | `fun rationalPower_1(base: Double, exp: Double): Double`<br>Returns the [exp](rational-power_1.md#com.github.mseleng.iv122.assignment2$rationalPower_1(kotlin.Double, kotlin.Double)/exp)-th power of this number. The exponent may be a positive decimal |
| [variations](variations.md) | `fun variations(numbers: List<Int>, k: Int, allowRepetition: Boolean): List<String>`<br>Returns the list of [k](variations.md#com.github.mseleng.iv122.assignment2$variations(kotlin.collections.List((kotlin.Int)), kotlin.Int, kotlin.Boolean)/k)-variations of the given numbers |

