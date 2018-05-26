/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */

public class Pebb extends GamePiece {
	private int wt=1;

	public int getWt() {
		return wt;
	}
	public char charRepresentation() {
		return '*';
	}
	
	

	public String look() {
		return "Big and grey";
	}

	public String listen() {
		return "Makes sound of splash when thrown in water";
	}

	public String touch() {
		return "hard and solid";
	}



	


}
