package example

import org.scalatest._
import org.scalatest.matchers.must.Matchers

class BoardSpec extends FlatSpec {

  "getRow" must "return the correct row" in new TestScope {
    val rowNum = 0
    assert(testBoard.getRow(rowNum) == testBoard.getBoard(rowNum))
  }

  "getCol" must "return the correct column" in new TestScope {
    val colNum = 0
    assert(testBoard.getCol(colNum) == Seq(5,6,0,8,4,7,0,0,0))
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
