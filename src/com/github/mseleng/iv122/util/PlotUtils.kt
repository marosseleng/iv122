package com.github.mseleng.iv122.util

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.awt.Paint
import java.io.File

/**
 * This class is used as a simple facade above the jfreechart library, providing simple chart actions
 *
 * @param chartName the name of the chart (required by jfreechart; this is **NOT** the name of an output file)
 * @param data a map of (Color-data) pairs, used as the dataset for the chart
 * @param showLegend true of legend of the chart should be shown, else otherwise (default false)
 * @constructor creates a [Chart] with the given data
 */
class Chart(chartName: String, data: Map<Paint, XYSeries>, showLegend: Boolean = false) {
    private val dataSet = XYSeriesCollection()
    private val chart = ChartFactory.createScatterPlot(chartName, "x", "y", dataSet)

    init {
        if (!showLegend) {
            chart.removeLegend()
        }
        var i = 0
        for ((x, y) in data) {
            dataSet.addSeries(y)
            chart.xyPlot.renderer.setSeriesPaint(i, x)
            i = i.inc()
        }
    }

    /**
     * Writes this chart into a PNG file
     *
     * @param file the target file
     * @param width the desired graph width
     * @param height the desired graph height
     */
    fun writeToPNG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsPNG(file, chart, width, height)
    }

    /**
     * Writes this chart into a JPEG file
     *
     * @param file the target file
     * @param width the desired graph width
     * @param height the desired graph height
     */
    fun writeToJPEG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsJPEG(file, chart, width, height)
    }
}