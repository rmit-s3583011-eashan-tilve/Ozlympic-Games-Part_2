package application;

import javafx.event.ActionEvent;
import model.Game;

/**
 *
 * Class Description: Controller class for Ozlympic.fxml
 * 
 * @author : Eashan Tilve
 */
public class NewGameController {
	/**
	 * This method is called when the user clicks on Swimming
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickSwimming(ActionEvent event) {
		System.out.println("Swimming");
		Ozlympic.driver.getGame().CreateNewSwimmingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.SWIMMING_ID);
	}

	/**
	 * This method is called when the user clicks on Cycling
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickCycling(ActionEvent event) {
		System.out.println("Cycling");
		Ozlympic.driver.getGame().CreateNewCyclingGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.CYCLING_ID);
	}

	/**
	 * This method is called when the user clicks on Running
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickRunning(ActionEvent event) {
		System.out.println("Running");
		Ozlympic.driver.getGame().CreateNewRunningGame();
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Game.RUNNING_ID);
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
	 * This method is called when the user clicks on Back
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickBack(ActionEvent event) {

		System.out.println("Back..");
		Ozlympic.set_pane(Ozlympic.HOME);
	}

}
