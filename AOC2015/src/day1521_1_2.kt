import java.io.File

fun main(args: Array<String>) {
	var win: Boolean
	var hitpoints_rjplog: Int = 100
	var damage_rjplog: Int // to be evaluated
	var armor_rjplog: Int //to be evaluated
	var hitpoints_boss: Int = 108
	var damage_boss: Int = 8
	var armor_boss: Int = 2
	var cost: Int
	var costmin: Int = 356
	var costmax: Int = 0

	val weapons: Array<IntArray> =
		arrayOf(intArrayOf(8, 4), intArrayOf(10, 5), intArrayOf(25, 6), intArrayOf(40, 7), intArrayOf(74, 8))
	val armor: Array<IntArray> =
		arrayOf(
			intArrayOf(0, 0),
			intArrayOf(13, 1),
			intArrayOf(31, 2),
			intArrayOf(53, 3),
			intArrayOf(75, 4),
			intArrayOf(102, 5)
		)

	val rings: Array<IntArray> =
		arrayOf(
			intArrayOf(0, 0),
			intArrayOf(25, 1),
			intArrayOf(50, 2),
			intArrayOf(100, 3),
			intArrayOf(20, 1),
			intArrayOf(40, 2),
			intArrayOf(80, 3)
		)

	//wähle damage and armor, calculate cost
	for (i1 in 0..4) {  // 0..4
		for (i2 in 0..5) { //0..5
			for (i3 in 0..6) { //0..6
				for (i4 in 0..6) { //0..6
					if (i4 == 0 || i4 != i3) {
						if (i4 < 4) {
							if (i3 < 4) {
								damage_rjplog = weapons[i1][1] + rings[i3][1] + rings[i4][1]
								armor_rjplog = armor[i2][1]
							} else {
								damage_rjplog = weapons[i1][1] + rings[i4][1]
								armor_rjplog = armor[i2][1] + rings[i3][1]
							}
						} else {
							if (i3 < 4) {
								damage_rjplog = weapons[i1][1] + rings[i3][1]
								armor_rjplog = armor[i2][1] + rings[i4][1]
							} else {
								damage_rjplog = weapons[i1][1]
								armor_rjplog = armor[i2][1] + rings[i3][1] + rings[i4][1]

							}
						}
						cost = weapons[i1][0] + armor[i2][0] + rings[i3][0] + rings[i4][0]
						//println("$i1 $i2 $i3 $i4: damage: $damage_rjplog, armor: $armor_rjplog, cost: $cost")
						win = fight(
							hitpoints_rjplog,
							damage_rjplog,
							armor_rjplog,
							hitpoints_boss,
							damage_boss,
							armor_boss
						)
						if (win) {
							//println("  Won a fight with Damage: $damage_rjplog, Armor: $armor_rjplog at cost: $cost")
							if (costmin > cost) {
								costmin = cost
								println("$i1 $i2 $i3 $i4: won with damage: $damage_rjplog, armor: $armor_rjplog, cost: $cost")
							}
						} else if (!win) {
							//println("  Lost a fight with Damage : $damage_rjplog, Armor: $armor_rjplog at cost: $cost")
							if (costmax < cost) {
								costmax = cost
								println("$i1 $i2 $i3 $i4: lost with damage: $damage_rjplog, armor: $armor_rjplog, cost: $cost")
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
	println("   You have won with $costmin")

// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
	println("   You have lost with $costmax")
}



