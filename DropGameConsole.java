import java.util.Scanner;

public class DropGameConsole {
	public static void main( String[] args ) {
		Scanner keyboard = new Scanner(System.in);

		String p = "O";
		DropGameHelper game = new DropGameHelper(6, 7);
		int col;

		while ( !(game.isWinner("O")||game.isWinner("#")||game.isFull()) ) {
			System.out.println(game);
			System.out.print("'"+ p +"', choose your column: ");
			col = keyboard.nextInt();

			while ( ! game.isValid(col) || game.isFull(col) ) {
				if ( game.isValid(col) == false )
					System.out.println("Not a valid location. Try again.");
				else if ( game.isFull(col) )
					System.out.println("That column is full. Try again.");

				System.out.print( "Choose your column: " );
				col = keyboard.nextInt();
			}
			game.playMove(p, col);

			if ( p.equals("O") )
				p = "#";
			else
				p = "O";
		}

		System.out.println(game);

		if ( game.isWinner("O") )
			System.out.println("O is the winner!");
		else if ( game.isWinner("#") )
			System.out.println("# is the winner!");
		else if ( game.isFull() )
			System.out.println("The game is a tie.");
	}
}
