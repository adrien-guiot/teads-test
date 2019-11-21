package com.aguiot.placeholder

import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Main.createAuction with default example") {
    val auction = Main.createAuction("src/test/resources/example", 100)

    assert(auction.reserve === 100)
    assert(auction.buyers.size === 5)
  }

  test("complete run with same maxBid") {
    assert(Main.createAuction("src/test/resources/samePrice", 100).solve === ("G", 150))
  }

}
