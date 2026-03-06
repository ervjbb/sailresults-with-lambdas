class Results(val totalResult: List<Int>) {

fun resultRefinement (
	withDiscardedRaces: (totalResult: List<Int>) -> Int    // this is a lambda function!
) {
	val resultAfterDiscardedRaces = withDiscardedRaces(totalResult)
        println("Final result after discards: $resultAfterDiscardedRaces")
  }
}

fun resultCalculation(totalResults: MutableList<Int>, nmbrOfDiscards: Int) {
        var discardedResults = arrayOf(0,0,0) // max 3 discards supported
        val sumOfAllRaces = totalResults.sum()
	val results = Results(totalResults)   // intitialize the class Results
        println("Total race results before discards: $totalResults")
	println("Sum of all races: $sumOfAllRaces")

	var raceNmbr: Int
	var worstRace: Int

	results.resultRefinement { x: List<Int> ->
	for (i in 0..nmbrOfDiscards-1) {      // loop through all race results for each discard
		raceNmbr = 0
		worstRace = 0
		for (raceResult in x) {
			if (raceResult > discardedResults[i]) {
			    worstRace = raceNmbr
                            discardedResults[i] = raceResult
		    }
		    raceNmbr++	
	    	}
		println("Found one discard, race number: $worstRace")
		totalResults[worstRace] = 0  // set the race result to 0 so it does not confuse next search for highest result
	}
	sumOfAllRaces - discardedResults.sum()
	}
        println("Results with no discards: $sumOfAllRaces")
	println("Results list after removing discarded races: $totalResults")
}


fun main() {
	val totalResults = mutableListOf(12,13,7,4,3,5,6,8,15,17,9)  // this is just to test the lambdas
	val nmbrOfDiscards = 2
	resultCalculation( totalResults, nmbrOfDiscards)
}






