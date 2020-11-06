// 01.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	Erstmalig ein File eingelesen, allerdings nur als kompletten String
//  -   Char kann man in einer If Abfrage nicht mit == "(" abfragen

import java.io.File

fun main(args: Array<String>) {
	/* https://kotlinlang.org/docs/tutorials/kotlin-for-py/file-io.html
 	// liest das ganze File und gibt es aus 
	File("puzzle_input.txt").forEachLine { println(it) }
	*/

	val levels: String  //hier steht dann der puzzle_input als String
	var floor = 0        //Zählvariable für die Level

	levels = File("day1501_puzzle_input.txt").readText()    //Einlesen des puzzle_inputs als String

	//für jedes Element in String einen Floor hoch oder runter zählen
	for (i in levels.indices) {
		if (levels[i].equals('(')) {
			floor++
		} else if (levels[i].equals(')')) {
			floor--
		}
	}

	// Ausgabe der Lösung für Part 1
	println("Solution for part1")
	print("   The instructions are taking Santa to Floor: ")
	println(floor)

	// part 2
	floor = 0 // Reinitialisieren der Floor Variable
	for (i in levels.indices) {
		if (levels[i].equals('(')) {
			floor++
		} else if (levels[i].equals(')')) {
			floor--
		}
		if (floor == -1) {
			println("Solution for part2")
			print("   The instruction wich brings Santa to Floor -1 is: ")
			println(i + 1)
			break
		}
	}
}