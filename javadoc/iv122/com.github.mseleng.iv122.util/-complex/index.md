---
title: Complex - iv122
---

[iv122](../../index.md) / [com.github.mseleng.iv122.util](../index.md) / [Complex](.)

# Complex

`data class Complex`

Complex number implementation, copied from
http://introcs.cs.princeton.edu/java/32class/Complex.java.html

### Constructors

| [&lt;init&gt;](-init-.md) | `Complex(re: Double, im: Double)`<br>constructs the complex number |

### Properties

| [im](im.md) | `val im: Double`<br>the imaginary part |
| [re](re.md) | `val re: Double`<br>the real part |

### Functions

| [abs](abs.md) | `fun abs(): Double`<br>return abs/modulus/magnitude |
| [conjugate](conjugate.md) | `fun conjugate(): Complex`<br>return a new Complex object whose value is the conjugate of this |
| [cos](cos.md) | `fun cos(): Complex`<br>return a new Complex object whose value is the complex cosine of this |
| [div](div.md) | `operator fun div(b: Int): Complex`<br>`operator fun div(b: Double): Complex`<br>`operator fun div(b: Complex): Complex`<br>return a / b |
| [exp](exp.md) | `fun exp(): Complex`<br>return a new Complex object whose value is the complex exponential of this |
| [minus](minus.md) | `operator fun minus(b: Int): Complex`<br>`operator fun minus(b: Double): Complex`<br>`operator fun minus(b: Complex): Complex`<br>return a new Complex object whose value is (this - b) |
| [phase](phase.md) | `fun phase(): Double`<br>return angle/phase/argument, normalized to be between -pi and pi |
| [plus](plus.md) | `operator fun plus(b: Int): Complex`<br>`operator fun plus(b: Double): Complex`<br>`operator fun plus(b: Complex): Complex`<br>return a new Complex object whose value is (this + b) |
| [reciprocal](reciprocal.md) | `fun reciprocal(): Complex`<br>return a new Complex object whose value is the reciprocal of this |
| [scale](scale.md) | `fun scale(alpha: Double): Complex`<br>return a new object whose value is (this * alpha) |
| [sin](sin.md) | `fun sin(): Complex`<br>return a new Complex object whose value is the complex sine of this |
| [tan](tan.md) | `fun tan(): Complex`<br>return a new Complex object whose value is the complex tangent of this |
| [times](times.md) | `operator fun times(b: Int): Complex`<br>`operator fun times(b: Double): Complex`<br>`operator fun times(b: Complex): Complex`<br>return a new Complex object whose value is (this * b) |
| [toString](to-string.md) | `fun toString(): String`<br>return a string representation of the invoking Complex object |

