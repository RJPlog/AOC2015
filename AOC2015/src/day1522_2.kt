// 2020100 restart of day 22

// read the spec more carefully, effects are working on each turn. both, boss and player !!!

// modify, spell can start in the same turn the spell ends

import java.io.File

fun main(args: Array<String>) {	
	// Idee: Pro Spielzug wird ein String angelegt, mit den relevanten Werten. Alle möglcihen Kombinationen werden in einer Liste abgelegt.
	// Die Liste wird im nächsten Spielzug um weitere Sprüche ergänzt und berechnet.
	
//***************************************************************************************
// declaration of variables
//	var element_number: Int   // Bestimme wieviele Spielüge in der initialen Liste sind			
	var turn: Int       // Spielzug Nummer
	var spells: String  // Reihenfolge Sprüche
	var c_sh: Int   // Counter Shield
	var c_po: Int   // Counter Poison
	var c_re: Int // Counter Recharge
	var hit_ply: Int    // Hitpoints Player
	var armor_ply: Int  // Armor Player
	var mana_ply: Int   // Mana Player available
	var mana_spt: Int   // Mana Player spent
	var hit_boss: Int   // Hitpoints Boss
	var dam_boss: Int   // Damage Boss
	var game_end: Boolean // True if game has found a winner
	
	var mana_spent_min: Int = 10000 //
	
//***************************************************************************************	
	val winlist = mutableListOf<String>("0=0=0=10000")
// 0 turn/ 1 spells/ / mana left/ mana spent	
	val gamelist = mutableListOf<String>("0==0=0=0=50=0=500=0=58=9")  // original werte
//	var gamelist = mutableListOf<String>("0==0=0=0=10=0=250=0=13=8")  // test werte #1
//	var gamelist = mutableListOf<String>("0==0=0=0=10=0=250=0=14=8")  // test werte #2	
// 0 turn/1 spells/2 count schield/ 3 count poison /4  count recharge / 5 P hitpoints / 6 P armor / 7 P mana / 8 P mana spent / 9 B hitpoints / 10 B damage
//***************************************************************************************


//***************************************************************************************
// führe mehrere Spielzüge durch	
for (j in 1..20) { // Schleife für Spielzüge 1 bis x

	var	element_number = gamelist.size
	
	println("************************************")
	println("*  Starte Schleife Spielzüge       *")
	println("************************************")	
	println()
	println("Spielzug $j Anzahl / Elemente $element_number ")
	println()

//***************************************************************************************	
// führe für jeden Initalspielzug alle möglichen Aktionen durch	
	for (i in 0..element_number-1){
		val elements = gamelist[i].split("=")	
	
//***************************************************************************************
// Play Magic Missile
		game_end = false
		turn = elements[0].toInt() + 1
		spells= elements[1]+"M"
		c_sh = elements[2].toInt()
		c_po = elements[3].toInt()
		c_re = elements[4].toInt()
		hit_ply = elements[5].toInt()
		
		mana_ply= elements[7].toInt()
		mana_spt= elements[8].toInt()
		hit_boss= elements[9].toInt()
		dam_boss = elements[10].toInt()
// Players Turn
		hit_ply = hit_ply -1
		if (hit_ply == 0) {game_end = true}
		mana_ply = mana_ply - 53
		if ( mana_ply <0) {game_end = true}
        mana_spt = mana_spt + 53
		hit_boss = hit_boss-4
		if (c_sh > 0) {
			c_sh = c_sh-1	
		} 
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}
							
// Boss Turn
		if (c_sh > 0) {
			armor_ply = 7
			c_sh = c_sh-1	
		} else {armor_ply = 0}
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}
				
		if (hit_boss <= 0  && !game_end){
			winlist.add(turn.toString()+"="+spells+"="+mana_ply+"="+mana_spt)
			game_end = true
			mana_spent_min = minOf(mana_spent_min, mana_spt)
		}
		
		hit_ply = hit_ply-maxOf(dam_boss-armor_ply,1)
		if (hit_ply <= 0){
			game_end = true
		}		
	    if (!game_end && (mana_spt < mana_spent_min)) {
			gamelist.add( turn.toString()+"="+spells+"="+c_sh+"="+c_po+"="+c_re+"="+hit_ply+"="+armor_ply+"="+mana_ply+"="+mana_spt+"="+hit_boss+"="+dam_boss)
		}
// End Magic Missile
//****************************************************************************************			
						
//****************************************************************************************
// Play Drain
		game_end = false
		turn = elements[0].toInt() + 1
		spells= elements[1]+"D"
		c_sh = elements[2].toInt()
		c_po = elements[3].toInt()
		c_re = elements[4].toInt()
		hit_ply = elements[5].toInt()
		
		mana_ply= elements[7].toInt()
		mana_spt= elements[8].toInt()
		hit_boss= elements[9].toInt()
		dam_boss = elements[10].toInt()
// Players Turn
		hit_ply = hit_ply -1
		if (hit_ply == 0) {game_end = true}
		mana_ply = mana_ply - 73
 		if ( mana_ply <0) {game_end = true}
		mana_spt = mana_spt + 73
		hit_ply = hit_ply +2
		hit_boss = hit_boss-2
		if (c_sh > 0) {
			c_sh = c_sh-1	
		} 
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}	
// Boss Turn
		if (c_sh > 0) {
			armor_ply = 7
			c_sh = c_sh-1	
		} else {armor_ply = 0}
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}
				
		if (hit_boss <= 0 && !game_end){
			winlist.add(turn.toString()+"="+spells+"="+mana_ply+"="+mana_spt)
			game_end = true
			mana_spent_min = minOf(mana_spent_min, mana_spt)
				}
		
		hit_ply = hit_ply-maxOf(dam_boss-armor_ply,1)
		if (hit_ply <= 0){
			game_end = true
		}		
	    if (!game_end && (mana_spt < mana_spent_min)) {
			gamelist.add( turn.toString()+"="+spells+"="+c_sh+"="+c_po+"="+c_re+"="+hit_ply+"="+armor_ply+"="+mana_ply+"="+mana_spt+"="+hit_boss+"="+dam_boss)
		}
