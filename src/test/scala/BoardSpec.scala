package example

import org.scalatest._

class BoardSpec extends FlatSpec {

  "getRow" must "return the correct row" in new TestScope {
    val rowNum = 0
    assert(testBoard.getRow(rowNum) == testBoard.getBoard(rowNum))
  }

  "getCol" must "return the correct column" in new TestScope {
    val colNum = 0
    assert(testBoard.getCol(colNum) == Seq(5,6,0,8,4,7,0,0,0))
  }

  "getBox" must "return the correct values for a box" in new TestScope {
    assert(testBoard.getBox(0) == Seq(5,3,0,6,0,0,0,9,8))
    assert(testBoard.getBox(1) == Seq(8,0,0,4,0,0,7,0,0)) // 3
    assert(testBoard.getBox(2) == Seq(0,6,0,0,0,0,0,0,0)) // 4
    assert(testBoard.getBox(3) == Seq(0,7,0,1,9,5,0,0,0)) // 1
    assert(testBoard.getBox(4) == Seq(0,6,0,8,0,3,0,2,0))
    assert(testBoard.getBox(5) == Seq(0,0,0,4,1,9,0,8,0)) // 7
    assert(testBoard.getBox(6) == Seq(0,0,0,0,0,0,0,6,0)) // 2
    assert(testBoard.getBox(7) == Seq(0,0,3,0,0,1,0,0,6)) // 5
    assert(testBoard.getBox(8) == Seq(2,8,0,0,0,5,0,7,9))
  }

  "getRowSetValues" must "return the right values" in new TestScope {
    assert(testBoard.getRowSetValues(0) == testBoard.getBoard(0).filter(_ != 0))
  }

  "getColSetValues" must "return the right values" in new TestScope {
    assert(testBoard.getColSetValues(0) == Seq(5,6,0,8,4,7,0,0,0).filter(_ != 0))
  }

  "getBoxSetValues" must "return the right values" in new TestScope {
    assert(testBoard.getBoxSetValues(0) == Seq(5,3,0,6,0,0,0,9,8).filter(_ != 0))
    assert(testBoard.getBoxSetValues(1) == Seq(8,0,0,4,0,0,7,0,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(2) == Seq(0,6,0,0,0,0,0,0,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(3) == Seq(0,7,0,1,9,5,0,0,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(4) == Seq(0,6,0,8,0,3,0,2,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(5) == Seq(0,0,0,4,1,9,0,8,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(6) == Seq(0,0,0,0,0,0,0,6,0).filter(_ != 0))
    assert(testBoard.getBoxSetValues(7) == Seq(0,0,3,0,0,1,0,0,6).filter(_ != 0))
    assert(testBoard.getBoxSetValues(8) == Seq(2,8,0,0,0,5,0,7,9).filter(_ != 0))
  }

}

class TestScope {

  val testValues: Seq[Seq[Int]] =
    Seq(
      Seq(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Seq(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Seq(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Seq(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Seq(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Seq(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Seq(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Seq(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Seq(0, 0, 0, 0, 8, 0, 0, 7, 9))

  val testBoard = new Board(testValues)
}
