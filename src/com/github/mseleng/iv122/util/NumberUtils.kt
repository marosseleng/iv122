package com.github.mseleng.iv122.util

/**
 * Says whether this is a prime number or not.
 *
 * @return true iff this is a prime number, false otherwise
 */
fun Int.isPrime() = this > 1 && (2..(this.div(2))).all { this.rem(it) != 0 }

/**
 * Computes the factorial of this number
 */
fun Int.factorial(): Int {
    if (this <= 1) {
        return 1
    }
    var result = 1
    for (i in 1..this) {
        result *= i
    }
    return result
}

/**
 * @suppress
 */
fun Int.pow(exp: Int) = pow(exp.toDouble()).toInt()

/**
 * Computes the fraction for the given part and the whole
 *
 * @param part
 * @param whole
 * @return a double = [part].div([whole])
 */
fun fraction(part: Int, whole: Int) = part.toDouble().div(whole)

/**
 * Returns the square of this
 *
 * @return the square
 */
fun Int.square(): Int = times(this)

/**
 * Returns the [exp]-th power of this number. The exponent may be a positive decimal
 *
 * @param exp a (potentionally) decimal exponent
 * @return the [exp]-th power of this
 */
fun Int.pow(exp: Double) = toDouble().pow(exp)

/**
 * Returns the [exp]-th power of this number, when the exponent is an integer
 *
 * @param exp the integral exponent
 * @return the [exp]-th power of this
 */
fun Int.integralPow(exp: Int) = toDouble().integralPow(exp.toLong()).toInt()

/**
 * Says whether this and [other] differ at most by [eps]
 *
 * @param other
 * @param eps
 * @return true, iff this and [other] differ at most by [eps], false otherwise
 */
fun Double.isAlmostEqual(other: Double, eps: Double): Boolean = Math.abs(this.minus(other)) <= eps

/**
 * Returns the square of this
 *
 * @return the square
 */
fun Double.square(): Double = times(this)

/**
 * Returns true iff this decimal number has decimal part == 0
 *
 * 2.0.isWhole() == true; 2.01.isWhole() == false;
 *
 * @return true iff this number is whole, false otherwise
 */
fun Double.isWhole(): Boolean = rem(1) == 0.toDouble()

/**
 * Returns the [exp]-th power of this number. The exponent may be a positive decimal
 *
 * @param exp a (potentionally) decimal exponent
 * @return the [exp]-th power of this
 */
fun Double.pow(exp: Double) = com.github.mseleng.iv122.assignment2.rationalPower_1(this, exp)

/**
 * Returns the [exp]-th power of this number, when the exponent is an integer
 *
 * @param exp the integral exponent
 * @return the [exp]-th power of this
 */
fun Double.integralPow(exp: Long): Double {
    return when {
        exp == 0L -> {
            1.toDouble()
        }
        exp > 0 -> {
            var res = 1.toDouble()
            for (i in 1..exp) {
                res *= this
            }
            res
        }
        else -> {
            1.div(integralPow(exp.unaryMinus()))
        }
    }
}

/**
 * Approximates (using the bisection) the square root of the given number
 *
 * @param num the number, whose square root we want to approximate
 * @param from the lower bound of the interval (default = 0.0)
 * @param to the upper bound of the interval (default ⌊([num] / 2)⌋ + 1; as (x/2 + 1) grows faster than sqrt(x))
 * @param eps the desired accuracy (default = 0.000001)
 * @return see [bisection]
 */
fun sqrt_approx_bisection(num: Double, from: Double = 0.0, to: Double = Math.floor(num.div(2.0)).plus(1), eps: Double = 0.0001)
        = bisection(num, from, to, eps, Double::square)

/**
 * Approximates (using the bisection) the [order]-th root of [num]
 *
 * @param num the number, whose root we want to approximate
 * @param order the order of the root
 * @param from the lower bound of the interval (default = 0.0)
 * @param to the upper bound of the interval (default ⌊([num] / [order])⌋ + 1; as linear function grows faster than the root function)
 * @param eps the desired accuracy (default = 0.000001)
 * @return see [bisection]
 */
fun nthRoot_approx_bisection(num: Double, order: Long, from: Double = 0.0, to: Double = Math.floor(num.div(order)).plus(1), eps: Double = 0.0001)
        = bisection(num, from, to, eps) { it.integralPow(order) }

/**
 * Approximates the number using bisection
 *
 * As this function cannot take a parameter representing the number that we want to approximate (because we do not know
 * the value of that number, that's why we want to approximate) one should provide the "validation function", which takes
 * the actual approximated number as a parameter and test whether that "validated" value is near enough to the target.
 *
 * Let's say, we want to approximate the square root of 5 (√5); we pass 5 to the [num] parameter and the squaring function
 * to the [validate] parameter
 *
 * @param num the "target" number; This is not he number that we want to approximate; this is the number,
 * close to which we want to get by applying [validate] on the approximated one
 * @param from the lower bound of the interval
 * @param to the upper bound of the interval
 * @param eps the desired accuracy (default = 0.000001)
 * @param validate the validation function
 * @return null, iff the value with the given accuracy could not be found within the given interval, or the approximated value otherwise
 */
fun bisection(num: Double, from: Double, to: Double, eps: Double = 0.00001, validate: (Double) -> Double): Double {
    val mid: Double = from.plus(to).div(2)
    val midValidated = validate(mid)
    if (midValidated.isAlmostEqual(num, eps)) {
        return mid
    } else if (midValidated < num) {
        return bisection(num, mid.plus(eps), to, eps, validate)
    } else {
        return bisection(num, from, mid.minus(eps), eps, validate)
    }
}

/**
 * Approximates the Euler's number
 *
 * e = SUM(n in [0,inf]) (1/n!)
 *
 * @param eps the desired accuracy (default = 0.000001)
 * @return the approximated value of e
 */
fun e(eps: Double = 0.000001): Double {
    var n = 0
    var fact = 1
    var result = 0.0

    do {
        val last = result
        result += 1.0 / fact
        n = n.inc()
        fact *= n
    } while (Math.abs(result - last) > eps)

    return result
}

/**
 * Approximates the natural logarithm of the given [x]
 *
 * ln(x) = 2 * SUM(n in [0,inf]) ((1/(2n+1)) * (((x-1)/(x+1))^(2n+1)))
 * WIKI: https://en.wikipedia.org/wiki/Logarithm#Calculation
 *
 * @param x the number, whose logarithm we are approximating
 * @param eps the desired accuracy (default = 0.000001)
 * @return the natural logarithm of [x]
 */
fun ln(x: Double, eps: Double = 0.000001): Double {
    var n = 1
    val secondPart = x.minus(1) / (x.plus(1))
    var result = secondPart

    do {
        val last = result
        val first = 1.00 / (2.times(n).plus(1))
        val second = secondPart.integralPow(2L.times(n).plus(1))
        result += first.times(second)
        n = n.inc()
    } while (Math.abs(2 * result - 2 * last) > eps)

    return 2.times(result)
}

/**
 * Syntactic sugar, which is more readable and simplifies for loops
 *
 * <tt>for(i in 1..5) { ... }</tt> becomes <tt>5.timesRepeat { ... }</tt>
 *
 * @param block block to execute in each iteration
 */
fun Int.timesRepeat(block: () -> Unit) {
    for (i in 1..this) {
        block()
    }
}