// End Drain
//****************************************************************************************	

//****************************************************************************************
// Play Shield
		if (elements[2].toInt() < 2) {
			game_end = false
			turn = elements[0].toInt() + 1
			spells= elements[1]+"S"
			
			c_po = elements[3].toInt()
			c_re = elements[4].toInt()
			hit_ply = elements[5].toInt()
	
			mana_ply= elements[7].toInt()
			mana_spt= elements[8].toInt()
			hit_boss= elements[9].toInt()
			dam_boss = elements[10].toInt()
	// Players Turn
			hit_ply = hit_ply -1
			if (hit_ply == 0) {game_end = true}
			mana_ply = mana_ply - 113
			if ( mana_ply <0) {game_end = true}
			mana_spt = mana_spt + 113
	        c_sh = 6
			if (c_po > 0) {
				hit_boss = hit_boss-3
				c_po = c_po-1	
			}
			if (c_re > 0) {
				mana_ply = mana_ply+101
				c_re = c_re-1
			}		
	// Boss Turn
			if (c_sh > 0) {
				armor_ply = 7
				c_sh = c_sh-1	
			} else {armor_ply = 0}
			if (c_po > 0) {
				hit_boss = hit_boss-3
				c_po = c_po-1	
			}
			if (c_re > 0) {
				mana_ply = mana_ply+101
				c_re = c_re-1
			}
					
			if (hit_boss <= 0 && !game_end){
				winlist.add(turn.toString()+"="+spells+"="+mana_ply+"="+mana_spt)
				game_end = true
				mana_spent_min = minOf(mana_spent_min, mana_spt)
				}
			
			hit_ply = hit_ply-maxOf(dam_boss-armor_ply,1)
			if (hit_ply <= 0){
				game_end = true
			}		
		    if (!game_end && (mana_spt < mana_spent_min)) {
				gamelist.add( turn.toString()+"="+spells+"="+c_sh+"="+c_po+"="+c_re+"="+hit_ply+"="+armor_ply+"="+mana_ply+"="+mana_spt+"="+hit_boss+"="+dam_boss)
			}
		}
// End Shield
//****************************************************************************************
		
