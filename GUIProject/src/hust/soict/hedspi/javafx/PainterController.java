package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	private boolean pen;
	private Color currentColor = Color.BLACK;
	@FXML
	private Pane drawingAreaPane;

	@FXML
	private CheckBox penBox;

	@FXML
	private CheckBox eraseBox;

	@FXML
	private void clearButtonPressed() {
		drawingAreaPane.getChildren().clear();
	}

	@FXML
	private void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
		drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	private void penCheckBoxAction(ActionEvent action) {
		if (penBox.isSelected()) {
			eraseBox.setSelected(false);
			currentColor = Color.BLACK;
		} else {
			eraseBox.setSelected(true);
			currentColor = Color.WHITE;
		}
	}

	@FXML
	private void eraserCheckBoxAction(ActionEvent action) {
		if (eraseBox.isSelected()) {
			penBox.setSelected(false);
			currentColor = Color.WHITE;
		} else {
			penBox.setSelected(true);
			currentColor = Color.BLACK;
		}
	}
}
