---
title: TurtleDirections - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [TurtleDirections](.)

# TurtleDirections

`sealed class TurtleDirections`

Sealed class representing the possible turtle directions

**Parameters**

### Properties

| [function](function.md) | `val function: `[`Turtle`](../-turtle/index.md)`.() -> Unit`<br>a function to invoke on the turtle |

### Inheritors

| [Backward](../-backward/index.md) | `class Backward : TurtleDirections`<br>A subclass of TurtleDirections representing the backward move |
| [Custom](../-custom/index.md) | `class Custom : TurtleDirections`<br>A subclass of TurtleDirections representing the custom defined movement of the turtle |
| [Forward](../-forward/index.md) | `class Forward : TurtleDirections`<br>A subclass of TurtleDirections representing the forward move |
| [Left](../-left/index.md) | `class Left : TurtleDirections`<br>A subclass of TurtleDirections representing the left rotation |
| [Pop](../-pop/index.md) | `class Pop : TurtleDirections`<br>A subclass of TurtleDirections representing the pop from the stack |
| [Push](../-push/index.md) | `class Push : TurtleDirections`<br>A subclass of TurtleDirections representing the push to the stack |
| [Right](../-right/index.md) | `class Right : TurtleDirections`<br>A subclass of TurtleDirections representing the right rotation |
| [StandStill](../-stand-still/index.md) | `class StandStill : TurtleDirections`<br>A subclass of TurtleDirections representing the default fallback (the turtle does nothing) |

