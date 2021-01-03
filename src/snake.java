import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
//public class snake extends Application implements Serializable{
public class snake  implements Serializable{

	/**
	 * Length of snake	
	 */
	private int len;
	/**
	 * Head of snake
	 */
	private Head hd;
	/**
	 * Body of snake, a List of Balls
	 */
	private ArrayList<Ball> body ;
	/**
	 * Current position of snake
	 */
	private int pos;
	/**
	 * Boolean variable to tell whether snake is alive or not
	 */
	private boolean alive;
	/**
	 * Constructor of snake class
	 */
	public snake() {

		burst_arr=new Circle[4];

		for(int k=0;k<burst_arr.length;k++) {
			
			Random gen=new Random();
			
			burst_arr[k]=new Circle();
			//burst_arr[k].setFill(Color.rgb(gen.nextInt(155)+100, gen.nextInt(155)+100,gen.nextInt(155)+100));
			burst_arr[k].setRadius(4);
			burst_arr[k].setVisible(false);
			burst_arr[k].setFill(Color.CYAN);
		}
		body = new ArrayList<Ball>();
		hd = new Head(10) ;
		hd.getC().setLayoutX(100);
		hd.getC().setLayoutY(185);
	}
	
	int getLen(){
		return len;
	}
	
	void setLen(int l) {
		len=l;
	}
	
	int getPos() {
		return pos;
	}
	
	void setPos(int x) {
		pos=x;
	}
	
	Head getHead() {
		return hd;
	}
	
	void setHead(Head h) {
		hd=h;
	}
	
	ArrayList<Ball> getBody() {
		return body;
	}
	
	void setBody(ArrayList<Ball> bl) {
		body=bl;
	}
	
	boolean getAlive(){
		return alive;
	}
	
		
	void setAlive(boolean al){
		alive=al;
	}
	
	void left() {
		
	}
	
	void right() {
		
	}
	
	void forward() {
		
	}
	
	void collect_token(Ball ba) {
		
	}
	
	void collect_token(Bomb bo) {
		
	}
	
	void collect_token(Shield sh) {
		
	}
	
	void collect_token(Magnet ma) {
		
	}
	/**
	 * An array of Circles to display burst of snake's body
	 */
	private Circle[] burst_arr;

	/**
	 * 
	 * @param change An object of class Integer
	 */
	void pos_change(int change) {
		
		burst_arr[0].setLayoutX(burst_arr[0].getLayoutX()-change);
		burst_arr[1].setLayoutY(burst_arr[1].getLayoutY()+change);
		burst_arr[2].setLayoutX(burst_arr[2].getLayoutX()+change);
		burst_arr[3].setLayoutY(burst_arr[3].getLayoutY()-change);
		
	}
	
	/**
	 * Displays the burst of snake 
	 */
	void startburst() {
		
		for(int e=0;e<burst_arr.length;e++) {
			burst_arr[e].setLayoutX(this.hd.getC().getLayoutX());
			burst_arr[e].setLayoutY(this.hd.getC().getLayoutY());
		}
		for(int e=0;e<burst_arr.length;e++) {	
			burst_arr[e].setVisible(true);
		}
		
	}
	
	public Head getHd() { 
		return hd;
	}

	public void setHd(Head hd) {
		this.hd = hd;
	}

	public Circle[] getBurst_arr() {
		return burst_arr;
	}

	public void setBurst_arr(Circle[] burst_arr) {
		this.burst_arr = burst_arr;
	}
	
	/**
	 * Updates the length of snake by x units 
	 * @param x An object of class Integer
	 * @param g An object of class PlayGame
	 */
	public void update_length(int x,PlayGame g) {
		setLen(getLen()+x);
		Pane p = new Pane() ;
		double val = hd.getC().getLayoutX();
		hd.display(val, 200-15, p);
		double temp = 0 ;
		this.getHead().setNumBalls(this.getHead().getNumBalls()+x);
		this.getHead().getL().setText(Integer.toString(this.getHead().getNum_balls()));
		if (body.size()==0) {
			temp=200;
		}
		else {
			temp  = body.get(body.size()-1).c.getLayoutY() + 5;
		}
		for(int i=0;i<x;i++) {
			Ball b  = new Ball(5); 
			b.c.setLayoutX(val);
			b.c.setLayoutY(temp+10*i);
			p.getChildren().add(b.c);
			body.add(b);
		}
		g.getWindow().getScene().setRoot(p);
		display(0,g);
		
	}
	
