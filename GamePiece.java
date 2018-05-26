/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */

/**
 * This class represents a generic GamePiece. Subclass from it to create Player
 * objects and other types you wish to use in your game.
 * 
 * @author pipWolfe
 *
 */
public class GamePiece {
	private int x = 0;
	private int y = 0;

	/**
	 * Construct a game piece with location (0, 0)
	 */
	public GamePiece() {
	}

	/**
	 * Gets the y coordinate on the board
	 * 
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate on the board
	 * 
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the x coordinate on the board
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate on the board
	 * 
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * By default, pieces will be "drawn" as a question mark (you should
	 * override this method in subclasses).
	 * 
	 * @return a single character that will be drawn on the map to mark this
	 *         piece
	 */
	public char charRepresentation() {
		return '?';
	}

	/**
	 * Override this method in subclasses to describe your game pieces.
	 * 
	 * @return A string that describes what this object looks like
	 */
	public String look() {
		return "no description known";
	}

	/**
	 * Override this method in subclasses to describe your game pieces.
	 * 
	 * @return A string that describes what this object sounds like
	 */
	public String listen() {
		return "no voice yet";
	}

	/**
	 * Override this method in subclasses to describe your game pieces.
	 * 
	 * @return A string that describes what this object feels like
	 * 
	 */
	public String touch() {
		return "no texture yet";
	}



	

	

	
	}


