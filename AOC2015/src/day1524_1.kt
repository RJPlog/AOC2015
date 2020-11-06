// 17.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {
	val weights = arrayListOf<String>()
	var sum_weights: Int = 0  // 1524 --> each Package has to have a weight of 508 (60/20 for example)
	var weight_box1: Int = 0
	var weight_product: Long = 1
	var weight_product_min: Long = 585021330491 //9900000000
	var weight_box2: Int = 0
	var weight_box3: Int = 0
	var number_box1: Int = 0
	var number_box2: Int = 0
	var number_box3: Int = 0
	var i0min:Int = 0
		var i1min:Int = 0
		var i2min:Int = 0
		var i3min:Int = 0
		var i4min:Int = 0
	var i5min: Int = 0
	var i: Int = 1

	File("day1524_puzzle_input.txt").forEachLine {
		weights.add(it)
		sum_weights = sum_weights + it.toInt()
	}
	println(" Die Summe der Pakete ist $sum_weights")

	for (i0 in 0..27) {
		for (i1 in 0..27) {
			for (i2 in 0..27) {
				for (i3 in 0..27) {
					for (i4 in 0..27) {
						for (i5 in 0..27) {
							if (i0 != i1 && i2 != i0 && i2 != i1 && i3 != i0 && i3 != i1 && i3 != i2 && i4 != i0 && i4 != i1 && i4 != i2 && i4 != i3 && i5 != i0 && i5 != i1 && i5 != i2 && i5 != i3 && i5 != i4) {
								weight_box1 =
									weights[i0].toInt() + weights[i1].toInt() + weights[i2].toInt() + weights[i3].toInt() + weights[i4].toInt()+ weights[i5].toInt()
								weight_product =
									weights[i0].toLong() * weights[i1].toLong() * weights[i2].toLong() * weights[i3].toLong() * weights[i4].toLong()* weights[i5].toLong()
								if (weight_box1 == sum_weights / 3) {
									println(" Ieration $i: Box1: $weight_box1, prod: $weight_product, items: ${weights[i0]}, ${weights[i1]}, ${weights[i2]}, ${weights[i3]}, ${weights[i4]}, ${weights[i5]}")
									if (weight_product < weight_product_min) {
										weight_product_min = weight_product
										 i0min = weights[i0].toInt()
										 i1min = weights[i1].toInt()
										 i2min = weights[i2].toInt()
										 i3min = weights[i3].toInt()
										 i4min = weights[i4].toInt()
										i5min = weights[i5].toInt()
									}
								}

								i = i + 1
								weight_box1 = 0
								weight_product = 1
								number_box1 = 0
							}
						}
					}
				}
			}
		}
	}
// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   Min Product: $weight_product_min @ $i0min, $i1min, $i2min, $i3min, $i4min, $i5min ")
}
