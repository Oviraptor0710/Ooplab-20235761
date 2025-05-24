package hust.soict.program.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup colorToggleGroup;

    // Sửa kiểu sự kiện thành MouseEvent
    @FXML
    void handleMouseDraw(MouseEvent event) {
        RadioButton selectedTool = (RadioButton) colorToggleGroup.getSelectedToggle();
        if (selectedTool == null) return;

        Color color = Color.BLACK; // default to Pen
        if ("Erasor".equals(selectedTool.getText())) {
            color = Color.WHITE;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}


