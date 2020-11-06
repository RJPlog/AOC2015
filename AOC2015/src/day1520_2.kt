// 14.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {
	val puzzleinput =   33100000
	var numberofgifts = 0
	var housenumber = 776133
	var elvesnumber = 776133


	
	while (numberofgifts < puzzleinput) {
		numberofgifts = 0
		while (elvesnumber > 0) {
			if ((housenumber.rem(elvesnumber) == 0) && (housenumber / elvesnumber - housenumber.rem(elvesnumber) < 51)) {  // and mod < 51 ! for part 2
				numberofgifts = numberofgifts + elvesnumber * 11
			}
			elvesnumber = elvesnumber - 1
		}
		println("we are at housnumber $housenumber and $numberofgifts nubers of gift")
			housenumber = housenumber +1
		elvesnumber = housenumber

	}
	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part2")
	println("   we are at housnumber ${housenumber-1} and $numberofgifts nubers of gift")

}