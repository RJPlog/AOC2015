// 05.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-
//  -  

import java.io.File

fun main(args: Array<String>) {

	var light_grid = Array(1000) { Array(1000) { 0 } }
	var sum_grid: Int = 0

	File("day1506_puzzle_input.txt").forEachLine {
		val instruction = it.split(" ")
		// turn on
		if (instruction[1].equals("on")) {
			val range_low = instruction[2].split(",")
			val range_high = instruction[4].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					light_grid[i][j] = 1
				}
			}
		}

		// turn off
		if (instruction[1].equals("off")) {
			val range_low = instruction[2].split(",")
			val range_high = instruction[4].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					light_grid[i][j] = 0
				}
			}
		}

		// toggle
		if (instruction[0].equals("toggle")) {
			val range_low = instruction[1].split(",")
			val range_high = instruction[3].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					if (light_grid[i][j] == 1) {
						light_grid[i][j] = 0
					} else {
						light_grid[i][j] = 1
					}
				}
			}
		}
	}

// aufsummieren aller Lichter
	for (i in 0..999) {
		for (j in 0..999) {
			sum_grid = sum_grid + light_grid[i][j]
		}
	}

	// Ausgabe der Lösung für Part 1
	println("Solution for part1")
	print("   There are lights on: ")
	println(sum_grid)

	///////////////////////////////////////////////////
	// part 2
	///////////////////////////////////////////////////

	light_grid = Array(1000) { Array(1000) { 0 } }
	sum_grid = 0

	File("day1506_puzzle_input.txt").forEachLine {
		val instruction = it.split(" ")
		// turn on
		if (instruction[1].equals("on")) {
			val range_low = instruction[2].split(",")
			val range_high = instruction[4].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					light_grid[i][j] = light_grid[i][j] + 1
				}
			}
		}

		// turn off
		if (instruction[1].equals("off")) {
			val range_low = instruction[2].split(",")
			val range_high = instruction[4].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					light_grid[i][j] = light_grid[i][j] - 1
					if (light_grid[i][j] < 0) {
						light_grid[i][j] = 0
					}
				}
			}
		}

		// toggle
		if (instruction[0].equals("toggle")) {
			val range_low = instruction[1].split(",")
			val range_high = instruction[3].split(",")
			for (i in range_low[0].toInt()..range_high[0].toInt()) {
				for (j in range_low[1].toInt()..range_high[1].toInt()) {
					light_grid[i][j] = light_grid[i][j] + 2

				}
			}
		}
	}

// aufsummieren aller Lichter
	for (i in 0..999) {
		for (j in 0..999) {
			sum_grid = sum_grid + light_grid[i][j]
		}
	}

	// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	print("   There are lights on: ")
	println(sum_grid)


}