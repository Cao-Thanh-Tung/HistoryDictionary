package frontend.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frontend.model.Period;
import frontend.jsonparse.EventParse;
import frontend.jsonparse.FestivalParse;
import frontend.jsonparse.PeopleParse;
import frontend.jsonparse.PeriodParse;
import frontend.jsonparse.PlaceParse;
import frontend.model.Event;
import frontend.model.Festival;
import frontend.model.People;
import frontend.model.Place;
import frontend.model.Model;
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

public class ResultListController implements Initializable {
    @FXML
    public ListView<Model> resultListView;
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
    public LinkedList<Model> resultList;
    public LinkedList<Period> dynastyList;
    public LinkedList<Event> eventList;
    public LinkedList<Festival> festivalList;
    public LinkedList<People> historicalFigureList;
    public LinkedList<Place> historicalSiteList;
    private ObservableList<Model> historyObservableList;
    final ServiceSearch serviceSearch;
    
    public ResultListController()  {
    	resultList = new LinkedList<Model>();
    	serviceSearch = new ServiceSearch();
    	dynastyList = PeriodParse.readFileJson();
    	eventList = EventParse.readFileJson();
    	festivalList = FestivalParse.readFileJson();
    	historicalFigureList = PeopleParse.readFileJson();
    	historicalSiteList = PlaceParse.readFileJson();
        historyObservableList = FXCollections.observableArrayList();
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
	
    private LinkedList<Model> search(String keyword){
    	LinkedList<Model> matchedList = new LinkedList<Model>();
    	if(allCB.isSelected()) {
    		for(Model i: dynastyList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: eventList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: festivalList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};    		
    		for(Model i: historicalFigureList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: historicalSiteList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    	}else {
        	if(dynastyCB.isSelected()) {
        		for(Model i: dynastyList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		}
        	}
        	if(eventCB.isSelected()) {
        		for(Model i: eventList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}
        	if(festivalCB.isSelected()) {
        		for(Model i: festivalList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};    	
        	}
        	if(historicalFigureCB.isSelected()) {
        		for(Model i: historicalFigureList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}if(historicalFigureCB.isSelected()) {
        		for(Model i: historicalSiteList) {
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
	public class ServiceSearch extends Service<LinkedList<Model>> {
	    @Override
	    protected Task<LinkedList<Model>> createTask() {
	        return new Task<LinkedList<Model>>() {
	            @Override
	            protected LinkedList<Model> call() throws Exception {
	                //DO YOU HARD STUFF HERE
	            	String searchKeyword = fieldSearch.getText();
	            	Thread.sleep(300);
	                return search(searchKeyword);
	            }
	        };
	    }
	}
	
	public class ResultItemCell extends ListCell<Model> {

	    @FXML
	    public Label titleLb;

	    @FXML
	    public Label typeLb;

	    @FXML
	    public Label urlLb;
	    public String time;
	    public String address;
	    public String story;
	    public Model model;
	    FXMLLoader loader;
	    public Model selectedItem;
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
	        	if(selectedItem.getClass() == Event.class) {
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
	        	}else if(selectedItem.getClass() == Festival.class) {
	        		
	        	}else if(selectedItem.getClass() == People.class) {
	        		
	        	}else if(selectedItem.getClass() == Period.class) {
	        		
	        	}else if(selectedItem.getClass() == Place.class) {
	        		
	        	}
	        	

	        	
	        	story_tx.setText(this.story);
	        });
	        
	    }
	    
	    private void loadFXML() {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/fxml/resultItem.fxml"));
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
	        	this.story = item.getStory();
	            titleLb.setText(item.getName());
	            if(item.getClass() ==  Period.class) {
	            	typeLb.setText("Triểu đại");
	            }else if(item.getClass() == Event.class) {
	            	typeLb.setText("Sự kiện lịch sử");
	            }else if(item.getClass() == Festival.class) {
	            	typeLb.setText("Lễ hội văn hóa Việt Nam");
	            }else if(item.getClass() == People.class) {
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
