import java.util.Scanner;

public class GameTestTicTac {
	public static void main( String[] args ) {
		GameBoard board = new GameBoard(3,3);
		Scanner kb = new Scanner(System.in);
		String p = "X";
		int r, c, turns = 0;
		boolean done = false;

		do {
			System.out.println("\n"+board);
			System.out.print("'"+ p +"', your turn: ");
		    r = kb.nextInt();
		    c = kb.nextInt();
			if ( board.canAdd(r,c) && board.get(r,c) == null ) {
				GamePiece XO = new GamePiece(r, c, p);
				XO.addSelfToBoard(board);
				turns++;
				p = p.equals("X") ? "O" : "X";
				done = isWinner(board,"X") || isWinner(board,"O") || turns == 9;
			}
			else {
				System.out.println("\nSorry, you can't go there. Try again.");
			}
		} while ( !done );

		System.out.println("\n"+board);

		if ( isWinner(board, "X") )
			System.out.println("X wins!");
		else if ( isWinner(board, "O") )
			System.out.println("O wins!");
		else
			System.out.println("It's a tie!");
	}

	public static boolean isWinner( GameBoard board, String p ) {
		if ( winCheck(board, p, 0,0, 0,1, 0,2) ) return true;
		if ( winCheck(board, p, 1,0, 1,1, 1,2) ) return true;
		if ( winCheck(board, p, 2,0, 2,1, 2,2) ) return true;
		if ( winCheck(board, p, 0,0, 1,0, 2,0) ) return true;
		if ( winCheck(board, p, 0,1, 1,1, 2,1) ) return true;
		if ( winCheck(board, p, 0,2, 1,2, 2,2) ) return true;
		if ( winCheck(board, p, 0,0, 1,1, 2,2) ) return true;
		if ( winCheck(board, p, 2,0, 1,1, 0,2) ) return true;
		return false;
	}

	public static boolean winCheck(GameBoard board, String p, int a,int b,
			int c, int d, int e, int f) {
		if ( board.get(a,b) == null || board.get(c,d) == null
				|| board.get(e,f) == null )
			return false;
		String A = board.get(a,b).getSymbol();
		String B = board.get(c,d).getSymbol();
		String C = board.get(e,f).getSymbol();
		return ( p.equals(A) && A.equals(B) && B.equals(C) );
	}
}
