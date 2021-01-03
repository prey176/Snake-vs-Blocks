import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;


/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
public class mainpage extends Application {
   
	/**
	 * An object of class PlayGame
	 */
	PlayGame playgame = null;
	
	/**
	 * Primary stage
	 */
	private Stage window = new Stage();
	/**
	 * Stores the scene of the mainpage
	 */
	private Scene home; 
	/**
	 * Leaderboard of the game
	 */
	private Leaderboard l =  null; 
	/**
	 * Label for the game's name
	 */
	private Label gamename = new Label("Snake Vs. Block");
	/**
	 * Button for the game's leaderboard
	 * Takes player to the leaderboard 
	 * 
	 */
	private Button leaderboard  = new Button() ;
	/**
	 * Play button for the game
	 * Takes user to the game screen 
	 */
	private Button play  = new Button();
	/**
	 * How to play button for the game
	 * Takes user to the Instructions screen
	 */
	private Button htplay=new Button();
	/**
	 * Exit button for the game
	 */
	private Button exit = new Button();
	/**
	 * TextField for entering Player Name
	 */
	private TextField textfield = new TextField() ; 
	/**
	 * 
	 * @return TextField
	 */
	public TextField getTextfield() {
		return textfield;
	}
	/**
	 * 
	 * @param textfield An object of class TextField
	 */
	public void setTextfield(TextField textfield) {
		this.textfield = textfield;
	}
	
	
	/**
	 * 
	 * @return PlayGame
	 */
	public PlayGame getPlaygame() {
		return playgame;
	}

	/**
	 * 
	 * @param playgame An object of class PlayGame
	 */
	public void setPlaygame(PlayGame playgame) {
		this.playgame = playgame;
	}

	/**
	 * 
	 * @return Stage
	 */
	public Stage getWindow() {
		return window;
	}

	/**
	 * 
	 * @param window An object of class Stage
	 */
	public void setWindow(Stage window) {
		this.window = window;
	}

	/**
	 * 
	 * @return Scene
	 */
	public Scene getHome() {
		return home;
	}

	/**
	 * 
	 * @param home An object of class Scene
	 */
	public void setHome(Scene home) {
		this.home = home;
	}

	/**
	 * 
	 * @return Leaderboard
	 */
	public Leaderboard getL() {
		return l;
	}

	/**
	 * 
	 * @param l An object of class Leaderboard  
	 */
	public void setL(Leaderboard l) {
		this.l = l;
	}

	/**
	 * 
	 * @return Label
	 */
	public Label getGamename() {
		return gamename;
	}

	/**
	 * 
	 * @param gamename An object of class Label
	 */
	public void setGamename(Label gamename) {
		this.gamename = gamename;
	}

	/**
	 * 
	 * @return Button
	 */
	public Button getLeaderboard() {
		return leaderboard;
	}

	/**
	 * 
	 * @param leaderboard An object of class Leaderboard
	 */
	public void setLeaderboard(Button leaderboard) {
		this.leaderboard = leaderboard;
	}
	
	/**
	 * 
	 * @return Button
	 */
	public Button getPlay() {
		return play;
	}

	/**
	 * 
	 * @param play An object of class Button
	 */
	public void setPlay(Button play) {
		this.play = play;
	}
	
	/**
	 * 
	 * @return Button
	 */
	public Button getHtplay() {
		return htplay;
	}

	/**
	 * 
	 * @param htplay An object of class Button
	 */
	public void setHtplay(Button htplay) {
		this.htplay = htplay;
	}
	
	/**
	 * 
	 * @return Button
	 */
	public Button getExit() {
		return exit;
	}
	
	/**
	 * 
	 * @param exit An object of class Button
	 */
	public void setExit(Button exit) {
		this.exit = exit;
	}
	
	/**
	 * Launches application
	 * @param args String arguments
	 *  
	 */
	public static void main(String[] args) {
        launch(args);
    }
	
	/**
	 * Initializes label of the game's name
	 */
	public void init_gamename_label() {
        gamename.setId("gamename");
        gamename.setLayoutX(40);
        gamename.setLayoutY(0);
        gamename.setMinWidth(150);
        gamename.setMinHeight(50);       
	}
	
	/**
	 * Redirects player to the leaderboard screen when leaderboard button is pressed
	 */
	public void leaderboardbuttonclicked() {
		
        System.out.println("LeaderBoard!");
        Pane mmm  = new Pane() ;
        Scene s = new Scene(mmm,300,450) ;
        s.getStylesheets().add("mainpage_css.css");
        window.setScene(s);
        if (l==null)
        	deser_leaderboard();
        if (l==null) {
        	System.out.println("HELLO");
			l = new Leaderboard();
		}
        l.display(window,home);
	}
	
