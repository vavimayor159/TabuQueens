package com.ivgarcia.nqueens

import java.lang.Math.abs
import scala.collection.immutable.ListMap
import scala.collection.mutable
import scala.collection.mutable.Map

/**
  * Created by ivan on 16/10/16.
  * Board class who represents a board of chess for the problem of the N-Queens
  */
class Board(board: Array[Int]) {

  /** Array representing the positions of the queen's in the board s */
  def bd: Array[Int] = {
    board.foreach({ x =>
      if (x < 0 || x >= board.length) {
        throw new IllegalArgumentException
      }
    })
    board
  }

  /** Length of the board for the queen's */
  def length = board.length

  /** Method for switch the position between two queens
    *
    * @param i : Index of the first queen
    * @param j : Index of the second queen */
  def switch(i: Int, j: Int) {
    val tmp = bd(i)
    bd(i) = bd(j)
    bd(j) = tmp
  }

  /** Method for find position fo the queen in the board
    *
    * @param queen : Index of the queen
    * @return Int: Position of the queen in the board */
  def posQ(queen: Int): Int = {
    if (queen < 0 || queen > bd.length - 1) return -1
    bd(queen)
  }

  /** Get the collision of the current state of the boar
    *
    * @return Int: Number of collisions */
  // TODO: We are getting only the collisions of the left not the right collisions

  def collisions(): Int = {
    // For doing easy we begging to try with the brutal force method
    var collisions = 0
    var revision = List.range(0, bd.length)
    // For every queen search for every position if we have a collision
    bd.indices foreach { queen =>
      val current = this.posQ(queen)
      revision.foreach { i =>
        if (i != current) {
          val dis = abs(i - current)
          if (this.posQ(queen + dis) == i) collisions += 1
          else if(this.posQ(queen - dis) == i) collisions += 1
            // For the right positions
          // else if(this.posQ(queen - dis) == i) collisions += 1
          // else if(this.posQ(queen - dis) == i) collisions += 1
        }
      }
      revision = revision.tail
    }

    collisions
  }

  /** Get the five better switch moves of board
 *
    * @return Map: map with the five better moves */
  def fiveBetterMoves(): ListMap[(Int, Int), Int] = {
    // First we need to made all the moves and evaluate his value per move
    var revision = List.range(0, bd.length)
    val allMoves = mutable.Map[(Int, Int), Int]()
    bd.indices foreach{ i =>
      revision foreach { j =>
        if(i != j){
          val tmp = this.clone()
          tmp.switch(i, j)
          val toAdd = (i -> j) -> tmp.collisions()
          allMoves += toAdd
        }
      }
      revision = revision.tail
    }
    ListMap(allMoves.toSeq.sortBy(_._2):_*)
  }


  /** Method for cloning a board
    *
    * @return Board: A new board with the same values of the actual board */
  override def clone(): Board = {
    new Board(bd.clone())
  }


  /** Method for print a board
    *
    * @return String: string with the board formatted like a real board */
  override def toString: String = {
    var res = "  "
    bd.indices foreach { i => res += (i + " ") }
    res += "\n"

    for (i <- bd.indices by 1) {
      res += i
      for (j <- bd.indices by 1) {
        res += " " + (if (bd(i) == j) "Q" else "") + " "
      }
      res += "\n"
    }

    res
  }
}
