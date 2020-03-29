name := "sudoku"

version := "0.1"

scalaVersion := "2.13.1"

// http://www.scalatest.org/user_guide/using_scalatest_with_sbt
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.1"
libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.1.1" % "test"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
