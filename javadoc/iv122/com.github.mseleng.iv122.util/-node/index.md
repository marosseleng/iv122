---
title: Node - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Node](.)

# Node

`class Node<T>`

### Constructors

| [&lt;init&gt;](-init-.md) | `Node(value: T, coordinates: `[`Coordinates`](../-coordinates/index.md)`)` |

### Properties

| [coordinates](coordinates.md) | `var coordinates: `[`Coordinates`](../-coordinates/index.md) |
| [distanceFromStart](distance-from-start.md) | `var distanceFromStart: Int` |
| [neighbors](neighbors.md) | `var neighbors: Set<Node<T>>` |
| [predecessor](predecessor.md) | `var predecessor: Node<T>?` |
| [searchState](search-state.md) | `var searchState: `[`SearchState`](../-search-state/index.md) |
| [value](value.md) | `val value: T` |

### Functions

| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |
| [initSSSP](init-s-s-s-p.md) | `fun initSSSP(): Unit` |
| [toString](to-string.md) | `fun toString(): String` |

