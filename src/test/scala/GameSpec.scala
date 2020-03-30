package example

import org.scalatest._

class GameSpec extends FlatSpec {

  "rowProp" must "propagate correctly" in new TestScope {
    game.rowProp(testBoard, 0)
    game.constraints
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
  val game = new Game()
}