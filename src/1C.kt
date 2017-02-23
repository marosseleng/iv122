fun collatz(n: Int) {
    for (number in 1..n) {
        var mutableNumber = number
        var steps = 1
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            steps++
        }
        print("$steps,")
    }
}

fun collatzWithMax(n: Int) {
    for (number in 1..n) {
        var mutableNumber = number
        var max = mutableNumber
        while (mutableNumber > 1) {
            if ((mutableNumber.rem(2)) == 0) {
                mutableNumber = mutableNumber.div(2)
            } else {
                mutableNumber = mutableNumber.times(3).plus(1)
            }
            max = maxOf(mutableNumber, max)
        }
        print("$max,")
    }
}