//****************************************************************************************
// Play Poison
		if (elements[3].toInt() < 2) {
			game_end = false
			turn = elements[0].toInt() + 1
			spells= elements[1]+"P"
			c_sh = elements[2].toInt()
			c_po = elements[3].toInt()
			c_re = elements[4].toInt()
			hit_ply = elements[5].toInt()
	
			mana_ply= elements[7].toInt()
			mana_spt= elements[8].toInt()
			hit_boss= elements[9].toInt()
			dam_boss = elements[10].toInt()
	// Players Turn
		hit_ply = hit_ply -1
		if (hit_ply == 0) {game_end = true}
		mana_ply = mana_ply - 173
        if ( mana_ply <0) {game_end = true}
		mana_spt = mana_spt + 173
	    // poison müsste hier noch wirken wenn bei zählerstand 1 reingegangen wurde!!!, geleiches gilt für Recharge?
			if (c_po == 1) {
				hit_boss = hit_boss-3	
			}
							c_po = 6
		if (c_sh > 0) {
			c_sh = c_sh-1	
		} 
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}			
	// Boss Turn
			if (c_sh > 0) {
				armor_ply = 7
				c_sh = c_sh-1	
			} else {armor_ply = 0}
			if (c_po > 0) {
				hit_boss = hit_boss-3
				c_po = c_po-1	
			}
			if (c_re > 0) {
				mana_ply = mana_ply+101
				c_re = c_re-1
			}
					
			if (hit_boss <= 0 && !game_end){
				winlist.add(turn.toString()+"="+spells+"="+mana_ply+"="+mana_spt)
				game_end = true
				mana_spent_min = minOf(mana_spent_min, mana_spt)
				}
			
			hit_ply = hit_ply-maxOf(dam_boss-armor_ply,1)
			if (hit_ply <= 0){
				game_end = true
			}		
		    if (!game_end && (mana_spt < mana_spent_min)) {
				gamelist.add( turn.toString()+"="+spells+"="+c_sh+"="+c_po+"="+c_re+"="+hit_ply+"="+armor_ply+"="+mana_ply+"="+mana_spt+"="+hit_boss+"="+dam_boss)
			}
		}
// End Poison
//****************************************************************************************	

//****************************************************************************************
// Play Recharge
		if (elements[4].toInt() < 2) {
		game_end = false
		turn = elements[0].toInt() + 1
		spells= elements[1]+"R"
		c_sh = elements[2].toInt()
		c_po = elements[3].toInt()
		c_re = elements[4].toInt()
		hit_ply = elements[5].toInt()

		mana_ply= elements[7].toInt()
		mana_spt= elements[8].toInt()
		hit_boss= elements[9].toInt()
		dam_boss = elements[10].toInt()
// Players Turn
		hit_ply = hit_ply -1
		if (hit_ply == 0) {game_end = true}
		mana_ply = mana_ply - 229
		if ( mana_ply <0) {game_end = true}
		mana_spt = mana_spt + 229
		if (c_re == 1) {
			mana_ply = mana_ply+101
		}
					c_re = 5
		if (c_sh > 0) {
			c_sh = c_sh-1	
		} 
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}		
// Boss Turn
		if (c_sh > 0) {
			armor_ply = 7
			c_sh = c_sh-1	
		} else {armor_ply = 0}
		if (c_po > 0) {
			hit_boss = hit_boss-3
			c_po = c_po-1	
		}
		if (c_re > 0) {
			mana_ply = mana_ply+101
			c_re = c_re-1
		}
				
		if (hit_boss <= 0 && !game_end){
			winlist.add(turn.toString()+"="+spells+"="+mana_ply+"="+mana_spt)
			mana_spent_min = minOf(mana_spent_min, mana_spt)
			game_end = true
		}
		
		hit_ply = hit_ply-maxOf(dam_boss-armor_ply,1)
		if (hit_ply <= 0){
			game_end = true
		}		
	    if (!game_end && (mana_spt < mana_spent_min)) {
			gamelist.add( turn.toString()+"="+spells+"="+c_sh+"="+c_po+"="+c_re+"="+hit_ply+"="+armor_ply+"="+mana_ply+"="+mana_spt+"="+hit_boss+"="+dam_boss)
				}
		}
// End Recharge
//****************************************************************************************
					
			
	} // Ende Schleife für Erweiterung eines jeden Initialzustands auf mögliche Aktionen

//***************************************************************************************	
// bereinige Liste mit Spielzügen um vorherige Spielzüge		
	for (k in 0..element_number-1){
		gamelist.removeAt(0)
	} // Ende Schleife für Bereinigung der Liste um vorherige Spielzüge
		
} // Ende Schleife für Spielzüge	
		
//***************************************************************************************	
// Ausgabe der Lösung für Part 2
	println("************************************")
	println("*  Ausgabe Ergebnis                *")
	println("************************************")
/*	println()
	println("Ausgabe der aktuellen Spielzüge")
	gamelist.forEach{		
	println(it)
	}
	
	println() */
	
	println("Ausgabe der aktuellen Winliste / Part 2")	
	winlist.forEach{		
	println(it)
	} 
	println()
	println("Der minimale Manaeinsatz ist $mana_spent_min")
	
//***************************************************************************************		
	
	
} // fun main(args: Array<String>)