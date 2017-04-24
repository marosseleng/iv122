package com.github.mseleng.iv122.assignment6

import com.github.mseleng.iv122.util.SVG
import com.github.mseleng.iv122.util.fileWithName
import com.github.mseleng.iv122.util.writeTo

fun run(path: String) {

    //A
    val imgSize = 1000
    val skip = 250
    println("-> Input: Image size: $imgSize; Number of points to skip: $skip")
    print("-> Sierpinski triangle (Chaos game; 1:2)......")
    chaosGame(3, 1 / 2.0, skip, imgSize).writeTo(fileWithName(path, 6, "sierpinski-triangle.png"))
    print(" ✓ (assignment6/sierpinski-triangle.png)\n-> Sierpinski triangle 2 (Chaos game; 1:4)......")
    chaosGame(3, 1 / 4.0, skip, imgSize).writeTo(fileWithName(path, 6, "sierpinski-triangle-2.png"))
    print(" ✓ (assignment6/sierpinski-triangle-2.png)\n-> Pentagon (Chaos game; 1:3)......")
    chaosGame(5, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "pentagon.png"))
    print(" ✓ (assignment6/pentagon.png)\n-> Pentagon 2 (Chaos game; 3:8)......")
    chaosGame(5, 3.0 / 8.0, skip, imgSize).writeTo(fileWithName(path, 6, "pentagon-2.png"))
    print(" ✓ (assignment6/pentagon-2.png)\n-> Hexagon (Chaos game; 1:3)......")
    chaosGame(6, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "hexagon.png"))
    print(" ✓ (assignment6/hexagon.png)\n-> Octagon (Chaos game; 1:3)......")
    chaosGame(8, 1 / 3.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon.png"))
    print(" ✓ (assignment6/octagon.png)\n-> Octagon 2 (Chaos game; 3:16)......")
    chaosGame(8, 3 / 16.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon-2.png"))
    print(" ✓ (assignment6/octagon-2.png)\n-> Octagon 3 (Chaos game; 2:7)......")
    chaosGame(8, 2 / 7.0, skip, imgSize).writeTo(fileWithName(path, 6, "octagon-3.png"))
    print(" ✓ (assignment6/octagon-3.png)\n==========\n")

    //B
    print("-> Koch's flake (L-system)......")
    SVG(300, 350).lines(kochLSystem()).writeTo(fileWithName(path, 6, "koch-l-system.svg"))
    print(" ✓ (assignment6/koch-l-system.svg)\n-> Sierpinski triangle (L-system)......")
    SVG(800, 700).lines(sierpinskiLSystem()).writeTo(fileWithName(path, 6, "sierpinski-l-system.svg"))
    print(" ✓ (assignment6/sierpinski-l-system.svg)\n-> Tree (L-system)......")
    SVG(700, 700).lines(treeLSystem()).writeTo(fileWithName(path, 6, "tree-l-system.svg"))
    print(" ✓ (assignment6/tree-l-system.svg)\n-> Hilbert's curve (L-system)......")
    SVG().lines(hilbertLSystem()).writeTo(fileWithName(path, 6, "hilbert-l-system.svg"))
    print(" ✓ (assignment6/hilbert-l-system.svg)\n-> Hilbert's curve (L-system; left 89°, right 91°)......")
    SVG().lines(hilbertLSystem2()).writeTo(fileWithName(path, 6, "hilbert-l-system-89-91.svg"))
    print(" ✓ (assignment6/hilbert-l-system-89-91.svg)\n-> Plant 1 (L-system, ABOP, edge-rewriting)......")
    SVG(500, 1000).lines(plant1()).writeTo(fileWithName(path, 6, "plant-1.svg"))
    print(" ✓ (assignment6/plant-1.svg)\n-> Plant 2 (L-system, ABOP, node-rewriting)......")
    SVG(500, 1000).lines(plant2()).writeTo(fileWithName(path, 6, "plant-2.svg"))
    print(" ✓ (assignment6/plant-2.svg)\n-> Plant 3 (L-system, ABOP, node-rewriting)......")
    SVG(500, 1000).lines(plant3()).writeTo(fileWithName(path, 6, "plant-3.svg"))
    print(" ✓ (assignment6/plant-3.svg)\n-> Plant 4 (L-system, ABOP modification (curved main axis))......")
    SVG().lines(plant4()).writeTo(fileWithName(path, 6, "plant-4.svg"))
    print(" ✓ (assignment6/plant-4.svg)\n-> Koch's island (L-system)......")
    SVG(750, 750).lines(kochIsland()).writeTo(fileWithName(path, 6, "koch-island-l-system.svg"))
    print(" ✓ (assignment6/koch-island-l-system.svg)\n-> Koch's island (L-system; left 90.2°, right 89.7°)......")
    SVG(750, 750).lines(kochIsland2()).writeTo(fileWithName(path, 6, "koch-island-l-system897-902.svg"))
    print(" ✓ (assignment6/koch-island-l-system897-902.svg)\n-> Dragon's curve (L-system)......")
    SVG(3000, 2300).lines(dragonCurve()).writeTo(fileWithName(path, 6, "dragon-curve-l-system.svg"))
    print(" ✓ (assignment6/dragon-curve-l-system.svg)\n-> Plant 5 (L-system)......")
    SVG().lines(plant5()).writeTo(fileWithName(path, 6, "plant-5.svg"))
    print(" ✓ (assignment6/plant-5.svg)\n==========\n")

    //C
    print("-> Feigenbaum's diagram (r∈[0.0;1.0], x∈[0.0;1.0])......")
    feigenbaum(500, 500, Pair(0.0, 1.0), Pair(0.0, 1.0)).writeTo(fileWithName(path, 6, "feigenbaum-0_00|1_00-0_00|1_00.png"))
    print(" ✓ (assignment6/feigenbaum-0_00|1_00-0_00|1_00.png)\n-> Feigenbaum's diagram (r∈[0.0;1.0], x∈[0.5;1.0])......")
    feigenbaum(500, 500, Pair(0.0, 1.0), Pair(0.5, 1.0)).writeTo(fileWithName(path, 6, "feigenbaum-0_00|1_00-0_50|1_00.png"))
    print(" ✓ (assignment6/feigenbaum-0_00|1_00-0_50|1_00.png)\n-> Feigenbaum's diagram (r∈[0.85;0.9], x∈[0.8;0.9])......")
    feigenbaum(500, 500, Pair(0.85, 0.9), Pair(0.8, 0.9)).writeTo(fileWithName(path, 6, "feigenbaum-0_85|0_90-0_80|0_90.png"))
    print(" ✓ (assignment6/feigenbaum-0_85|0_90-0_80|0_90.png)\n-> Feigenbaum's diagram (r∈[0.85;1.0], x∈[0.0;1.0])......")
    feigenbaum(500, 500, Pair(0.85, 1.0), Pair(0.0, 1.0)).writeTo(fileWithName(path, 6, "feigenbaum-0_85|1_00-0_00|1_00.png"))
    print(" ✓ (assignment6/feigenbaum-0_85|1_00-0_00|1_00.png)\n-> Feigenbaum's diagram (r∈[0.85;1.0], x∈[0.75;1.0])......")
    feigenbaum(500, 500, Pair(0.85, 1.0), Pair(0.75, 1.0)).writeTo(fileWithName(path, 6, "feigenbaum-0_85|1_00-0_75|1_00.png"))
    print(" ✓ (assignment6/feigenbaum-0_85|1_00-0_75|1_00.png)\n")
}