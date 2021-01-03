import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Special_Coin extends Token implements Serializable{
	
	/**
	 * Colour of Special Coin
	 */
	String Colour;
	/**
	 * Value of Special Coin
	 */
	final int Value=1;
	/**
	 * ImageView of Special Coin
	 */
	private ImageView img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img2.png"));
	
	/**
	 * Constructor of Special Coin
	 */
	public Special_Coin() {
		img = new ImageView(new Image("file:///C:/Users/sanjay%20rastogi/Desktop/img2.png"));
	}
	/**
	 * @return ImageView
	 */
	public ImageView getImg() {
		return img;
	}
	
	/**
	 * @param img An object of class ImageView
	 */
	public void setImg(ImageView img) {
		this.img = img;
	}
	
	/**
	 * 
	 * @return String
	 */
	String getColour() {
		return Colour;
	}
	
	/**
	 * 
	 * @param hh An object of class String
	 */
	void setColour(String hh) {
		Colour=hh;	
	}
	
	/**
	 * 
	 * @return Integer
	 */
	int getValue() {
		return Value;
	}
}
