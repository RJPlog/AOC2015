// 03.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun main(args: Array<String>) {

var input2: String		
var input = "abcdef609043"
var md5 = input.md5()
var md5_short: String
var count: Int = 0	

println("testvector #1")
print(input)
println("   computed md5 value is $md5")
println()

input = "pqrstuv1048970"
md5 = input.md5()
println("testvector #2")
print(input)
println("   computed md5 value is $md5")
println()

////////////////////////////////////////
// part 2
////////////////////////////////////////
		
input = "ckczppom"

do {
	input2 = input + count.toString()
	count = count.toInt() + 1	
	md5 = input2.md5()	
	md5_short = md5.substring(0,5)
} while (!md5_short.equals("00000"))
	
println("Solution for part1")
print(input2)
println("   computed md5 value is $md5")
	
////////////////////////////////////////
// part 2
////////////////////////////////////////

println()
count = 0

	do {
	input2 = input + count.toString()
	count = count.toInt() + 1	
	md5 = input2.md5()	
	md5_short = md5.substring(0,6)
} while (!md5_short.equals("000000"))
	
println("Solution for part2")
print(input2)
println("   computed md5 value is $md5")	
}