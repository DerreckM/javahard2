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

public class NoughtsCrossesGUI extends Application {
	private GraphicsContext gc;
	private String player = "X";
	private NoughtsCrossesObject ttt;
	private boolean started = false;
	private boolean gameOver = false;
	private boolean drawLabels = false;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root);

		Canvas canvas = new Canvas(800,800);
		gc = canvas.getGraphicsContext2D();

		ttt = new NoughtsCrossesObject();

		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if ( gameOver ) {
					started = false;
					gameOver = false;
					ttt = new NoughtsCrossesObject();
					return;
				}

				if ( ! started ) {
					started = true;
					return;
				}

				int r = ((int)t.getY() - 85) / 200;
				int c = ((int)t.getX() - 125) / 200;

				if ( ttt.isTaken(r,c) == false ) {
					ttt.playMove(player,r,c);
					player = ( player.equals("X") ? "O" : "X" );
				}
			}
		});

		root.getChildren().add(canvas);

		stage.setTitle("Noughts and Crosses");
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
		gc.fillRect(0, 0, 800, 800);

		if ( ! started )
		{
			gc.setFill(Color.BLACK);
			gc.setFont(Font.font("Arial", FontWeight.BOLD, 48) );
			gc.fillText( "click to play", 275, 400 );
		}
		else
		{
			drawEmptyBoard();
			for ( int r=0; r<3; r++ )
				for ( int c=0; c<3; c++ )
					if ( ttt.isTaken(r,c) )
						drawSymbol(ttt.playerAt(r,c), r, c);

			gameOver = (ttt.isWinner("X") || ttt.isWinner("O") || ttt.isFull());
			if ( gameOver )
			{
				gc.setFont(Font.font("Arial", FontWeight.BOLD, 144));
				gc.setFill(Color.BLACK);
				if ( ttt.isWinner("X") )
					gc.fillText("X wins!", 160, 400);
				if ( ttt.isWinner("O") )
					gc.fillText("O wins!", 160, 400);
				if ( ttt.isCat() )
					gc.fillText("TIE GAME", 50, 400);
			}
			else
			{
				gc.setFont(Font.font("Arial", FontWeight.BOLD, 72));
				gc.setFill(Color.BLACK);
				gc.fillText(player + ", go.", 10, 730);
			}
		}
	}

	public void drawEmptyBoard() {
		gc.setStroke(Color.BLACK);
		// horizontal lines
		gc.strokeLine(100,250,700,250);
		gc.strokeLine(100,450,700,450);
		// vertical lines
		gc.strokeLine(300,50,300,650);
		gc.strokeLine(500,50,500,650);
		// labels
		if ( drawLabels ) {
			gc.setFont(Font.getDefault());
			gc.setFill(Color.BLACK);
			gc.fillText("(0,0)",105,65);
			gc.fillText("(1,0)",105,265);
			gc.fillText("(2,0)",105,465);

			gc.fillText("(0,1)",305,65);
			gc.fillText("(1,1)",305,265);
			gc.fillText("(2,1)",305,465);

			gc.fillText("(0,2)",505,65);
			gc.fillText("(1,2)",505,265);
			gc.fillText("(2,2)",505,465);
		}
	}

	public void drawSymbol(String p, int r, int c) {
		int x = 200*c + 125;
		int y = 200*r + 85;
		if ( p.equals("X") ) {
			gc.setStroke(Color.RED);
			gc.strokeLine(x,y,x+150,y+150);
			gc.strokeLine(x+150,y,x,y+150);
		}
		else if ( p.equals("O") ) {
			gc.setFill(Color.YELLOW);
			gc.fillOval(x,y,150,150);
		}
	}

	public static void main( String[] args ) { launch(args); }
}
