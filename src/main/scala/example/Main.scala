package example

object Main extends App {
  val testBoard = Seq(
    Seq(5, 3, 0, 0, 7, 0, 0, 0, 0),
    Seq(6, 0, 0, 1, 9, 5, 0, 0, 0),
    Seq(0, 9, 8, 0, 0, 0, 0, 6, 0),
    Seq(8, 0, 0, 0, 6, 0, 0, 0, 3),
    Seq(4, 0, 0, 8, 0, 3, 0, 0, 1),
    Seq(7, 0, 0, 0, 2, 0, 0, 0, 6),
    Seq(0, 6, 0, 0, 0, 0, 2, 8, 0),
    Seq(0, 0, 0, 4, 1, 9, 0, 0, 5),
    Seq(0, 0, 0, 0, 8, 0, 0, 7, 9))
  val b = new Board(testBoard)

}
