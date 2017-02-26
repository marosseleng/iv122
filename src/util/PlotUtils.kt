package util

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.awt.Paint
import java.io.File


/**
 * Created by mseleng on 2/22/17.
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

    fun writeToPNG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsPNG(file, chart, width, height)
    }

    fun writeToJPEG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsJPEG(file, chart, width, height)
    }
}