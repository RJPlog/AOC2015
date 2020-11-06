// 7.10.2020 new start for part 2
//
// 14.03.2020 starting to learn Kotlin with how to read files
// Leasons Learned:
//	-	
//  -   



import java.io.File

fun main(args: Array<String>) {
	
//***************************************************************************************
// declaration of variables
	var recon_ongoing: Boolean = true
	var double_con: Boolean
	var j:Int = 1


//****************************************************************************	
//*     Einlesen Puzzledaten
//****************************************************************************	
	val replacements = mutableListOf<String>()
	val molecules = mutableListOf<String>()

	var stop: Boolean = false

	// put all the replacements in a map, separate then the last string.
	File("day1519_puzzle_input.txt").forEachLine {
		if (!stop) {
			if (!it.equals("")) {
				replacements.add(it)
			} else if (it.equals("")) {
				stop = true
			}
		} else if (stop) {
			molecules.add("HSiRnCaFYCaCaCaCaFArCaPBCaCaCaCa")
			
			// check out my excelfile, I started to put the input into portions, from start to the next "Ar", calculated the minimum value and than replaced the result
		}
	}


//****************************************************************************	
//*     Einlesen Puzzledaten Ende
//****************************************************************************

	
	
//****************************************************************************	
// Schleife f�r R�ckw�rtsrekunstrion starten
//****************************************************************************	

for (j in 1..32) { // Schleife f�r Spielz�ge 1 bis x
//	while(recon_ongoing) {
	println("****** R�ckkonstruktion Schritt # $j  ")
	println()
				
	var	element_number = molecules.size
	
//****************************************************************************	
// Ermittle f�r jedes Molek�hl in diesem Schritt die m�glichen Vorg�nger
//**************************************************************************** 	
	for (i in 0..element_number-1){	
			

		replacements.forEach { //f�r jede Zeile in den Rezepten
			var startindex = 0
			var substring = it.split(" => ")
			while (molecules[i].drop(startindex).contains(substring[1])) {      // solange substring value in puzzle enthalten ist, ersetze und generiere neues Molek�hl
				startindex = molecules[i].indexOf(substring[1], startindex)
				val molecule = molecules[i].replaceRange(startindex, substring[1].length + startindex, substring[0])

				// M�glichkeiten f�r weitere Reduktionen? -> doppeltpr�fung gleich hier.
				double_con = false
/*				for(mn in 0 .. molecules.size - 1) {
				if (molecule.equals(molecules[mn])){
				double_con = true	
				}	} */
				if(!double_con){molecules.add(molecule)}

				//if(!molecules.contains(molecule)){molecules.add(molecule)} alternative to above, seems to be slower
				
				// abbruchbedingung setzen
				if (molecule.equals("e")) {recon_ongoing = false}
				
				// hochsetzen Startindex
				startindex = startindex + 1
				}
			}
		
		} //Ende Ermittlung der m�glichen Vorg�nger

//****************************************************************************	
// Bereinige Liste um Ausgangsmodule
//****************************************************************************	
	for (k in 0..element_number-1){
		molecules.removeAt(0)
	} // Ende Schleife bereinige Liste um Ausgangsmodule
		
//	println(" Anzahl an Ausgansmolek�hlen ${molecules.size}")


	
//****************************************************************************	
// Bereinige Liste um Doppelnennungen
//****************************************************************************

		val list_help = molecules.distinct()
        molecules.clear()
		list_help.forEach {
			molecules.add(it)
		}
  
//	println(" Anzahl ohne Doppelnennungen ${molecules.size}")
	println(molecules)
		println()
			
//****************************************************************************	
// Bereinige Liste um Doppelnennungen
//****************************************************************************		
//	j= j+1
} // Ende Schleife f�r R�ckw�rtsvorg�nge
	

	
	// Ausgabe der L�sung f�r Part 2
	println()
	println("Solution for part2")
	print(" It takes  ${j-1} steps to make the medicine")
}
