package com.ivgarcia.nqueens

/**
  * Created by ivan on 16/10/16.
  */

class QueensTabuSearch(board:Board, tabuLenght: Int){

  def bd = board
  def tl = tabuLenght

  /** Function who resolve the problem of the queen's table
    * in the object */
  def resolve(): Unit = {
    val moves = bd.fiveBetterMoves()
    for ((k, v) <- moves) printf("x: %s, y: %s, value: %s\n", k._1, k._2, v)
  }
}
