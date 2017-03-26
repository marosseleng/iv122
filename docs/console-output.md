## The console output
[Home](../)

```
IV122
Output directory: iv122_outputs/


***The first assignment***
-> Four-way gradient...... ✓ (assignment1/gradient.png)
-> A star...... ✓ (assignment1/star.svg)
-> An "inside-out" star...... ✓ (assignment1/weird-star.svg)
==========
-> The Ulam's spiral I.(prime numbers)...... ✓ (assignment1/ulamsSpiral-[prime].png)
-> The Ulam's spiral II.(x mod 5 > 1)...... ✓ (assignment1/ulamsSpiral-[mod5>1].png)
-> The Ulam's spiral III.(x*e mod π >= 2)....... ✓ (assignment1/ulamsSpiral-[*EmodPI>=2].png)
==========
-> The Collatz's sequence...... ✓ (assignment1/collatz.png)
-> The Collatz's sequence (the maximum numbers)...... ✓ (assignment1/collatz-max.png)
==========
-> The Euclidean gcd algorithm (modulo variant)...... ✓ (assignment1/euclid-[modulus].png)
-> The Euclidean gcd algorithm (subtraction variant)...... ✓ (assignment1/euclid-[subtraction].png)
Complete.

***The second assignment***
-> Input: [1, 2, 3, 4, 5]; k: 3
-> Permutations:
	Size is: 120. Should be: 120
	[12345, 12354, 12435, 12453, 12534, 12543, 13245, 13254, 13425, 13452, 13524, 13542, 14235, 14253, 14325, 14352, 14523, 14532, 15234, 15243, 15324, 15342, 15423, 15432, 21345, 21354, 21435, 21453, 21534, 21543, 23145, 23154, 23415, 23451, 23514, 23541, 24135, 24153, 24315, 24351, 24513, 24531, 25134, 25143, 25314, 25341, 25413, 25431, 31245, 31254, 31425, 31452, 31524, 31542, 32145, 32154, 32415, 32451, 32514, 32541, 34125, 34152, 34215, 34251, 34512, 34521, 35124, 35142, 35214, 35241, 35412, 35421, 41235, 41253, 41325, 41352, 41523, 41532, 42135, 42153, 42315, 42351, 42513, 42531, 43125, 43152, 43215, 43251, 43512, 43521, 45123, 45132, 45213, 45231, 45312, 45321, 51234, 51243, 51324, 51342, 51423, 51432, 52134, 52143, 52314, 52341, 52413, 52431, 53124, 53142, 53214, 53241, 53412, 53421, 54123, 54132, 54213, 54231, 54312, 54321]
-> Combinations without repetition:
	Size is: 10. Should be: 10
	[123, 124, 125, 134, 135, 145, 234, 235, 245, 345]
-> Combinations with repetition:
	Size is: 35. Should be: 35
	[111, 112, 113, 114, 115, 122, 123, 124, 125, 133, 134, 135, 144, 145, 155, 222, 223, 224, 225, 233, 234, 235, 244, 245, 255, 333, 334, 335, 344, 345, 355, 444, 445, 455, 555]
-> Variations without repetition:
	Size is: 60. Should be: 60
	[123, 124, 125, 132, 134, 135, 142, 143, 145, 152, 153, 154, 213, 214, 215, 231, 234, 235, 241, 243, 245, 251, 253, 254, 312, 314, 315, 321, 324, 325, 341, 342, 345, 351, 352, 354, 412, 413, 415, 421, 423, 425, 431, 432, 435, 451, 452, 453, 512, 513, 514, 521, 523, 524, 531, 532, 534, 541, 542, 543]
-> Variations with repetition:
	Size is: 125. Should be: 125
	[111, 112, 113, 114, 115, 121, 122, 123, 124, 125, 131, 132, 133, 134, 135, 141, 142, 143, 144, 145, 151, 152, 153, 154, 155, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225, 231, 232, 233, 234, 235, 241, 242, 243, 244, 245, 251, 252, 253, 254, 255, 311, 312, 313, 314, 315, 321, 322, 323, 324, 325, 331, 332, 333, 334, 335, 341, 342, 343, 344, 345, 351, 352, 353, 354, 355, 411, 412, 413, 414, 415, 421, 422, 423, 424, 425, 431, 432, 433, 434, 435, 441, 442, 443, 444, 445, 451, 452, 453, 454, 455, 511, 512, 513, 514, 515, 521, 522, 523, 524, 525, 531, 532, 533, 534, 535, 541, 542, 543, 544, 545, 551, 552, 553, 554, 555]
==========
-> Pascal's triangle (mod 5)...... ✓ (assignment2/pascal-mod5.png)
-> Pascal's triangle (mod 7)...... ✓ (assignment2/pascal-mod7.png)
-> Pascal's triangle (mod 3)...... ✓ (assignment2/pascal-mod3.png)
-> Pascal's triangle (mod 2)...... ✓ (assignment2/pascal-evenOdd.png)
==========
-> √2 = 2^0.5 = 1.4142259887695312; Library value = 1.4142135623730951
-> √3 = 3^0.5 = 1.7320678283691404; Library value = 1.7320508075688772
-> 3^3.14 = 31.48913562608489; Library value = 31.489135652454948
-> 2^3 = 8.0; Library value = 8.0
==========
-> π approximation within 3000 ms:
-> The library value of π: 3.141592653589793
	Monte Carlo method (using the library square (root) function): 3.141142721095495
	Gregory-Leibnitz method: 3.1416089108445644
	Archimedes' method (using the approximated square root): 3.1414670028686524 < π < 3.1414670028686524
	Archimedes' method (using the library square root function): 3.1415926535897927 < π < 3.1415926535897927
Complete.

***The third assignment***
-> Polygon (7 edges)...... ✓ (assignment3/polygon7.svg)
-> Polygon (9 edges)...... ✓ (assignment3/polygon9.svg)
-> Polygon (17 edges)...... ✓ (assignment3/polygon17.svg)
-> Multistar (9 vertices)...... ✓ (assignment3/multistar9.svg)
-> Multistar (5 vertices)...... ✓ (assignment3/multistar5.svg)==========

-> Pentagram (turtle)...... ✓ (assignment3/pentagram_turtle.svg)
-> 79gram (turtle)...... ✓ (assignment3/79gram_turtle.svg)
-> Nested square (20;[1:3];5])...... ✓ (assignment3/nestedsquare.svg)
-> Nested square (40;[1:7];5])...... ✓ (assignment3/nestedsquare2.svg)
-> Nested square (40;[1:10];0])...... ✓ (assignment3/nestedsquare3.svg)
-> Nested triangle ([25;5])...... ✓ (assignment3/nestedTriangle2.svg)
-> Nested triangle ([25;0])...... ✓ (assignment3/nestedTriangle.svg)
-> Rounded flower..... ✓ (assignment3/flower.svg)
==========
-> Branch fractal...... ✓ (assignment3/branch.svg)
-> Koch's flake (depth=1)...... ✓ (assignment3/koch-flake-1.svg)
-> Koch's flake (depth=3)...... ✓ (assignment3/koch-flake-3.svg)
-> Koch's flake (depth=5)...... ✓ (assignment3/koch-flake-5.svg)
-> Sierpiński's triangle (depth=2)...... ✓ (assignment3/sierpinski-triangle-2.svg)
-> Sierpiński's triangle (depth=4)...... ✓ (assignment3/sierpinski-triangle-4.svg)
-> Sierpiński's triangle (depth=8)...... ✓ (assignment3/sierpinski-triangle-8.svg)
-> Pentagonal flake (depth=2)...... ✓ (assignment3/penta-flake-2.svg)
-> Pentagonal flake (depth=4)...... ✓ (assignment3/penta-flake-4.svg)
-> Pentagonal flake (depth=6)...... ✓ (assignment3/penta-flake-5.svg)
Complete.

```
