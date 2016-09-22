import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MessengerFXMLController {
	@FXML private TextField tf;

	@FXML protected void handleButtonClickOrWhatever(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, tf.getText());
		alert.showAndWait();
	}
}
