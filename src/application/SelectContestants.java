package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Driver;
import controller.GameFullException;
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
import model.Game;

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
		Driver driver = Ozlympic.driver;
		Game game = driver.getGame();
		ArrayList<Athlete> setAthletes = driver.getSelectedAthletes(selectedAthletes);
		game.assignContestants(setAthletes);
		Ozlympic.set_pane(Ozlympic.SELECT_OFFICIAL);

	}

	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}

	public void onClickBack(ActionEvent event) {

		System.out.println("Back..");
		Ozlympic.set_pane(Ozlympic.NEW_GAME);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ParticipantList participantList = Ozlympic.driver.getParticipantList();
		athletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		selectedAthletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		athletes.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ObservableList<String> selectedItems = athletes.getSelectionModel().getSelectedItems();
				for (@SuppressWarnings("unused")
				String s : selectedItems) {
					count++;
				}
				System.out.println("count " + count);
				if (count > MAX_ATHELETES) {
					try {
						throw new GameFullException();
					} catch (GameFullException e) {
						count = MAX_ATHELETES;
						exception.setText(e.getMessage());
					}
				} else {
				for (String s : selectedItems) {
					System.out.println("selected item " + s);
					selectedAthletes.getItems().add(s);
					athletes.getSelectionModel().select(-1);
					athletes.getItems().remove(s);
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

		for (Athlete athlete : participantList.getCyclists())
			athletes.getItems().add("CYCLIST " + athlete.toString());
		for (Athlete athlete : participantList.getSprinters())
			athletes.getItems().add("SPRINTER " + athlete.toString());
		for (Athlete athlete : participantList.getSwimmers())
			athletes.getItems().add("SWIMMER " + athlete.toString());
		for (Athlete athlete : participantList.getSuperAthletes())
			athletes.getItems().add("SUPER ATHLETE " + athlete.toString());

	}

}
