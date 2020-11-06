// 14.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   



import java.io.File

fun main(args: Array<String>) {

	var puzzle: String = "" //hier steht dann der puzzle_input als String

	val replacements = arrayListOf<String>()
	val molecules = arrayListOf<String>()

	var stop: Boolean = false

	// put all the replacements in a map, separate then the last string.
	File("day1519_puzzle_input.txt").forEachLine {
		if (!stop) {
			if (!it.equals("")) {
				replacements.add(it)
			} else if (it.equals("")) {
				stop = true
			}
		} else if (stop) {
			puzzle = it  //506 Zeichen
		}
	}

	println(puzzle)
	println()
	println(replacements)

	replacements.forEach {
		//für jede Zeile in List
		var startindex = 0
		var substring = it.split(" => ")
		while (puzzle.drop(startindex).contains(substring[0])) {      // solange substring value in puzzle, aber diese eingangsbedingung passt nicht
			startindex = puzzle.indexOf(substring[0], startindex)
			val molecule = puzzle.replaceRange(startindex, substring[0].length + startindex, substring[1])
			println("wir suchen ${substring[0]}")
			println("an Stelle $startindex bis ${substring[0].length + startindex} ")
			println(" und ersetzen hier ${substring[1]} ")
			println("das ergibt dann $molecule")
			println()
			molecules.add(molecule)
			// hochsetzen Startindex
			startindex = startindex + 1
		}
	}
	println(molecules)

	// starte mit Startindex 0 und suche Substring,
	// replace mit Map Key
	// setze startindex auf gefundenen Index + Länge des Keys
	// speichere das in Liste --> prüfen auf doppelte noch offen.
	
	val moleculesred = mutableMapOf<String, Int>()
	molecules.forEach {
moleculesred.put(it, 1)
	}



	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   There are : ${moleculesred.size} molecules / ${molecules.size} (with duplicate)")

}
