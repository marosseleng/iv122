package com.github.mseleng.iv122.util

/**
 * Complex number implementation, copied from
 * http://introcs.cs.princeton.edu/java/32class/Complex.java.html
 *
 * @property re the real part
 * @property im the imaginary part
 * @constructor constructs the complex number
 */
data class Complex(val re: Double, val im: Double) {

    /**
     * @suppress
     */
    constructor(re: Int, im: Int) : this(re.toDouble(), im.toDouble())

    /**
     * return a string representation of the invoking Complex object
     */
    override fun toString(): String {
        if (im == 0.0) return re.toString() + ""
        if (re == 0.0) return im.toString() + "i"
        if (im < 0) return re.toString() + " - " + -im + "i"
        return re.toString() + " + " + im + "i"
    }

    /**
     * return abs/modulus/magnitude
     */
    fun abs(): Double {
        return Math.hypot(re, im)
    }

    /**
     * return angle/phase/argument, normalized to be between -pi and pi
     */
    fun phase(): Double {
        return Math.atan2(im, re)
    }

    /**
     * return a new Complex object whose value is (this + b) 
     */
    operator fun plus(b: Int): Complex {
        return plus(b.toDouble())
    }

    /**
     * return a new Complex object whose value is (this + b)
     */
    operator fun plus(b: Double): Complex {
        return plus(Complex(b, 0.0))
    }

    /**
     * return a new Complex object whose value is (this + b)
     */
    operator fun plus(b: Complex): Complex {
        val a = this             // invoking object
        val real = a.re + b.re
        val imag = a.im + b.im
        return Complex(real, imag)
    }

    /**
     * return a new Complex object whose value is (this - b)
     */
    operator fun minus(b: Int): Complex {
        return minus(b.toDouble())
    }

    /**
     * return a new Complex object whose value is (this - b)
     */
    operator fun minus(b: Double): Complex {
        return minus(Complex(b, 0.0))
    }

    /**
     * return a new Complex object whose value is (this - b)
     */
    operator fun minus(b: Complex): Complex {
        val a = this
        val real = a.re - b.re
        val imag = a.im - b.im
        return Complex(real, imag)
    }

    /**
     * return a new Complex object whose value is (this * b)
     */
    operator fun times(b: Int): Complex {
        return times(b.toDouble())
    }

    /**
     * return a new Complex object whose value is (this * b)
     */
    operator fun times(b: Double): Complex {
        return times(Complex(b, 0.0))
    }

    /**
     * return a new Complex object whose value is (this * b)
     */
    operator fun times(b: Complex): Complex {
        val a = this
        val real = a.re * b.re - a.im * b.im
        val imag = a.re * b.im + a.im * b.re
        return Complex(real, imag)
    }

    /**
     * return a / b
     */
    operator fun div(b: Int): Complex {
        return div(b.toDouble())
    }

    /**
     * return a / b
     */
    operator fun div(b: Double): Complex {
        return div(Complex(b, 0.0))
    }

    /**
     * return a / b
     */
    operator fun div(b: Complex): Complex {
        val a = this
        return a.times(b.reciprocal())
    }

    /**
     * return a new object whose value is (this * alpha)
     */
    fun scale(alpha: Double): Complex {
        return Complex(alpha * re, alpha * im)
    }

    /**
     * return a new Complex object whose value is the conjugate of this
     */
    fun conjugate(): Complex {
        return Complex(re, -im)
    }

    /**
     * return a new Complex object whose value is the reciprocal of this
     */
    fun reciprocal(): Complex {
        val scale = re * re + im * im
        return Complex(re / scale, -im / scale)
    }

    /**
     * return a new Complex object whose value is the complex exponential of this
     */
    fun exp(): Complex {
        return Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im))
    }

    /**
     * return a new Complex object whose value is the complex sine of this
     */
    fun sin(): Complex {
        return Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im))
    }

    /**
     * return a new Complex object whose value is the complex cosine of this
     */
    fun cos(): Complex {
        return Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im))
    }

    /**
     * return a new Complex object whose value is the complex tangent of this
     */
    fun tan(): Complex {
        return sin().div(cos())
    }
}