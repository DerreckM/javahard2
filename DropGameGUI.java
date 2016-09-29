import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DropGameGUI extends Application {
	private GraphicsContext gc;
	private int player = 1;
	private DropGameHelper game;
	private boolean started = false;
	private boolean gameOver = false;
	private Location[][] locs;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root);

		Canvas canvas = new Canvas(900, 800);
		gc = canvas.getGraphicsContext2D();

		game = new DropGameHelper(6, 7);
		locs = new Location[6][7];
		for ( int r=0; r<locs.length; r++ )
			for ( int c=0; c<locs[0].length; c++ )
				locs[r][c] = new Location(r,c);
		gc.setStroke(Color.BLACK);

		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if ( gameOver ) {
					started = false;
					gameOver = false;
					game = new DropGameHelper(6, 7);
				}
				else if ( ! started ) {
					started = true;
				}
				else {
					int xOffset = 100, colWidth = 100;
					int col = ((int)t.getX() - xOffset) / colWidth;
					if ( game.isValid(col) && ! game.isFull(col) ) {
						game.playMove(""+player, col);
						player = (player%2) + 1;
					}
				}
			}
		});

		root.getChildren().add(canvas);

		stage.setTitle("Drop Game");
		stage.setScene(scene);
		stage.show();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				drawEverything();
			}
		}.start();
	}

	public void drawEverything() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 900, 800);

		if ( ! started )
		{
			gc.setFill(Color.BLACK);
			gc.setFont(Font.font("Arial", FontWeight.BOLD, 48) );
			gc.fillText( "click to begin", 275, 400 );
		}
		else
		{
			drawBoard();
			gameOver = game.isWinner("1") || game.isWinner("2") || game.isFull();
			if ( gameOver ) {
				gc.setFont(Font.font("Arial", FontWeight.BOLD, 120));
				gc.setFill(Color.BLACK);
				if ( game.isWinner("1") )
					gc.fillText("Player 1 wins!", 50, 400);
				else if ( game.isWinner("2") )
					gc.fillText("Player 2 wins!", 50, 400);
				else if ( game.isFull() )
					gc.fillText("TIE GAME", 150, 400);
			}
			else {
				gc.setFont(Font.font("Arial", FontWeight.BOLD, 72));
				gc.setFill(Color.BLACK);
				gc.fillText("Player " + player + ", go.", 30, 750);
			}
		}
	}

	public void drawBoard() {
		double xOffset = 100;
		double yOffset = 50;
		double colWidth = 100;
		double rowWidth = 100;
		for ( int r=0; r<game.numRows(); r++ ) {
			for ( int c=0; c<game.numCols(); c++ ) {
				double x = xOffset + c*colWidth;
				double y = yOffset + r*rowWidth;
				if ( game.playerAt(locs[r][c]).equals(" ") )
					gc.strokeOval(x, y, 80, 80);
				else {
					if ( game.playerAt(locs[r][c]).equals("1") )
						gc.setFill(Color.RED);
					else
						gc.setFill(Color.YELLOW);
					gc.fillOval(x, y, 80, 80);
				}
			}
		}
	}

	public static void main( String[] args ) { launch(args); }
}
