package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgorithmController {

	public void onClickNewGame(ActionEvent event) {

		System.out.println("New Game");
		Ozlympic.set_pane(Ozlympic.NEW_GAME);
	}

	public void onClickGameReults(ActionEvent event) {

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

}
