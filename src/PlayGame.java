import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayGame  implements EventHandler<KeyEvent>{
	
	/**
	 * An object of class snake
	 */
	private snake hiss ; 
	/**
	 * Primary stage
	 */
	private Stage window ;
	/**
	 * A row of Blocks
	 */
	private Block row1[] = new Block[5] ; 
	/**
	 * Homepage scene
	 */
	private Scene home ;
	/**
	 * A boolean variable which tells if game is over or not
	 */
	private boolean gameover = false;
	/**
	 * A Button to restart the game
	 */
	private Button restartgame = new Button();
	/**
	 * A Label for timer of shield
	 */
	private Label timerforshield = new Label();
	/**
	 * An object of ExecutorService for doing multithreading
	 */
	ExecutorService  exec = Executors.newCachedThreadPool();

	
	public ExecutorService getExec() {
		return exec;
	}

	public void setExec(ExecutorService exec) {
		this.exec = exec;
	}

	public Button getRestartgame() {
		return restartgame;
	}

	public void setRestartgame(Button restartgame) {
		this.restartgame = restartgame;
	}

	public mainpage getMpage() {
		return mpage;
	}

	public void setMpage(mainpage mpage) {
		this.mpage = mpage;
	}

	public Label getTimerforshield() {
		return timerforshield;
	}

	public void setTimerforshield(Label timerforshield) {
		this.timerforshield = timerforshield;
	}

	public boolean isGameover() {
		return gameover;
	}

	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}

	private Coin coin2  = new Coin();
	private Coin coin1  = new Coin();

	private Magnet magnet1  = new Magnet();
	private Bomb bomb1  = new Bomb();
	private Shield shield1 = new Shield();
	private Special_Coin scoin1 = new Special_Coin();
	private Wall wall1[] = new Wall[4];
	
	private Label bottomLabel = new Label() ;
	private Label topLabel = new Label() ;
	
	private Label PlayerScore  = new Label() ;
	private Label GameScore = new Label() ;
	
	private Scene mainmenu; 
	private boolean shield=false;
	
	private Label DisplayPlayerScore  = new Label();
	private Label DisplayGameScore = new Label();
	
	public Label getDisplayGameScore() {
		return DisplayGameScore;
	}

	public void setDisplayGameScore(Label displayGameScore) {
		DisplayGameScore = displayGameScore;
	}

	public Scene getMainmenu() {
		return mainmenu;
	}

	public void setMainmenu(Scene mainmenu) {
		this.mainmenu = mainmenu;
	}

	public long getAaa() {
		return aaa;
	}

	public void setAaa(long aaa) {
		this.aaa = aaa;
	}

	private int pscore =0; 
	private int gscore=0; 
	
	private Button MMButton=new Button("MMButton");
	private Button PauseButton=new Button("Pause");
	
	public long aaa=1;
	
	public Coin getCoin1() {
		return coin1;
	}
	
	public Coin getCoin2() {
		return coin2;
	}

	public Wall[] getWall1() {
		return wall1;
	}

	public void setWall1(Wall wall1[]) {
		this.wall1 = wall1;
	}

	public void setCoin1(Coin coin1) {
		this.coin1 = coin1;
	}
	public void setCoin2(Coin coin2) {
		this.coin2 = coin2;
	}

	public Magnet getMagnet1() {
		return magnet1;
	}

	public void setMagnet1(Magnet magnet1) {
		this.magnet1 = magnet1;
	}

	public Bomb getBomb1() {
		return bomb1;
	}

	public void setBomb1(Bomb bomb1) {
		this.bomb1 = bomb1;
	}

	public Shield getShield1() {
		return shield1;
	}

	public void setShield1(Shield shield1) {
		this.shield1 = shield1;
	}

	public Special_Coin getScoin1() {
		return scoin1;
	}

	public void setScoin1(Special_Coin scoin1) {
		this.scoin1 = scoin1;
	}
	
	public Label getPlayerScore() {
		return PlayerScore;
	}

	public void setPlayerScore(Label playerScore) {
		PlayerScore = playerScore;
	}

	public Label getGameScore() {
		return GameScore;
	}

	public void setGameScore(Label gameScore) {
		GameScore = gameScore;
	}

	public int getPscore() {
		return pscore;
	}

	public void setPscore(int pscore) {
		this.pscore = pscore;
	}

	public int getGscore() {
		return gscore;
	}

	public void setGscore(int gscore) {
		this.gscore = gscore;
	}

	public snake getHiss() {
		return hiss;
	}

	public void setHiss(snake hiss) {
		this.hiss = hiss;
	}

	public Label getTopLabel() {
		return topLabel;
	}

	public void setTopLabel(Label topLabel) {
		this.topLabel = topLabel;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}
	
	/**
	 * A method for moving down row of objects, tokens and wall on the screen
	 * @param change An object of class Integer
	 */
	public void movedown(int change) {
		
		
		for (int i = 0 ; i < 5;i++) {
			getRow1()[i].getRect().setLayoutY(getRow1()[i].getRect().getLayoutY() + change);
			getRow1()[i].getNum().setY(getRow1()[i].getNum().getY() + change);
		}
		
		
		getCoin1().getImg().setLayoutY(getCoin1().getImg().getLayoutY()+change);
		getCoin2().getImg().setLayoutY(getCoin2().getImg().getLayoutY()+change);
		getCoin1().getL().setLayoutY(getCoin1().getL().getLayoutY()+change);
		getCoin2().getL().setLayoutY(getCoin2().getL().getLayoutY()+change);
		getBomb1().getImg().setLayoutY(getBomb1().getImg().getLayoutY()+change);
		getMagnet1().getImg().setLayoutY(getMagnet1().getImg().getLayoutY()+change);
		getScoin1().getImg().setLayoutY(getScoin1().getImg().getLayoutY()+change);
		getShield1().getImg().setLayoutY(getShield1().getImg().getLayoutY()+change);
		for (int i = 0 ; i < 4 ; i++)
			getWall1()[i].getRect().setLayoutY(getWall1()[i].getRect().getLayoutY()+change);
		
		
	}
	
	int value = 1 ;
	
	AnimationTimer temp=  new AnimationTimer() {

		@Override
		public void handle(long now) {
	
			if (value==1) {
				hiss.startburst();
			}
			
			if (value%2==0 ) {
				// cry
				
				hiss.pos_change(2);
				if (value%20==0) {
					value=1;
					
					animation.start();
					for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
						hiss.getBurst_arr()[i].setVisible(false);
					}
					this.stop();
					
				}
				else {
					value++;
				}
			}
			
			System.out.println("hello" + value);
			value+=1;

		
		}
		
	};
	
	
	
	int sheildtime = 0 ;
	
	public boolean isShield() {
		return shield;
	}

	public void setShield(boolean shield) {
		this.shield = shield;
	}

	public int getSheildtime() {
		return sheildtime;
	}

	public void setSheildtime(int sheildtime) {
		this.sheildtime = sheildtime;
	}

	public AnimationTimer getForsheild() {
		return forsheild;
	}

	public void setForsheild(AnimationTimer forsheild) {
		this.forsheild = forsheild;
	}

	AnimationTimer forsheild=  new AnimationTimer() {

		@Override
		public void handle(long now) {
			// TODO Auto-generated method stub

			System.out.println("HAS SHIELD " + sheildtime);
			if (getSheildtime()==400) {
				setSheildtime(0);
				this.stop();
				shield=false;
				getTimerforshield().setVisible(false);
			}
			else {
				getTimerforshield().setVisible(true);
				getTimerforshield().setText(Integer.toString(6-sheildtime/60));
				sheildtime++;
			}
			
		}
		
	};
	
	/**
	 * Calls update_length method of snake
	 * @param val An object of class Integer
	 */
	public void callsnakeupdatelength(int val) {
		hiss.update_length(val, this);
	}
	
	/**
	 * Displays GameOver screen when snake dies
	 */
	public void gameover() {
		
		if (mpage.getL()==null)
			mpage.setL(new Leaderboard());
		mpage.getL().add_Player(new Player("PREYANSH",this.gscore));	
	
		
		animation.stop();
		gameover=true;
		GameOver.playgame=this;
		GameOver.display(this);
	}
	
	public Block[] getRow1() {
		return row1;
	}

	public void setRow1(Block[] row1) {
		this.row1 = row1;
	}
	
