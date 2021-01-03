import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
public class Instruction {
	
	/**
	 * Button for Main Menu
	 */
	public Button b;
	/**
	 * Homepage scene
	 */
	Scene mainmenu;
	/**
	 * Primary stage
	 */
	Stage window;
	/**
	 * A Label for heading 
	 */
	private Label Lb=new Label("Instructions ");
	/**
	 * 
	 * @param s An object of class Stage
	 * @param s1 An object of class Scene
	 */
	public Instruction(Stage s, Scene s1) {
		b=new Button("Main Menu");
		window=s;
		mainmenu=s1;
	}
	/**
	 * Displays the Instructions screen
	 */
	public void display() {
		Pane p= new Pane();
		
		Label instr1 = new Label() ;
		instr1.setText("1. Block Collision increases score");
		Label instr2 = new Label() ;
		instr2.setText("2. Shield, Magnet, Bomb are for resque");
		Label instr3 = new Label() ;
		instr3.setText("3. Play Hard!");
		instr1.setLayoutY(120);
		instr2.setLayoutY(180);
		instr3.setLayoutY(240);
		instr1.setId("label_forhead");
		instr2.setId("label_forhead");
		instr3.setId("label_forhead");
		
		p.getChildren().addAll(instr1,instr2,instr3);
		p.getChildren().add(b);
		p.getChildren().add(Lb);
		b.setOnAction(e -> window.setScene(mainmenu));
		b.setLayoutX(110);
		b.setLayoutY(422.5);
		b.setMinHeight(25);
		b.setMinWidth(80);
		b.setText("Main Menu");
		window.getScene().setRoot(p);
		Lb.setMinSize(80, 25);
		Lb.setLayoutX(62.5);
		Lb.setLayoutY(20);
		Lb.setId("gamename");
	}
	
}
