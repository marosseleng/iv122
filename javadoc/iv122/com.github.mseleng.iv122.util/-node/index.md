---
title: Node - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Node](.)

# Node

`class Node<T>`

Generic class representing the node in the graph, which is identified by its coordinates and value

### Constructors

| [&lt;init&gt;](-init-.md) | `Node(value: T, coordinates: `[`Coordinates`](../-coordinates/index.md)`)`<br>creates the node with the specified [value](-init-.md#com.github.mseleng.iv122.util.Node$<init>(com.github.mseleng.iv122.util.Node.T, com.github.mseleng.iv122.util.Coordinates)/value) and [coordinates](-init-.md#com.github.mseleng.iv122.util.Node$<init>(com.github.mseleng.iv122.util.Node.T, com.github.mseleng.iv122.util.Coordinates)/coordinates) |

### Properties

| [coordinates](coordinates.md) | `var coordinates: `[`Coordinates`](../-coordinates/index.md)<br>the coordinates of this node |
| [distanceFromStart](distance-from-start.md) | `var distanceFromStart: Int` |
| [neighbors](neighbors.md) | `var neighbors: Set<Node<T>>` |
| [predecessor](predecessor.md) | `var predecessor: Node<T>?` |
| [searchState](search-state.md) | `var searchState: `[`SearchState`](../-search-state/index.md) |
| [value](value.md) | `val value: T`<br>the value associated with this node |

### Functions

| [initSSSP](init-s-s-s-p.md) | `fun initSSSP(): Unit`<br>Initializes this node for the Single-source-shortest-path algorithms |

