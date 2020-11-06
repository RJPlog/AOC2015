fun fight(
	hitpoints_rjplog: Int,
	damage_rjplog: Int,
	armor_rjplog: Int,
	hitpoints_boss: Int,
	damage_boss: Int,
	armor_boss: Int
): Boolean {
	var win: Boolean = false
	var beginner: String = "rjplog"
	var hitpoints_boss_int = hitpoints_boss
	var hitpoints_rjplog_int = hitpoints_rjplog
	while (hitpoints_rjplog_int != 0 && hitpoints_boss_int != 0) {
		if (beginner.equals("rjplog")) {
		hitpoints_boss_int = maxOf(hitpoints_boss_int - maxOf((damage_rjplog-armor_boss),1),0)
				beginner = "boss"
//	println("The Boss hitpoints goes down to $hitpoints_boss_int")
			} else if (beginner.equals("boss")) {
		hitpoints_rjplog_int = maxOf(hitpoints_rjplog_int - maxOf((damage_boss-armor_rjplog),1),0)
				beginner = "rjplog"
//		println("RJPlogs hitpoints goes down to $hitpoints_rjplog_int")
		}
	//println("Your hitpoints are $hitpoints_rjplog_int, the hitpoints of boss are $hitpoints_boss_int")
		}

	if (hitpoints_rjplog_int == 0) {
		win = false
	} else if (hitpoints_boss_int == 0) {
		win = true
	}
	return win
}