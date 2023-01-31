package screen;
import controller.ContentLayerController;
import controller.SearchLayerController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
public class MainScreen extends Application {

	public Parent searchLayer;
	public Parent contentLayer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// root of screen is a StackPane
		StackPane root = new StackPane();
		
		//get searchScreen
		FXMLLoader searchLayerLoader = new FXMLLoader(getClass().getResource("/fxml/searchLayer.fxml"));
		SearchLayerController searchLayerController = new SearchLayerController(this);
		searchLayerLoader.setController(searchLayerController);
		searchLayer = searchLayerLoader.load();
		searchLayer.getStylesheets().add(getClass().getResource("/css/searchbar.css").toExternalForm());
		searchLayer.getStylesheets().add(getClass().getResource("/css/resultItem.css").toExternalForm());
		
//		get contentScreen
		FXMLLoader contentLayerLoader = new FXMLLoader(getClass().getResource("/fxml/contentLayer.fxml"));
		ContentLayerController contentLayerController = new ContentLayerController();
		contentLayerLoader.setController(contentLayerController);
		contentLayer = contentLayerLoader.load();
		contentLayer.getStylesheets().add(getClass().getResource("/css/searchbar.css").toExternalForm());
		contentLayer.getStylesheets().add(getClass().getResource("/css/content.css").toExternalForm());
		contentLayerController.tf_searchBarSmall.setOnMouseClicked(MouseEvent->{
        	searchLayer.toFront();
        });
		
		root.getChildren().addAll(contentLayer, searchLayer);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
