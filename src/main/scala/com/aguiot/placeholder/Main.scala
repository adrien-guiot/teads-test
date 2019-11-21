package com.aguiot.placeholder

import scala.io.Source

object Main extends App {

  if (args.length == 0) {
    println("dude, i need at least one parameter")
  }

  def createAuction(filename: String, reserve: Int) = {
    val buyers = for (line <- Source.fromFile(filename).getLines) yield {
      val lineSplit = line.split(" ").toList
      Buyer(lineSplit(0), lineSplit.drop(1).map(_.toInt))
    }

    new Auction(reserve, buyers.toList)
  }

  print(createAuction(args(0), args(1).toInt).solve)
}
