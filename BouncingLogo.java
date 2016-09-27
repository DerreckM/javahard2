import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BouncingLogo extends Application {
	private boolean flashing = false;
	private double x, y, dx, dy;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 900, 700);

		x = 500;
		y = 350;
		dx = 5;
		dy = 5;

		Image img = new Image("file:datafiles/ljthw-logo-32px.png");
		ImageView logo = new ImageView(img);
		logo.relocate(x,y);

		Rectangle rect = new Rectangle(x, y, img.getWidth(), img.getHeight());
		rect.setFill(Color.WHITE);

		scene.addEventHandler(KeyEvent.KEY_PRESSED,
				new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if ( t.getCode() == KeyCode.SPACE )
					flashing = ! flashing;
			}
		});

		root.getChildren().add(rect);
		root.getChildren().add(logo);

		stage.setTitle("Bouncing Logo");
		stage.setScene(scene);
		stage.show();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				x += dx;
				y += dy;

				if ( x < 0 || x+img.getWidth() > scene.getWidth() )
					dx = -dx;
				if ( y < 0 || y+img.getHeight() > scene.getHeight() )
					dy = -dy;

				if ( flashing ) {
					double red = Math.random();
					double green = Math.random();
					double blue = Math.random();
					rect.setFill(Color.color(red,green,blue));
				}
				logo.relocate(x,y);
				rect.relocate(x,y);
			}
		}.start();
	}

	public static void main( String[] args ) { launch(args); }
}
