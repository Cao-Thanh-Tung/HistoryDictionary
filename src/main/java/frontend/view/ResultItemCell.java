package frontend.view;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import model.HistoryObject;

public class ResultItemCell extends ListCell<HistoryObject> {

    @FXML
    public Label titleLb;

    @FXML
    public Label typeLb;

    @FXML
    public Label urlLb;
	
    FXMLLoader loader;
    
    public ResultItemCell() {
        loadFXML();
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
            System.out.println(item.getName());
            titleLb.setText(item.getName());
            typeLb.setText("hello");
            urlLb.setText(item.getSource());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            

        }
    }


}
