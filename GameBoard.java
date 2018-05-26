/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */
import java.util.Random;

/**
 * A rectangular, text based game board which can display GamePiece objects placed on it.
 *  
 * @author pipWolfe
 *
 */
public class GameBoard {

	public static final int X_SIZE = 7;
	public static final int Y_SIZE = 10;
	private GamePiece[][] gamePieces = new GamePiece[X_SIZE][Y_SIZE];
	private Random random = new Random();

	/**
	 * Prints the board. If a space on the board is empty, prints a dash. If a
	 * space is occupied by a GamePiece, prints the piece's character
	 * representation.
	 */
	public void printBoard() {
		for (int i = 0; i < gamePieces.length; i++) {
			for (int j = 0; j < gamePieces[i].length; j++) {
				if (gamePieces[i][j] == null) {
					System.out.print("- ");
				} else {
					System.out.print(gamePieces[i][j].charRepresentation() + " ");
				}
			}
			// newline after each row
			System.out.println("");
		}
		// newline at the end of the board
		System.out.println("");
		
	}

	/**
	 * Adds the piece to the specified location (will replace any pieces
	 * already there). The game piece's x and y coordinates are updated to match
	 * its location on the board.
	 * 
	 * @param piece The game piece to add
	 * @param x The desired x location
	 * @param y The desired y location
	 */
	public void addPiece(GamePiece piece, int x, int y) {
		piece.setX(x);
		piece.setY(y);
		gamePieces[piece.getX()][piece.getY()] = piece;
	}

	/**
	 * Add a piece to a random, unoccupied location. If there are no unoccupied
	 * locations left, throws an error.
	 * 
	 * @param piece The game piece to add to the board.
	 */
	public void addPieceToRandomLocation(GamePiece piece) {
		int x = random.nextInt(X_SIZE);
		int y = random.nextInt(Y_SIZE - 1) + 1; // skip y coord 0

		placeAtNextEmpty(piece, x, y);
	}

	/**
	 * Tries to place the piece at the x and y coordinates specified. If those are full,
	 * advances to the next square in the grid, trying to find an empty square. If all
	 * spaces are full, throws an exception.
	 * 
	 * @param piece The game piece to place
	 * @param x The desired x location
	 * @param y The desired y location
	 */
	private void placeAtNextEmpty(GamePiece piece, int x, int y) {
		int startIndex = x * Y_SIZE + y;
		int index = startIndex + 1;
		index = index % (Y_SIZE * X_SIZE); // if have reached highest x, y start
											// again at 0

		while (index != startIndex) {
			int nextY = index % Y_SIZE;
			int nextX = index / Y_SIZE;
			// Do not place piece if in the first column, or if the square is
			// occupied
			if ((nextY != 0) && (gamePieces[nextX][nextY] == null)) {
				gamePieces[nextX][nextY] = piece;
				piece.setX(nextX);
				piece.setY(nextY);
				return;
			} else {
				index = index + 1;
				index = index % (Y_SIZE * X_SIZE); // if have reached highest x,
													// y start again at 0
			}
		}
		throw new RuntimeException("Could not place item: board is full.");
	}

	/**
	 * Change the location of the piece on the board. Returns false if the
	 * piece would move off the board, or if the desired location is full.
	 * 
	 * @param piece The game piece being moved
	 * @param newX Its new x location
	 * @param newY Its new y location
	 * @returns false if the move is invalid
	 */
	public boolean movePiece(GamePiece piece, int newX, int newY) {
		if ((newX < X_SIZE) && (newY < Y_SIZE) && (newX >= 0) && (newY >= 0) && (gamePieces[newX][newY] == null)) {
			// remove from the old location
			gamePieces[piece.getX()][piece.getY()] = null;
			// add to the new location
			addPiece(piece, newX, newY);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the piece at the specified x and y location. If nothing is there,
	 * this will return "null". It also returns null if the coordinates reference
	 * a location off the board.
	 * 
	 * @param x
	 *            x coordinate (up/down)
	 * @param y
	 *            y coordinate (left/right)
	 * @return the piece at (x, y)
	 */
	public GamePiece getPiece(int x, int y) {
		if ((x < X_SIZE) && (y < Y_SIZE) && (x >= 0) && (y >= 0))
			return gamePieces[x][y];	
		else
			return null;
	}

	/**
	 * Remove the piece from the board. Assumes that the piece's x and y
	 * coordinates are correct.
	 * 
	 * @param piece
	 *            The piece to remove.
	 */
	///NOTE: I MODIEFIED IT:- 
	public void removePiece(GamePiece piece) {
		gamePieces[piece.getX()][piece.getY()+1] = null;

	}
}
