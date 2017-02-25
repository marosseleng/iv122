package util

/**
 * Created by mseleng on 2/25/17.
 */

fun Int.isPrime() = this > 1 && (2..(this.div(2))).all{ this.rem(it) != 0 }

fun fraction(part: Int, whole: Int) = part.toDouble().div(whole)
