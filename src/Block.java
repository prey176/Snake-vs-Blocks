import java.io.Serializable;
import java.util.Random;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Block implements Serializable{
	
	/**
	 * Value of the block
	 */
	private int Value;
	/**
	 * Colour of the block
	 */
	private String Colour;
	/**
	 * Size of the block
	 */
	private int Size;
	/**
	 * A text label for value of the block
	 */
	private Text Num;
	/**
	 * An array containing Rectangles displayed at the time the block gets burst
	 */
	private Rectangle[] burst_arr;
	/**
	 * Rectangle displayed on the screen to represent the block
	 */
	private Rectangle rect ; 
	
	/**
	 * Constructor of Block class
	 */
	public Block() {
		rect = new Rectangle();
		rect.setArcHeight(20);
		rect.setArcWidth(20);
		
		// DEFAULT VALUE
		Value=5;
		
		Num=new Text("BlockValue");
		Num.setText(Integer.toString(Value));
		Num.setFont(Font.font("jokerman",FontWeight.BOLD,FontPosture.REGULAR,20));
		Num.setX(100);
		Num.setY(100);
		Num.setFill(Color.BLACK);
		
		burst_arr=new Rectangle[4];

		for(int k=0;k<burst_arr.length;k++) {
			
			Random gen=new Random();
			
			burst_arr[k]=new Rectangle();
			burst_arr[k].setFill(Color.rgb(gen.nextInt(155)+100, gen.nextInt(155)+100,gen.nextInt(155)+100));
			burst_arr[k].setHeight(10);
			burst_arr[k].setWidth(10);
			burst_arr[k].setVisible(false);
		}
	}
	
	/**
	 * 
	 * @return Rectangle array
	 */
	public Rectangle[] getBurst_arr() {
		return burst_arr;
	}

	/**
	 * 
	 * @param burst_arr An object of class Rectangle array
	 */
	public void setBurst_arr(Rectangle[] burst_arr) {
		this.burst_arr = burst_arr;
	}

	/**
	 * 
	 * @return Text 
	 */
	public Text getNum() {
		return Num;
	}

	/**
	 * 
	 * @param num An object of class Text
	 */
	public void setNum(Text num) {
		Num = num;
	}

	/**
	 * 
	 * @return Rectangle
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * 
	 * @param r1 An object of class Rectangle
	 */
	public void setR1(Rectangle r1) {
		this.rect = r1;
	}
	
	/**
	 * Assigns color randomly to Block
	 */
	public void assignRandomColor() {
		Random generator = new Random() ;
		rect.setFill(Color.rgb(generator.nextInt(155)+100, generator.nextInt(155)+100,generator.nextInt(155)+100));
	}
	
	/**
	 * Assigns visibility randomly to Block
	 */
	public void assignRandomVisibility() {
		Random generator = new Random();
		boolean vis=generator.nextBoolean();
		rect.setVisible(vis);
		Num.setVisible(vis);
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
	 * @param ss An object of class String
	 */
	void setColour(String ss) {
		Colour=ss;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	int getSize() {
		return Size;
	}
	
	/**
	 * 
	 * @param pp An object of class Integer
	 */
	void setSize(int pp){
		Size=pp;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	int getValue() {
		return Value;
	}
	
	/**
	 * 
	 * @param v An object of class Integer
	 */
	void setValue(int v) {
		Value=v;
	}
	
	/**
	 * Initializes the position of rectangles which display when block bursts
	 */
	void initialize_pos() {
		
		for(int e=0;e<burst_arr.length;e++) {
			burst_arr[e].setX(this.rect.getLayoutX()+15);
			burst_arr[e].setY(this.rect.getLayoutY()+60);
		}
		
	}
	
	/**
	 * 
	 * @param change An object of class Integer
	 */
	void pos_change(int change) {
		
		burst_arr[0].setX(burst_arr[0].getX()-change);
		burst_arr[1].setY(burst_arr[1].getY()+change);
		burst_arr[2].setX(burst_arr[2].getX()+change);
		burst_arr[3].setY(burst_arr[3].getY()-change);
		
	}
	
	/**
	 * A counter used to measure delay time for displaying burst of Block
	 */
	int delaytime=1; 
	
	AnimationTimer delay = new AnimationTimer() {

		@Override
		public void handle(long now) {
			System.out.println("hello");
			if (delaytime%3==0) {
				if (delaytime%30==0) {
					delaytime = 1;
					for (int e  =0  ; e < 4 ; e++) {
						burst_arr[e].setVisible(false);
					}
					this.stop();
				}
				else {
					delaytime++;
					pos_change(10);
				}
			}
			else {
				delaytime++;
			}
			
		}
		
	};
	
	/**
	 * Bursts the block
	 */
	void burst() {
		initialize_pos();
		for(int e=0;e<burst_arr.length;e++) {	
			burst_arr[e].setVisible(true);
		}
		delay.start();
		
	}
	
	
}

