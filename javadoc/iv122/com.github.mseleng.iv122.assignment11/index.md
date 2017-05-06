---
title: com.github.mseleng.iv122.assignment11 - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.assignment11](.)

## Package com.github.mseleng.iv122.assignment11

### Functions

| [computeCenters](compute-centers.md) | `fun computeCenters(points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, n: Int): Set<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>`<br>Computes the initial centers by randomly choosing centers from the points |
| [findClustersKMeans](find-clusters-k-means.md) | `fun findClustersKMeans(points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, n: Int, chartName: String, targetFile: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`<br>Finds and draws the points and colors them by the cluster they belong to |
| [generateClustersDataSet](generate-clusters-data-set.md) | `fun generateClustersDataSet(n: Int, radius: Double, center: `[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, clusterRadius: Double, totalPoints: Int): List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>`<br>Generates the dataset for the clustering |
| [generateRegressionDataSet](generate-regression-data-set.md) | `fun generateRegressionDataSet(a: Double, b: Double, deviation: Double, interval: <ERROR CLASS><Double, Double>, n: Int): List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>`<br>Generates the regression dataset around the function y = a*x + b |
| [gradientDescent](gradient-descent.md) | `fun gradientDescent(initialA: Double, initialB: Double, points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, learningRate: Double, numOfIterations: Int = 50, targetFile: (Int) -> `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): Unit`<br>Computes the linear regression using the gradient-descent algorithm |
| [gradientDescentStep](gradient-descent-step.md) | `fun gradientDescentStep(a: Double, b: Double, points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, learningRate: Double): <ERROR CLASS><Double, Double>`<br>Performs one step of the gradient-descent algorithm |
| [kMeansIteration](k-means-iteration.md) | `fun kMeansIteration(centers: Set<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>, points: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>): Map<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`, List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>>`<br>Performs one iteration of the k-means algorithm |
| [readDataSet](read-data-set.md) | `fun readDataSet(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): <ERROR CLASS>`<br>Reads the dataset from the file. The format must be:
x-value y-value\n |
| [regressionAnalytical](regression-analytical.md) | `fun regressionAnalytical(data: List<`[`Coordinates`](../com.github.mseleng.iv122.util/-coordinates/index.md)`>): `[`Chart`](../com.github.mseleng.iv122.util/-chart/index.md)<br>Computes the linear regression analytically (using a formula) |

