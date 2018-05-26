/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */

public class Tree extends GamePiece {
	private int x = 0;
	private int y = 0;

	
	public int getY() {
		return y;
	}

		public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	
	public void setX(int x) {
		this.x = x;
	}

	public char charRepresentation() {
		return '?';
	}

	
	public String look() {
		return "Big and Green";
	}

	
	public String listen() {
		return "I rustle in the wind";
	}

	
	public String touch() {
		return "Bark of the object is sharp";
	}

}
