package frontend.controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import jsonparse.DynastyParse;
import jsonparse.EventParse;
import jsonparse.FestivalParse;
import jsonparse.HistoricalFigureParse;
import jsonparse.HistoricalSiteParse;
import model.Dynasty;
import model.Event;
import model.Festival;
import model.HistoricalFigure;
import model.HistoricalSite;
import model.HistoryObject;

public class ResultListController implements Initializable {
    @FXML
    public ListView<HistoryObject> resultListView;
    @FXML
    public TextField smallSearch;
    @FXML
    public BorderPane contentScreen;
    @FXML
    public BorderPane searchScreen;
    @FXML
    public TextField fieldSearch;
    @FXML
    public BorderPane lvresult;
    @FXML
    public ToolBar searchComponent;
    @FXML
    public ProgressIndicator progressIndicator;
    @FXML
    public BorderPane progressComponent;
    @FXML
    public CheckBox dynastyCB;
    @FXML
    public CheckBox eventCB;
    @FXML
    public CheckBox festivalCB;
    @FXML
    public CheckBox historicalSiteCB;
    @FXML
    public CheckBox historicalFigureCB;
    @FXML
    public CheckBox allCB;
    @FXML
    public Label title_lb;
    @FXML
    public Label source_lb;
    @FXML
    public Label time_lb;
    @FXML
    public Label type_lb;
    @FXML
    public Label story_lb;
    @FXML
    public Label address_lb;
    @FXML
    public Text story_tx;
    public LinkedList<HistoryObject> resultList;
    public LinkedList<Dynasty> dynastyList;
    public LinkedList<Event> eventList;
    public LinkedList<Festival> festivalList;
    public LinkedList<HistoricalFigure> historicalFigureList;
    public LinkedList<HistoricalSite> historicalSiteList;
    private ObservableList<HistoryObject> historyObservableList;
    final ServiceSearch serviceSearch;

    public ResultListController()  {
    	resultList = new LinkedList<HistoryObject>();
    	serviceSearch = new ServiceSearch();
    	dynastyList = DynastyParse.readFileJson();
    	eventList = EventParse.readFileJson();
    	festivalList = FestivalParse.readFileJson();
    	historicalFigureList = HistoricalFigureParse.readFileJson();
    	historicalSiteList = HistoricalSiteParse.readFileJson();
        historyObservableList = FXCollections.observableArrayList();
        
        historyObservableList.addAll(
                new Event("Le hoi dong", "http:s","events","1","story"),
                new Event("Le hoi dong1", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong3", "http:s1","events1","11","story1"),
                new Event("Le hoi dong4", "http:s1","events1","11","story1")
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	progressIndicator.visibleProperty().bind(serviceSearch.runningProperty());
    	serviceSearch.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                resultList = serviceSearch.getValue();   
            	progressComponent.setManaged(false);
            	progressComponent.setVisible(false);
            	historyObservableList.addAll(resultList);
            	resultListView.setItems(historyObservableList);
            	lvresult.setManaged(true);
                lvresult.setVisible(true);
            }
        });
    	resultListView.setItems(historyObservableList);
    	resultListView.setCellFactory(oldListViewItem -> new ResultItemCell());
    	progressComponent.setManaged(false);
    	progressComponent.setVisible(false);
    	lvresult.setManaged(false);
    	lvresult.setVisible(false);
    	contentScreen.setVisible(false);
    	contentScreen.setManaged(false);
    	
