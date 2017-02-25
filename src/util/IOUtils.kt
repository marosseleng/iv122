package util

import java.io.File

/**
 * Created by mseleng on 2/22/17.
 */

fun fileWithName(name: String): File {
    return File("outputs").resolve(name)
}

fun svgFileWithName(name: String): File {
    return fileWithName("$name.svg")
}