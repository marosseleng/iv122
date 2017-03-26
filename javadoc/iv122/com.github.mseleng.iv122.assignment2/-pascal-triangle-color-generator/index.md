---
title: PascalTriangleColorGenerator - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.assignment2](../index.md) / [PascalTriangleColorGenerator](.)

# PascalTriangleColorGenerator

`interface PascalTriangleColorGenerator`

An interface providing simple method for the Pascal's triangle color retrieval

### Functions

| [next](next.md) | `abstract fun next(): List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>`<br>Returns a [List](#) of [Color](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)s to be put to the next line |

### Inheritors

| [EvenOddColorGenerator](../-even-odd-color-generator/index.md) | `class EvenOddColorGenerator : PascalTriangleColorGenerator`<br>A generator that supplies colors based on the parity of the numbers in the current line |
| [ModuloColorGenerator](../-modulo-color-generator/index.md) | `class ModuloColorGenerator : PascalTriangleColorGenerator`<br>A generator that supplies colors based on current line's modulus |

