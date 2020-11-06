// 09.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File

fun main(args: Array<String>) {

	var json: String  //hier steht dann der puzzle_input als String
	var objectstart: Int    // range which belongs to an "red"
	var objectend: Int      // range which belongs to an "red"
	var redposition: Int
	var i: Int
	var searchleft: Boolean
	var searchright: Boolean
	var bracketcount: Int = 0
	var deletered: Boolean

	json = File("day1512_puzzle_input.txt").readText()    //Einlesen des puzzle_inputs als String    

	while (json.contains("red")) {
	//for (j in 1..15) {  // hier stimmt einiges nicht beim abrechnen  --> Durchgang 14, right bracket vor red! 171 90 121
		println()
		println(json.length)

		redposition = json.indexOf("red", 0)
		objectstart = 0
		objectend = 0
		searchleft = true
		searchright = true
		deletered= false
		
// suche links von red ob [ oder { kommt
		i = redposition
		while (searchleft) {
			if (json[i].equals('[') && bracketcount == 0) {
				searchleft = false
				//searchright = false
				json = json.replaceRange(redposition, redposition + 3, "XXX")
			} else if (json[i].equals('{') && bracketcount == 0) {
				objectstart = i
				searchleft = false
				deletered = true
			} else if (json[i].equals(']') || json[i].equals('}')) {
				bracketcount = bracketcount + 1
			} else if (json[i].equals('[') || json[i].equals('{') && bracketcount > 0) {
				bracketcount = bracketcount - 1
			}
			i = i - 1
		}
// suche rechts von red ob ] oder } kommt
		i = redposition
		while (searchright) {
			if (json[i].equals(']') && bracketcount == 0) {
				searchright = false
			} else if (json[i].equals('}') && bracketcount == 0) {
				objectend = i
				searchright = false
			} else if (json[i].equals('[') || json[i].equals('{')) {
				bracketcount = bracketcount + 1
			} else if (json[i].equals(']') || json[i].equals('}') && bracketcount > 0) {
				bracketcount = bracketcount - 1
			}
			i = i + 1
		}

		println("Durchgang : red gefunden bei: $redposition")
		println("	Leftklammer gefunden bei $objectstart")
		println("	Rightklammer gefunden bei $objectend")
		println("	${json.length}")
		if (deletered) {
			json = json.removeRange(objectstart, objectend + 1)
			println("	${json.length}")
			deletered = false
		}

	}
println(json)

File("day1512_puzzle_input3.txt").writeText(json)
	// Ausgabe der Lösung für Part 2
	println()
	println("Solution for part2")
// print("   --> send this json into day1512_1.kt :-)")


}
