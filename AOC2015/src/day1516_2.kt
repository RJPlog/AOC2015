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
		if ((aunt.contains("children") && !aunt.contains("children: 3")) || (aunt.contains(
				"samoyeds"
			) && !aunt.contains("samoyeds: 2") || (aunt.contains(
				"akitas"
			) && !aunt.contains("akitas: 0"))) || (aunt.contains("vizslas") && !aunt.contains("vizslas: 0")) || (aunt.contains(
				"cars"
			) && !aunt.contains("cars: 2")) || (aunt.contains("perfumes") && !aunt.contains("perfumes: 1")) || aunt.contains(
				"cats: 0"
			) || aunt.contains("cats: 1") || aunt.contains("cats: 2") || aunt.contains("cats: 3") || aunt.contains("cats: 4") || aunt.contains(
				"cats: 5"
			) || aunt.contains("cats: 6") || aunt.contains("cats: 7") || aunt.contains(
				"trees: 0"
			) || aunt.contains("trees: 1") || aunt.contains("trees: 2") || aunt.contains("pomeranians: 3") || aunt.contains(
				"pomeranians: 4"
			) || aunt.contains("pomeranians: 5") || aunt.contains("pomeranians: 6") || aunt.contains("pomeranians: 7") || aunt.contains(
				"pomeranians: 8"
			) || aunt.contains("pomeranians: 9")|| aunt.contains("goldfish: 8")|| aunt.contains("goldfish: 10")
		) {
			auntIterator.remove()
		}


	}


	println(aunties)
	println(aunties.size)

// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part2")
	print("   $aunties ")

} 		
 		
 		