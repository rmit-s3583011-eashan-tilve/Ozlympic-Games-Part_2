package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AlgorithmController implements Initializable{

	@FXML
	private Label readFrom;
	
	public void onClickNewGame(ActionEvent event) {

		System.out.println("New Game");
		Ozlympic.set_pane(Ozlympic.NEW_GAME);
	}

	public void onClickGameResults(ActionEvent event) {

		System.out.println("Game Results..");
		Ozlympic.set_pane(Ozlympic.GAME_RESULTS);
	}

	public void onClickAthleteStandings(ActionEvent event) {

		Ozlympic.set_pane(Ozlympic.STANDINGS);

	}

	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		readFrom.setText("Reading from: "+Ozlympic.driver.getParticipantList().getReadFrom());
	}

}
