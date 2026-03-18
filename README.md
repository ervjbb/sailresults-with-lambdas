An example on the use of lambda functions in Kotlin. 

The most commonly used way to score racing is to assign the same point as the placement in the race: the first boat gets the point 1, the second 2 and so forth.

But in Olympics sailing and other high level regattas it was for a long time a practice to prioritize really top level race placements more than placements further down the fleet. The first boat received the point 0, second 3, third 5.7, fourth 8, fifth 10, sixth 11.7, seventh 13 and all further down the fleet the race placement + 6.

This example of using Kotlin lambdas is just to show a practical example on how to add the use of a scoring system without having to change the basic regatta management function, if one would ever want to add the BonusPointScoring system again.
