// 16.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {
	val program = arrayListOf<String>()
	var a: Long = 1  // 0 für Part1
	var b: Long = 0
	var i: Int = 0

	File("day1523_puzzle_input.txt").forEachLine {
		program.add(it)
	}
	println(program)

	//for (j in 0..50) {
		while (i < program.size) {
		var instruction = program[i].split(" ")
	//	print(" $i  ${program[i]}  ")
		when (instruction[0]) {
			"hlf" -> {
				when (instruction[1]) {
					"a" -> a = a / 2
					"b" -> b = b / 2
				}
				i = i + 1
			}
			"tpl" -> {
				when (instruction[1]) {
					"a" -> a = a * 3
					"b" -> b = b * 3
				}
				i = i + 1
			}
			"inc" -> {
				when (instruction[1]) {
					"a" -> a = a + 1
					"b" -> b = b + 1
				}
				i = i + 1
			}
			"jmp" -> i = i + instruction[1].toInt()
			"jie" -> when (instruction[1]) {
				"a," -> if (a.rem(2) == 0.toLong()) {
					i = i + instruction[2].toInt()
				} else {
					i = i + 1
				}
				"b," -> if (b.rem(2) == 0.toLong()) {
					i = i + instruction[2].toInt()
				} else {
					i = i + 1
				}
			}
			"jio" ->
				when (instruction[1]) {
					"a," -> if (a == 1.toLong()) {
						i = i + instruction[2].toInt()
					} else {
						i = i + 1
					}
					"b," -> if (b == 1.toLong()) {
						i = i + instruction[2].toInt()
					} else {
						i = i + 1
					}

				}
		}
		println("a: $a b: $b ")
	}


// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	print("   register b: $b ")
}
