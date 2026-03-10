class Results(val totalResult: List<Int>) {

fun resultRefinement (
	withDiscardedRaces: (totalResult: List<Int>) -> Int    // this is a lambda function!
) {
	val resultAfterDiscardedRaces = withDiscardedRaces(totalResult)
        println("Final result after discards: $resultAfterDiscardedRaces")
  }
}

fun resultCalculation(totalResults: MutableList<Int>, nmbrOfDiscards: Int = 1) {
    val sumOfAllRaces = totalResults.sum()
	val sortedRaceResults = totalResults.sorted()
	println("Sorted list of race results: $sortedRaceResults")
	val results = Results(sortedRaceResults)   // intitialize the class Results
    println("List of sail results before discards: $totalResults")
	println("Sum of all races: $sumOfAllRaces")


	results.resultRefinement { x: List<Int> ->
	  val lastIndex = x.count()-1
	  var sumOfDiscards = 0
	  for (i in 0..nmbrOfDiscards-1) {      // loop through the last race results in the sorted list
            sumOfDiscards = sumOfDiscards + x[lastIndex - i]
	  }

	sumOfAllRaces - sumOfDiscards
	}
}


fun main() {
	val totalResults = mutableListOf(12,13,7,4,3,5,6,8,15,17,9)  // this is just to test the lambdas
	val nmbrOfDiscards = 2
	resultCalculation( totalResults, nmbrOfDiscards)
}






