package application;

import javafx.beans.property.SimpleStringProperty;

/**
*
* Class Description: This class is used to create objects for TableView
* 
* @author : Eashan Tilve
*/
public class Results {

	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty time;
	private final SimpleStringProperty points;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param ActionEvent
	 * @return void
	 */
	public Results(String id, String name, String time, String points) {
		super();
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.time = new SimpleStringProperty(time);
		this.points = new SimpleStringProperty(points);
	}

	public String getId() {
		return id.get();
	}

	public String getName() {
		return name.get();
	}

	public String getTime() {
		return time.get();
	}

	public String getPoints() {
		return points.get();
	}
	
	public void setPoints(String points) {
		this.points.set(points);
	}

}
