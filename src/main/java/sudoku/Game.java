package sudoku;

import java.util.ArrayList;

public class Game {

	public Board board;
	public ArrayList<Location> boxLocations;

	public Game(Board board) {
		this.board = board;
	}

	public void propagate() {
		for (int i = 0; i < board.DIMENSION; i++) {
			rowProp(i);
			colProp(i);
			boxProp(i);
		}
	}

	public void rowProp(int rowNum) {
		ArrayList<Integer> setVals = new ArrayList<Integer>();
		//find already set values
		for (int j = 0; j < board.tiles[rowNum].length; j++) {
			Tile currentTile = board.tiles[rowNum][j];
			if (currentTile.possibleVals.size() == 1 && !setVals.contains(currentTile.possibleVals.get(0))) {
				setVals.add(currentTile.possibleVals.get(0));
			}
		}
		//remove them from possible values
		for (int j = 0; j < board.tiles[rowNum].length; j++) {
			Tile currentTile = board.tiles[rowNum][j];
			if (currentTile.possibleVals.size() > 1) {
				board.mostConstrained.remove(currentTile); //remove from heap
				currentTile.possibleVals.removeAll(setVals);
				if (currentTile.possibleVals.size() == 1) {
					currentTile.isSet = true;
				} else {
					board.mostConstrained.offer(currentTile); //re add to heap so it repositions itself correctly
				}
			}
		}
	}

	public void colProp(int colNum) {
		ArrayList<Integer> setVals = new ArrayList<Integer>();
		//find already set values
		for (int j = 0; j < board.tiles[colNum].length; j++) {
			Tile currentTile = board.tiles[j][colNum];
			if (currentTile.possibleVals.size() == 1 && !setVals.contains(currentTile.possibleVals.get(0))) {
				setVals.add(currentTile.possibleVals.get(0));
			}
		}
		//remove them from possible values
		for (int j = 0; j < board.tiles[colNum].length; j++) {
			Tile currentTile = board.tiles[j][colNum];
			if (currentTile.possibleVals.size() > 1) {
				board.mostConstrained.remove(currentTile); //remove from heap
				currentTile.possibleVals.removeAll(setVals);
				if (currentTile.possibleVals.size() == 1) {
					currentTile.isSet = true;
				} else {
					board.mostConstrained.offer(currentTile); //re add to heap so it repositions itself correctly
				}
			}
		}
	}

	public void boxProp(int boxNum) {
		int startingX = (boxNum % board.SQRTDIMENSION) * board.SQRTDIMENSION;
		int startingY = (boxNum / board.SQRTDIMENSION) * board.SQRTDIMENSION;
		
		ArrayList<Integer> setVals = new ArrayList<Integer>();
		for (int i = startingX; i < startingX + board.SQRTDIMENSION; i++) {
			for (int j = startingY; j < startingY + board.SQRTDIMENSION; j++) {
				Tile currentTile = board.tiles[i][j];
				if (currentTile.possibleVals.size() == 1 && !setVals.contains(currentTile.possibleVals.get(0))) {
					setVals.add(currentTile.possibleVals.get(0));
				}
			}
		}
		//remove set values
		for (int i = startingX; i < startingX + board.SQRTDIMENSION; i++) {
			for (int j = startingY; j < startingY + board.SQRTDIMENSION; j++) {
				Tile currentTile = board.tiles[i][j];
				if (currentTile.possibleVals.size() > 1) {
					board.mostConstrained.remove(currentTile); //remove from heap
					currentTile.possibleVals.removeAll(setVals);
					if (currentTile.possibleVals.size() == 1) {
						currentTile.isSet = true;
					} else {
						board.mostConstrained.offer(currentTile); //re add to heap so it repositions itself correctly
					}
				}
			}
		}
	}

	// x0 = (x/3)*3
	// y0 = (y/3)*3
	// i range(0,3)
	// 	j range(0,3)
	// 		val[x0+i][y0+j]



}
