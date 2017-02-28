package com.github.mseleng.iv122.util

/**
 * Created by mseleng on 2/25/17.
 */

/**
 * @suppress
 */
fun Int.isPrime() = this > 1 && (2..(this.div(2))).all{ this.rem(it) != 0 }

/**
 * Computes the fraction for the given part and the whole
 *
 * @param part
 * @param whole
 * @return a double = [part].div([whole])
 */
fun fraction(part: Int, whole: Int) = part.toDouble().div(whole)
