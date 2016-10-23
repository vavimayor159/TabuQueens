package com.ivgarcia.nqueens

/**
  * Created by ivan on 18/10/16.
  */
class BoardSpec extends UnitSpec{
  "A Board" should "change values of the queens on swith" in {
    val board = new Board(Array(1,2,3))
    val oFirst = board.posQ(0)
    val oSecond = board.posQ(1)
    board.switch(0, 1)
    assert(board.posQ(0) === oSecond)
    assert(board.posQ(1) === oFirst)
  }

  it should "be simmetric on switch" in {
    val board = new Board(Array(1,2,3))
    val original = board.posQ(1)
    board.switch(1, 1)
    assert(board.posQ(0) === original)
  }
}
