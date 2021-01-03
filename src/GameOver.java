import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
public class GameOver {
	
	/**
	 * Main Stage
	 */
	static Stage window = new Stage();
	
	/**
	 * Button for Back to Menu
	 */
	static Button backtoMM = new Button(); 
	
	/**
	 * A Label for heading
	 */
	static Label heading  = new  Label() ;
	
	/**
	 * Game screen
	 */
	static PlayGame playgame = null ;
	
	/**
	 * A Button for Try Again
	 */
	static Button tryagain = new Button();
	
	/**
	 * A Label for the Score of the Player in the game which just got over
	 */
	static Label Score  = new Label() ;
	
	/**
	 * Displays the GameOver screen 
	 */
	public static void display(PlayGame g) {
		window = g.getWindow();
		Pane p = new Pane();
		heading.setText("Game Over");
		heading.setId("gamename");
		heading.setLayoutX(60);
	    heading.setLayoutY(50);
	    heading.setMinWidth(150);
	    heading.setMinHeight(50);       
		
		backtoMM.setText("Back to Main Menu");
		backtoMM.setId("homepage_button");
		backtoMM.setLayoutX(80);
		backtoMM.setLayoutY(350);
		backtoMM.setMinSize(50,30);
        
		backtoMM.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				window.setScene(g.getMainmenu());
			}
		});
		
		
		tryagain.setText("TRY AGAIN");
		tryagain.setId("homepage_button");
		tryagain.setLayoutX(80);
		tryagain.setLayoutY(250);
		tryagain.setMinSize(50,30);
        
		tryagain.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				playgame.getMpage().newgame();
//			window.setScene(g.getMainmenu());
			}
		});
		
		Score.setText("Score : " + Integer.toString(playgame.getGscore()));
		Score.setId("homepage_button");
		Score.setLayoutX(80);
		Score.setLayoutY(150);
		Score.setMinSize(50,30);
		
		p.getChildren().addAll(backtoMM,heading,tryagain,Score);
		Scene s = new Scene(p,300,450 );
		s.getStylesheets().add("mainpage_css.css");
		window.setScene(s);
	}
	

}
