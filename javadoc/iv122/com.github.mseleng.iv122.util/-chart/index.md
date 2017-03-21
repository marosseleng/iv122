---
title: Chart - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Chart](.)

# Chart

`class Chart : Any`

This class is used as a simple facade above the jfreechart library, providing simple chart actions

### Parameters

`chartName` - the name of the chart (required by jfreechart; this is **NOT** the name of an output file)

`data` - a map of (Color-data) pairs, used as the dataset for the chart

`showLegend` - true of legend of the chart should be shown, else otherwise (default false)

### Constructors

| [&lt;init&gt;](-init-.md) | `Chart(chartName: String, data: Map<`[`Paint`](http://docs.oracle.com/javase/6/docs/api/java/awt/Paint.html)`, <ERROR CLASS>>, showLegend: Boolean = false)`<br>creates a Chart with the given data |

### Functions

| [writeToJPEG](write-to-j-p-e-g.md) | `fun writeToJPEG(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, width: Int, height: Int): Unit`<br>Writes this chart into a JPEG file |
| [writeToPNG](write-to-p-n-g.md) | `fun writeToPNG(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, width: Int, height: Int): Unit`<br>Writes this chart into a PNG file |

