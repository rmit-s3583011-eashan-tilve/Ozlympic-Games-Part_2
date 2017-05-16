package application;

import java.net.URL;
import java.util.ResourceBundle;
import controller.Driver;
import controller.NoRefereeException;
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
import model.Game;
import model.Official;
/**
*
* Class Description: Controller class for SelectOfficial.fxml
* 
* @author : Eashan Tilve
*/
public class SelectOfficial implements Initializable {

	private static final String UNASSIGNED = "UNASSIGNED";
	@FXML
	private ListView<String> officials = new ListView<String>();

	@FXML
	private Label exception;

	private String official = UNASSIGNED;

	/**
	 * This method is called when the user clicks on Next
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public void onClickNext(ActionEvent event) {

		if (this.official.equals(UNASSIGNED)) {
			System.out.println("unassigned");
			try {
				throw new NoRefereeException();
			} catch (NoRefereeException e) {
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
			officials.getItems().clear();
			initializeList();
			this.official = UNASSIGNED;
		}

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
		Ozlympic.set_pane(Ozlympic.SELECT_CONTESTANTS);
		officials.getItems().clear();
		initializeList();
		this.official = UNASSIGNED;

	}

	private void initializeList() {
		ParticipantList participantList = Ozlympic.driver.getParticipantList();
		officials.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		for (Official official : participantList.getOfficials())
			officials.getItems().add(official.toString());
	}
	
	/**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initializeList();

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
