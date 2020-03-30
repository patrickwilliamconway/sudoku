package example

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.math.sqrt

class Board(board: Seq[Seq[Int]]) {

  val boardDim = getBoard.size // this is not based zero
  val boardDimSqrt = sqrt(boardDim).toInt // this is not based zero
  val range = 0 until boardDim

  def getBoard: Seq[Seq[Int]] = board

  def getRow(rowNum: Int): Seq[Int] = {
    getBoard(rowNum)
  }

  def getCol(numCol: Int): Seq[Int] = {
    getBoard.map(row => row(numCol))
  }

  // returns Seq[Int] where the first number is the top left value of box, and last is bottom right
  def getBox(boxNum: Int): Seq[Int] = {
    val startX = (boxNum % boardDimSqrt) * boardDimSqrt
    val startY = (boxNum / boardDimSqrt) * boardDimSqrt
    val l: ListBuffer[Int] = ListBuffer()
    for(i <- 0 until boardDimSqrt) {
      for(j <- 0 until boardDimSqrt) {
        val x = startX + i
        val y = startY + j
        val v = getLocationValue(x, y)
        l.append(v)
      }
    }
    l.toSeq
  }

  def getLocationValue(x: Int, y: Int): Int = {
    getBoard(x)(y)
  }

  def getRowSetValues(rowNum: Int): Set[Int] = {
    getRow(rowNum).filter(_ != 0).toSet
  }

  def getColSetValues(colNum: Int): Set[Int] = {
    getCol(colNum).filter(_ != 0).toSet
  }

  def getBoxSetValues(boxNum: Int): Set[Int] = {
    getBox(boxNum).filter(_ != 0).toSet
  }

}