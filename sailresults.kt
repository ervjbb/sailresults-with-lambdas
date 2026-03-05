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
	var raceNmbr: Int
	var worstRace: Int

	results.resultRefinement { x: List<Int> ->
	for (i in 0..nmbrOfDiscards-1) {
		raceNmbr = 0
		worstRace = 0
		for (raceResult in x) {
			if (raceResult > discardedResults[i]) {
			    worstRace = raceNmbr
                            discardedResults[i] = raceResult
                            println("Finding new highestRaceScore: $raceResult")
		    }
		    raceNmbr++
		
	    	}
		totalResults[worstRace] = 0
	}
	sumOfAllRaces - discardedResults.sum()
	}
        println("Results with no discards: $sumOfAllRaces")
}


fun main() {
	val totalResults = mutableListOf(12,13,7,4,3,5,6,8,15,17,9)  // this is just to test the lambdas
	val nmbrOfDiscards = 2
	resultCalculation( totalResults, nmbrOfDiscards)
}





