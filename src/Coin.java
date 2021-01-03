import java.io.Serializable;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Coin extends Token implements Serializable{
	
	/**
	 * Value of coin
	 */
	private int Value;
	/**
	 * A Label to display value of coin
	 */
	private Label l = new Label();
	
	
	/**
	 * 
	 * @return Label
	 */
	public Label getL() {
		return l;
	}

	/**
	 * 
	 * @param l An object of class Label
	 */
	public void setL(Label l) {
		this.l = l;
	}


	/**
	 * 
	 * @return Integer
	 */
	public int getValue() {
		return Value;
	}

	/**
	 * 
	 * @param value An object of class Integer
	 */
	public void setValue(int value) {
		Value = value;
	}

	/**
	 * Constructor of Coin class
	 */
	public Coin() {
		img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img3.png"));
		l.setId("label_forhead");
	}
	
	
}