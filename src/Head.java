import java.io.Serializable;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */

class Head extends Ball implements Serializable{
	
	/**
	 * Length of Snake whose Head it is
	 */
	private int num_balls;
	
	/**
	 * A Label for the length of the snake
	 */
	private Label l = new Label() ;

	/**
	 * 
	 * @param radius An object of class Integer
	 */
	public Head(int radius) {
		
		super(radius);
		num_balls=0;
		l.setText(Integer.toString(0));
		l.setVisible(true);
		l.setId("label_forhead");		
	}
	
	/**
	 * @param x An object of class Double
	 * @param y An object of class Double
	 * @param p An object of class Pane
	 */
	public void display(double x , double y , Pane p) {
		super.display(x, y, p);
		l.setLayoutX(x-7);
		l.setLayoutY(y-20);
		p.getChildren().add(l);

	}
	
	/**
	 * @return Integer
	 */
	public int getNum_balls() {
		return num_balls;
	}

	/**
	 * 
	 * @param num_balls An object of class Integer
	 */
	public void setNum_balls(int num_balls) {
		this.num_balls = num_balls;
	}

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
	 * @return Circle
	 */
	public Circle getC() {
		return c;
	}

	/**
	 * 
	 * @param c An object of class Circle
	 */
	public void setC(Circle c) {
		this.c = c;
	}

	/**
	 * 
	 * @return Integer
	 */
	public int getNumBalls(){
		return num_balls;
	}
	
	/**
	 * 
	 * @param bb An object of class Integer
	 */
	public void setNumBalls(int bb) {
		num_balls=bb;
	}
}