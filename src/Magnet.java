import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Magnet extends Token implements Serializable{
	
	/**
	 * Distance of coin collection
	 */
	private int Distance;
	/**
	 * Time for which magnet remains active after it is taken by snake
	 */
	private int Duration;
	
	/**
	 * Constructor for the Magnet class
	 */
	public Magnet() {
		img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img.png"));
	}
	
	/**
	 * 
	 * @return Integer
	 */
	int getDistance(){
		return Distance;
	}
	

	/**
	 * 
	 * @return Integer
	 */
	int getDuration() {
		return Duration;
	}
	
	/**
	 * 
	 * @param aa An object of class Integer
	 */
	void setDistance(int aa) {
		Distance=aa;
	}
	
	/**
	 * 
	 * @param cc An object of class Integer
	 */
	void setDuration(int cc) {
		Duration=cc;
	}

}
