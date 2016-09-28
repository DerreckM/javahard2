public class DropGameHelper
{
	private DropGamePiece[][] board;
	private int numRows, numCols;

	public DropGameHelper( int numRows, int numCols ) {
		board = new DropGamePiece[numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;

		for ( int r=0; r<numRows; r++ )
			for ( int c=0; c<numCols; c++ )
				board[r][c] = null;
	}

	public int numRows() { return numRows; }
	public int numCols() { return numCols; }

	public boolean isWinner( String p ) {
		for ( int r=0; r<numRows; r++ )
			for ( int c=0; c<numCols; c++ )
				if ( winCheck(p, board[r][c]) )
					return true;
		return false;
	}

	private boolean winCheck( String p, DropGamePiece piece ) {
		if ( piece == null )
			return false;
		if ( ! p.equals(piece.getSymbol()) )
			return false;
		Location loc = piece.getLocation();
		if ( ! isValid(loc) )
			return false;

		Location left, right, below, above;
		int adjacentCount = 0;
		left = loc.left();
		right = loc.right();
		below = loc.below();
		above = loc.above();
		if ( isValid(left) && p.equals(this.playerAt(left)) )
			adjacentCount++;
		if ( isValid(right) && p.equals(this.playerAt(right)) )
			adjacentCount++;
		if ( isValid(below) && p.equals(this.playerAt(below)) )
			adjacentCount++;
		if ( isValid(above) && p.equals(this.playerAt(above)) )
			adjacentCount++;

		return adjacentCount >= 3;
	}

	public boolean isFull() {
		int usedCount = 0;
		for ( int r=0; r<numRows; r++ )
			for ( int c=0; c<numCols; c++ )
				if ( board[r][c] != null )
					usedCount++;

		return usedCount == numRows*numCols;
	}

	public boolean isFull(int col) {
		assert isValid(col);
		int nullCount = 0;
		for ( int r=0; r<numRows; r++ )
			if ( board[r][col] == null )
				nullCount++;

		return nullCount == 0;
	}

	public boolean isValid( Location loc ) {
		return ( 0 <= loc.row && loc.row < numRows
			  && 0 <= loc.col && loc.col < numCols
		);
	}

	public boolean isValid( int col ) {
		return ( 0 <= col && col < this.numCols );
	}

	public String playerAt( Location loc ) {
		if ( isValid(loc) && board[loc.row][loc.col] != null )
			return board[loc.row][loc.col].getSymbol();
		else if ( isValid(loc) && board[loc.row][loc.col] == null )
			return " ";
		else
			return "ERROR:" + loc;
	}

	public String toString() {
		String out = "", line;
		for ( int r=0; r<numRows; r++ ) {
			line = "|";
			for ( int c=0; c<numCols; c++ ) {
				DropGamePiece piece = board[r][c];
				if ( piece == null )
					line += "_|";
				else
					line += piece.getSymbol() + "|";
			}
			out += line + "\n";
		}
		// draw numbers under each column
		line = "|";
		for ( int c=0; c<numCols; c++ )
			line += c + "|";
		out += line + "\n";
		return out;
	}

	private int findLowestEmptyRow( int col ) {
		assert isValid(col);
		assert ! isFull(col);
		int row = numRows-1;
		while ( board[row][col] != null )
			row--;
		return row;
	}

	public void playMove( String p, int col ) {
		assert isValid(col);
		assert ! isFull(col);
		int row = findLowestEmptyRow(col);
		board[row][col] = new DropGamePiece(row, col, p);
	}
}
