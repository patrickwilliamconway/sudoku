package sudoku;

public class Driver {

	public static void main (String[] args) {
		int initial[][] = 
			{{5,3,0,  0,7,0,  0,0,0},
			{6,0,0,  1,9,5,  0,0,0},
			{0,9,8,  0,0,0,  0,6,0},

			{8,0,0,  0,6,0,  0,0,3},
			{4,0,0,  8,0,3,  0,0,1},
			{7,0,0,  0,2,0,  0,0,6},

			{0,6,0,  0,0,0,  2,8,0},
			{0,0,0,  4,1,9,  0,0,5},
			{0,0,0,  0,8,0,  0,7,9}};
		
		Game g = new Game(new Board(initial, initial.length));
		g.board.printBoard();
		g.board.printHeap();
		
		g.propagate();
		
		System.out.println("\n\n");
		
		g.board.printBoard();

	}

}