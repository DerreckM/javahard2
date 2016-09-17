import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleWindow extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 400);

		stage.setTitle("Simple Window");
		stage.setScene(scene);
		stage.show();
	}

	public static void main( String[] args ) {
		launch(args);
	}
}
