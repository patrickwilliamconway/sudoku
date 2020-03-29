this will be the readme for this project

Goal: 
1) write a sudoku solver in scala to handle standard 3x3 game
2) solve an nxn game
3) solve multi-dimensional nxn game
4) that utilizes parallelism
5) add ability to push computation to spark

https://curiosity.com/topics/a-finnish-mathematician-claimed-that-this-is-the-most-difficult-sudoku-puzzle-in-the-world-curiosity/

input will be a sudoku board that is just a two dimensional array (could I eventually extend this to do thee dimensional sudoku? Maybe n-dimensional sudoku?)

I will use constraint satisfaction searching to solve. Each spot on the board is constained by values established in the existing rows, columns, and boxes.

Each spot will maintain set of potential values

Propegation will eliminate possible values for rows, cols, and boxes




