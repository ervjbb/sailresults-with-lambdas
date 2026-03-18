class Results(val racePlacements: List<Int>) {

fun scoreCalculation ( resultPolish: ( List<Int> ) -> Float ) {       // this is a lambda funtion
     val finalResult = resultPolish(racePlacements)             // it has no knowledge of discards nor scoring system
     println("Final result: ${"%.1f".float(finalResult)}")      // put out rounded value to one decimal

     // assume this function has all code to publish scores and to create the full regatta results
     // and that is the drive for using lambdas; to specialize the scores for different needs
     // and not having to update this function itself
}
 
  }
 
fun lowPointScoring(racePlacements: List<Int>, nmbrOfDiscards: Int = 0) {   // default nmbr of discards = 0
    println("lowPointScoring")
	
    val sumOfAllRaces = racePlacements.sum()
	val results = Results(racePlacements.sorted() )   // intitialize the class Results with a sorted list of race places

	results.scoreCalculation { x: List<Int> ->        // this is the body of the lambda function, it is provided as trailing lambda
	  val lastIndex = x.count()-1
	  var sumOfDiscards = 0f
	  for (i in 0..nmbrOfDiscards-1) {   // loop through the last race results in the sorted list, as many as race discards
            sumOfDiscards = sumOfDiscards + x[lastIndex - i]
	  }
	sumOfAllRaces - sumOfDiscards
	} 
}

fun bonusPointScoring(racePlacements: List<Int>, nmbrOfDiscards: Int = 0) {
	println("bonusPointScoring")

    val results = Results(racePlacements.sorted() )
	var sum = 0f

	results.scoreCalculation { x: List<Int> ->
          for (item in x) {
		  when (item) {                           // transform race placement to a bonus point
			  1 -> sum = sum+0
			  2 -> sum = sum+3
			  3 -> sum = sum+5.7f
			  4 -> sum = sum+8
			  5 -> sum = sum+10
			  6 -> sum = sum+11.7f
			  7 -> sum = sum+13
		      else -> sum = sum+item+6
		  }
	  }

	  println("Sum: $sum")
      val lastIndex = x.count()-1
	  var sumOfDiscards = 0f
	  for (i in 0..nmbrOfDiscards-1) {   // loop through the last race results in the sorted list, as many as race discards
          	if ( x[lastIndex - i] > 7 ) sumOfDiscards = sumOfDiscards + x[lastIndex - i] + 6
		    else if ( x[lastIndex - i] == 2) sumOfDiscards = sumOfDiscards + 3 
         	else if ( x[lastIndex - i] == 3) sumOfDiscards = sumOfDiscards + 5.7f
            else if ( x[lastIndex - i] == 4) sumOfDiscards = sumOfDiscards + 8 
            else if ( x[lastIndex - i] == 5) sumOfDiscards = sumOfDiscards + 10 
            else if ( x[lastIndex - i] == 6) sumOfDiscards = sumOfDiscards + 11.7f
            else if ( x[lastIndex - i] == 7) sumOfDiscards = sumOfDiscards + 13
	}
	sum - sumOfDiscards
	} 
}

fun main() {
	val racePlacements = listOf(12,13,7,4,3,5,6,8,15,17,9)  // this is just to test the lambdas
	val nmbrOfDiscards = 2

	println("List of race results unprocessed: $racePlacements")
	println("Sum of all races: ${racePlacements.sum()}")
	println("Nmbr of race discards: $nmbrOfDiscards")
	println("Sorted list of race results: ${racePlacements.sorted()}")
	
	lowPointScoring( racePlacements, nmbrOfDiscards )

	bonusPointScoring( racePlacements, nmbrOfDiscards )
}
