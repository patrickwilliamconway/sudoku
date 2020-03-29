package example

class Board(board: Seq[Seq[Int]]) {

  def getRow(rowNum: Int): Seq[Int] = {
    board(rowNum)
  }

  def getCol(numCol: Int): Seq[Int] = {
    board.map(row => row(numCol))
  }

  def getBoard = board
}