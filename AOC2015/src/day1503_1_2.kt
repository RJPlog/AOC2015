// 02.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

val directions: String  //hier steht dann der puzzle_input als String
var counter: Int = 1
var x : Int = 1000
var y : Int = 1000 
val positions = mutableListOf(10001000)


	directions = File("day1503_puzzle_input.txt").readText() 	//Einlesen des puzzle_inputs als String
	
	//für jedes Element in String einen Floor hoch oder runter zählen
	for (i in directions.indices){
        if (directions[i].equals('^')) {
		y=y+1
			require(y > 0) { "y must be > 0" }
		} else if (directions[i].equals('v')) {
		y=y-1
			require(y > 0) { "y must be > 0" }
		} else if (directions[i].equals('>')) {
		x=x+1
			require(x > 0) { "x must be > 0" }
		}else if (directions[i].equals('<')) {
		x=x-1
			require(x > 0) { "x must be > 0" }
		}
	positions.add(y*10000+x)
	}
	
	positions.sort()

	for (i in positions.indices){
		if (i > 0) {
			if (positions[i-1] != positions[i]){
			counter = counter +1
			}
		}
	}

	// Ausgabe der Lösung für Part 1	
	println("Solution for part1")
	print("   So many houses are visited at least once by Santa: ")
	println(counter)
	
	////////////////////////////////////////////////777
	// Part 2
	///////////////////////////////////////////////////
	
	counter  = 1
    x  = 1000
    y  = 1000
	var xr: Int = 1000
	var yr: Int = 1000
    val positions2 = mutableListOf(10001000)


	//für jedes Element in String einen Floor hoch oder runter zählen
	for (i in directions.indices){
    if (i % 2 == 0) {
	    if (directions[i].equals('^')) {
		y=y+1
			require(y > 0) { "y must be > 0" }
		} else if (directions[i].equals('v')) {
		y=y-1
			require(y > 0) { "y must be > 0" }
		} else if (directions[i].equals('>')) {
		x=x+1
			require(x > 0) { "x must be > 0" }
		}else if (directions[i].equals('<')) {
		x=x-1
			require(x > 0) { "x must be > 0" }
		}
	positions2.add(y*10000+x)
	}
    if (i % 2 != 0) {
	    if (directions[i].equals('^')) {
		yr=yr+1
			require(yr > 0) { "y must be > 0" }
		} else if (directions[i].equals('v')) {
		yr=yr-1
			require(yr > 0) { "y must be > 0" }
		} else if (directions[i].equals('>')) {
		xr=xr+1
			require(xr > 0) { "x must be > 0" }
		}else if (directions[i].equals('<')) {
		xr=xr-1
			require(xr > 0) { "x must be > 0" }
		}
	positions2.add(yr*10000+xr)
	}
		}
	
	positions2.sort()

	for (i in positions2.indices){
		if (i > 0) {
			if (positions2[i-1] != positions2[i]){
			counter = counter +1
			}
		}
	}

	// Ausgabe der Lösung für Part 1	
	println("Solution for part2")
	print("   So many houses are visited at least once by Santa and his robot: ")
	println(counter)

}