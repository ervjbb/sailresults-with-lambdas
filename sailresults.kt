class Results(val racePlacements: List<Int>) {

fun scoreCalculation ( resultPolish: ( List<Int> ) -> Float ) {       // this function accepts a lambda function as the only parameter
     val finalResult = resultPolish(racePlacements)                   // it has no knowledge of discards nor scoring system
     println("Final result: ${"%.1f".format(finalResult)}") 

     // assume this function has all code to publish scores and to create the full regatta results
     // and that is the drive for using lambdas; to specialize the scores for different needs
     // and not having to update this function itself
     }
}
 
fun lowPointScoring(racePlacements: List<Int>, nmbrOfDiscards: Int = 0) {   // default nmbr of discards = 0
        println("lowPointScoring")
	
        val sumOfAllRaces = racePlacements.sum()
	val results = Results(racePlacements.sorted() )   // intitialize the class Results with a sorted list of race places

	results.scoreCalculation { x: List<Int> ->
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

    val results = Results(racePlacements.sorted()

	results.scoreCalculation { x: List<Int> ->              // start of the lambda function
	  val lastIndex = x.count()-1
	  var sumOfDiscards = 0f
      val tempList  = mutableListOf<Float>()                  // creating a temporarty list for the BonusPoints scoring
      var bonusPoint: Float = 0f
	  for (race in x ) {                                      // filling up the temporary list with correct bonus points
          	if ( race > 7 ) bonusPoint = race + 6f
		    else if ( race == 2) bonusPoint = 3f 
         	else if ( race == 3) bonusPoint = 5.7f 
            else if ( race == 4) bonusPoint = 8f 
            else if ( race == 5) bonusPoint = 10f 
            else if ( race == 6) bonusPoint = 11.7f
            else if ( race == 7) bonusPoint = 13f
		    tempList.add( bonusPoint )
	  }
      println("templist: $tempList")

	  for (i in 0..nmbrOfDiscards-1) {                     // loop through the last race results in the sorted list, as many as race discards
            sumOfDiscards = sumOfDiscards + tempList[lastIndex - i]
	  }
	  println("Sum: ${tempList.sum()}")
 	  tempList.sum() - sumOfDiscards
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
