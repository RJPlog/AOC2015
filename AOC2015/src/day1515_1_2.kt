// 12.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {


	val ingredients = mutableMapOf<String, Int>()
	var scorecapacity: Int
	var scoredurability: Int
	var scoreflavor: Int
	var scoretexture: Int
	var scorecalorie: Int
	var score: Int
	var scoremax: Int = 0
	var scoremax_500: Int = 0
	// erzeuge aus dem Input eine Map mit Verbindungsdaten
	File("day1515_puzzle_input.txt").forEachLine {
		val ingredient = it.split(" ")
		ingredients.put(ingredient[0] + ingredient[1], ingredient[2].dropLast(1).toInt())
		ingredients.put(ingredient[0] + ingredient[3], ingredient[4].dropLast(1).toInt())
		ingredients.put(ingredient[0] + ingredient[5], ingredient[6].dropLast(1).toInt())
		ingredients.put(ingredient[0] + ingredient[7], ingredient[8].dropLast(1).toInt())
		ingredients.put(ingredient[0] + ingredient[9], ingredient[10].toInt())
	}
	println(ingredients)

	// erzeuge über 8 Schleifen alle Variationen
	val spices =
		arrayListOf("Sugar:", "Sprinkles:", "Candy:", "Chocolate:")
	val attributes =
		arrayListOf("capacity", "durability", "flavor", "texture", "calories")
	for (i1 in 0..100) {
		for (i2 in 0..100) {
			for (i3 in 0..100) {
				for (i4 in 0..100) {
					if (i1 + i2 + i3 + i4 == 100) {

						scorecapacity =
							ingredients.getValue(spices[0] + attributes[0]) * i1 + ingredients.getValue(spices[1] + attributes[0]) * i2 + ingredients.getValue(
								spices[2] + attributes[0]
							) * i3 + ingredients.getValue(spices[3] + attributes[0]) * i4
						scoredurability =
							ingredients.getValue(spices[0] + attributes[1]) * i1 + ingredients.getValue(spices[1] + attributes[1]) * i2 + ingredients.getValue(
								spices[2] + attributes[1]
							) * i3 + ingredients.getValue(spices[3] + attributes[1]) * i4
						scoreflavor =
							ingredients.getValue(spices[0] + attributes[2]) * i1 + ingredients.getValue(spices[1] + attributes[2]) * i2 + ingredients.getValue(
								spices[2] + attributes[2]
							) * i3 + ingredients.getValue(spices[3] + attributes[2]) * i4
						scoretexture =
							ingredients.getValue(spices[0] + attributes[3]) * i1 + ingredients.getValue(spices[1] + attributes[3]) * i2 + ingredients.getValue(
								spices[2] + attributes[3]
							) * i3 + ingredients.getValue(spices[3] + attributes[3]) * i4
						scorecalorie =
							ingredients.getValue(spices[0] + attributes[4]) * i1 + ingredients.getValue(spices[1] + attributes[4]) * i2 + ingredients.getValue(
								spices[2] + attributes[4]
							) * i3 + ingredients.getValue(spices[3] + attributes[4]) * i4

						score =
							maxOf(scorecapacity, 0) * maxOf(scoredurability, 0) * maxOf(scoreflavor, 0) * maxOf(
								scoretexture,
								0
							)

						if (score > scoremax) {
							scoremax = score
						}
						if (scorecalorie == 500 && score > scoremax_500) {
							scoremax_500 = score
						}
					}
				}
			}
		}
	}

// Ausgabe der Lösung für Part 1
	println()
	println("Solution for part1")
	print("   The highest scoring is $scoremax  ")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	print("   The highest scoring @500 cal is $scoremax_500  ")
	println()
}