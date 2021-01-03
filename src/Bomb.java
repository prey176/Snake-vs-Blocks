import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Bomb extends Token implements Serializable{
	
	
	/**
	 * Constructor for Bomb class
	 */
	public Bomb() {
		 img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img4.png"));
	}
	
	
}

