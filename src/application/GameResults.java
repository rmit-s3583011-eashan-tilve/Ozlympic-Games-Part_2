package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Callback;
import model.Athlete;
import model.Cycling;
import model.Game;
import model.Running;
import model.Swimming;

public class GameResults implements Initializable {
	@FXML
	private ImageView image;  
	@FXML
	private Label gameID;
	@FXML
	private Label refereeID;
	@FXML
	private Label gametime;
	@FXML
	private Circle gold;
	@FXML
	private Circle silver;
	@FXML
	private Circle bronze;
	@FXML
	private Button view;
	@FXML
	private ImageView medal;
	@FXML
	private TableColumn<Results, String> id;
	@FXML
	private TableColumn<Results, String> name;
	@FXML
	private TableColumn<Results, String> time;
	@FXML
	private TableColumn<Results, String> points;
	@FXML
	private TableView<Results> table;
	@FXML
	private Pagination pagination;
	public ObservableList<Results> list = FXCollections.observableArrayList();

	public void onClickHome(ActionEvent event) {
		Ozlympic.set_pane(Ozlympic.HOME);
		view.setVisible(true);
		table.setVisible(false);
		pagination.setVisible(false);
		medal.setVisible(true);
		gameID.setVisible(false);
		refereeID.setVisible(false);
		gametime.setVisible(false);
		gold.setVisible(false);
		silver.setVisible(false);
		bronze.setVisible(false);
		image.setVisible(false);


	}
	
	public void onClickView(ActionEvent event) {
		view.setVisible(false);
		
		Game games = Ozlympic.driver.getGame();
		if(games.getGames().size() > 0) {
			table.setVisible(true);
			pagination.setVisible(true);
			medal.setVisible(false);
			gameID.setVisible(true);
			refereeID.setVisible(true);
			gametime.setVisible(true);
			gold.setVisible(true);
			silver.setVisible(true);
			bronze.setVisible(true);
			image.setVisible(true);

		}
		else {
			refereeID.setVisible(true);
			refereeID.setText("YOU HAVE NOT PLAYED ANY GAMES YET!");
		}
		pagination.setCurrentPageIndex(0);
		pagination.setPageCount(games.getGames().size());
		
	}

	private void showGameResult(Integer pageIndex) {
		list.clear();
		System.out.println(pageIndex);
		Game games = Ozlympic.driver.getGame();
		System.out.println("PAGINATION");
		if (games.getGames().size() > 0 && pageIndex < games.getGames().size()) {
			if (Ozlympic.driver.getGame().getGames().get(pageIndex) instanceof Cycling) {
				Cycling game = (Cycling) Ozlympic.driver.getGame().getGames().get(pageIndex);
				for (Athlete athlete : game.getContestants()) {
					list.add(new Results(athlete.getUniqueID(), athlete.getName(),
							Float.toString(game.getTimings().get(athlete)), "0"));
				}
				image.setImage(new Image("/application/images/cycling.png"));
				gameID.setText("GAME: "+game.getGameID());
				refereeID.setText("REFEREE: "+game.getOfficial().getName());
				gametime.setText("TIME: "+game.getGameTime());
			} else if (Ozlympic.driver.getGame().getGames().get(pageIndex) instanceof Swimming) {
				Swimming game = (Swimming) Ozlympic.driver.getGame().getGames().get(pageIndex);
				for (Athlete athlete : game.getContestants()) {
					list.add(new Results(athlete.getUniqueID(), athlete.getName(),
							Float.toString(game.getTimings().get(athlete)), "0"));
				}
				image.setImage(new Image("/application/images/swimming.png"));
				gameID.setText("GAME: "+game.getGameID());
				refereeID.setText("REFEREE: "+game.getOfficial().getName());
				gametime.setText("TIME: "+game.getGameTime());
			} else if (Ozlympic.driver.getGame().getGames().get(pageIndex) instanceof Running) {
				Running game = (Running) Ozlympic.driver.getGame().getGames().get(pageIndex);
				for (Athlete athlete : game.getContestants()) {
					list.add(new Results(athlete.getUniqueID(), athlete.getName(),
							Float.toString(game.getTimings().get(athlete)), "0"));
				}
				image.setImage(new Image("/application/images/running.png"));
				gameID.setText("GAME: "+game.getGameID());
				refereeID.setText("REFEREE: "+game.getOfficial().getName());
				gametime.setText("TIME: "+game.getGameTime());
			}
			list.get(0).setPoints("5");
			list.get(1).setPoints("2");
			list.get(2).setPoints("1");
		}
	}

	public Node createPage(int pageIndex) {
		Label label = new Label();
		return label;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<Results, String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Results, String>("name"));
		time.setCellValueFactory(new PropertyValueFactory<Results, String>("time"));
		points.setCellValueFactory(new PropertyValueFactory<Results, String>("points"));
		table.setItems(list);
		image.setVisible(false);
		pagination.setPageCount(2);
		pagination.setMaxPageIndicatorCount(10);
		view.setVisible(true);
		table.setVisible(false);
		pagination.setVisible(false);
		medal.setVisible(true);
		gameID.setVisible(false);
		refereeID.setVisible(false);
		gametime.setVisible(false);
		gold.setVisible(false);
		silver.setVisible(false);
		bronze.setVisible(false);
		
		pagination.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer pageIndex) {
				showGameResult(pageIndex);
				return createPage(pageIndex);
			}
		});
	}

}