    	smallSearch.setOnMouseClicked(mouseEvent->{
    		contentScreen.setVisible(false);
    		contentScreen.setManaged(false);
        	searchScreen.setVisible(true);
        	searchScreen.setManaged(true);
    	});
    }

    @FXML
    public void changeValue(ActionEvent event) {
    	progressComponent.setManaged(true);
    	progressComponent.setVisible(true);
    	lvresult.setManaged(false);
    	lvresult.setVisible(false);
    	smallSearch.setText(fieldSearch.getText());
    	historyObservableList.clear();
    	serviceSearch.restart();
    	
    }
	
    private LinkedList<HistoryObject> search(String keyword){
    	LinkedList<HistoryObject> matchedList = new LinkedList<HistoryObject>();
    	if(allCB.isSelected()) {
    		for(HistoryObject i: dynastyList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(HistoryObject i: eventList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(HistoryObject i: festivalList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};    		
    		for(HistoryObject i: historicalFigureList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(HistoryObject i: historicalSiteList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    	}else {
        	if(dynastyCB.isSelected()) {
        		for(HistoryObject i: dynastyList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		}
        	}
        	if(eventCB.isSelected()) {
        		for(HistoryObject i: eventList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}
        	if(festivalCB.isSelected()) {
        		for(HistoryObject i: festivalList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};    	
        	}
        	if(historicalFigureCB.isSelected()) {
        		for(HistoryObject i: historicalFigureList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}if(historicalFigureCB.isSelected()) {
        		for(HistoryObject i: historicalSiteList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}
    	}
    	return matchedList;

    }
    private boolean matched(String keyword, String title) {
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(title);
        boolean matchFound = matcher.find();
        if(matchFound) {
          return true;
        } else {
          return false;
        }
    }
	public class ServiceSearch extends Service<LinkedList<HistoryObject>> {
	    @Override
	    protected Task<LinkedList<HistoryObject>> createTask() {
	        return new Task<LinkedList<HistoryObject>>() {
	            @Override
	            protected LinkedList<HistoryObject> call() throws Exception {
	                //DO YOU HARD STUFF HERE
	            	String searchKeyword = fieldSearch.getText();
	            	Thread.sleep(300);
	                return search(searchKeyword);
	            }
	        };
	    }
	}
	
	public class ResultItemCell extends ListCell<HistoryObject> {

	    @FXML
	    public Label titleLb;

	    @FXML
	    public Label typeLb;

	    @FXML
	    public Label urlLb;
	    public String time;
	    public String address;
	    public String story;
	    FXMLLoader loader;
	    
	    public ResultItemCell() {
	        loadFXML();
	        this.setOnMouseClicked(MouseEvent->{
	        	contentScreen.setVisible(true);
	        	contentScreen.setManaged(true);
	        	searchScreen.setVisible(false);
	        	searchScreen.setManaged(false);
	        	title_lb.setText(this.titleLb.getText());
	        	source_lb.setText("Nguồn: " + this.urlLb.getText());
	        	type_lb.setText("Thể loại: " + this.typeLb.getText());
	        	if(time != null) {	        		
	        		time_lb.setText("Thời gian: " + this.time);
	        	}else {
	        		time_lb.setText("");
	        	}
	        	if(address != null) {
	        		address_lb.setText("Địa điểm: "+ this.address);
	        	}else {
	        		address_lb.setText("");
	        	}
	        	
	        	story_tx.setText(this.story);
	        });
	        
	    }
	    
	    private void loadFXML() {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/model/resultItem.fxml"));
	            loader.setController(this);
	            loader.setRoot(this);
	            loader.load();
	        }
	        catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
		@Override
	    protected void updateItem(HistoryObject item, boolean empty) {
	        super.updateItem(item, empty);

	        if(empty || item == null) {
	            setText(null);
	            setContentDisplay(ContentDisplay.TEXT_ONLY);
	        }
	        else {
	        	this.story = item.getStory();
	            titleLb.setText(item.getName());
	            String type = item.getType();
	            if(type.equalsIgnoreCase("dynasty")) {
	            	typeLb.setText("Triểu đại");
	            }else if(type.equalsIgnoreCase("event")) {
	            	typeLb.setText("Sự kiện lịch sử");
	            }else if(type.equalsIgnoreCase("festival")) {
	            	typeLb.setText("Lễ hội văn hóa Việt Nam");
	            }else if(type.equalsIgnoreCase("historicalFigure")) {
	            	typeLb.setText("Nhân vật lịch sử");
	            }else {
	            	typeLb.setText("Địa điểm di tích lịch sử");
	            }
	            urlLb.setText(item.getSource());
	            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	            

	        }
	    }

	}
}
