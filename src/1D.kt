import org.jfree.data.xy.XYSeries
import util.Chart
import util.fileWithName
import java.awt.Color
import java.awt.Paint

/**
 * Created by mseleng on 2/23/17.
 */
fun main(args: Array<String>) {
    euclidMod(300, 300)
}

fun euclidMod(width: Int, height: Int) {
    val result = mutableMapOf(
            NumberOfSteps.ONE_TO_THREE to XYSeries("1-3"),
            NumberOfSteps.FOUR_TO_FIVE to XYSeries("4-5"),
            NumberOfSteps.SIX_TO_EIGHT to XYSeries("6-8"),
            NumberOfSteps.NINE_TO_TEN to XYSeries("9-10"),
            NumberOfSteps.MORE_THAN_TEN to XYSeries("10<"))
    for (x in 1..width) {
        for (y in 1..height) {
            val (_, steps) = euclidMod_recursive(x, y)
            result[getNumberOfStepsEnum(steps)]?.add(x, y)
        }
    }
    Chart("The number of steps needed to compute GCD of two numbers using the Euclid's modulus algorithm.",
            result.mapKeys { it.key.getPaint() }, true)
            .writeToPNG(fileWithName(1, "euclid[modulus].png"), 2000, 2000)
}

private fun euclidMod_recursive(x: Int, y: Int): EuclidSolution {
    if (y == 0) {
        return EuclidSolution(x, 1)
    } else {
        val (gcd, steps) = euclidMod_recursive(y, x.rem(y))
        return EuclidSolution(gcd, steps + 1)
    }
}

private fun euclidSub_recursive(x: Int, y: Int): EuclidSolution {

}

private data class EuclidSolution(val gcd: Int, val steps: Int)

private enum class NumberOfSteps(val from: Int, val to: Int) {
    ONE_TO_THREE(1, 3) {
        override fun getPaint(): Paint = Color.RED
    },
    FOUR_TO_FIVE(4, 5) {
        override fun getPaint(): Paint = Color.ORANGE
    },
    SIX_TO_EIGHT(6, 8) {
        override fun getPaint(): Paint = Color.YELLOW
    },
    NINE_TO_TEN(9, 10) {
        override fun getPaint(): Paint = Color.GREEN
    },
    MORE_THAN_TEN(11, Int.MAX_VALUE) {
        override fun getPaint(): Paint = Color.BLUE
    };

    abstract fun getPaint(): Paint
}

private fun getNumberOfStepsEnum(steps: Int) = NumberOfSteps.values().filter { steps >= it.from && steps <= it.to }.first()
