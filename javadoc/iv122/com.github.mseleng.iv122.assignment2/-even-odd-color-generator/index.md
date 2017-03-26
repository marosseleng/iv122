---
title: EvenOddColorGenerator - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.assignment2](../index.md) / [EvenOddColorGenerator](.)

# EvenOddColorGenerator

`class EvenOddColorGenerator : `[`PascalTriangleColorGenerator`](../-pascal-triangle-color-generator/index.md)

A generator that supplies colors based on the parity of the numbers in the current line

### Parameters

`evenColor` - a color to apply on the even numbers

`oddColor` - a color to apply on the odd numbers

### Constructors

| [&lt;init&gt;](-init-.md) | `EvenOddColorGenerator(evenColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`, oddColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`)` |

### Properties

| [evenColor](even-color.md) | `val evenColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)<br>a color to apply on the even numbers |
| [oddColor](odd-color.md) | `val oddColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)<br>a color to apply on the odd numbers |

### Functions

| [next](next.md) | `fun next(): List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>`<br>Returns a [List](#) of [Color](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)s to be put to the next line |

