---
title: fileWithName - iv122
---

[iv122](../index.md) / [com.github.mseleng.iv122.util](index.md) / [fileWithName](.)

# fileWithName

`fun fileWithName(rootDirName: String = "outputs", assignmentNo: Int, name: String): `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)

Returns an instance of [File](http://docs.oracle.com/javase/6/docs/api/java/io/File.html) somewhere in the `/outputs/` directory

### Parameters

`rootDirName` - the relative (on the classpath) or absolute path to the root output directory. Must be an existent directory!!

`assignmentNo` - the number of an assignment (the file will be located inside '/outputs/assignment[assignmentNo](file-with-name.md#com.github.mseleng.iv122.util$fileWithName(kotlin.String, kotlin.Int, kotlin.String)/assignmentNo)/` directory

`name` - the name of the desired file **WITH** the extension (eg. something.png, nothing.xml, etc.)

**Return**
the desired file

