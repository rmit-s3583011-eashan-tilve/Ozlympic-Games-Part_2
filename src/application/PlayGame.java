package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import controller.Driver;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.util.Duration;
import model.Athlete;
import model.Cycling;
import model.Game;
import model.Official;
import model.Running;
import model.Swimming;

public class PlayGame implements Initializable {

	private static final double WIDTH_OF_PATH = 95;
	private static final double CONTESTANT_SIZE = 30;
	private static final double INITIAL_X = 100;
	private static final double INITIAL_Y = 50;
	private ArrayList<ImageView> contestants = new ArrayList<ImageView>();
	private ArrayList<PathElement[]> paths = new ArrayList<PathElement[]>();
	private int numberOfContestants = 0;
	private static final int MAXIMUM_NUMBER_OF_CONTESTANTS = 8;
	private static final int CYCLING_FASTFORWARD = 60;
	private static final int SWIMMING_FASTFORWARD = 10;
	private static final int RUNNING_FASTFORWARD = 1;
	private Path road = new Path();
	private ArrayList<Label> names = new ArrayList<Label>();
	private ArrayList<Label> ids = new ArrayList<Label>();
	private ArrayList<Label> times = new ArrayList<Label>();
	private ArrayList<PathTransition> animations = new ArrayList<PathTransition>();
	private ArrayList<Circle> medals = new ArrayList<Circle>();

	@FXML
	private Circle gold;

	@FXML
	private Circle silver;

	@FXML
	private Circle bronze;

	@FXML
	private Label goldtext;

	@FXML
	private Label silvertext;

	@FXML
	private Label bronzetext;

	@FXML
	private Circle medal1;

	@FXML
	private Circle medal2;

	@FXML
	private Circle medal3;

	@FXML
	private Circle medal4;

	@FXML
	private Circle medal5;

	@FXML
	private Circle medal6;

	@FXML
	private Circle medal7;

	@FXML
	private Circle medal8;

	@FXML
	private Button back;

	@FXML
	private Button view;

	@FXML
	private Label referee;

	@FXML
	private Button start;

	@FXML
	private Button home;

	@FXML
	private Label name1;

	@FXML
	private Label time1;

	@FXML
	private Label name2;

	@FXML
	private Label time2;

	@FXML
	private Label name3;

	@FXML
	private Label time3;

	@FXML
	private Label name4;

	@FXML
	private Label time4;

	@FXML
	private Label name5;

	@FXML
	private Label time5;

	@FXML
	private Label name6;

	@FXML
	private Label time6;

	@FXML
	private Label name7;

	@FXML
	private Label time7;

	@FXML
	private Label name8;

	@FXML
	private Label time8;

	@FXML
	private Label id1;

	@FXML
	private Label id2;

	@FXML
	private Label id3;

	@FXML
	private Label id4;

	@FXML
	private Label id5;

	@FXML
	private Label id6;

	@FXML
	private Label id7;

	@FXML
	private Label id8;

	@FXML
	private Label fastForward;

	@FXML
	private ImageView rings;

	public void onClickStart(ActionEvent event) {
		Game game = Ozlympic.driver.getGame();
		home.setVisible(false);
		fastForward.setVisible(true);
		rings.setVisible(false);
		System.out.println(game.getCurrentGame());
		if (game.getCurrentGame() == Game.SWIMMING_ID) {
			fastForward.setText("Game Speed Fast Forwarded by: " + SWIMMING_FASTFORWARD + "x times");
			Swimming nowRunning = (Swimming) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants(nowRunning.getContestants());
			referee.setText(
					"Referee: " + nowRunning.getOfficial().getUniqueID() + "  " + nowRunning.getOfficial().getName());
			setSwimmers();
			competeRace(nowRunning.getContestants());
		}
		if (game.getCurrentGame() == Game.RUNNING_ID) {
			fastForward.setText("Game Speed Fast Forwarded by: " + RUNNING_FASTFORWARD + "x time");
			Running nowRunning = (Running) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants(nowRunning.getContestants());
			System.out.println(nowRunning.getOfficial());
			referee.setText(
					"Referee: " + nowRunning.getOfficial().getUniqueID() + "  " + nowRunning.getOfficial().getName());
			setRunners();
			competeRace(nowRunning.getContestants());
		}
		if (game.getCurrentGame() == Game.CYCLING_ID) {
			fastForward.setText("Game Speed Fast Forwarded by: " + CYCLING_FASTFORWARD + "x times");
			Cycling nowRunning = (Cycling) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants(nowRunning.getContestants());
			referee.setText(
					"Referee: " + nowRunning.getOfficial().getUniqueID() + "  " + nowRunning.getOfficial().getName());
			setCyclists();
			competeRace(nowRunning.getContestants());
		}
		view.setVisible(true);
		back.setVisible(false);
		start.setVisible(false);
	}

