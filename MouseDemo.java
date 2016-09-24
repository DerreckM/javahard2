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
import javafx.stage.Stage;

public class MouseDemo extends Application {
	private Color curColor;
	private String curMessage;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root);

		curColor = Color.RED;
		curMessage = "The square is red.";

		Canvas canvas = new Canvas(800,400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFont(Font.font(24));

		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				curColor = Color.GREEN;
				curMessage = "The square is green.";
			}
		});


		root.getChildren().add(canvas);

		stage.setTitle("Mouse Demo");
		stage.setScene(scene);
		stage.show();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				gc.setFill(curColor);
				gc.fillRect(150, 100, 100, 100);
				gc.setFill(Color.WHITE);
				gc.fillRect(295, 78, 260, 30);
				gc.setFill(Color.BLACK);
				gc.fillText(curMessage, 300, 100);
			}
		}.start();
	}

	public static void main( String[] args ) {
		launch(args);
	}
}
