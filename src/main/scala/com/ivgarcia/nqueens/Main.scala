package com.ivgarcia.nqueens



/**
  * Created by ivan on 16/10/16.
  */
object Main {
  def main(args: Array[String]) {

    val board = new Board(Array(3,4,2,5,6,0,1))
    val tmp = board.clone()
    tmp.switch(0, 4)
    println(board)
    println(tmp)
    //val queensTabu = new QueensTabuSearch(board, 3)
    //queensTabu.resolve()
  }
}