	private void initializeContestants(ArrayList<Athlete> arrayList) {
		for (int contestantNumber = 0; contestantNumber < numberOfContestants; contestantNumber++) {
			contestants.add(new ImageView());
			names.get(contestantNumber).setText(arrayList.get(contestantNumber).getName());
			ids.get(contestantNumber).setText(arrayList.get(contestantNumber).getUniqueID());
		}
	}

	private void setSwimmers() {

		for (ImageView contestant : contestants) {
			contestant.setImage(new Image("/application/images/swimming_icon.png"));
			contestant.setFitWidth(CONTESTANT_SIZE);
			contestant.setFitHeight(CONTESTANT_SIZE);
			contestant.setX(-contestant.getImage().getWidth() / 2);
			contestant.setY(300 - contestant.getImage().getHeight());
			contestant.setRotate(90);
			road.setStroke(Color.LIGHTSKYBLUE);
		}

	}

	private void setRunners() {

		for (ImageView contestant : contestants) {
			contestant.setImage(new Image("/application/images/running_icon.png"));
			contestant.setFitWidth(CONTESTANT_SIZE * 1.1);
			contestant.setFitHeight(CONTESTANT_SIZE * 1.1);
			contestant.setX(-contestant.getImage().getWidth() / 2);
			contestant.setY(300 - contestant.getImage().getHeight());
			contestant.setRotate(90);
			road.setStroke(Color.ORANGE);

		}

	}

	private void setCyclists() {

		for (ImageView contestant : contestants) {
			contestant.setImage(new Image("/application/images/cycling_icon.png"));
			contestant.setFitWidth(CONTESTANT_SIZE * 1.1);
			contestant.setFitHeight(CONTESTANT_SIZE * 1.1);
			contestant.setX(-contestant.getImage().getWidth() / 2);
			contestant.setY(300 - contestant.getImage().getHeight());
			contestant.setRotate(90);
			road.setStroke(Color.LIGHTGREEN);

		}

	}

	private void competeRace(ArrayList<Athlete> athletes) {
		assignPathsToAnimation(athletes);
		addAnimationsToRoot();
		runAnimation();

	}

	private void runAnimation() {
		for (PathTransition anim : animations) {
			anim.play();
		}
	}

	private void stopAnimation() {
		for (PathTransition anim : animations) {
			anim.stop();
		}
		List<AnchorPane> list = Ozlympic.getAnchorPane();
		AnchorPane root = list.get(Ozlympic.PLAY_GAME);
		root.getChildren().remove(road);
		for (ImageView contestant : contestants) {
			root.getChildren().remove(contestant);
		}
	}

	private void addAnimationsToRoot() {
		List<AnchorPane> list = Ozlympic.getAnchorPane();

		AnchorPane root = list.get(Ozlympic.PLAY_GAME);

		root.getChildren().addAll(road);
		int offset = 0;
		for (ImageView contestant : contestants) {
			offset += 20;
			root.getChildren().add(contestant);
			contestant.setTranslateX(INITIAL_X);
			contestant.setTranslateY(INITIAL_Y + offset);
		}
		road.setTranslateX(INITIAL_X);
		road.setTranslateY(INITIAL_Y);
	}

	private ArrayList<PathTransition> assignPathsToAnimation(ArrayList<Athlete> athletes) {

		for (int contestantNumber = 0; contestantNumber < numberOfContestants; contestantNumber++) {
			PathTransition anim = new PathTransition();
			anim.setNode(contestants.get(contestantNumber));

			Path path = new Path();
			path.getElements().addAll(paths.get(contestantNumber));
			path.setStroke(Color.RED);
			path.setTranslateX(INITIAL_X);
			path.setTranslateY(INITIAL_Y);
			path.setStrokeWidth(3);
			anim.setPath(path);
			anim.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
			anim.setInterpolator(Interpolator.LINEAR);
			float time = athletes.get(contestantNumber).compete();
			float durationOffset = setDurationOffset();
			this.addGameResult(time, contestantNumber);
			times.get(contestantNumber).setText(Float.toString(time));
			anim.setDuration(new Duration((1000 * time) / durationOffset));
			anim.setCycleCount(1);
			animations.add(anim);
		}

		return animations;
	}

