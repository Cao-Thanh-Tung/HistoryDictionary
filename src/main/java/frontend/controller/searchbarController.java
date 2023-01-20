package frontend.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class searchbarController {
	// Cao Thanh Tung 20200569
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup Tool;
    // Cao Thanh Tung 20200569
    // Tao mot bien danh dau xem tool dang chon la gi, ban dau la but
    String tool = "Pen";
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	// Cao Thanh Tung 20200569
    	Color paintColor = Color.BLACK;
    	if(tool.equals("Pen")) {
    		paintColor = Color.BLACK;    		
    	}else {
    		paintColor = Color.WHITE;
    	}
    	
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, paintColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	// Cao Thanh Tung 20200569
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawByBlackColor(ActionEvent event) {
    	// Dat tool la Pen
    	this.tool = "Pen";
    }

    @FXML
    void eraserByWhiteColor(ActionEvent event) {
    	// Dat tool la eraser
    	this.tool = "eraser";
    }
}

