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

		//		0 -> 1,1
		//		1 -> 1,4
		//		2 -> 1,7
		//		3 -> 4,1
		//		4 -> 4,4
		//		5 -> 4,7
		//		6 -> 7,1
		//		7 -> 7,4
		//		8 -> 7,7



//		Board b = new Board(initial, initial.length);
//		b.printBoard();
//		b.printHeap();
//		System.out.println(b.mostConstrained.size());
		
		Game g = new Game(new Board(initial, initial.length));
		g.board.printBoard();
		g.board.printHeap();
		
		g.propagate();
		
		System.out.println();
		
//		int i = 0;
//		while (g.board.mostConstrained.size() > 0) {
//			System.out.println(i + ": " + g.board.mostConstrained.poll());
//			i++;
//		}
		
//		System.out.println(g.board.mostConstrained.comparator());
		
		g.board.printBoard();
//		g.board.printHeap();
//		System.out.println(g.board.mostConstrained.peek());
	}

}