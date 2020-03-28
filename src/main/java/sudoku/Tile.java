package sudoku;

import java.util.ArrayList;
import java.util.Collection;

public class Tile {
	
	public ArrayList<Integer> possibleVals;
	public boolean isSet = false;
	public Location location;
	
	public Tile (Collection<Integer> list, Location location) {
		this.possibleVals = new ArrayList<Integer>(list);
		this.location = location;
	}
	
	public Tile (Location location) {
		this.possibleVals = new ArrayList<Integer>();
		this.location = location;
	}
	
	public Tile (int dimension, Location location) {
		this.possibleVals = new ArrayList<Integer>(dimension);
		for (int i = 1; i <= dimension; i++) {
			this.possibleVals.add(i);
		}
		this.location = location;
	}
	
	public String toString() {
		return possibleVals.toString();
	}

}
