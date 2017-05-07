package com.github.mseleng.iv122.assignment10

import com.github.mseleng.iv122.util.fileWithName

/**
 * @suppress
 */
fun run(path: String) {

    // A
    val mhIterations = 100000
    println("-> Monty hall problem ($mhIterations iterations):")
    val stay = montyHall(mhIterations, MontyHallChoice.STAY)
    val change = montyHall(mhIterations, MontyHallChoice.CHANGE)
    val whatever = montyHall(mhIterations, MontyHallChoice.WHATEVER)
    println("\tChoice =     STAY:\t${String.format("%.4f", stay)}\tExpected: ⅓")
    println("\tChoice =   CHANGE:\t${String.format("%.4f", change)}\tExpected: ⅔")
    println("\tChoice = WHATEVER:\t${String.format("%.4f", whatever)}\tExpected: ½")
    println("==========")

    // B
    println("-> (Non)random numbers")
    println("\t1\t Repeating permutations of (1,2,3,4,5,6)")
    println("\t2\t Probably some not honest cube (edge with 5 is probably heavier, which causes three times more fives than twos)")
    println("\t3\t I was not able to find any regularity. The distribution of numbers looks fine, although there is the same amount of 6s and 3s (850x 6; 821x 5; 824x 4; 850x 3; 836x 2; 819x 1)")
    println("\t4\t I was not able to find any regularity. The distribution of numbers looks fine as well (823x 6; 819x 5; 850x 4; 829x 3; 827x 2; 852x 1)")
    println("\t5\t I was not able to find any regularity. The distribution looks good also (859x 6; 842x5; 843x 4; 812x 3; 836x 2; 808x 1)")
    println("\t6\t There is a sequence of numbers repeating (contains 106 digits; found just by CTRL+F in text editor; unable to find just by looking at it)")
    println("\t7\t There is a long sequence of numbers repeating also (contains 2392 digits; found just by CTRL+F in text editor; unable to find just by looking at it)")
    println("==========")

    // C
    print("-> Central limit theorem (tossing just the cube A in each iteration; 100 tosses, 10000 iterations)......")
    clt(100, 10000, CLTExperimentStrategy.JUST_A).writeToPNG(fileWithName(path, 10, "clt1.png"), 2000, 2000)
    print(" ✓ (assignment10/clt1.png)\n-> Central limit theorem (choosing the random cube before each toss; 100 tosses, 10000 iterations)......")
    clt(100, 10000, CLTExperimentStrategy.EACH_TOSS_RANDOM).writeToPNG(fileWithName(path, 10, "clt2.png"), 2000, 2000)
    print(" ✓ (assignment10/clt2.png)\n-> Central limit theorem (picking the random cube before each iteration; 100 tosses, 10000 iterations)......")
    clt(100, 10000, CLTExperimentStrategy.EACH_ITERATION_RANDOM).writeToPNG(fileWithName(path, 10, "clt3.png"), 2000, 2000)
    println(" ✓ (assignment10/clt3.png)\n==========")

    // D
    println("-> Bayes theorem and simulations:")
    println("\tN=100; X=3; 1 million iterations for experiment:")
    println("\t\texperiment: ${experimentForCubes(100, 3, 1_000_000)}")
    println("\t\tbayes:      ${bayesForCubes(100, 3)}")
    println("\tN=10; X=5; 1 million iterations for experiment:")
    println("\t\texperiment: ${experimentForCubes(10, 5, 1_000_000)}")
    println("\t\tbayes:      ${bayesForCubes(10, 5)}")
    println("\tN=10; X=3; 1 million iterations for experiment:")
    println("\t\texperiment: ${experimentForCubes(10, 3, 1_000_000)}")
    println("\t\tbayes:      ${bayesForCubes(10, 3)}")
    println("\tN=10; X=1; 1 million iterations for experiment:")
    println("\t\texperiment: ${experimentForCubes(10, 1, 1_000_000)}")
    println("\t\tbayes:      ${bayesForCubes(10, 1)}")
}