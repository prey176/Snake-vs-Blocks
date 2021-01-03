import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Shield extends Token implements Serializable{
	
	/**
	 * Duration of time for which shield remains active after it is taken by snake  
	 */
	private int Duration;
	
	/**
	 * Constructor for Shield class
	 */
	public Shield() {
		img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img1.jpg"));
	}
		
	/**
	 * 
	 * @return Integer
	 */
	int getDuration(){
		return Duration;
	}
	
	/**
	 * 
	 * @param d An object of class Integer
	 */
	void setDuration(int d) {
		// uml no param
		
		Duration=d;
	}
}