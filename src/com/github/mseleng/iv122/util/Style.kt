package com.github.mseleng.iv122.util

import java.awt.Color

/**
 * The class representing the style of the SVG elements
 *
 * @param stroke the Color of the stroke
 * @param strokeWidth the width of the stroke
 * @param fill the Color of the fill
 * @constructor creates the Style with the given parameters
 * @property stroke the Color of the stroke
 * @property strokeWidth the width of the stroke
 * @property fill the Color of the fill
 */
data class Style(val stroke: Color? = null, val strokeWidth: Int? = null, val fill: Color? = null)

/**
 * The default style (black stroke and stroke width == 1)
 */
val defaultLineStyle = Style(Color.BLACK, 1, null)
