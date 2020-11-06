// 11.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	val routes = arrayListOf<String>()
	val distances = mutableMapOf<String, Int>()
	// erzeuge aus dem Input eine Map mit Verbindungsdaten
	File("day1513_puzzle_input.txt").forEachLine {
		val singleroute = it.split(" ")
		if (singleroute[2] == "gain") {
			distances.put(singleroute[0] + singleroute[10].dropLast(1), singleroute[3].toInt())
		} else if (singleroute[2] == "lose") {
			distances.put(singleroute[0] + singleroute[10].dropLast(1), singleroute[3].toInt() * -1)
		}
		println(distances)
	}


	// erzeuge über 8 Schleifen alle Variationen
	val places =
		arrayListOf("Alice", "Bob", "Carol", "David", "Eric", "Frank", "George", "Mallory")
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
									if (route.contains("Alice") && route.contains("Bob") && route.contains("Carol") && route.contains(
											"David"
										) && route.contains("Eric") && route.contains("Frank") && route.contains("George") && route.contains(
											"Mallory"
										)
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

	println(routes)

// Berechne für alle Wertepaare aus der Liste die Entfernung. Speichere jeweils die kleinste Gesamtlänge ab.
	var result: Int
	var result_max: Int = 0
	var longestdistance: String = ""
	routes.forEach {
		val pl = it.split(" ")

		result =
			distances.getValue(pl[0] + pl[1]) + distances.getValue(pl[1] + pl[2]) + distances.getValue(pl[2] + pl[3]) + distances.getValue(
				pl[3] + pl[4]
			) + distances.getValue(pl[4] + pl[5]) + distances.getValue(pl[5] + pl[6]) + distances.getValue(pl[6] + pl[7]) + distances.getValue(
				pl[7] + pl[0]
			) +			distances.getValue(pl[1] + pl[0]) + distances.getValue(pl[2] + pl[1]) + distances.getValue(pl[3] + pl[2]) + distances.getValue(
				pl[4] + pl[3]
			) + distances.getValue(pl[5] + pl[4]) + distances.getValue(pl[6] + pl[5]) + distances.getValue(pl[7] + pl[6]) + distances.getValue(
				pl[0] + pl[7]
			)


		if (result > result_max) {
			result_max = result
			longestdistance = it
		}
	}
// Ausgabe der Lösung für Part 1	
	println("Solution for part1")
	print("   The minimum distance is $result_max for the order of $longestdistance  ")
	println()

}