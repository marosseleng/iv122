package com.github.mseleng.iv122.util

import java.io.File

/**
 * Returns an instance of [File] somewhere in the `/outputs/` directory
 *
 * @param assignmentNo the number of an assignment (the file will be located inside '/outputs/assignment[assignmentNo]/` directory
 * @param name the name of the desired file **WITH** the extension (eg. something.png, nothing.xml, etc.)
 * @return the desired file
 */
fun fileWithName(assignmentNo: Int, name: String): File {
    return File("outputs").resolve("assignment$assignmentNo").resolve(name)
}

/**
 * @suppress
 */
fun svgFileWithName(assignmentNo: Int, name: String): File {
    return fileWithName(assignmentNo, "$name.svg")
}