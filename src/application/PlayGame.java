package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import controller.Driver;
import controller.NoRefereeException;
import database.ParticipantList;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
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
	private final int MAXIMUM_NUMBER_OF_CONTESTANTS = 8;
	private Path road = new Path();

	public void onClickStart(ActionEvent event) {
		Game game = Ozlympic.driver.getGame();
		System.out.println(game.getCurrentGame());
		if (game.getCurrentGame() == Game.SWIMMING_ID) {
			Swimming nowRunning = (Swimming) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants();
			setSwimmers();
			competeRace();
		}
		if (game.getCurrentGame() == Game.RUNNING_ID) {
			Running nowRunning = (Running) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants();
			setRunners();
			competeRace();
		}
		if (game.getCurrentGame() == Game.CYCLING_ID) {
			Cycling nowRunning = (Cycling) game.getSelectedGame();
			numberOfContestants = nowRunning.getContestants().size();
			initializeContestants();
			setCyclists();
			competeRace();

		}
	}

	private void initializeContestants() {
		for (int contestantNumber = 1; contestantNumber <= numberOfContestants; contestantNumber++) {
			contestants.add(new ImageView());
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
			road.setStroke(Color.LIGHTBLUE);

		}

	}

	private void setRunners() {

		for (ImageView contestant : contestants) {
			contestant.setImage(new Image("/application/images/running_icon.png"));
			contestant.setFitWidth(CONTESTANT_SIZE*1.1);
			contestant.setFitHeight(CONTESTANT_SIZE*1.1);
			contestant.setX(-contestant.getImage().getWidth() / 2);
			contestant.setY(300 - contestant.getImage().getHeight());
			contestant.setRotate(90);
			road.setStroke(Color.ORANGE);

		}

	}
	
	private void setCyclists() {

		for (ImageView contestant : contestants) {
			contestant.setImage(new Image("/application/images/cycling_icon.png"));
			contestant.setFitWidth(CONTESTANT_SIZE*1.1);
			contestant.setFitHeight(CONTESTANT_SIZE*1.1);
			contestant.setX(-contestant.getImage().getWidth() / 2);
			contestant.setY(300 - contestant.getImage().getHeight());
			contestant.setRotate(90);
			road.setStroke(Color.LIGHTGREEN);

		}

	}
	private void competeRace() {

		Random r = new Random();
		ArrayList<PathTransition> animations = new ArrayList<PathTransition>();
		for (int contestantNumber = 0; contestantNumber < numberOfContestants; contestantNumber++) {
			PathTransition anim = new PathTransition();
			anim.setNode(contestants.get(contestantNumber));

			Path path = new Path();
			path.getElements().addAll(paths.get(contestantNumber));
			path.setStroke(Color.BLACK);
			path.setTranslateX(INITIAL_X);
			path.setTranslateY(INITIAL_Y);
			path.setStrokeWidth(WIDTH_OF_PATH);

			anim.setPath(path);
			anim.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
			anim.setInterpolator(Interpolator.LINEAR);
			anim.setDuration(new Duration(6000 + 200 * r.nextInt(10)));
			anim.setCycleCount(Timeline.INDEFINITE);
			animations.add(anim);
		}

		List<AnchorPane> list = Ozlympic.getAnchorPane();
		AnchorPane root = list.get(Ozlympic.PLAY_GAME);

		root.getChildren().add(road);
		int offset = 0;
		for (ImageView contestant : contestants) {
			offset += 20;
			root.getChildren().add(contestant);
			contestant.setTranslateX(INITIAL_X);
			contestant.setTranslateY(INITIAL_Y + offset);
		}
		road.setTranslateX(INITIAL_X);
		road.setTranslateY(INITIAL_Y);

		root.setOnMouseClicked(me -> {
			for (PathTransition anim : animations) {
				Animation.Status status = anim.getStatus();
				if (status == Animation.Status.RUNNING && status != Animation.Status.PAUSED)
					anim.pause();
				else {
					anim.play();
				}
			}

		});
	}

	public void onClickBack(ActionEvent event) {
		Ozlympic.set_pane(Ozlympic.SELECT_OFFICIAL);

	}

	public void onClickHome(ActionEvent event) {
		Ozlympic.set_pane(Ozlympic.HOME);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		double arcOffset = 0;
		double lineOffset = 0;
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
		final int ZERO = 0;

		PathElement[] roadPath = { new MoveTo(ZERO, CORNER_VAL_6),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_5, CORNER_VAL_7, false, false),
				new LineTo(CORNER_VAL_6, CORNER_VAL_7),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_7, CORNER_VAL_6, false, false),
				new LineTo(CORNER_VAL_7, CORNER_VAL_5),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, CORNER_VAL_6, ZERO, false, false),
				new LineTo(CORNER_VAL_5, ZERO),
				new ArcTo(CORNER_VAL_5, CORNER_VAL_5, ZERO, ZERO, CORNER_VAL_5, false, false),
				new LineTo(ZERO, CORNER_VAL_6), new ClosePath() };
		road.setStrokeWidth(WIDTH_OF_PATH);
		road.getElements().addAll(roadPath);
		for (int index = 0; index < MAXIMUM_NUMBER_OF_CONTESTANTS; index++) {

			PathElement[] path = { new MoveTo(CORNER_VAL_1 - lineOffset, CORNER_VAL_3),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_2,
							CORNER_VAL_4 + lineOffset, false, false),
					new LineTo(CORNER_VAL_3, CORNER_VAL_4 + lineOffset),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_4 + lineOffset,
							CORNER_VAL_3, false, false),
					new LineTo(CORNER_VAL_4 + lineOffset, CORNER_VAL_2),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_3,
							CORNER_VAL_1 - lineOffset, false, false),
					new LineTo(CORNER_VAL_2, CORNER_VAL_1 - lineOffset),
					new ArcTo(ARC_RADII + arcOffset, ARC_RADII + arcOffset, ZERO, CORNER_VAL_1 - lineOffset,
							CORNER_VAL_2, false, false),
					new LineTo(CORNER_VAL_1 - lineOffset, CORNER_VAL_3), new ClosePath() };
			paths.add(path);
			arcOffset += arcIncrement;
			lineOffset += lineIncrement;
		}

	}

}
