// 17.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  - 

import java.io.File

fun main(args: Array<String>) {
	var i: Int = 1
	var j: Int = 1
	var row: Int = 3010
	var column: Int = 3019
	var code: Long = 20151125

	var operations: Int = 0

	println("Enter Two number")
//	var (a, b) = readLine()!!.split(' ') // !! this operator use for NPE(NullPointerException).

	//println("Max number is : ${maxOf(a.toInt(), b.toInt())}")

	//row = a.toInt()

	//column = b.toInt()

	while (j <= row-2) {
		operations = operations + j
		println("iteration $j : $operations")
		j = j + 1
	}
	
	while (i <= column-1) {
		operations = operations + i
		println("iteration $i : $operations")
		i = i + 1
	}

	operations = operations + column*row
	
	for (k in 2.. operations){
		code = (code * 252533).rem(33554393)
	}

	println(" after operations: $operations the key is: $code")

}
 