// 07.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	first experience with maps, list's and exeptions
//  -   

import java.io.File

fun main(args: Array<String>) {

	val wires = arrayListOf<String>()
	val wire_map = mutableMapOf<String, Int>()
	wire_map.put("1", 1)

	File("day1507_puzzle_input_2.txt").forEachLine {
		wires.add(it)
	}

	var z: Int = 0
	while (wires.size > 0 && z < 1000) {
		val iterator = wires.iterator()

		while (iterator.hasNext()) {
			val it = iterator.next()
			val instruction = it.split(" ")
			//check if wire already mapped and mapping is a number
			if (instruction[1].equals("->") && !(instruction[0].toIntOrNull() == null)) {
				print(instruction[2])
				print("  ")
				println(instruction[0].toInt())
				wire_map.put(instruction[2], instruction[0].toInt())
				iterator.remove()
			}
			if (instruction[1].equals("->") && instruction[0].toIntOrNull() == null) {
				var new_instruction: String = ""
				var key_present: Boolean = true
				try {
					new_instruction =
						wire_map.getValue(instruction[0]).toString() + " " + instruction[1] + " " + instruction[2]
				} catch (e: NoSuchElementException) {
					key_present = false
				}
				if (key_present) {
					iterator.remove()
					//			wires.add(new_instruction)
					wire_map.put(instruction[2], wire_map.getValue(instruction[0]))
					print(wire_map.getValue(instruction[0]))
					print("  -> ")
					println(instruction[2])
				}
			}
			// deal with NOT
			if (instruction[0].equals("NOT")) {
				var new_instruction: String = ""
				var key_present: Boolean = true
				try {
					new_instruction =
						"NOT " + wire_map.getValue(instruction[1]).toString() + " -> " + instruction[3]
				} catch (e: NoSuchElementException) {
					key_present = false
				}
//				println(new_instruction)  // ok, funkioniert
				if (key_present) {

					iterator.remove()
					wire_map.put(instruction[3], 65535 - wire_map.getValue(instruction[1]))
				}
			}
			// deal with OR
			if (instruction[1].equals("OR")) {
				var key_one: Int = 0
				var key_two: Int = 0
				var key_present1: Boolean = true
				var key_present2: Boolean = true
				try {
					key_one = wire_map.getValue(instruction[0])
				} catch (e: NoSuchElementException) {
					key_present1 = false
				}
				try {
					key_two = wire_map.getValue(instruction[2])
				} catch (e: NoSuchElementException) {
					key_present2 = false
				}
				if (key_present1 && key_present2) {
					iterator.remove()
					wire_map.put(instruction[4], (key_one or key_two))
				}
			}
			// deal with AND
			if (instruction[1].equals("AND")) {
				var key_one: Int = 0
				var key_two: Int = 0
				var key_present1: Boolean = true
				var key_present2: Boolean = true
				try {
					key_one = wire_map.getValue(instruction[0])
				} catch (e: NoSuchElementException) {
					key_present1 = false
				}
				try {
					key_two = wire_map.getValue(instruction[2])
				} catch (e: NoSuchElementException) {
					key_present2 = false
				}
				if (key_present1 && key_present2) {
					iterator.remove()
					wire_map.put(instruction[4], (key_one and key_two))
				}
			}
			// deal with Lshift
			if (instruction[1].equals("LSHIFT")) {
				var key_one: Int = 0
				var digits: Int
				var key_present: Boolean = true
				try {
					key_one = wire_map.getValue(instruction[0])
				} catch (e: NoSuchElementException) {
					key_present = false
				}
				digits = instruction[2].toInt()
				if (key_present) {
					iterator.remove()
					wire_map.put(instruction[4], (key_one shl digits))
				}
			}
			// deal with Rshift
			if (instruction[1].equals("RSHIFT")) {
				var key_one: Int = 0
				var digits: Int
				var key_present: Boolean = true
				try {
					key_one = wire_map.getValue(instruction[0])
				} catch (e: NoSuchElementException) {
					key_present = false
				}
				digits = instruction[2].toInt()
				if (key_present) {
					iterator.remove()
					wire_map.put(instruction[4], (key_one shr digits))
				}
			}
		}

		z = z + 1
	}

	// Ausgabe der Lösung für Part 1	
	println("Solution for part1")
	print("   Wire 'a' is connected to:  ")
	println(wire_map.getValue("a"))   // exeption_handling missing!
	println()
	println(wires)
	println(wire_map)
	println(z)

}