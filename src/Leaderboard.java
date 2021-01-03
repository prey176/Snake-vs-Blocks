import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Leaderboard implements Serializable{
	
	/**
	 * A List of Players
	 */
	private ArrayList<Player> playerList;
	/**
	 * Constructor of class Leaderboard
	 */
	public Leaderboard() {
		playerList = new ArrayList<Player>();
	}
	/**
	 * Adds a Player to Leaderboard 
	 * @param ply An object of class Player
	 */
	void add_Player(Player ply) {
		playerList.add(ply);
	}
	/**
	 * 
	 * @return ArrayList of Players
	 */
	ArrayList<Player> getPlayerList(){
		return playerList;
	}
	/**
	 * 
	 * @param plyr A List of Players
	 */
	void setPlayerList(ArrayList<Player> plyr){
		playerList=plyr;
	}
	
	/**
	 * 
	 * @param window An object of class Stage
	 * @param mainmenu An object of class Scene
	 */
	public void display(Stage window , Scene mainmenu) {
		
		Button BTMenu=new Button("BTMenu");
			

		BTMenu.setLayoutX(110);
		BTMenu.setLayoutY(422.5);
		BTMenu.setMinWidth(80);
		BTMenu.setMaxHeight(25);
		BTMenu.setText("Main Menu");
		BTMenu.setOnAction(e -> {
			System.out.println("MAINMENU RETURNED");
			window.setScene(mainmenu);	
		});
	
//		playerList.add(new Player("QWERTYUIOP",10));
//		playerList.add(new Player("PPPLLL",11));
//		playerList.add(new Player("PPAAAPP",12));
//		playerList.add(new Player("PPPP",10));
//		playerList.add(new Player("PPPLLL",19991));
//		playerList.add(new Player("PPAAAPP",12));
//		playerList.add(new Player("PPPP",10));
//		playerList.add(new Player("PPPLLL",11));
//		playerList.add(new Player("PPAAAPP",12));
		
		
//		Plater ipl = new Player
		playerList.sort(new abc());
		
		Scene s = window.getScene() ;
		Pane  p  = new Pane();  
		Label heading  = new Label() ;
		heading.setText("LEADERBOARD");
		heading.setId("Leaderboard_heading");
		heading.setMinWidth(250);
		heading.setLayoutX(40);
		heading.setLayoutY(20);
		p.getChildren().add(heading);
		p.getChildren().add(BTMenu);
		
		
		for (int i = 0 ; i < min(playerList.size() , 10) ; i++) {
			
			Label temp1 = new Label() ;
			Label temp2 = new Label() ;
			Label temp3 = new Label() ;
//			Label temp4 = new Label() ; 
			
			temp1.setText((i+1) + ". " );
			temp1.setLayoutX(10);
			temp1.setLayoutY(100+30*i);
			
			String temp = playerList.get(i).getName().substring(0,min(8,playerList.get(i).getName().length()));
			temp2.setText(temp);
			temp2.setLayoutX(50);
			temp2.setLayoutY(100+30*i);
			
			int temporary = playerList.get(i).getHighest_score();
			temp3.setText(Integer.toString(temporary));
			temp3.setLayoutX(180);
			temp3.setLayoutY(100+30*i);
			
			
			
//			playerList.get(i).getName().substring(0,min(playerList.get(i).getName().length(),8)).toString() + " " + playerList.get(i).getHighest_score());
//			temp.setLayoutX(0);
			
//			temp.wrapTextProperty();
//			temp.setLayoutY(100+30*i);
			temp1.setId("Leaderboard_list");
			temp2.setId("Leaderboard_list");
			temp3.setId("Leaderboard_list");
			p.getChildren().addAll(temp1,temp2,temp3);
		}
		s.setRoot(p);
		
	}
	
	/** 
	 * Returns minimum of Integers a and b
	 * @param a An object of class Integer
	 * @param b An object of class Integer
	 * @return Integer
	 */
	private int min(int a, int b) {
		// TODO Auto-generated method stub
		return a>b?b:a;
	}
}

