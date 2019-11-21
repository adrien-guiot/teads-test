package com.aguiot.placeholder

class Auction(val reserve: Int, var buyers: List[Buyer]) {
  def solve: (String, Int) = {
    findWinningBuyer match {
      case Some(winner) => (winner.name, findWinningPrice(winner))
      case None => ("no bidding above reserve", 0)
    }
  }

  def findWinningBuyer: Option[Buyer] = {
    val buyersBid = buyers.map(buyer => buyer.bids.maxOption match {
      case Some(maxBid) => (buyer, maxBid)
      case None => (buyer, 0)
    })
    val highestBid = buyersBid.reduceLeft((b1, b2) => {
      if (b1._2 > b2._2)
        b1
      else if (b1._2 < b2._2)
        b2
      else if (b1._1.bids.size < b2._1.bids.size) //if there are two buyer with the same max bid, the one with the fewest bid wins, because why not
        b1
      else
        b2
    })
    if (highestBid._2 >= reserve)
      Some(highestBid._1)
    else
      None
  }

  def findWinningPrice(winner: Buyer): Int = {
    val winningPrice = buyers.filter(_.bids.nonEmpty).filter(_ != winner).map(_.bids.max).max
    if (winningPrice >= reserve)
      winningPrice
    else
      reserve
  }
}