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

/**
 *
 * Class Description: Class containing the main method
 * 
 * @author : Eashan Tilve
 */
public class Ozlympic extends Application {
	private static AnchorPane root;
	private static List<AnchorPane> grid = new ArrayList<AnchorPane>();
	public final static int HOME = 0;
	public final static int NEW_GAME = 1;
	public final static int SELECT_CONTESTANTS = 2;
	public final static int SELECT_OFFICIAL = 3;
	public final static int PLAY_GAME = 4;
	public static final int GAME_RESULTS = 5;
	public static final int STANDINGS = 6;
	public static Driver driver = new Driver();
	private static int indexCurrent = 0;

	/**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
	@Override 
	public void start(Stage primaryStage) {
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Ozlympic.fxml"));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/Ozlympic.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/NewGame.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/SelectContestants.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/SelectOfficial.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/PlayGame.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/GameResults.fxml")));
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/AthleteStandings.fxml")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ozlympics");
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the list of all AnchorPanes 
	 * 
	 * @return List<AnchorPane>
	 */
	public static List<AnchorPane> getAnchorPane() {
		return grid;
	}

	/**
	 * This method is used to switch between different pages of the GUI
	 * @param int index
	 * @return void
	 */
	public static void set_pane(int index) {
		root.getChildren().remove(grid.get(indexCurrent));
		root.getChildren().add(grid.get(index));
		indexCurrent = index;
	}

	/**
	 * Main method. Here is where the execution will begin.
	 * @param String[] args
	 * @return void
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
