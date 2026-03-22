
This is a rather practical example on how to add the use of a sail racing scoring system without having to change the basic regatta management function. They key to this is the use of lambda funtions in Kotlin.

The commonly used way to score sailracing is to assign the same point as the placement in the race: the first boat gets the point 1, the second 2 and so forth. The boat with lowest sum of points wins. Often there is an allowance to discard the highest point in the regatta, and sometimes two or more discards are allowed.

But in Olympics and other high level regattas it was for a long time a practice to prioritize top level race placements more. The first boat received the point 0, second 3, third 5.7, fourth 8, fifth 10, sixth 11.7, seventh 13 and all further down the fleet the race placement + 6. It was often called HighPoint or BonusPoint scoring system. The result was given as a one decimal number.
