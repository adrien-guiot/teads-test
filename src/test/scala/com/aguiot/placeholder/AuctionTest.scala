package com.aguiot.placeholder

import org.scalatest.FunSuite

class AuctionTest extends FunSuite {
  private val buyers1 = List(
    Buyer("A", List(110, 130)),
    Buyer("B", List()),
    Buyer("C", List(125)),
    Buyer("D", List(105, 115, 90)),
    Buyer("E", List(132, 135, 140))
  )

  private val auction1 = new Auction(100, buyers1)

  test("Auction.findWinningBuyer") {
    assert(auction1.findWinningBuyer === Some(buyers1(4)))
  }

  test("Auction.findWinningPrice") {
    assert(auction1.findWinningPrice(buyers1(4)) === 130)
  }

  test("Auction.solve") {
    assert(auction1.solve === ("E", 130))
  }

  private val buyers2 = List(
    Buyer("E", List(140)),
    Buyer("F", List(150, 142, 132)),
    Buyer("G", List(150, 142)),
    Buyer("H", List(150, 141, 118, 120)),
    Buyer("I", List(135, 140))
  )

  private val auction2 = new Auction(100, buyers2)

  test("Auction.findWinningBuyer with same price") {
    assert(auction2.findWinningBuyer === Some(buyers2(2)))
  }

  test("Auction.findWinningPrice with same price") {
    assert(auction2.findWinningPrice(buyers2(2)) === 150)
  }

  test("Auction.solve with same price") {
    assert(auction2.solve === ("G", 150))
  }
}
