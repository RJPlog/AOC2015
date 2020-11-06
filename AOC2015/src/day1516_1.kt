// 12.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	val aunties = arrayListOf<String>()

	File("day1516_puzzle_input.txt").forEachLine {
		aunties.add(it)
	}
	println(aunties)

	val auntIterator = aunties.iterator()
	while (auntIterator.hasNext()) {
		var aunt = auntIterator.next()
		if ((aunt.contains("children") && !aunt.contains("children: 3")) || (aunt.contains("cats") && !aunt.contains("cats: 7")) || (aunt.contains(
				"samoyeds"
			) && !aunt.contains("samoyeds: 2") || (aunt.contains("pomeranians") && !aunt.contains("pomeranians: 3")) || (aunt.contains(
				"akitas"
			) && !aunt.contains("akitas: 0"))) || (aunt.contains("vizslas") && !aunt.contains("vizslas: 0")) || (aunt.contains(
				"goldfish"
			) && !aunt.contains("goldfish: 5")) || (aunt.contains("trees") && !aunt.contains("trees: 3")) || (aunt.contains(
				"cars"
			) && !aunt.contains("cars: 2")) || (aunt.contains("perfumes") && !aunt.contains("perfumes: 1"))
		) {
			auntIterator.remove()
		}


	}


	println(aunties)
	println(aunties.size)

// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   $aunties ")

} 		
 		
 		