	/**
	 * Initializes the leaderboard button of the game
	 */
	public void init_leaderboard_button() {
		//l =  new Leaderboard(home);
        leaderboard.setLayoutX(100);
        leaderboard.setLayoutY(225);
        leaderboard.setMinSize(100, 30);
        leaderboard.setId("homepage_button");
        leaderboard.setText("LeaderBoard");
        leaderboard.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                leaderboardbuttonclicked();
            }
        });
	}
	
	/**
	 * Redirects player to the game screen and starts a new game
	 */
	public void newgame() {
		HBox s = new HBox();
        Scene temp ; 
        temp  = new Scene (s,300,450);
       
        temp.getStylesheets().add("mainpage_css.css");
        window.setScene(temp);
        

    	playgame = new PlayGame(window,home,temp,this) ;
    	playgame.Play();
	}
	
	/**
	 * Handles the event when the play button is clicked
	 */
	public void playbuttonclicked() {
    	
		if (playgame==null) {
			newgame();
	    }
		else {
			if (!playgame.isGameover() ) {
				boolean temp = Resume.display();
				if (temp) {
					window.setScene(playgame.getHome());
					playgame.pause_game();	
				}
				else {
					newgame();
				}
			}
			else {
				newgame();
			}
		}

	}
	
	/**
	 * Initializes the play button of the game screen 
	 * Defines event handler for play button
	 */
	public void init_play_button() {

        play.setText("Play");
		play.setId("homepage_button");
        play.setLayoutX(125);
        play.setLayoutY(150);
        play.setMinSize(50,30);
        play.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	playbuttonclicked();
            }
        });
	}
	
	/**
	 * Initializes how to play button
	 * Defines event handler for how to play button
	 */
	public void init_htplay_button() {
		htplay.setLayoutX(100);
		htplay.setLayoutY(300);
		htplay.setMinSize(50, 30);
		htplay.setId("homepage_button");
		htplay.setText("How to Play");
        
		htplay.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("How to Play!");
                Pane mmm2  = new Pane() ;
                Scene s = new Scene(mmm2,300,450) ;
                window.setScene(s);
                s.getStylesheets().add("mainpage_css.css");
                
                Instruction instr=new Instruction(window,home);
                instr.display();
                
                //window.setScene(s);
                

            }
        });
	}
	
	/**
	 * Initializes exit button
	 * Defines event handler for exit button
	 */
	public void init_exit_button() {
        exit.setLayoutX(125);
        exit.setLayoutY(375);
        exit.setMinSize(50, 30);
        exit.setId("homepage_button");
        exit.setText("Exit");
        
        
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	
            	ser_leaderboard();
            	closeprogram();
            	window.close();
            }
        });
        
	}
    
	/**
	 * Serializes leaderboard of the game
	 */
	public void ser_leaderboard() {
		
		try {
    		FileOutputStream fos=new FileOutputStream("leaderboard.txt");
    		ObjectOutputStream oos=new ObjectOutputStream(fos);
    		
    		oos.writeObject(l);
    		
    		oos.flush();
    		oos.close();
    		
    	}catch(IOException e) {
    		System.out.println("Exception occurred: "+e);
    		//System.exit(0);
    	}
		
	}
	
	/**
	 * Deserializes leaderboard of the game
	 */
	public void deser_leaderboard() {
		
		try {
			FileInputStream fis=new FileInputStream("leaderboard.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			l=(Leaderboard)ois.readObject();
		
			if(l==null) {
				System.out.println("PPPP");
				l=new Leaderboard();
			}
			
			ois.close();
			
		}catch(Exception e) {
			System.out.println("----++++______");
			l=new Leaderboard();
		}
	}
	
	/**
	 * Starts the application
	 */
    @Override
    public void start(Stage primaryStage) {
    	
    	window = primaryStage;
        window.setTitle("Snake Vs. Block");
        
        init_gamename_label();
        init_play_button();
        init_leaderboard_button();
        init_exit_button();  
        init_htplay_button();
        textfield.setLayoutX(100);
        textfield.setLayoutY(80);
        textfield.setMinSize(100, 30);
//        textfield.setId("homepage_button");
        textfield.setPromptText("Enter Name");
//        textfield.setText("LeaderBoard");
        
        //window.setOnCloseRequest(e->closeprogram());
         
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
        	 
            @Override
            public void handle(WindowEvent event) {
            	
//            	ser_leaderboard();
            	closeprogram();
            	window.close();
            }
        });
        
        Pane p  = new Pane();
        p.getChildren().addAll(gamename,play,htplay,leaderboard,exit,textfield);
        
        home = new Scene(p,300,450);
        home.getStylesheets().add("mainpage_css.css");
               
        window.setScene(home);
        window.show();

       
        
    }
    
    /**
     *	Closes the program 
     */
    public void closeprogram() {
 
    	System.out.println("GAME CLOSED");
    	
    }
    
}
