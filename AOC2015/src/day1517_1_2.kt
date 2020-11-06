// 13.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   


import java.io.File

fun main(args: Array<String>) {
	var sum: Int = 0
	var sum_boxes: Int = 0
	val sum_boxes_min: Int = 4
	var sum_boxes_count: Int = 0
	var volume: Int = 0

	val boxes = arrayListOf<Int>()

	File("day1517_puzzle_input.txt").forEachLine {
		boxes.add(it.toInt())
	}

	println(boxes)

	for (j in 0..1048575) {
		var box: String
		box = Integer.toBinaryString(j)
		box = box.padStart(20, '0')
		for (k in 0..19) {
			if (box[k].equals('1')) {
				volume = volume + boxes[k]
				sum_boxes = sum_boxes + 1
			}
		}
		if (volume == 150) {

			sum = sum + 1
			if (sum_boxes == 4) {
				sum_boxes_count = sum_boxes_count + 1
				println("$box $volume $sum_boxes")
			}
		}
		volume = 0

		sum_boxes = 0
	}

	// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	println("   There are $sum different combinations")

	// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	println("   There are $sum_boxes_count different combinations with only $sum_boxes_min")

}