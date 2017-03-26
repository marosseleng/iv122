---
title: ModuloColorGenerator - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.assignment2](../index.md) / [ModuloColorGenerator](.)

# ModuloColorGenerator

`class ModuloColorGenerator : `[`PascalTriangleColorGenerator`](../-pascal-triangle-color-generator/index.md)

A generator that supplies colors based on current line's modulus

### Parameters

`mod` - the desired modulus base

`colors` - (possibly mutliple) [Color](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)s

### Constructors

| [&lt;init&gt;](-init-.md) | `ModuloColorGenerator(mod: Int, vararg colors: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`)` |

### Properties

| [colors](colors.md) | `vararg val colors: Array<out `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>`<br>(possibly mutliple) [Color](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)s |
| [mod](mod.md) | `val mod: Int`<br>the desired modulus base |

### Functions

| [next](next.md) | `fun next(): List<`[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)`>`<br>Returns a [List](#) of [Color](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)s to be put to the next line |

