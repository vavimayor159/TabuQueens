package com.ivgarcia.nqueens

/**
  * Created by ivan on 22/10/16.
  * Tabu Array Data Structure
  */
class TabuArray(length: Int) {

  def tabu = Array.fill[Int](length, length) {
    0
  }

  /** Get tabu value of a move
    * @param x: First position of the move
    * @param y: Second position of the move */
  def getValue(x: Int, y: Int): Int = (x, y) match {
    case (a, b) if x < y => tabu(a)(b)
    case (a, b) if x > y => tabu(b)(a)
  }

  /** Set tabu value of a move
    * @param x: First position of the move
    * @param y: Second position of the move
    * @param value: Tabu value for setting */
  // TODO: We can get a better approach
  def setValue(x: Int, y: Int, value: Int): Unit = (x, y) match {
    case (a, b) if x < y => tabu(a)(b) = value
    case (a, b) if x > y => tabu(b)(a) = value
  }
}
