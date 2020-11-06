// 08.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	val routes = arrayListOf<String>()
	val distances = mutableMapOf<String, Int>()
	// erzeuge aus dem Input eine Map mit Verbindungsdaten
	File("day1509_puzzle_input.txt").forEachLine {
		val singleroute = it.split(" ")
		distances.put(singleroute[0] + singleroute[2], singleroute[4].toInt())
		distances.put(singleroute[2] + singleroute[0], singleroute[4].toInt())
	}
	println(distances)


	// erzeuge über 8 Schleifen alle Variationen
	val places =
		arrayListOf("Faerun", "Tristram", "Tambi", "Norrath", "Snowdin", "Straylight", "AlphaCentauri", "Arbre")
	for (i1 in places) {
		for (i2 in places) {
			for (i3 in places) {
				for (i4 in places) {
					for (i5 in places) {
						for (i6 in places) {
							for (i7 in places) {
								for (i8 in places) {
									var route =
										i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + i6 + " " + i7 + " " + i8
									// wenn alle Buchstaben vertreten sind, dann addiere die Strings zu einer Liste
									if (route.contains("Faerun") && route.contains("Tristram") && route.contains("Tambi") && route.contains(
											"Norrath"
										) && route.contains("Snowdin") && route.contains("Straylight") && route.contains(
											"AlphaCentauri"
										) && route.contains("Arbre")
									) {
										routes.add(route)
									}
								}
							}

						}
					}
				}
			}
		}
	}

	println(routes.size)
	println(places)
// Berechne für alle Wertepaare aus der Liste die Entfernung. Speichere jeweils die kleinste Gesamtlänge ab.
	var result: Int
	var result_min: Int = 1000
	var result_max: Int = 0
	var shortesdistance: String = ""
	var longestdistance: String = ""
	routes.forEach {
		val pl = it.split(" ")

		result =
			distances.getValue(pl[0] + pl[1]) + distances.getValue(pl[1] + pl[2]) + distances.getValue(pl[2] + pl[3]) + distances.getValue(
				pl[3] + pl[4]
			) + distances.getValue(pl[4] + pl[5]) + distances.getValue(pl[5] + pl[6]) + distances.getValue(pl[6] + pl[7])
		if (result < result_min) {
			result_min = result
			shortesdistance = it
		}
		if (result > result_max) {
			result_max = result
			longestdistance = it
		}
	}
// Ausgabe der Lösung für Part 1	
	println("Solution for part1")
	print("   The minimum distance is $result_min for the order of $shortesdistance  ")
	println()

	// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	print("   The mmaximum distance is $result_max for the order of $longestdistance  ")
	println()

}