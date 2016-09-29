public class DropGamePiece
		implements Locatable, Comparable<DropGamePiece>, Translatable {
	private Location loc;
	private String symbol;

	public DropGamePiece() {
		loc = new Location(0,0);
		symbol = "x";
	}

	public DropGamePiece(int r, int c, String sym) {
		this(new Location(r,c), sym);
	}

	public DropGamePiece(Location loc, String sym) {
		this.loc = loc;
		symbol = sym;
	}

	public Location getLocation() {
		return loc;
	}

	public String getSymbol() {
		return symbol;
	}

	public int compareTo( DropGamePiece other ) {
		return loc.compareTo(other.loc);
	}

	public void translate(int dr, int dc) {
		loc.row += dr;
		loc.col += dc;
	}

	public String toString() {
		return "DropGamePiece " + symbol + " at " + loc;
	}
}
