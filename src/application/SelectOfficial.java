package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Driver;
import controller.NoRefereeException;
import database.ParticipantList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import model.Athlete;
import model.Game;
import model.Official;

public class SelectOfficial implements Initializable {

	private static final String UNASSIGNED = "UNASSIGNED";
	@FXML
	private ListView<String> officials = new ListView<String>();

	@FXML
	private Label exception;

	private String official = UNASSIGNED;

	public void onClickNext(ActionEvent event) {

		if (this.official.equals(UNASSIGNED)) {
			System.out.println("unassigned");
			try {
			throw new NoRefereeException();
			}catch(NoRefereeException e ) {
			exception.setText(e.getMessage());
			}

		} else {
			System.out.println("assigned");
			System.out.println("Next");
			Driver driver = Ozlympic.driver;
			Game game = driver.getGame();
			Official official = driver.getSelectedOfficial(this.official);
			game.assignOfficial(official);
			Ozlympic.set_pane(Ozlympic.PLAY_GAME);

		}

	}

	public void onClickExit(ActionEvent event) {

		System.out.println("Exiting..");
		System.exit(0);
	}

	public void onClickBack(ActionEvent event) {

		System.out.println("Back..");
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ParticipantList participantList = Ozlympic.driver.getParticipantList();
		officials.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		for (Official official : participantList.getOfficials())
			officials.getItems().add(official.toString());

		officials.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				ObservableList<String> selectedItems = officials.getSelectionModel().getSelectedItems();

				for (String s : selectedItems) {
					official = s;
					exception.setText("");

				}

			}
		});

	}

}
