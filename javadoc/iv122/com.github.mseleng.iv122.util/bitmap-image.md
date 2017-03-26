---
title: bitmapImage - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [bitmapImage](.)

# bitmapImage

`fun bitmapImage(width: Int, height: Int, backgroundColor: `[`Color`](http://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)` = Color.WHITE, init: `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)`.() -> Unit = {}): `[`BufferedImage`](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)

An helper function that creates an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html) for further edit.

**An instance uses the RGB coloring**

### Parameters

`width` - the width of the target image

`height` - the height of the target image

`init` - a block of code to execute on a newly created [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)

**Return**
an instance of [BufferedImage](http://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html)

