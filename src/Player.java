import java.io.Serializable;
import java.util.Comparator;

/**
 * A class to compare the highest score of two players
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class abc  implements Comparator<Player> {
	/**
	 * Compares highest score of two players
	 */
	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return -1*Integer.compare(o1.getHighest_score(),o2.getHighest_score() );
	}
}

/**
 * A class to represent a Player
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Player implements Serializable{
	
	/**
	 * Name of the player
	 */
	private String name;
	/**
	 * Number of coins the player has earned
	 */
	private int num_coins;
	/**
	 * Highest score of the player 
	 */
	private int highest_score;
	/**
	 * Constructor of Player class
	 * @param name An object of class String
	 * @param h An object of class Integer
	 */
	public Player(String name, int h) {
		this.name = name;
		highest_score = h;
	}
	/**
	 * 
	 * @return String
	 */
	String getName() {
		return name;
	}
	/**
	 * @param ss An object of class String
	 */
	void setName(String ss) {
		name=ss;
	}
	/**
	 * 
	 * @return Integer
	 */
	int getNum_coins() {
		return num_coins;
	}
	
	/**
	 * 
	 * @param vl An object of class Integer
	 */
	void setNum_coins(int vl) {
		num_coins=vl;
	}
	/**
	 * 
	 * @return Integer
	 */
	int getHighest_score() {
		return highest_score;
	}
	/**
	 * 
	 * @param va An object of class Integer
	 */
	void setHighest_score(int va) {
		highest_score=va;
	}
	
}