// 09.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	var json: String  //hier steht dann der puzzle_input als String
	var numberstart: Int = 0
	var numberend: Int
	var number: Int = 0
	var i: Int = 1
	json = File("day1512_puzzle_input.txt").readText()    //Einlesen des puzzle_inputs als String   input 3 für Solution2!!

	json = "x" + json + "x"
	while (i < json.length - 1) {

		if (!json[i - 1].isDigit() && json[i].isDigit()) {
			numberstart = i
			if (json[i - 1].equals('-')) {
				numberstart = numberstart - 1
			}
				println("Startpos:  $numberstart")		
		}
		if (json[i].isDigit() && !json[i + 1].isDigit()) {
			numberend = i+1
			println("Endpos:   $numberend")
			number = number +  json.substring(numberstart, numberend).toInt()
			println("Number:  $number")
			println(json.substring(numberstart, numberend))
		}
		i = i + 1
	}

	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   The sum of all numbers in the doc is: $number")


}
