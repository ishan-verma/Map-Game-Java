/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */

public class MappleTree extends GamePiece {
	public char charRepresentation() {
		return 'M';
	}

	public int CarryItem(){
		return '0';
		
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
