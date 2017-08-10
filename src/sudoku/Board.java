package sudoku;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Board {
	
	public Tile[][] tiles;
	public PriorityQueue<Tile> mostConstrained;
	
	public static final int BLANK_SPACE = 0;
	public final int DIMENSION;
	
	public Board(int[][] board, int dimension) {
		this.DIMENSION = dimension;
		this.tiles = new Tile[dimension][dimension];
		this.mostConstrained = new PriorityQueue<Tile>(new TileComparator());
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == BLANK_SPACE) {
					Tile tile = new Tile(dimension);
					this.tiles[i][j] = tile;
					this.mostConstrained.offer(tile);
				} else {
					this.tiles[i][j] = new Tile();
					this.tiles[i][j].possibleVals.add(board[i][j]);
					this.tiles[i][j].isSet = true;
				}
			}
		}
	}
	
	public Board(Board board) {
		this.DIMENSION = board.DIMENSION;
		this.tiles = new Tile[DIMENSION][DIMENSION];
		for (int i = 0; i < board.tiles.length; i++) {
			for (int j = 0; j < board.tiles[i].length; j++) {
				this.tiles[i][j] = board.tiles[i][j];
			}
		}
	}
	
	public void printBoard() {
		for (Tile[] i : tiles) {
			for (Tile j : i) {
				System.out.print(j + "   ");
			}
			System.out.println();
		}
	}
	
	public void printHeap() {
		System.out.println(this.mostConstrained);
	}

}
