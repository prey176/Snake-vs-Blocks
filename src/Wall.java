import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Wall {
	/**
	 * Length of wall
	 */
	private int len;
	private Rectangle rect =  new Rectangle();
	
	/**
	 * Constructor of Wall class
	 */
	public Wall() {
		rect.setFill(Color.WHITE);
		rect.setHeight(90);
		rect.setWidth(5);
	}
	
	/**
	 * 
	 * @return Rectangle
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * @param rect An object of class Rectangle
	 */
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	/**
	 * 
	 * @return Integer
	 */
	int getLen() {
		return len;
	}
	
	/**
	 * 
	 * @param ll An object of class Integer
	 */
	void setLen(int ll) {
		len=ll;
	}
}