//	SPECIAL COIN COLLISION

	int[] q= {1,1,1,1,1,1};
	
	/**
	 * Handles collision of snake with Special Coin
	 */
	public void collisionwithspecialcoin() {
		scoin1.setPython(hiss);
		exec.execute(scoin1);
		if (scoin1.isActive()) {
			hiss.startburst();
			
			getScoin1().getImg().setVisible(false);
			pscore++;
			DisplayPlayerScore.setText(Integer.toString(pscore));
			scoin1.setActive(false);
			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[5]%2==0) {
						hiss.pos_change(2);
						if (q[5]%20==0) {
							q[5]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[5]++;
						}
					}
					else {
						q[5]++;
					}
					
				}
				
			};
			delay.start();
		}
				
	}
	
	/**
	 * Handles collision of snake with Shield
	 */
//	SHIELD COLLISION
	public void collisionwithshield() {
		shield1.setPython(hiss);
		exec.execute(shield1);
		if (shield1.isActive()) {
			hiss.startburst();

			shield=true;
			getShield1().getImg().setVisible(false);
			forsheild.start();
			shield1.setActive(false);
			
			
			
			
			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[0]%2==0) {
						hiss.pos_change(2);
						if (q[0]%20==0) {
							q[0]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[0]++;
						}
					}
					else {
						q[0]++;
					}
					
				}
				
			};
			delay.start();
			
		}

	}
	
	
	/**
	 * Handles collision of snake with Coin1
	 */
