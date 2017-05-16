package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Athlete;

public class AthleteStandings implements Initializable {

	@FXML
	private Button view;
	@FXML
	private TableColumn<Results, String> id;
	@FXML
	private TableColumn<Results, String> name;
	@FXML
	private TableColumn<Results, String> state;
	@FXML
	private TableColumn<Results, String> points;
	@FXML
	private TableView<Results> athletes;
	public ObservableList<Results> list = FXCollections.observableArrayList();

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
		list.clear();
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		athletes.addAll(Ozlympic.driver.getParticipantList().getSprinters());
		athletes.addAll(Ozlympic.driver.getParticipantList().getSuperAthletes());
		athletes.addAll(Ozlympic.driver.getParticipantList().getSwimmers());
		athletes.addAll(Ozlympic.driver.getParticipantList().getCyclists());
		Collections.sort(athletes, new AthleteCompare());

		for (Athlete athlete : athletes) {
			list.add(new Results(athlete.getUniqueID(), athlete.getName(), athlete.getState(),
					Integer.toString(athlete.getPoints())));
		}
		this.athletes.setVisible(true);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.athletes.setVisible(false);
		id.setCellValueFactory(new PropertyValueFactory<Results, String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Results, String>("name"));
		state.setCellValueFactory(new PropertyValueFactory<Results, String>("time"));
		points.setCellValueFactory(new PropertyValueFactory<Results, String>("points"));
		athletes.setItems(list);
	}

}
