import java.awt.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
public class Resume {
	
	/**	
	 * Button for resuming the game
	 */
	static Button yesbutton = new Button(); 
	
	/**
	 * Button for not resuming the previous game and starting with a new game
	 */
	static Button nobutton  = new Button();
	
	/**
	 * A label for the question asked to resume the game
	 */
	static Label ques = new Label();
	
	/**
	 * A boolean attribute which stores whether the player wants to resume the game or not 
	 */
	static boolean answer = false;
	
	
	/**
	 * Displays the screen for resuming the game
	 * @return boolean
	 */
	public static boolean display() {
		Stage window = new Stage() ; 
		window.initModality(Modality.APPLICATION_MODAL);
		Pane p = new Pane () ;
		
		ques.setText("Do you want to Resume");
		ques.setLayoutX(5);
		ques.setLayoutY(5);
		ques.setTextFill(Color.RED);
		ques.setFont(javafx.scene.text.Font.font(14));
		
		yesbutton.setText("Yes");
		nobutton.setText("No");
		
		yesbutton.setLayoutX(5);
		yesbutton.setLayoutY(40);

		nobutton.setLayoutX(55);
		nobutton.setLayoutY(40);
		
		yesbutton.setOnAction(e -> { 
			answer =true;
			window.close();
		});
		
		nobutton.setOnAction(e ->  {
			answer=  false; 
			window.close();
		});
		
		Scene s = new Scene(p,180,80) ; 
		p.getChildren().addAll(ques,yesbutton,nobutton);

		window.setScene(s);
		window.showAndWait();
		return answer; 
		
	}


}
