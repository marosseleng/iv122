---
title: Turtle - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Turtle](.)

# Turtle

`class Turtle`

A helper class to work with the turtle graphics

The initial direction of the turtle is 0.0 (the turtle is heading East)

### Types

| [State](-state/index.md) | `class State`<br>A class representing the state of a turtle |

### Constructors

| [&lt;init&gt;](-init-.md) | `Turtle(initialState: `[`State`](-state/index.md)`)`<br>creates an instance of turtle with the [initialState](-init-.md#com.github.mseleng.iv122.util.Turtle$<init>(com.github.mseleng.iv122.util.Turtle.State)/initialState) set`Turtle(lSystem: `[`LSystem`](../-l-system/index.md)`, depth: Int, initialState: `[`State`](-state/index.md)`)`<br>a constructor to use with L-Systems`Turtle()`<br>creates the turtle starting at (0;0) |

### Properties

| [currentState](current-state.md) | `var currentState: `[`State`](-state/index.md) |
| [lines](lines.md) | `val lines: <ERROR CLASS>` |

### Functions

| [backward](backward.md) | `fun backward(amount: Int): Unit`<br>Does backward`fun backward(amount: Double): Unit`<br>Does backward but stay in the [currentDirection](#) |
| [forward](forward.md) | `fun forward(amount: Int): Unit`<br>Goes forward`fun forward(amount: Double): Unit`<br>Goes forward in the [currentDirection](#) |
| [left](left.md) | `fun left(degrees: Double): Unit`<br>Turns left by the given amount of [degrees](left.md#com.github.mseleng.iv122.util.Turtle$left(kotlin.Double)/degrees) |
| [penDown](pen-down.md) | `fun penDown(): Unit`<br>Puts the pen down |
| [penUp](pen-up.md) | `fun penUp(): Unit`<br>Lifts the pen |
| [popStack](pop-stack.md) | `fun popStack(): Unit`<br>Loads the state from the stack |
| [pushToStack](push-to-stack.md) | `fun pushToStack(): Unit`<br>Pushes the current state to the stack |
| [right](right.md) | `fun right(degrees: Double): Unit`<br>Turns left by the given amount of [degrees](right.md#com.github.mseleng.iv122.util.Turtle$right(kotlin.Double)/degrees) |

