class Results(val totalResult: List<Int>) {

fun resultRefinement ( resultPolish: (totalResult: List<Int>) -> Int ) {       // this is a lambda funtion
     val finalResult = resultPolish(totalResult)                               // it has no knowledge of discards!
     println("Final result: $finalResult")                                     
}
 
  }
 
fun resultCalculation(totalResults: MutableList<Int>, nmbrOfDiscards: Int = 0) {   // default nmbr of discards = 0
        val sumOfAllRaces = totalResults.sum()
	val results = Results(totalResults.sorted() )   // intitialize the class Results with a sorted list of race results

        println("List of race results unprocessed: $totalResults")
	println("Sum of all races: $sumOfAllRaces")
	println("Nmbr of race discards: $nmbrOfDiscards")
	println("Sorted list of race results: ${totalResults.sorted()}")
	

	results.resultRefinement { x: List<Int> ->
	  val lastIndex = x.count()-1
	  var sumOfDiscards = 0
	  for (i in 0..nmbrOfDiscards-1) {   // loop through the last race results in the sorted list, as many as race discards
            sumOfDiscards = sumOfDiscards + x[lastIndex - i]
	  }

	sumOfAllRaces - sumOfDiscards   // it needs to return an Int
	}
}


fun main() {
	val totalResults = mutableListOf(12,13,7,4,3,5,6,8,15,17,9)  // this is just to test the lambdas
	val nmbrOfDiscards = 3
	resultCalculation( totalResults, nmbrOfDiscards)
}




