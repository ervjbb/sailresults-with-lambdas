class Results(val totalResult: List<Int>) {

fun resultRefinement (
	withDiscardedRaces: (totalResult: List<Int>) -> Int
) {
	val resultAfterDiscardedRaces = withDiscardedRaces(totalResult)
        println("Final result after discards: $resultAfterDiscardedRaces")
  }
}

fun main() {
	var highestRaceScoreSoFar = 0
	val res = listOf(12,13,7,4,3,5,6,8,15,17,9)
	val results = Results(res)
	val resultsWithNoDiscards = res.sum()
	results.resultRefinement { x: List<Int> ->
		for (racePlacement in x) {
			if (racePlacement > highestRaceScoreSoFar) {
                            highestRaceScoreSoFar = racePlacement
                            println("Finding new highestRaceScore: $highestRaceScoreSoFar")
		    }
		}
		res.sum() - highestRaceScoreSoFar
		}
        println("Results with no discards: $resultsWithNoDiscards")
}




