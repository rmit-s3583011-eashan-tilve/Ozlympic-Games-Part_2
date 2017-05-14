package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Athlete;

public class AthleteStandings implements Initializable {

	@FXML
	private Button view;

	@FXML
	private ListView<String> athletes = new ListView<String>();

	@FXML
	private ImageView image = new ImageView();

	@FXML
	void onClickHome(ActionEvent event) {
		Ozlympic.set_pane(Ozlympic.HOME);
		this.athletes.setVisible(false);
		this.image.setVisible(true);

	}

	@FXML
	void onClickView(ActionEvent event) {
		athletes.getItems().clear();
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		athletes.addAll(Ozlympic.driver.getParticipantList().getSprinters());
		athletes.addAll(Ozlympic.driver.getParticipantList().getSuperAthletes());
		athletes.addAll(Ozlympic.driver.getParticipantList().getSwimmers());
		athletes.addAll(Ozlympic.driver.getParticipantList().getCyclists());
		Collections.sort(athletes, new AthleteCompare());

		for (Athlete athlete : athletes)
			this.athletes.getItems().add(athlete.getUniqueID() + ", " + athlete.getName() + ", "+athlete.getState() +", " + athlete.getPoints());
		this.image.setVisible(false);
		this.athletes.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.athletes.setVisible(false);
	}

}
