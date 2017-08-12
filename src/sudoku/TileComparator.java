package sudoku;

import java.util.Comparator;

public class TileComparator implements Comparator<Tile> {

	@Override
	public int compare(Tile t1, Tile t2) {
		if (t1.possibleVals.size() < t2.possibleVals.size()) { // this Tile is MORE constrained than o
			return -1;
		} else if (t1.possibleVals.size() > t2.possibleVals.size()) { // this Tile is LESS constrained than o
			return 1;
		} else {
			return 0; // this and o are EQUALLY constained
		}
	}
}
