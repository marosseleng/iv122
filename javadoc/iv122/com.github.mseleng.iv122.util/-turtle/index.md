---
title: Turtle - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Turtle](.)

# Turtle

`class Turtle : Any`

A helper class to work with the turtle graphics

The initial direction of the turtle is 0.0 (the turtle is heading East)

### Parameters

`currentPosition` - the coordinates of the starting point

### Constructors

| [&lt;init&gt;](-init-.md) | `Turtle(currentPosition: `[`Coordinates`](../-coordinates/index.md)` = Coordinates(0.0, 0.0))`<br>A helper class to work with the turtle graphics |

### Properties

| [currentPosition](current-position.md) | `var currentPosition: `[`Coordinates`](../-coordinates/index.md) |
| [lines](lines.md) | `val lines: <ERROR CLASS>` |

### Functions

| [backward](backward.md) | `fun backward(amount: Int): Unit`<br>`fun backward(amount: Double): Unit`<br>Does backward but stay in the [currentDirection](#) |
| [forward](forward.md) | `fun forward(amount: Int): Unit`<br>`fun forward(amount: Double): Unit`<br>Goes forward in the [currentDirection](#) |
| [left](left.md) | `fun left(degrees: Double): Unit`<br>Turns left by the given amount of [degrees](left.md#com.github.mseleng.iv122.util.Turtle$left(kotlin.Double)/degrees) |
| [penDown](pen-down.md) | `fun penDown(): Unit`<br>Puts the pen down |
| [penUp](pen-up.md) | `fun penUp(): Unit`<br>Lifts the pen |
| [right](right.md) | `fun right(degrees: Double): Unit`<br>Turns left by the given amount of [degrees](right.md#com.github.mseleng.iv122.util.Turtle$right(kotlin.Double)/degrees) |