//	COIN1 COLLISION
	public void collisionwithcoin1() {
		coin1.setPython(hiss);
		exec.execute(coin1);
		if (coin1.isActive()) {
			hiss.startburst();
			callsnakeupdatelength(Integer.parseInt(coin1.getL().getText()));
			getCoin1().getImg().setVisible(false);
			getCoin1().getL().setVisible(false);
			coin1.setActive(false);

			
			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[1]%2==0) {
						hiss.pos_change(2);
						if (q[1]%20==0) {
							q[1]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[1]++;
						}
					}
					else {
						q[1]++;
					}
					
				}
				
			};
			delay.start();
		}
		
	}
	
	/**
	 * Handles Collision of snake with Coin2
	 */
//	COIN2 COLLISION
	public void collisionwithcoin2() {
		coin2.setPython(hiss);
		exec.execute(coin2);
		if (coin2.isActive()) {
			hiss.startburst();
			callsnakeupdatelength(Integer.parseInt(coin2.getL().getText()));
			getCoin2().getImg().setVisible(false);
			getCoin2().getL().setVisible(false);
			coin2.setActive(false);

			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[2]%2==0) {
						hiss.pos_change(2);
						if (q[2]%20==0) {
							q[2]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[2]++;
						}
					}
					else {
						q[2]++;
					}
					
				}
				
			};
			delay.start();
		}
		
	}
	
	/**
	 * Handles collision of snake with Bomb
	 */
//	BOMB COLLISION
	public void collisionwithbomb() {
		bomb1.setPython(hiss);
		exec.execute(bomb1);
		
		if (bomb1.isActive()) {
			bomb1.setActive(false);
			hiss.startburst();
			getBomb1().getImg().setVisible(false);
			
			for (int i = 0 ; i < 5 ; i++) {
				if (getRow1()[i].getRect().isVisible()) {
					getRow1()[i].getRect().setVisible(false);
					getRow1()[i].getNum().setVisible(false);
					getRow1()[i].burst();
				}
			}

			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[3]%2==0) {
						hiss.pos_change(2);
						if (q[3]%20==0) {
							q[3]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[3]++;
						}
					}
					else {
						q[3]++;
					}
					
				}
				
			};
			delay.start();
		}

	}

	/**
	 * Handles collision of snake with Magnet
	 */
