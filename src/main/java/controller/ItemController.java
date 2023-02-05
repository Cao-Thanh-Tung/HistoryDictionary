package controller;

import java.io.IOException;

import model.Model;
import model.Event;
import model.Festival;
import model.Person;
import model.Period;
import model.Place;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import screen.MainScreen;
import service.ServiceDisplayInfo;

public class ItemController extends ListCell<Model> {
    @FXML
    public Label titleLb;
    @FXML
    public Label typeLb;
    @FXML
    public Label urlLb;
    public Model model;
    FXMLLoader loader;
    public Model selectedItem;
    public ItemController(MainScreen mainScreen) {
        loadFXML();
        this.setOnMouseClicked(MouseEvent->{
        	mainScreen.contentLayer.toFront();
        	mainScreen.contentLayer.setVisible(true);
        	mainScreen.contentLayerController.vb_contentWrapper = ServiceDisplayInfo.displayInfo(mainScreen.contentLayerController.vb_contentWrapper, this.model);
        	mainScreen.contentLayerController.tf_searchBarSmall.setText(this.model.getName());
        });
     
    }
    
    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/resultItem.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	@Override
    protected void updateItem(Model item, boolean empty) {
        super.updateItem(item, empty);
        model = item;
        if(empty || item == null) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
        else {
        	this.selectedItem = item;
            titleLb.setText(item.getName());
            if(item instanceof Period) {
            	typeLb.setText("Triểu đại");
            }else if(item instanceof Event) {
            	typeLb.setText("Sự kiện lịch sử");
            }else if(item instanceof Festival) {
            	typeLb.setText("Lễ hội văn hóa Việt Nam");
            }else if(item instanceof Person) {
            	typeLb.setText("Nhân vật lịch sử");
            }else {
            	typeLb.setText("Địa điểm di tích lịch sử");
            }
            urlLb.setText(item.getHref());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            

        }
    }

	
}
