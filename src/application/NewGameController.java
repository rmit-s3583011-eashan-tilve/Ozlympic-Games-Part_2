package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class NewGameController {



	public void onClickSwimming(ActionEvent event) {
		
		System.out.println("Swimming");
		Ozlympic.driver.getGame().CreateNewSwimmingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);

	}
	
	public void onClickCycling(ActionEvent event) {
		
		System.out.println("Cycling");
		Ozlympic.driver.getGame().CreateNewCyclingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);

	}

	public void onClickRunning(ActionEvent event) {
		
		System.out.println("Running");
		Ozlympic.driver.getGame().CreateNewRunningGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);

	}

	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}
	
	public void onClickBack(ActionEvent event) {

		System.out.println("Back..");
		Ozlympic.set_pane(Ozlympic.HOME);
	}

}
