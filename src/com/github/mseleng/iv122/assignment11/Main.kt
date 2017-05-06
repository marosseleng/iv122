package com.github.mseleng.iv122.assignment11

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.fileWithName
import java.io.File

/**
 * @suppress
 */
fun run(path: String) {

    // A
    val size = 1000
    println("-> Input: Image size: $size")
    print("-> Linear regression (analytical solution; data from file linreg.txt)......")
    regressionAnalytical(readDataSet(File("inputs/assignment11/linreg.txt"))).writeToPNG(fileWithName(path, 11, "linreg-analytic-file.png"), size, size)
    print(" ✓ (assignment11/linreg-analytic-1-file.png)\n-> Linear regression (gradient descent; data from file linreg.txt; learning rate 0.001)......")
    gradientDescent(0.0, 0.0, readDataSet(File("inputs/assignment11/linreg.txt")), 0.001) { fileWithName(path, 11, String.format("linreg-gd-file%02d.png", it)) }
    print(" ✓ (assignment11/linreg-gd-file%02d.png[1-50])\n-> Linear regression (analytical solution; y=2.4x-1)......")
    regressionAnalytical(generateRegressionDataSet(2.4, -1.0, 4.5, Pair(-10.0, 50.0), 100)).writeToPNG(fileWithName(path, 11, "linreg-analytic-synthetic.png"), size, size)
    print(" ✓ (assignment11/linreg-analytic-synthetic.png)\n-> Linear regression (gradient descent; synthetic data; y=2.4x-1; deviation 4.5; learning rate 0.000001)......")
    gradientDescent(0.0, 0.0, generateRegressionDataSet(2.4, -1.0, 4.5, Pair(-10.0, 50.0), 100), 0.000001, 70) { fileWithName(path, 11, String.format("linreg-gd-synthetic-2-%02d.png", it)) }
    print(" ✓ (assignment11/linreg-gd-synthetic-2-%02d.png)\n-> Linear regression (gradient descent; synthetic data; y=2.4x-1; deviation 4.5; learning rate 0.0001)......")
    gradientDescent(0.0, 0.0, generateRegressionDataSet(2.4, -1.0, 4.5, Pair(-10.0, 50.0), 100), 0.0001, 70) { fileWithName(path, 11, String.format("linreg-gd-synthetic-2-bad-%02d.png", it)) }
    print(" ✓ (assignment11/linreg-gd-synthetic-2-bad-%02d.png)\n==========\n")

    // B
    print("-> Clustering (data from faithful.txt; 2 clusters)......")
    findClustersKMeans(readDataSet(File("inputs/assignment11/faithful.txt")), 2, "Old faithful") { fileWithName(path, 11, String.format("clusters-file%02d.png", it)) }
    print(" ✓ (assignment11/clusters-file%02d.png)\n-> Clustering (synthetic data; 6 clusters)......")
    findClustersKMeans(generateClustersDataSet(6, 300.0, Coordinates(1000, 1000), 150.0, 400), 6, "Synthetic dataset") { fileWithName(path, 11, String.format("clusters-synthetic%02d.png", it)) }
    println(" ✓ (assignment11/clusters-synthetic%02d.png)")
}