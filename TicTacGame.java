import java.util.Scanner;

public class TicTacGame {
	public static void main( String[] args ) {
		TicTacBoard board = new TicTacBoard();
		Scanner kb = new Scanner(System.in);
		int r, c;

		do {
			System.out.println("\n"+board);
			System.out.print("'"+ board.currentPlayer() +"', your turn: ");
		    r = kb.nextInt();
		    c = kb.nextInt();
			if ( ! board.canAdd(r,c) ) {
				System.out.println("\nSorry, you can't go there. Try again.");
				continue;
			}
			TicTacPiece XO = new TicTacPiece(r, c);
			XO.addSelfToBoard(board);
		} while ( !board.isOver() );

		System.out.println("\n"+board);

		if ( board.isWinner("X") )
			System.out.println("X wins!");
		else if ( board.isWinner("O") )
			System.out.println("O wins!");
		else
			System.out.println("It's a tie!");
	}
}
