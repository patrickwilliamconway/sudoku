package sudoku;

import java.util.ArrayList;
import java.util.Collection;

public class Tile {
	
	public ArrayList<Integer> possibleVals;
	public boolean isSet = false;
	
	public Tile (Collection<Integer> list) {
		this.possibleVals = new ArrayList<Integer>(list);
	}
	
	public Tile () {
		this.possibleVals = new ArrayList<Integer>();
	}
	
	public Tile (int dimension) {
		this.possibleVals = new ArrayList<Integer>(dimension);
		for (int i = 1; i <= dimension; i++) {
			this.possibleVals.add(i);
		}
	}
	
	public String toString() {
		return possibleVals.toString();
	}

}
