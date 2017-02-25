package util

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.data.general.Dataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.io.File


/**
 * Created by mseleng on 2/22/17.
 */
class Chart<X: Number, out Y: Number>(chartName: String, data: Map<X, Y>) {
    private val dataSet: Dataset
    private val chart: JFreeChart

    init {
        val series = XYSeries("")
        for ((x, y) in data) {
            series.add(x, y)
        }
        dataSet = XYSeriesCollection(series)
        chart = ChartFactory.createScatterPlot(chartName, "x", "y", dataSet)
        chart.removeLegend()
    }

    fun writeToPNG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsPNG(file, chart, width, height)
    }

    fun writeToJPEG(file: File, width: Int, height: Int) {
        ChartUtilities.saveChartAsJPEG(file, chart, width, height)
    }
}