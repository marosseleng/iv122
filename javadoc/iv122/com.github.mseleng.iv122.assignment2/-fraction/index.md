---
title: Fraction - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.assignment2](../index.md) / [Fraction](.)

# Fraction

`data class Fraction : Any`

A class representing rational numbers as the fraction in the format [part](part.md)/[whole](whole.md)

E.g.: 3.14 == 157/50

### Parameters

`part` -

`whole` -

### Constructors

| [&lt;init&gt;](-init-.md) | `Fraction(part: Long, whole: Long)`<br>creates a rational number in the format of a fraction |

### Properties

| [part](part.md) | `val part: Long` |
| [whole](whole.md) | `val whole: Long` |

### Functions

| [toDecimalFraction](to-decimal-fraction.md) | `fun toDecimalFraction(): <ERROR CLASS><Long, Fraction>`<br>Returns this rational number represented as a decimal fraction (when possible) |

