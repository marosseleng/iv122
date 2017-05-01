package com.github.mseleng.iv122.assignment8

import com.github.mseleng.iv122.util.Coordinates
import com.github.mseleng.iv122.util.SVG
import com.github.mseleng.iv122.util.fileWithName

/**
 * @suppress
 */
fun run(path: String) {
    // A
    print("-> Squares......")
    SVG(900, 550).lines(applyTransformations(square(400.0), Coordinates(440, 260), 15, rotation(10.0), scaling(1.1, 0.8)))
            .writeTo(fileWithName(path, 8, "squares.svg"))
    print(" ✓ (assignment8/squares.svg)\n-> Spiral......")
    SVG(650, 200).lines(applyTransformations(square(100.0), Coordinates(70, 120), 25, shear(1.3), rotation(10.0), scaling(0.9, 0.9), translation(50.0, -50.0)))
            .writeTo(fileWithName(path, 8, "spiral.svg"))
    print(" ✓ (assignment8/spiral.svg)\n-> Another spiral......")
    SVG(5000, 5000).lines(applyTransformations(square(80.0), Coordinates(2500, 3000), 35, rotation(-20.0), scaling(1.1, 1.1), translation(10.0, 20.0)))
            .writeTo(fileWithName(path, 8, "spiral-2.svg"))
    print(" ✓ (assignment8/spiral-2.svg)\n==========\n")

    // B
    print("-> Twin christmas tree......")
    SVG(640, 640).lines(twinChristmasTreeMRCM(300.0, Coordinates(320, 320), 8)).writeTo(fileWithName(path, 8, "christmas-tree.svg"))
    print(" ✓ (assignment8/christmas-tree.svg)\n-> Dragon......")
    SVG(320, 300).lines(dragonMRCM(300.0, Coordinates(150, 160), 8)).writeTo(fileWithName(path, 8, "dragon.svg"))
    print(" ✓ (assignment8/dragon.svg)\n-> Sierpinski triangle......")
    SVG(650, 550).lines(originalSierpinskiMRCM(600.0, Coordinates(325, 200), 8)).writeTo(fileWithName(path, 8, "sierpinski.svg"))
    print(" ✓ (assignment8/sierpinski.svg)\n-> Sierpinski triangle 2......")
    SVG(320, 320).lines(sierpAlt1MRCM(300.0, Coordinates(160, 160), 8)).writeTo(fileWithName(path, 8, "sierpinski-2.svg"))
    print(" ✓ (assignment8/sierpinski-2.svg)\n-> Sierpinski triangle 3......")
    SVG(320, 320).lines(sierpAlt2MRCM(300.0, Coordinates(160, 160), 8)).writeTo(fileWithName(path, 8, "sierpinski-3.svg"))
    print(" ✓ (assignment8/sierpinski-3.svg)\n-> Sierpinski triangle 4......")
    SVG(320, 320).lines(sierpAlt3MRCM(300.0, Coordinates(160, 160), 8)).writeTo(fileWithName(path, 8, "sierpinski-4.svg"))
    print(" ✓ (assignment8/sierpinski-4.svg)\n-> Sierpinski triangle 5......")
    SVG(320, 320).lines(sierpAlt4MRCM(300.0, Coordinates(160, 160), 8)).writeTo(fileWithName(path, 8, "sierpinski-5.svg"))
    print(" ✓ (assignment8/sierpinski-5.svg)\n")
}
