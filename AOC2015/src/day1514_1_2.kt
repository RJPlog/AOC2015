// 11.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	var points = IntArray(9)
	var ways = IntArray(9)

	var way: Int
	var waymax: Int = 0
	var elvemax: String = ""
	var j: Int


//	val distances = mutableMapOf<String, Int>()
	// erzeuge aus dem Input eine Map mit Verbindungsdaten
	for (time in 1..2503) {
		j = 0
		File("day1514_puzzle_input.txt").forEachLine {

			val velocity = it.split(" ")
			if (time.rem(velocity[6].toInt() + velocity[13].toInt()) < velocity[6].toInt()) {
				way =
					velocity[6].toInt() * velocity[3].toInt() * (time / (velocity[6].toInt() + velocity[13].toInt())) + time.rem(
						velocity[6].toInt() + velocity[13].toInt()
					) * velocity[3].toInt()
			} else {
				way =
					velocity[6].toInt() * velocity[3].toInt() * (time / (velocity[6].toInt() + velocity[13].toInt())) + velocity[6].toInt() * velocity[3].toInt()
			}
			// part 1
			if (way > waymax) {
				waymax = way
				elvemax = velocity[0]
			}
			// part 2
			ways[j] = way

			//println("$j:    ${velocity[0]} runs ${ways[j]} km")
			j = j + 1
		}
		for (k in 0..8) {
			points[k] = points[k]+ways[k] / waymax
		}
	}
	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	println("   $elvemax runs $waymax km")
	
		// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	println("   max points: ${points.max()}")
}