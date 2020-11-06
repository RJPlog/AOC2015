// 03.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-
//  -  

import java.io.File

fun main(args: Array<String>) {

var nice: Int = 0
var vocal_count: Int
var double_count: Int	
	
//https://kotlinlang.org/docs/tutorials/kotlin-for-py/file-io.html
File("day1505_puzzle_input.txt").forEachLine{
	// prüfe ob String ein verbotenes Muster enthält: ab, cd, pq, or xy
	if(!it.contains("ab") && !it.contains("cd") && !it.contains("pq") && !it.contains("xy")) {

		// prüfe ob String drei Vokale und einen doppelbuchstaben enthält
			vocal_count = 0
		    double_count = 0
			for (i in it.indices){
			// prüfung auf drei Vokale
			if (it[i].equals('a') || it[i].equals('e') || it[i].equals('i') || it[i].equals('o') || it[i].equals('u')){
				vocal_count = vocal_count + 1
			}
			// prüfung auf doppelbuchstaben
			if (i > 0) {
				if (it[i-1].equals(it[i])){
					double_count = double_count +1
				}
			}
		}
		if (vocal_count > 2 && double_count > 0) {
			nice = nice + 1
		}
	}
}
	
				
	// Ausgabe der Lösung für Part 1
	println("Solution for part1")
	print("   There are nice strings: ")
	println(nice)

	/////////////////////////////////////////////////////////
	//  part 2
	/////////////////////////////////////////////////////////

var nice2: Int = 0
var vocal_count2: Int
var double_count2: Int
var ithelp: String
var ithelp2: String
var ithelp3: String

		
File("day1505_puzzle_input.txt").forEachLine{
		// prüfe ob String drei Vokale und einen doppelbuchstaben enthält
			vocal_count2 = 0
		    double_count2 = 0  // here in part two used to detect xyx
			for (i in it.indices){
			// prüfung auf drei Vokale
			if (i > 0 && i < it.length-2) {
				ithelp = it.drop(i+1)
				ithelp2 = it.dropLast(it.length-(1+i))	
				ithelp3 = ithelp2.drop(i-1) 
				if (ithelp.contains(ithelp3)){  // warum schlägt das hier nicht zu?
				vocal_count2 = vocal_count2 +1
				}
			}
			// prüfung auf doppelbuchstaben
			if (i > 1) {
				if (it[i-2].equals(it[i]) && !it[i-2].equals(it[i-1])){
					double_count2 = double_count2 +1
				}
			}
		}
		if (vocal_count2 > 0 && double_count2 > 0) {
			nice2 = nice2 + 1
		}
	}

	
	
	// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	print("   There are nice strings: ")
	println(nice2)

	
}
