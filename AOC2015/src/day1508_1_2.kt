// 07.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {
	var sum_memory: Int = 0
	var sum_string: Int = 0
	var sum_memory2: Int = 0
	var sum_diff: Int

	File("day1508_puzzle_input.txt").forEachLine {
		sum_memory = sum_memory + it.length
		sum_string = sum_string + (it.length - 2)
		sum_memory2 = sum_memory2 + (it.length + 4)
		if (it.length > 3) {
			var i: Int = 0
			while (i < it.length - 1) {
				if (it[i].toInt() == 92 && it[i + 1].toInt() == 34) {
					sum_string = sum_string - 1
					sum_memory2 = sum_memory2 +2
				}
				if (it[i].toInt() == 92 && it[i + 1].toInt() == 120) {
					sum_string = sum_string - 3
					sum_memory2 = sum_memory2 +1
				}
				if (it[i].toInt() == 92 && it[i + 1].toInt() == 92) {
					sum_string = sum_string - 1
					sum_memory2 = sum_memory2 +2
					i = i + 1
				}
				i = i + 1
			}
		}
	}

	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	println("   The number of characters of code for string literals is $sum_memory  ")
	println("   The number of characters in memory for the values of the strings $sum_string  ")
	sum_diff = sum_memory - sum_string
	println("   The difference is $sum_diff ")
	// Ausgabe der Lösung für Part 1	
		println()
	println("Solution for part2")
	println("   The number of characters of code for string literals is $sum_memory  ")
	println("   The number of characters in memory for the values of the strings $sum_memory2  ")
	sum_diff = sum_memory2 - sum_memory
	println("   The difference is $sum_diff ")
	// 1370 is to high
}