//	MAGNET COLLISION
	public void collisionwithmagnet() {
		magnet1.setPython(hiss);
		exec.execute(magnet1);
		if (magnet1.isActive()) {
			hiss.startburst();
			getMagnet1().getImg().setVisible(false);
			if (getCoin1().getImg().isVisible()) {
				callsnakeupdatelength(Integer.parseInt(coin1.getL().getText()));
				getCoin1().getImg().setVisible(false);
				getCoin1().getL().setVisible(false);
				magnet1.setActive(false);
			}
			if (getCoin2().getImg().isVisible()) {
				callsnakeupdatelength(Integer.parseInt(coin2.getL().getText()));
				getCoin2().getImg().setVisible(false);
				getCoin1().getL().setVisible(false);
				magnet1.setActive(false);
			}
			AnimationTimer delay = new AnimationTimer() {

				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					
					if (q[4]%2==0) {
						hiss.pos_change(2);
						if (q[4]%20==0) {
							q[4]=1;
							for (int i = 0 ; i < hiss.getBurst_arr().length ; i++) {
								hiss.getBurst_arr()[i].setVisible(false);
							}
							this.stop();
							
						}
						else {
							q[4]++;
						}
					}
					else {
						q[4]++;
					}
					
				}
				
			};
			delay.start();

		}
	}
	
	/**
	 * Handles collision of snake with Block
	 */
