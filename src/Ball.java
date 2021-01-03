
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
public class Ball {
	
	/**
	 * Radius of the ball
	 */
	private int Radius;
	
	/**
	 * Circle object displayed on scene which represents a Ball object
	 */
	Circle c ;
	
	/**
	 * Constructor for Ball class
	 * @param radius An object of class Integer
	 */
	public Ball( int radius) {
		c = new Circle(radius);
		c.setFill(Color.LIGHTSALMON);
	}
	
	/**
	 * 
	 * @param x An object of class Double
	 * @param y An object of class Double
	 * @param p An object of class Pane
	 */
	public void display(double x , double y , Pane p) {
		c.setLayoutX(x);
		c.setLayoutY(y);
		p.getChildren().add(c);
	}

	/**
	 * @return Integer
	 */
	int getRadius() {
		return Radius;
	}
	
	/**
	 * 
	 * @param rr An object of class Integer
	 */
	void setRadius(int rr) {
		Radius=rr;
	}
	
	
}
 
