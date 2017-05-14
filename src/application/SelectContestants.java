package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Driver;
import controller.GameFullException;
import controller.TooFewAthleteException;
import controller.WrongTypeException;
import database.ParticipantList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import model.Athlete;
import model.Cyclist;
import model.Game;
import model.Sprinter;
import model.SuperAthlete;
import model.Swimmer;

public class SelectContestants implements Initializable {

	protected static final int MAX_ATHELETES = 8;
	private int count = 0;

	@FXML
	private Label exception;

	@FXML
	private ListView<String> athletes = new ListView<String>();

	@FXML
	private ListView<String> selectedAthletes = new ListView<String>();

	public void onClickNext(ActionEvent event) {
		System.out.println("Next");
		if (count < 4) {
			try {
				throw new TooFewAthleteException();
			} catch (TooFewAthleteException e) {
				exception.setText(e.getMessage());
			}
		} else {
			Driver driver = Ozlympic.driver;
			Game game = driver.getGame();
			ArrayList<Athlete> setAthletes = driver.getSelectedAthletes(selectedAthletes);
			game.assignContestants(setAthletes);
			Ozlympic.set_pane(Ozlympic.SELECT_OFFICIAL);
			resetPage();
		}
	}

	private void resetPage() {
		resetListViews();
		count = 0;
		exception.setText("");
	}

	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}

	public void onClickBack(ActionEvent event) {

		System.out.println("Back..");
		Ozlympic.driver.getGame().getGames().remove(Ozlympic.driver.getGame().getSelectedGame());
		Ozlympic.driver.getGame().decrementGameCount();
		Ozlympic.set_pane(Ozlympic.NEW_GAME);
		resetPage();
	}

	private boolean isTypeCorrect(ObservableList<String> selectedItems) {
		Driver driver = Ozlympic.driver;
		Game game = driver.getGame();
		ArrayList<Athlete> setAthletes = driver.getSelectedAthletesBy(selectedItems);
		char gameType = game.getCurrentGame();
		for (Athlete athlete : setAthletes) {
			System.out.println(gameType);
			switch (gameType) {
			case Game.SWIMMING_ID:
				if (!((athlete instanceof Swimmer) || (athlete instanceof SuperAthlete)))
					return false;
				break;
			case Game.RUNNING_ID:
				if (!((athlete instanceof Sprinter) || (athlete instanceof SuperAthlete)))
					return false;
				break;
			case Game.CYCLING_ID:
				if (!((athlete instanceof Cyclist) || (athlete instanceof SuperAthlete)))
					return false;
				break;
			default:
			}
		}

		return true;
	}

	private void resetListViews() {

		selectedAthletes.getItems().clear();
		athletes.getItems().clear();
		initializeAthletes();
	}

	private void initializeAthletes() {
		ParticipantList participantList = Ozlympic.driver.getParticipantList();

		for (Athlete athlete : participantList.getCyclists())
			athletes.getItems().add("CYCLIST " + athlete.toString());
		for (Athlete athlete : participantList.getSprinters())
			athletes.getItems().add("SPRINTER " + athlete.toString());
		for (Athlete athlete : participantList.getSwimmers())
			athletes.getItems().add("SWIMMER " + athlete.toString());
		for (Athlete athlete : participantList.getSuperAthletes())
			athletes.getItems().add("SUPER ATHLETE " + athlete.toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		athletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		selectedAthletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		initializeAthletes();

		athletes.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				ObservableList<String> selectedItems = athletes.getSelectionModel().getSelectedItems();

				System.out.println("count " + count);
				if (count >= MAX_ATHELETES) {
					try {
						throw new GameFullException();
					} catch (GameFullException e) {
						exception.setText(e.getMessage());
					}
				} else if (!isTypeCorrect(selectedItems)) {
					try {
						throw new WrongTypeException();
					} catch (WrongTypeException e) {
						exception.setText(e.getMessage());
					}
				} else {
					for (String s : selectedItems) {
						System.out.println("selected item " + s);
						selectedAthletes.getItems().add(s);
						athletes.getSelectionModel().select(-1);
						athletes.getItems().remove(s);
						count++;
					}
				}
			}

		});

		selectedAthletes.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ObservableList<String> selectedItems = selectedAthletes.getSelectionModel().getSelectedItems();

				for (String s : selectedItems) {
					System.out.println("removed item " + s);
					athletes.getItems().add(s);
					selectedAthletes.getSelectionModel().select(-1);
					selectedAthletes.getItems().remove(s);
					count--;
					exception.setText("");
				}

			}
		});

	}

}
