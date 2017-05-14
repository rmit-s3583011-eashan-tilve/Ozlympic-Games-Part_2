package application;

import javafx.event.ActionEvent;
import model.Game;


public class NewGameController {
public void onClickSwimming(ActionEvent event) {
		
		System.out.println("Swimming");
		Ozlympic.driver.getGame().CreateNewSwimmingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.SWIMMING_ID);
	}
	
	public void onClickCycling(ActionEvent event) {
		
		System.out.println("Cycling");
		Ozlympic.driver.getGame().CreateNewCyclingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.CYCLING_ID);
	}

	public void onClickRunning(ActionEvent event) {
		
		System.out.println("Running");
		Ozlympic.driver.getGame().CreateNewRunningGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.RUNNING_ID);
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
