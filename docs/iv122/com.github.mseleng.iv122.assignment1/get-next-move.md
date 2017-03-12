---
title: getNextMove - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment1](index.md) / [getNextMove](.)

# getNextMove

`fun getNextMove(center: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, lastCoordinates: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`?, lastDirection: `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`?): <ERROR CLASS><`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, `[`Direction`](../com.github.mseleng.iv122.util/-direction/index.md)`?>`

Computes the next move (where to place the next number on a spiral)

### Parameters

`center` - the coordinates of the center pixel (where number 1 is)

`lastCoordinates` - the coordinates of the place with the last number (if the current number is i, then this param represents the coordinates of (x-1))

`lastDirection` - the direction which we moved from the number (i-2) to (i-1)

**Return**
a pair containing the coordinates and the direction to the current number (i)

