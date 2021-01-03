import java.io.Serializable;

import javafx.scene.image.ImageView;

/**
 * 
 * @author Preyansh Rastogi and Vaibhav Sarda
 *
 */
class Token implements Runnable{
	
	/**
	 * Tells whether token is active or not
	 */
	private boolean Active;
	/**
	 * Image of the token
	 */
	protected ImageView img;
	
	/**
	 * 
	 * @return ImageView
	 */
	public ImageView getImg() {
		return img;
	}
	
	/**
	 * 
	 * @param img An object of class ImageView
	 */
	public void setImg(ImageView img) {
		this.img = img;
	}

	/**
	 * An object of class snake
	 */
	private snake python = null; 
	
	
	/**
	 * 
	 * @return snake
	 */
	public snake getPython() {
		return python;
	}
	
	/**
	 * 
	 * @param python An object of class snake
	 */
	public void setPython(snake python) {
		this.python = python;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isActive() {
		return Active;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	boolean getstatus() {
		return Active;
	}
	

	/**
	 * 
	 * @param ac An object of class boolean
	 */
	void setActive(boolean ac) {
		// uml no param
		
		Active=ac;
	}
	
	/**
	 * Checks whether snake collides with token or not
	 */
	@Override
	public void run() {
		snake hiss = getPython();
		if ((this.getImg().getLayoutX() <= hiss.getHead().getC().getLayoutX() ) && (this.getImg().getLayoutX() +30 >= hiss.getHead().getC().getLayoutX())) {
			if ((this.getImg().getLayoutY() <= hiss.getHead().getC().getLayoutY() ) && (this.getImg().getLayoutY() +30 >= hiss.getHead().getC().getLayoutY())) {
				if (this.getImg().isVisible()) {
					// Snake found the magnet
					this.setActive(true);
				}
			}

		}
	}

}
