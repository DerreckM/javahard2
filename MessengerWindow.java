import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MessengerWindow extends Application {
	@Override
	public void start(Stage stage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 300, 200);

		TextField tf = new TextField("Ginna is the best!");
		Button btn = new Button("Print Message");

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println( tf.getText() );
			}
		});

		root.setAlignment(Pos.CENTER);
		root.setVgap(20);

		root.add(tf, 0, 0);
		root.add(btn, 0, 1);

		root.setHalignment(btn, HPos.CENTER);

		stage.setTitle("Messenger Window");
		stage.setScene(scene);
		stage.show();
	}

	public static void main( String[] args ) {
		launch(args);
	}
}
