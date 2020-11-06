// 08.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	var las: String       
	var count = 1        
	var las_new: String = ""
	var i: Int = 0
	var part1: Int = 0
	las = File("day1510_puzzle_input.txt").readText()    
	println(las)


	//auswerten des look and say algorithms
	las = las + "0"

	for (j in 1..50) {
		while (i < las.length - 1) {
			if (las[i].equals(las[i + 1])) {
				count = count + 1
			} else {
				las_new = las_new + count.toString() + las[i]
				count = 1
			}
			i = i + 1
		}
		print("Runde $j --> Länge des Ergebnis: ")
		println(las_new.length)
		if (j == 40) {
			part1 = las_new.length
		}
		las = las_new + "0"
		las_new= ""
		i= 0
		count= 1
	}

	las=las.dropLast(1)

	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   After 40y rounds of look and say the length is: ")
	println(part1)
	
		// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part2")
	print("   After 50y rounds of look and say the length is: ")
	println(las.length)

}