	private void addGameResult(float time, int contestantNumber) {
		Driver driver = Ozlympic.driver;

		if (driver.getGame().getSelectedGame() instanceof Cycling) {
			Cycling game = (Cycling) Ozlympic.driver.getGame().getSelectedGame();
			game.recordAthleteTime(time, game.getContestants().get(contestantNumber));

		} else if (driver.getGame().getSelectedGame() instanceof Swimming) {
			Swimming game = (Swimming) Ozlympic.driver.getGame().getSelectedGame();
			game.recordAthleteTime(time, game.getContestants().get(contestantNumber));

		} else if (driver.getGame().getSelectedGame() instanceof Running) {
			Running game = (Running) Ozlympic.driver.getGame().getSelectedGame();
			game.recordAthleteTime(time, game.getContestants().get(contestantNumber));

		}
	}

	private int setDurationOffset() {
		Driver driver = Ozlympic.driver;
		int durationOffset = 1;
		if (driver.getGame().getSelectedGame() instanceof Cycling) {
			durationOffset = CYCLING_FASTFORWARD;
		} else if (driver.getGame().getSelectedGame() instanceof Swimming) {
			durationOffset = SWIMMING_FASTFORWARD;
		} else if (driver.getGame().getSelectedGame() instanceof Running) {
			durationOffset = RUNNING_FASTFORWARD;
		}
		return durationOffset;
	}

	private int getIndexFromIDs(String uniqueID) {

		for (Label id : ids) {
			if (id.getText().equals(uniqueID))
				return ids.indexOf(id);
		}

		return -1;
	}

	public void onClickBack(ActionEvent event) {
		Ozlympic.set_pane(Ozlympic.SELECT_OFFICIAL);

	}

