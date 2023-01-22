package frontend.controller;

import java.net.URL;
import java.util.ResourceBundle;

import frontend.view.ResultItemCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Event;
import model.HistoryObject;

public class ResultListController implements Initializable {
    @FXML
    public ListView<HistoryObject> resultListView;
    private ObservableList<HistoryObject> historyObservableList;

    public ResultListController()  {

        historyObservableList = FXCollections.observableArrayList();

        //add some Students
        historyObservableList.addAll(
                new Event("Le hoi dong", "http:s","events","2","1","story"),
                new Event("Le hoi dong1", "http:s1","events1","21","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","21","11","story1"),
                new Event("Le hoi dong4", "http:s1","events1","21","11","story1")
        );


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	resultListView.setItems(historyObservableList);
    	resultListView.setCellFactory(oldListViewItem -> new ResultItemCell());

    }


}
