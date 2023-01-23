package frontend.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/frontend/model/abc.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Searchbar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
