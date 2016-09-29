import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 300, 600);

		Label label = new Label("Click on one of the circles!");
		label.relocate(20, 10);

		Circle circle1 = new Circle(150, 140, 75);
		circle1.setFill(Color.RED);
		Circle circle2 = new Circle(150, 310, 75);
		circle2.setFill(Color.YELLOW);
		Circle circle3 = new Circle(150, 480, 75);
		circle3.setFill(Color.web("#008000"));

		scene.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if ( circle1.contains(t.getX(), t.getY()) )
					label.setText("You clicked on the red circle!");
				else if ( circle2.contains(t.getX(), t.getY()) )
					label.setText("You clicked on the yellow circle!");
				else if ( circle3.contains(t.getX(), t.getY()) )
					label.setText("You clicked on the green circle!");
				else
					label.setText("Click at " + t.getX() + ", " + t.getY());
			}
		});

		root.getChildren().addAll(label, circle1, circle2, circle3);

		stage.setTitle("Traffic Light");
		stage.setScene(scene);
		stage.show();
	}

	public static void main( String[] args ) { launch(args); }
}
