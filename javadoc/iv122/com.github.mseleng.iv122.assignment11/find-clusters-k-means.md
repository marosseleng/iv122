---
title: findClustersKMeans - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment11](index.md) / [findClustersKMeans](.)

# findClustersKMeans

`fun findClustersKMeans(points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, n: Int, chartName: String, targetFile: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`

Finds and draws the points and colors them by the cluster they belong to

Uses the k-means algorithm

### Parameters

`points` - the points to divide to clusters

`n` - the number of clusters

`targetFile` - the function that should return the file for each chart saved