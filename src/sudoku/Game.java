package sudoku;

import java.util.ArrayList;

public class Game {

	public Board board;

	public Game(Board board) {
		this.board = board;
	}

	public void propagate() {
		for (int i = 0; i < board.DIMENSION; i++) {
			rowProp(i);
			colProp(i);
		}
	}

	public void rowProp(int rowNum) {
		ArrayList<Integer> setVals = new ArrayList<Integer>();
		//find already set values
		for (int j = 0; j < board.tiles[rowNum].length; j++) {
			if (board.tiles[rowNum][j].possibleVals.size() == 1 && !setVals.contains(board.tiles[rowNum][j].possibleVals.get(0))) {
				setVals.add(board.tiles[rowNum][j].possibleVals.get(0));
			}
		}
		//remove them from possible values
		for (int j = 0; j < board.tiles[rowNum].length; j++) {
			if (board.tiles[rowNum][j].possibleVals.size() > 1) {
				board.mostConstrained.remove(board.tiles[rowNum][j]); //remove from heap
				board.tiles[rowNum][j].possibleVals.removeAll(setVals);
				if (board.tiles[rowNum][j].possibleVals.size() == 1) {
					board.tiles[rowNum][j].isSet = true;
				} else {
					board.mostConstrained.offer(board.tiles[rowNum][j]); //re add to heap so it repositions itself correctly
				}
			}
		}
	}
	
	public void colProp(int colNum) {
		ArrayList<Integer> setVals = new ArrayList<Integer>();
		//find already set values
		for (int j = 0; j < board.tiles[colNum].length; j++) {
			if (board.tiles[j][colNum].possibleVals.size() == 1 && !setVals.contains(board.tiles[j][colNum].possibleVals.get(0))) {
				setVals.add(board.tiles[j][colNum].possibleVals.get(0));
			}
		}
		//remove them from possible values
		for (int j = 0; j < board.tiles[colNum].length; j++) {
			if (board.tiles[j][colNum].possibleVals.size() > 1) {
				board.mostConstrained.remove(board.tiles[j][colNum]); //remove from heap
				board.tiles[j][colNum].possibleVals.removeAll(setVals);
				if (board.tiles[j][colNum].possibleVals.size() == 1) {
					board.tiles[j][colNum].isSet = true;
				} else {
					board.mostConstrained.offer(board.tiles[j][colNum]); //re add to heap so it repositions itself correctly
				}
			}
		}
	}

//	public void boxProp(int boxNum) {
//		for () {
//			
//		}
//	}


}
