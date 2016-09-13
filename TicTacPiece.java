public class TicTacPiece extends GamePiece {
  private static int whichOne = 0; //static means that all instances of this object share a single copy of this variable

  public TicTacPiece( int r, int c ) {
    super(r,c, whichOne%2 == 0 ? "X" : "O");
    whichOne++;
  }
}
