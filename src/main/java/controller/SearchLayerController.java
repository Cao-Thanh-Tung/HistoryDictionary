package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import crawler.MainCrawler;
import model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import screen.MainScreen;
import service.ServiceSearch;

public class SearchLayerController implements Initializable {

	@FXML
	public Button btn_getData;
    @FXML
    public CheckBox cb_period;
    @FXML
    public CheckBox cb_event;
    @FXML
    public CheckBox cb_festival;
    @FXML
    public CheckBox cb_people;
    @FXML
    public CheckBox cb_place;
    @FXML
    public CheckBox cb_all;
	@FXML
	public TextField tf_search;
    @FXML
    public ProgressIndicator progressIndicator;
    @FXML
    public BorderPane bp_resultList;
    public ListView listView = new ListView();
    private ObservableList listItem = FXCollections.observableArrayList();
    private ServiceSearch serviceSearch = new ServiceSearch();
	private MainScreen mainScreen;
	public SearchLayerController(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
	}
	@FXML
	public void search(ActionEvent event) {
		bp_resultList.setCenter(progressIndicator);
		serviceSearch.search(tf_search.getText(), cb_all.isSelected(), cb_period.isSelected(), cb_event.isSelected(), cb_festival.isSelected(), cb_people.isSelected(), cb_place.isSelected());
	}
	
	@FXML
	public void getData(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Operating");
		alert.setHeaderText("continueing");
		alert.setContentText("Dang tai data");
		alert.showAndWait();
		MainCrawler.crawl();
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Finished");
		alert.setHeaderText("The operation is finish");
		alert.setContentText("Da tai xong data");
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setCellFactory(oldListViewItem -> new ItemController(mainScreen));
		progressIndicator.visibleProperty().bind(serviceSearch.runningProperty());
    	serviceSearch.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                List<Model> resultList = serviceSearch.getValue();
                setNewItems(resultList);
                bp_resultList.setCenter(listView);
             
            }
        });	
	}
	
	private void setNewItems(List<Model> listModel) {
		listItem.clear();
		listItem.addAll(listModel);
		listView.setItems(listItem);
	}
}
