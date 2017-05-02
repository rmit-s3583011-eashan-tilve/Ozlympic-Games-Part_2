package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.Driver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Ozlympic extends Application {
	static AnchorPane root;
	static List<AnchorPane> grid = new ArrayList<AnchorPane>();
	public final static int HOME = 0;
	public final static int NEW_GAME = 1;
	public final static int SELECT_CONTESTANTS = 2;
	public final static int SELECT_OFFICIAL = 3;
	public static Driver driver = new Driver();
	
	private static int indexCurrent = 0;
	@Override // Override the start method from the superclass
	public void start(Stage primaryStage) {
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Ozlympic.fxml"));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/Ozlympic.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/NewGame.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/SelectContestants.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/SelectOfficial.fxml")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ozlympics");
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void set_pane(int index) {
		root.getChildren().remove(grid.get(indexCurrent));
		root.getChildren().add(grid.get(index));
		indexCurrent = index;
	}

	/**
	 * The main method is not needed for running from the command line.
	 */

	public static void main(String[] args) {
		launch(args);
	}
}