	/**
	 * Decreases length of snake by one unit
	 * @param g An object of class PlayGame
	 */
	public void decrease_length(PlayGame g) {
		if (body.size()!=0) {
			// proper decrease
			
			this.getHead().setNumBalls(this.getHead().getNumBalls()-1);
			this.getHead().getL().setText(Integer.toString(this.getHead().getNum_balls()));
			body.remove(body.size()-1);
			setLen(getLen()-1);
			
			display(0,g);
		}
		else {
			g.animation.stop();
			g.temp.stop();
			System.out.println("ho gaya...........!!!!!!!!!!!!!!!!!!!!!");
//			g.getWindow().setScene(new Scene (null,300,400));
//			g.getWindow().getScene().
			g.getWindow().setScene(g.getMainmenu());
		}
	}
	
	/**
	 * Displays the snake  
	 * @param change An object of class Integer
	 * @param g An object of class PlayGame
	 */
	public void display(int change ,PlayGame g ) {
		
		
		Pane p = new Pane();

		
		for (int i = 0 ; i < 5 ; i++) {
			p.getChildren().add(g.getRow1()[i].getRect());
		}
	

		for (int i = 0 ; i < 5 ; i++) {
			p.getChildren().add(g.getRow1()[i].getNum());
		}
	
		for(int e=0;e<g.getRow1()[0].getBurst_arr().length;e++) {
			
			for (int i = 0 ; i < 5 ; i++) {
				p.getChildren().add(g.getRow1()[i].getBurst_arr()[e]);
			}
			

		}
			
		p.getChildren().add(g.getMagnet1().getImg());
		p.getChildren().add(g.getShield1().getImg());
		p.getChildren().add(g.getScoin1().getImg());
		p.getChildren().add(g.getCoin1().getImg());
		p.getChildren().add(g.getCoin2().getImg());
		p.getChildren().add(g.getCoin1().getL());
		p.getChildren().add(g.getCoin2().getL());
		p.getChildren().add(g.getBomb1().getImg());	

		for (int i = 0 ; i  <4 ; i++)
			p.getChildren().add(g.getWall1()[i].getRect());

		
		int val  =(int)hd.c.getLayoutX() ; 
		
		System.out.println(val+change);
		if (val+change<20) {
			hd.display(20,200+ 85, p);
			
		}
		else if (val+change > 280) {
			hd.display(280, 200+85, p);
		}
		else {
			hd.display(val+change, 200+85, p);
		}
		
		for(int e=0;e<burst_arr.length;e++) {
			p.getChildren().add(burst_arr[e]);
		}
		
		for (int i = 0 ; i < body.size() ; i++) {
			
			if ((val+change>=20) &&(val+change<=280)) {
				body.get(i).display(val+change, 100+200+10*i, p); 	
			}
			else {
				if (val+change < 20) 
					body.get(i).display(20, 100+200+10*i, p); 
				else
					body.get(i).display(280, 100+200+10*i, p); 	
			}
		}
		p.getChildren().add(g.getBottomLabel());
		p.getChildren().add(g.getTopLabel());

		p.getChildren().add(g.getPlayerScore());
		p.getChildren().add(g.getDisplayPlayerScore());
		p.getChildren().add(g.getDisplayGameScore());
		p.getChildren().add(g.getGameScore());
		p.getChildren().add(g.getTimerforshield());
		
		p.getChildren().add(g.getPauseButton());
		p.getChildren().add(g.getMMButton());
		p.getChildren().add(g.getRestartgame());
//		Scene s = new Scene(p,300,450);
//		s.setRoot(p); 
		g.getWindow().getScene().setRoot(p);
//		g.getWindow().setScene(s);
		g.getWindow().getScene().setOnKeyPressed(g);
		
	
	}
	
//	public void start(Stage mystage){
			
	//		HBox pane=new HBox(10);
	//		pane.setAlignment(Pos.CENTER);
	//		Button b=new Button("Ok");
	//		Button c=new Button("Cancel");
	//		OkHandlerClass handlegetRect()=new OkHandlerClass();
	//		b.setOnAction(handlegetRect());
	//		
	//		CancelHandlerClass handler2=new CancelHandlerClass();
	//		c.setOnAction(handler2);
	//		
	//		pane.getChildren().addAll(b,c);
			
//			Scene sc=new Scene(new Button("OK"),100,100);
//			mystage.setTitle("First JavaFX");
//			mystage.setScene(sc);
//			mystage.show();
			
	//		Stage stage=new Stage();
	//		stage.setTitle("Second stage");
	//		stage.setScene(new Scene(new Button("OK"),100,100));
	//		stage.show();
	
//	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		launch(args);
	}

}
