package com.github.mseleng.iv122.util

import java.io.File

/**
 * Returns an instance of [File] somewhere in the `/outputs/` directory
 *
 * @param rootDirName the relative (on the classpath) or absolute path to the root output directory. Must be an existent directory!!
 * @param assignmentNo the number of an assignment (the file will be located inside '/outputs/assignment[assignmentNo]/` directory
 * @param name the name of the desired file **WITH** the extension (eg. something.png, nothing.xml, etc.)
 * @return the desired file
 */
fun fileWithName(rootDirName: String = "iv122_outputs", assignmentNo: Int, name: String): File {
    val rootDirectory = File(rootDirName)
    rootDirectory.mkdir()
    val subdirectory = rootDirectory.resolve("assignment$assignmentNo")
    subdirectory.mkdir()
    return subdirectory.resolve(name)
}

/**
 * @suppress
 */
fun svgFileWithName(rootDirName: String = "outputs", assignmentNo: Int, name: String): File {
    return fileWithName(rootDirName, assignmentNo, "$name.svg")
}