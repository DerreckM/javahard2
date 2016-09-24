import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasBasics extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root);

		Canvas canvas = new Canvas(800,600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setStroke(Color.GREEN);
		gc.setFill(Color.GREEN);
    //50 pixels from left side, 20 px from top, 100px width, 200p height
		gc.strokeRect(50, 20, 100, 200);
		gc.fillOval(160, 20, 100, 200);
		gc.setFill(Color.BLUE);
		gc.fillRect(200, 400, 200, 20);
		gc.strokeOval(200, 430, 200, 100);
    gc.setFill(Color.RED);
    gc.fillRect(600, 500, 50, 50);

		gc.setFill(Color.BLACK);
		gc.fillText("Graphics are pretty neat.", 500, 100);

		double x = canvas.getWidth() / 2;
		double y = canvas.getHeight() / 2;
		gc.fillText("This message is at (" + x + "," + y + ")", x, y);

		root.getChildren().add(canvas);

		stage.setTitle("Canvas Basics");
		stage.setScene(scene);
		stage.show();
	}

	public static void main( String[] args ) {
		launch(args);
	}
}