	public void onClickView(ActionEvent event) {
		home.setVisible(true);
		fastForward.setVisible(false);
		visibilityMedals(true);
		for (int contestantNumber = 0; contestantNumber < numberOfContestants; contestantNumber++) {
			times.get(contestantNumber).setVisible(true);
		}
		Driver driver = Ozlympic.driver;
		if (driver.getGame().getSelectedGame() instanceof Cycling) {
			Cycling game = (Cycling) Ozlympic.driver.getGame().getSelectedGame();
			Official official = game.getOfficial();
			game.setContestants(official.computeWinners(game.getTimings()));
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setFill(Color.GOLD);
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setFill(Color.SILVER);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setFill(Color.DARKGOLDENROD);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setVisible(true);

		} else if (driver.getGame().getSelectedGame() instanceof Swimming) {
			Swimming game = (Swimming) Ozlympic.driver.getGame().getSelectedGame();
			Official official = game.getOfficial();
			game.setContestants(official.computeWinners(game.getTimings()));
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setFill(Color.GOLD);
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setFill(Color.SILVER);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setFill(Color.DARKGOLDENROD);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setVisible(true);
		} else if (driver.getGame().getSelectedGame() instanceof Running) {
			Running game = (Running) Ozlympic.driver.getGame().getSelectedGame();
			Official official = game.getOfficial();
			game.setContestants(official.computeWinners(game.getTimings()));
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setFill(Color.GOLD);
			medals.get(getIndexFromIDs(game.getContestants().get(0).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setFill(Color.SILVER);
			medals.get(getIndexFromIDs(game.getContestants().get(1).getUniqueID())).setVisible(true);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setFill(Color.DARKGOLDENROD);
			medals.get(getIndexFromIDs(game.getContestants().get(2).getUniqueID())).setVisible(true);
		}
		view.setVisible(false);
		if (driver.getParticipantList().getReadFrom().equals(driver.getParticipantList().DATABASE))
			Ozlympic.driver.addResultsToDatabase();
	}

	public void onClickHome(ActionEvent event) {
		back.setVisible(true);
		start.setVisible(true);
		rings.setVisible(true);
		Ozlympic.set_pane(Ozlympic.HOME);
		clearAll();
	}

	private void clearAll() {
		visibilityMedals(false);
		back.setVisible(true);
		start.setVisible(true);
		referee.setText("");
		view.setVisible(false);
		for (int number = 0; number < MAXIMUM_NUMBER_OF_CONTESTANTS; number++) {
			names.get(number).setText("");
			ids.get(number).setText("");
			times.get(number).setText("");
			times.get(number).setVisible(false);
			medals.get(number).setVisible(false);

		}
		stopAnimation();
		contestants.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initializePaths();
		initializeNames();
		initializeIDS();
		initializeTimes();
		fastForward.setVisible(false);
		initializeMedals();
		back.setVisible(true);
		start.setVisible(true);
		referee.setText("");
		view.setVisible(false);
		for (int number = 0; number < MAXIMUM_NUMBER_OF_CONTESTANTS; number++) {
			names.get(number).setText("");
			ids.get(number).setText("");
			times.get(number).setText("");
			times.get(number).setVisible(false);
			medals.get(number).setVisible(false);
		}

	}

	private void initializePaths() {

		double arcOffset = 0;
		double lineOffset = -2;
		double arcIncrement = 8;
		double lineIncrement = 10.8;
		final int ARC_RADII = 75;
		final int CORNER_VAL_1 = 40;
		final int CORNER_VAL_2 = 80;
		final int CORNER_VAL_3 = 320;
		final int CORNER_VAL_4 = 360;
		final int CORNER_VAL_5 = 100;
		final int CORNER_VAL_6 = 300;
		final int CORNER_VAL_7 = 400;
		final int X_OFFSET = 40;
		final int ZERO = 0;

		PathElement[] roadPath = { new MoveTo(ZERO - X_OFFSET, CORNER_VAL_6 + X_OFFSET),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_5 - X_OFFSET, CORNER_VAL_7 + X_OFFSET, false,
						false),
				new LineTo(CORNER_VAL_6 + X_OFFSET, CORNER_VAL_7 + X_OFFSET),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_7 + X_OFFSET, CORNER_VAL_6 + X_OFFSET, false,
						false),
				new LineTo(CORNER_VAL_7 + X_OFFSET, CORNER_VAL_5),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_6 + X_OFFSET, ZERO, false, false),
				new LineTo(CORNER_VAL_5 - X_OFFSET, ZERO),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, ZERO - X_OFFSET, CORNER_VAL_5, false, false),
				new LineTo(ZERO - X_OFFSET, CORNER_VAL_6 + X_OFFSET), new ClosePath() };
		road.setStrokeWidth(WIDTH_OF_PATH);
		road.getElements().addAll(roadPath);
		for (int index = 0; index < MAXIMUM_NUMBER_OF_CONTESTANTS; index++) {

			PathElement[] path = { new MoveTo(CORNER_VAL_1 - lineOffset - X_OFFSET, CORNER_VAL_3 + X_OFFSET),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_2 - X_OFFSET,
							CORNER_VAL_4 + lineOffset + X_OFFSET, false, false),
					new LineTo(CORNER_VAL_3 + X_OFFSET, CORNER_VAL_4 + lineOffset + X_OFFSET),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_4 + lineOffset + X_OFFSET,
							CORNER_VAL_3 + X_OFFSET, false, false),
					new LineTo(CORNER_VAL_4 + lineOffset + X_OFFSET, CORNER_VAL_2),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_3 + X_OFFSET,
							CORNER_VAL_1 - lineOffset, false, false),
					new LineTo(CORNER_VAL_2 - X_OFFSET, CORNER_VAL_1 - lineOffset),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_1 - lineOffset - X_OFFSET,
							CORNER_VAL_2, false, false),
					new LineTo(CORNER_VAL_1 - lineOffset - X_OFFSET, CORNER_VAL_3 + X_OFFSET), new ClosePath() };
			paths.add(path);
			arcOffset += arcIncrement;
			lineOffset += lineIncrement;

		}

	}

	private void initializeTimes() {
		times.add(time1);
		times.add(time2);
		times.add(time3);
		times.add(time4);
		times.add(time5);
		times.add(time6);
		times.add(time7);
		times.add(time8);
	}

	private void initializeIDS() {
		ids.add(id1);
		ids.add(id2);
		ids.add(id3);
		ids.add(id4);
		ids.add(id5);
		ids.add(id6);
		ids.add(id7);
		ids.add(id8);
	}

	private void initializeNames() {
		names.add(name1);
		names.add(name2);
		names.add(name3);
		names.add(name4);
		names.add(name5);
		names.add(name6);
		names.add(name7);
		names.add(name8);
	}

	private void initializeMedals() {
		medals.add(medal1);
		medals.add(medal2);
		medals.add(medal3);
		medals.add(medal4);
		medals.add(medal5);
		medals.add(medal6);
		medals.add(medal7);
		medals.add(medal8);
		gold.setFill(Color.GOLD);
		silver.setFill(Color.SILVER);
		bronze.setFill(Color.DARKGOLDENROD);
		visibilityMedals(false);
	}

	private void visibilityMedals(boolean value) {
		gold.setVisible(value);
		silver.setVisible(value);
		bronze.setVisible(value);
		goldtext.setVisible(value);
		silvertext.setVisible(value);
		bronzetext.setVisible(value);
	}

}
