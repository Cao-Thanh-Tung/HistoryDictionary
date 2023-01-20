
package frontend.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Searchbar extends Application {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage state) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/frontend/model/searchbar.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/frontend/style/searchbar.css").toExternalForm());
		state.setTitle("Searchbar");
		state.setScene(scene);
		state.show();
	}

}