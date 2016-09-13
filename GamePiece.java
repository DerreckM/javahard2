public class GamePiece {
  protected int r, c;
  protected GameBoard board;
  protected String symbol;

  public GamePiece() {
     r = c = 0;
     board = null;
     symbol = "@";
  }

  public GamePiece(int r, int c, String symbol) {
    this.r = r;
    this.c = c;
    this.board = null;
    this.symbol = symbol;
  }

  public boolean addSelfToBoard(GameBoard board) {
    if ( board.canAdd(r,c) && ! isOnBoard() && board.get(r,c) == null) {
      this.board = board;
      board.add(this,r,c);
      return true;
    }
    return false;
  }

  public boolean isOnBoard() {
    return board != null && board.get(r,c) == this;
  }

  public void removeSelfFromBoard() {
    if ( isOnBoard() ) {
      board.remove(r,c);
      board = null;
    }
  }

  public int getRow() { return r; }
  public int getCol() { return c; }
  public String getSymbol() { return symbol; }

  public String toString() {
    return "Gamepiece at (" + r + ", " + c + ")";
  }
}
