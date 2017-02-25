package util

import java.io.File

/**
 * Created by mseleng on 2/22/17.
 */

fun fileWithName(assignmentNo: Int, name: String): File {
    return File("outputs").resolve(assignmentNo.toString()).resolve(name)
}

fun svgFileWithName(assignmentNo: Int, name: String): File {
    return fileWithName(assignmentNo, "$name.svg")
}