//	BLOCK COLLISION
	public void collisionwithblock() {
		double posB1=getRow1()[0].getRect().getLayoutY()+60;
		double poshiss=hiss.getHead().getC().getLayoutY();
		
		if(Math.abs(posB1-poshiss)<=4) {
			System.out.println("PPPPPPPPPP");
			double temp1=hiss.getHead().getC().getLayoutX();
			
			int index = (int)temp1/60;
			if (shield) {
				if (getRow1()[index].getRect().isVisible()) {

					gscore+=Integer.parseInt(getRow1()[index].getNum().getText());
					DisplayGameScore.setText(Integer.toString(gscore));
					getRow1()[index].getRect().setVisible(false);
					getRow1()[index].getNum().setVisible(false);
					getRow1()[index].burst();
			
				}
				
			}
			if(getRow1()[index].getRect().isVisible()) {
				if (Integer.parseInt(getRow1()[index].getNum().getText()) <=0) {
					getRow1()[index].getRect().setVisible(false);
					// new code {
						getRow1()[index].burst();
						// status -> working
					//  } new code close
					getRow1()[index].getNum().setText("0");
					getRow1()[index].getNum().setVisible(false);
					movedown(+3);
					
				}
				else {
					
					if (hiss.getBody().size()==0) {
						System.out.println("-----------------------------------------------------------------------");
						gameover();
					}
					else {
						//SNAKE CRY
						//SNAKE CRY
						//SNAKE CRY
						//SNAKE CRY
						//SNAKE CRY
						//SNAKE CRY
						//Preyansh CRY
						
						gscore++;
						DisplayGameScore.setText(Integer.toString(gscore));
						call_decrease_length();
						getRow1()[index].getNum().setText( Integer.toString(Integer.parseInt(getRow1()[index].getNum().getText())-1 )  );
						movedown(-3);
						value=1;
						temp.start();
						animation.stop();
					}
				}

			}
				
		
		}
	}
	
	int randomtokenvalue = 0; 
	
	
	AnimationTimer animation = new AnimationTimer() {

		@Override
		public void handle(long now) {
			temp.stop();
			movedown(3);
			System.out.println("WORKING");
			
			
//			SPECIAL COIN COLLISION
			collisionwithspecialcoin();
			
//			SHIELD COLLISION
			collisionwithshield();
	
//			COIN1 COLLISION
			collisionwithcoin1();
			
//			COIN2 COLLISION
			collisionwithcoin2();

//			BOMB COLLISION
			collisionwithbomb();
			
//			MAGNET COLLISION
			collisionwithmagnet();
			
//			BLOCK COLLISION 
			collisionwithblock();
			
			System.out.println(getRow1()[0].getRect().getLayoutY());
			System.out.println(getRow1()[0].getNum().getY());
			if (getRow1()[0].getRect().getLayoutY() > 430) {
				
				randomtokenvalue++;
				
				Random generator=new Random();
				
				int token_genx=generator.nextInt(275)+10;
				int token_geny=generator.nextInt(150)-500;
				
				if (randomtokenvalue==200) {
					randomtokenvalue=0;
				}
				
				if (shield1.getImg().getLayoutY() > 430) {
					if (randomtokenvalue%8==1) {
						shield1.getImg().setLayoutX(token_genx);
						shield1.getImg().setLayoutY(token_geny);
						shield1.getImg().setVisible(true);	
					}
				}
				
				if (magnet1.getImg().getLayoutY() > 430) {
					if (randomtokenvalue%8==5) {
						magnet1.getImg().setLayoutX(token_genx);
						magnet1.getImg().setLayoutY(token_geny);
						magnet1.getImg().setVisible(true);
					}
				}
				if (bomb1.getImg().getLayoutY() > 430) {
					if (randomtokenvalue%8==3) {
						bomb1.getImg().setLayoutX(token_genx);
						bomb1.getImg().setLayoutY(token_geny);
						bomb1.getImg().setVisible(true);
					}
				}
				
				if (scoin1.getImg().getLayoutY() > 430) {
					if (randomtokenvalue%8==2) {
						scoin1.getImg().setLayoutX(token_genx);
						scoin1.getImg().setLayoutY(token_geny);
						scoin1.getImg().setVisible(true);	
					}
				}
				
				
				
				if (coin1.getImg().getLayoutY() > 430) {
					coin1.getImg().setLayoutY(generator.nextInt(100)-350);
					coin1.getImg().setLayoutX(generator.nextInt(280)+10);
					coin1.getL().setLayoutY(coin1.getImg().getLayoutY());
					coin1.getL().setLayoutX(coin1.getImg().getLayoutX());
					coin1.getL().setText(Integer.toString(generator.nextInt(10)+5));
					coin1.getImg().setVisible(true);
					coin1.getL().setVisible(true);
				}
				
				if (coin2.getImg().getLayoutY() > 430) {
					coin2.getImg().setLayoutY(generator.nextInt(100)-350);
					coin2.getImg().setLayoutX(generator.nextInt(280)+10);
					coin2.getL().setLayoutY(coin2.getImg().getLayoutY());
					coin2.getL().setLayoutX(coin2.getImg().getLayoutX());
					coin2.getL().setText(Integer.toString(generator.nextInt(10)+5));
					coin2.getImg().setVisible(true);
					coin2.getL().setVisible(true);
				}
				
				boolean checktemp = true;
				
				for (int i =0 ; i < 5 ; i++) {
					getRow1()[i].getRect().setLayoutY(-200);
					getRow1()[i].getNum().setY(-165);
					getRow1()[i].assignRandomColor();
					getRow1()[i].assignRandomVisibility();
					checktemp = (checktemp)&&(getRow1()[i].getRect().isVisible());
				}			
				
				if (hiss.getLen()==0) {
					if (checktemp) {
						// there is a path
					}
					else {
						int removeblock = generator.nextInt(5);
						getRow1()[removeblock].getRect().setVisible(false);
						getRow1()[removeblock].getNum().setVisible(false);
					}
					for (int i = 0 ; i < 5 ; i++) {
						if (getRow1()[i].getRect().isVisible()) {
							getRow1()[i].getNum().setText(Integer.toString(hiss.getLen()+generator.nextInt(10)+1));
						}
					}
				}
				else {

					int removeblock1 = generator.nextInt(5);
					int removeblock2 = generator.nextInt(5);
					if (!checktemp) {
						removeblock1 = -1;
						removeblock2 = -1;
						System.out.println("last moment check last moment check");
					}
					for (int i = 0 ; i < 5 ; i++) {
						if (i!=removeblock1 && i!=removeblock2) {
							getRow1()[i].getNum().setText(Integer.toString(hiss.getLen()+generator.nextInt(10)+1));
						}
						else {
							getRow1()[i].getNum().setText(Integer.toString(generator.nextInt(hiss.getLen())+1));
						}
					}
					
				}
				
			}
			
			
		
			
			
			
			for (int i = 0 ;i  < 4 ; i++) {
				if (wall1[i].getRect().getLayoutY() > 430) {
					wall1[i].getRect().setLayoutY(-200);
					Random generator = new Random();
					wall1[i].getRect().setHeight(generator.nextInt(60)+90);
					wall1[i].getRect().setVisible(generator.nextBoolean());
				}
			}
		}
		
	};
	
	public Label getDisplayPlayerScore() {
		return DisplayPlayerScore;
	}

	public void setDisplayPlayerScore(Label displayPlayerScore) {
		DisplayPlayerScore = displayPlayerScore;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public AnimationTimer getTemp() {
		return temp;
	}

	public void setTemp(AnimationTimer temp) {
		this.temp = temp;
	}
	
	/**
	 * Calls decrease_length method of snake
	 */
	public void call_decrease_length() {
		hiss.decrease_length(this);
	}
	
	public Stage getWindow() {
		return window;
	}
	
	public PlayGame() {
		
	}
	
	/**
	 * An object of class mainpage
	 */
	private mainpage mpage  = new mainpage(); 

	/**
	 * Constructor of class PlayGame
	 * @param s An object of class Stage
	 * @param lll An object of class Scene 
	 * @param pppp An object of class Scene
	 * @param mmmm An object of class mainpage
	 */
	public PlayGame(Stage s , Scene lll, Scene pppp, mainpage mmmm) {
		window = s;
		hiss = new snake();
		
		for (int i = 0 ; i < 5 ; i++) {
			row1[i] = new Block();
		}
		for (int i = 0 ;  i < 4 ;i++)
			wall1[i] = new Wall();
		coin1=  new Coin();
		coin2 = new Coin();
		mainmenu= lll;
		home  = pppp;
		mpage =  mmmm;
	}
	
	public Scene getHome() {
		return home;
	}

	public void setHome(Scene home) {
		this.home = home;
	}
	/**
	 * Initializes row1 of Blocks
	 */
	public void init_row1() {
		for (int i = 0 ; i < 5 ; i++) {
			row1[i].assignRandomColor();
			row1[i].assignRandomVisibility();
			row1[i].getRect().setHeight(56);
			row1[i].getRect().setWidth(56);
			row1[i].getRect().setLayoutX(60*i);
			row1[i].getRect().setLayoutY(-1000);
			row1[i].getNum().setX(60*i + 20);
			row1[i].getNum().setY(-965);
		}
	}
	
	/**
	 * Initializes Top Label of Game Screen
	 */
	public void init_topLabel() {
		topLabel.setMinHeight(30);
		topLabel.setMinWidth(300);
		topLabel.setLayoutY(0);
		topLabel.setLayoutX(0);
		topLabel.setId("abc");		
	}
	
	/**
	 * Initializes Bottom Label of Game Screen
	 */
	public void init_bottomLabel() {
		bottomLabel.setMinHeight(30);
		bottomLabel.setMinWidth(300);
		bottomLabel.setLayoutY(420);
		bottomLabel.setLayoutX(0);
		bottomLabel.setId("abc");
		
	}
	
	/**
	 * Initializes Shield of GameScreen 
	 */
	public void init_Shield1() {

		this.shield1.getImg().setLayoutX(150);
		this.shield1.getImg().setLayoutY(1000);
		this.shield1.getImg().setFitHeight(30);
		this.shield1.getImg().setFitWidth(30);
	}
	
	/**
	 * Initializes Special Coin of Game Screen
	 */
	public void init_Scoin1() {

		this.scoin1.getImg().setLayoutX(50);
		this.scoin1.getImg().setLayoutY(1000);
		this.scoin1.getImg().setFitHeight(30);
		this.scoin1.getImg().setFitWidth(30);
	}
	
	/**
	 * Initializes Bomb of Game Screen
	 */
	public void init_Bomb1() {

		this.bomb1.getImg().setLayoutX(150);
		this.bomb1.getImg().setLayoutY(1000);
		this.bomb1.getImg().setFitHeight(30);
		this.bomb1.getImg().setFitWidth(30);
		
		
	}
	
	/**
	 * Initializes Magnet of Game Screen
	 */
	public void init_Magnet1() {
		
		this.magnet1.getImg().setLayoutX(250);
		this.magnet1.getImg().setLayoutY(1000);
		this.magnet1.getImg().setFitHeight(30);
		this.magnet1.getImg().setFitWidth(30);
	}
	
	/**
	 * Initializes Coin1 of Game Screen
	 */
	public void init_Coin1() {

		this.coin1.getImg().setLayoutX(50);
		this.coin1.getImg().setLayoutY(1000);
		this.coin1.getImg().setFitHeight(30);
		this.coin1.getImg().setFitWidth(30);
		this.coin1.getL().setLayoutX(50);
		this.coin1.getL().setLayoutY(990);
	}
	
	/**
	 * Initializes Coin2 of Game Screen
	 */
	public void init_Coin2() {

		this.coin2.getImg().setLayoutX(50);
		this.coin2.getImg().setLayoutY(1000);
		this.coin2.getImg().setFitHeight(30);
		this.coin2.getImg().setFitWidth(30);
		this.coin1.getL().setLayoutX(50);
		this.coin1.getL().setLayoutY(990);
	}

	/**
	 * Initializes Wall of Game Screen
	 */
	public void init_Wall1() {
		for (int i = 0 ; i < 4 ; i++) {
			this.wall1[i].getRect().setLayoutX(56+ 60*i);
			this.wall1[i].getRect().setLayoutY(-1000+60);
//			this.wall1[i].getRect().setFitHeight(140);
//			this.wall1[i].getRect().setFitWidth(20);

		}

	}
	
	/**
	 * Initializes the game screen and starts the game
	 */
	public void Play() {
		
		
		hiss = new snake();
		hiss.update_length(10,this);
		
		init_row1();
		
		
		init_topLabel();
		init_bottomLabel();
		init_Coin1();
		init_Coin2();
		init_Bomb1();
		init_Scoin1();
		init_Shield1();
		init_Magnet1();
		init_Wall1();
		
		PlayerScore.setLayoutX(5);
		PlayerScore.setLayoutY(5);
		PlayerScore.setText("PlayerScore: ");
		
		DisplayPlayerScore.setLayoutX(85);
		DisplayPlayerScore.setLayoutY(5);
		DisplayPlayerScore.setText(Integer.toString(pscore));
		
		timerforshield.setLayoutX(140);
		timerforshield.setLayoutY(5);
		timerforshield.setVisible(false);
		
		GameScore.setLayoutX(200);
		GameScore.setLayoutY(5);
		GameScore.setText("GameScore:");

		DisplayGameScore.setLayoutX(280);
		DisplayGameScore.setLayoutY(5);
		DisplayGameScore.setText(Integer.toString(gscore));
		
		MMButton.setLayoutX(110);
		MMButton.setLayoutY(422.5);
		MMButton.setMinWidth(80);
		MMButton.setMaxHeight(25);
		MMButton.setText("Main Menu");
		MMButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
//			animation.stop();
//			temp.stop();
				if (aaa%2==1)
					pause_game();
				window.setScene(mainmenu);	
			}
		});
		
		PauseButton.setLayoutX(20);
		PauseButton.setLayoutY(422.5);
		PauseButton.setMinWidth(80);
		PauseButton.setMaxHeight(25);
		PauseButton.setText("Pause");
		PauseButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pause_game();
			}
		});

		this.restartgame.setLayoutX(200);
		this.restartgame.setLayoutY(422.5);
		this.restartgame.setMinSize(80,25);
		this.restartgame.setText("Restart");
		this.restartgame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) { 
				if  (aaa%2==1) 
					pause_game();
//			gameover();
				mpage.newgame();
			}
		});
		
		animation.start();
		
		Pane p = (Pane)window.getScene().getRoot();
		for (int i = 0 ; i < 5 ; i++)
			p.getChildren().add(row1[i].getRect());

	
		p.getChildren().add(PlayerScore);
		p.getChildren().add(DisplayPlayerScore);
		p.getChildren().add(DisplayGameScore);
		p.getChildren().add(GameScore);
		p.getChildren().add(MMButton);
		p.getChildren().add(PauseButton);
		p.getChildren().add(restartgame);		
		p.getChildren().add(getBomb1().getImg());	
		p.getChildren().add(getMagnet1().getImg());
		p.getChildren().add(getShield1().getImg());
		p.getChildren().add(getScoin1().getImg());
		p.getChildren().add(getCoin1().getImg());
		p.getChildren().add(getCoin2().getImg());
		p.getChildren().add(getCoin1().getL());
		p.getChildren().add(getCoin2().getImg());
		for (int i = 0 ; i < 4; i++)
			p.getChildren().add(getWall1()[i].getRect());
		
		for (int i = 0 ; i < 5 ; i++) {
			p.getChildren().add(getRow1()[i].getNum());
		}
		
		for(int e=0;e<getRow1()[0].getBurst_arr().length;e++) {
			
			for (int i = 0 ; i < 5 ; i++) {
				p.getChildren().add(getRow1()[i].getBurst_arr()[e]);
			}
		
		}
		
		window.getScene().setRoot(p);
		
		hiss.display(0,this);
		
	}
	
	/**
	 * Pauses the game
	 */
	public void pause_game() {
		if(aaa%2==1) {
			// pausing the game
			animation.stop();
			temp.stop();
			forsheild.stop();
			aaa++;
		}
		else {
			// resuming the game
			if (shield)
				forsheild.start();
			animation.start();
			aaa++;
		}
		
	}
	
	public Button getMMButton() {
		return MMButton;
	}

	public void setMMButton(Button mmButton) {
		MMButton = mmButton;
	}
	
	public Button getPauseButton() {
		return PauseButton;
	}
	
	public void setPauseButton(Button pauseButton) {
		PauseButton=pauseButton;
	}
	
	public Label getBottomLabel() {
		return bottomLabel;
	}

	public void setBottomLabel(Label bottomLabel) {
		this.bottomLabel = bottomLabel;
	}

	public AnimationTimer getAnimation() {
		return animation;
	}

	public void setAnimation(AnimationTimer animation) {
		this.animation = animation;
	}
	
	/**
	 * Moves the snake left and right
	 */
	@Override
	public void handle(KeyEvent event) {
		System.out.println(event.getCode().toString());
		System.out.println((int)hiss.getHead().getC().getLayoutX());
		if (event.getCode()==KeyCode.LEFT) {
			boolean temporarycheck = true;
			for (int i = 0 ; i < 4 ; i++) {
				int tempo1 =(int)row1[0].getRect().getLayoutY(); 
				int tempo2 = (int)hiss.getHead().getC().getLayoutY();
				if (!wall1[i].getRect().isVisible()) {
					continue;
				}
				if ( (tempo1+ 60 + wall1[i].getRect().getHeight() >= tempo2 )&&(tempo2 >= tempo1 + 50)) {
					// walls are in sync with snake 
					// i.e. at same height
					int temporary1 = (int)hiss.getHead().getC().getLayoutX()+5;
					int temporary2 = (int)wall1[i].getRect().getLayoutX();
					if ( (temporary1 - temporary2 < 20) && (temporary1 > 10 + temporary2) ) {
						
//						hiss.display(Math.max(temporary2 - temporary1 + 1,-10), this);
						temporarycheck = false;
//						System.out.println(temporary1 + " "  + temporary2 +  " ");
					}
					System.out.println(temporary1 + " "  + temporary2 +  " ___________________");

				}
				else {
					continue;
				}
				
			}
			if (temporarycheck) {

				hiss.display(-10,this);
				System.out.println("-------------------+++++++++++++++++++++!222222");
			}
		}
		else if(event.getCode().toString().equals("RIGHT")) {
			boolean temporarycheck = true;
			for (int i = 0 ; i < 4 ; i++) {
				int tempo1 =(int)row1[0].getRect().getLayoutY(); 
				int tempo2 = (int)hiss.getHead().getC().getLayoutY();
				if (!wall1[i].getRect().isVisible()) {
					continue;
				}
				if ( (tempo1+ 50 + wall1[i].getRect().getHeight() >= tempo2 )&&(tempo2 >= tempo1 + 50)) {
					// walls are in sync with snake 
					// i.e. at same height
					int temporary1 = (int)hiss.getHead().getC().getLayoutX();
					int temporary2 = (int)wall1[i].getRect().getLayoutX();
					if ( (temporary2 - temporary1 < 10) && (temporary1 <= temporary2) ) {
						hiss.display(temporary2 - temporary1 - 1, this);
						temporarycheck = false;
					}
				}
				else {
					continue;
				}
				
			}
			if (temporarycheck)
				hiss.display(10,this);
//			hiss.display( 10,this);
		}
		
	}

}
