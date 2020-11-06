// 01.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-
//  -  

import java.io.File

fun main(args: Array<String>) {
	val delimiter = "x"
	var w: Int
	var l: Int
	var h: Int
	var wrapping_paper = 0
	var ribbon = 0

	//https://kotlinlang.org/docs/tutorials/kotlin-for-py/file-io.html
	File("day1502_puzzle_input.txt").forEachLine {
		//	println(it)
		// zerlegen in drei Werte für l, w, h
		val size = it.split(delimiter)
		w = size[0].toInt()
		l = size[1].toInt()
		h = size[2].toInt()
		//	println(size)
		// berechnen des Papiers 2*(l*w + w*h + h*l)
		wrapping_paper = wrapping_paper + 2 * (l * w + w * h + h * l)
		ribbon = ribbon + w * l * h
		// suchen der zwei kleinsten, summiere alles auf
		wrapping_paper = wrapping_paper + w * l * h / maxOf(h, w, l)
		ribbon = ribbon + 2 * (h + w + l) - 2 * maxOf(h, w, l)
		//	println(wrapping_paper)

	}

	// Ausgabe der Lösung für Part 1
	println("Solution for part1")
	print("   The Elves need in total of wrapping paper: ")
	println(wrapping_paper)

	// Ausgabe der Lösung für Part 2
	println("Solution for part2")
	print("   The Elves need in total of rippon: ")
	println(ribbon)


}
