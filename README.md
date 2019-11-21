# teads-test

repo *https://github.com/adrien-guiot/teads-test*
there is no jar creation and I left a few CI files which would not go into a release
but they are part of that repo

written in scala 2.13.1 using sbt 1.13

> sbt test
>
>sbt run \<filename\> \<reserve\>
>e.g. sbt run resources/examples 100

the file is the list of buyer with the following format:

`name bid1 bid2 ...`

# Why and how

If at some point, there are two buyers with the same max bid
the one with the lowest amount of bids is selected as the winner
because... why not! and if some are still tied,
well the first one on the list got it!

Everything should be Immutable except the buyer in the auction object.
I had in mind to do a "simple" event oriented auction house hence why the `var`
but that would require me more than three hours

the parsing is very "naive" and can be broken in absolutely every way possible.


