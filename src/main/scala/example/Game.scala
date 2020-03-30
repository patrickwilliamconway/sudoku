package example

class Game {

  val constraints: Map[(Int, Int), Set[Int]] = Map()

  def solve(b: Board): Board = {

  }

  def rowProp(b: Board, rowNum: Int) = {
    val setVals = b.getRowSetValues(rowNum)
    val possible = (1 to b.boardDim).toSet
    for(i <- b.range) {
      val location = (rowNum, i)
      constraints updated (location, possible -- setVals)
    }
  }

  def colProp(b: Board, colNum: Int) = {
    val setVals = b.getColSetValues(colNum)
    val possible = (1 to b.boardDim).toSet
    for(i <- b.range) {
      val location = (i, colNum)
      constraints updated (location, possible -- setVals)
    }
  }

  def boxProp(b: Board, boxNum: Int)  = {
    val setVals = b.getBoxSetValues(boxNum)
    val possible = (1 to b.boardDim).toSet
    val startX = (boxNum % b.boardDimSqrt) * b.boardDimSqrt
    val startY = (boxNum / b.boardDimSqrt) * b.boardDimSqrt
    for(i <- 0 until b.boardDimSqrt) {
      for(j <- 0 until b.boardDimSqrt) {
        val location = (startX + i, startY + j)
        constraints updated (location, possible -- setVals)
      }
    }
  }

  def constraintSatisfaction(b: Board): Board = {
    for(i <- b.range) {
      rowProp(b, i)
      colProp(b, i)
      boxProp(b, i)
    }
  }

}
