package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * Class Description: Controller class for Ozlympic.fxml
 * 
 * @author : Eashan Tilve
 */
public class AlgorithmController implements Initializable {

	@FXML
	private Label readFrom;

	/**
	 * This method is called when the user clicks on New Game
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickNewGame(ActionEvent event) {

		System.out.println("New Game");
		Ozlympic.set_pane(Ozlympic.NEW_GAME);
	}

	/**
	 * This method is called when the user clicks on Game Results
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickGameResults(ActionEvent event) {

		System.out.println("Game Results..");
		Ozlympic.set_pane(Ozlympic.GAME_RESULTS);
	}

	/**
	 * This method is called when the user clicks on Athlete Standings
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickAthleteStandings(ActionEvent event) {

		Ozlympic.set_pane(Ozlympic.STANDINGS);

	}

	/**
	 * This method is called when the user clicks on Exit
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}

	/**
	 * This method is called when the user clicks on Game Results
	 * 
	 * @return void
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		readFrom.setText("Reading from: " + Ozlympic.driver.getParticipantList().getReadFrom());
	}

}
