/**
 * Ishan Verma is author of this map game 
 * due date of assignment was October 14, 2016
 * time taken - 1 week
 * no of files including this one (i.e. MapGame.java) = 10
 * name of the file - MapGame.java, GamePiece.java, GameBoard.java, Player.java, Tree.java, MappleTree.java, Oaktree.java, Rock.java, Pebb.java and Boulder.java
	
	 */

import java.util.Scanner;

public class MapGame {

	private GameBoard board;

	public MapGame() {
		board = new GameBoard();

	}

	/**
	 * Add game loop logic
	 */
	public void play() {
		Player p = new Player();
		MappleTree mp = new MappleTree();
		OakTree ot = new OakTree();
		Pebb pb = new Pebb();
		Boulder bo = new Boulder();
		board.addPiece(p, 3, 3);
		for (int i = 0; i < 5; i++) {

			board.addPieceToRandomLocation(mp);

			board.addPieceToRandomLocation(ot);

			board.addPieceToRandomLocation(pb);

			board.addPieceToRandomLocation(bo);
		}

		// create objects representing rocks, trees and add them to the board -
		// add to random position
		// board.addPieceToRandomLocation(piece);

		// get ip from user, for l r ,..... if q you have to quit

		// board.movePiece(p, p.getX(), p.getY()+1);

		board.printBoard();
		System.out.println("Press:\n" + "l for left\t" + "r for right\t" + "d for down\t" + "u for up\n"
				+ "p for pickup (item to right)\t" + "w for putdown (item to right)\n" + "o for look\t"
				+ "n for listen\t" + "t for touch\t" + "q for quit\n");
		Scanner input = new Scanner(System.in);
		char c = input.next().charAt(0);
		while (c != 'q') {
			if (c == 'l') {
				board.movePiece(p, p.getX(), p.getY() - 1);
			} else if (c == 'r') {
				board.movePiece(p, p.getX(), p.getY() + 1);
			} else if (c == 'u') {
				board.movePiece(p, p.getX() - 1, p.getY());
			} else if (c == 'd') {
				board.movePiece(p, p.getX() + 1, p.getY());
			} else if (c == 'o') {
				if (board.getPiece(p.getX(), p.getY() + 1) == null) {
					System.out.println("There is Nothing there");

				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'M') {
					System.out.println();
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'T') {
					System.out.println(ot.look());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == '*') {
					System.out.println(pb.look());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'o') {
					System.out.println(bo.look());
				}
			}

			else if (c == 'n') {
				if (board.getPiece(p.getX(), p.getY() + 1) == null) {
					System.out.println("There is Nothing there");
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'M') {
					System.out.println(mp.listen());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'T') {
					System.out.println(ot.listen());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == '*') {
					System.out.println(pb.listen());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'o') {
					System.out.println(bo.listen());
				}

			} else if (c == 't') {
				if (board.getPiece(p.getX(), p.getY() + 1) == null) {
					System.out.println("There is Nothing there");
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'M') {
					System.out.println(mp.touch());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'T') {
					System.out.println(ot.touch());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == '*') {
					System.out.println(pb.touch());
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'o') {
					System.out.println(bo.touch());
				}

			}

			else if (c == 'p') {
				if (board.getPiece(p.getX(), p.getY() + 1) == null) {
					System.out.println("There is Nothing there");
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'M') {
					System.out.println("Can't pick up the item");
				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'T') {
					System.out.println("Can't pick up the item");

				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == '*') {
					if (p.getCarryWeight() < 20) {
						p.addWeight(pb.getWt());
						p.al.add("Pebble(weight = 1)");
						board.removePiece(p);
						// changed the actual default methods that take player
						// 'p' as parameter.
						// check in GameBoard class

					} else {
						System.out.println("Too much Weight to carry in backpack");
					}

				} else if (board.getPiece(p.getX(), p.getY() + 1).charRepresentation() == 'o') {
					if (p.getCarryWeight() < 20) {
						p.addWeight(bo.getWt());
						p.al.add("Boulder(weight = 10)");
						board.removePiece(p);
					} else {
						System.out.println("Too much Weight to carry in backpack");
					}

				}
			}

			else if (c == 'w') {
				if (p.getCarryWeight() > 0) {
					if (board.getPiece(p.getX(), p.getY() + 1) == null) {
						if (p.al.get(p.al.size() - 1) == "Pebble(weight = 1)") {
							p.al.remove(p.al.size() - 1);
							p.removeWeight(1);
							board.addPiece(pb, p.getX(), p.getY() + 1);

						} else if (p.al.get(p.al.size() - 1) == "Boulder(weight = 10)") {
							p.al.remove(p.al.size() - 1);
							p.removeWeight(10);
							board.addPiece(bo, bo.getX(), p.getY() + 1);

						}

					} else if (board.getPiece(p.getX(), p.getY() + 1) != null){
						System.out.println("Can't drop item there. sorry!");
					}
				}
			} else {
				System.out.println("Nothing in the backpack.");
			}

			board.printBoard();
			System.out.println("Player's Backpack: " + p.al);
			System.out.println("Total Weight: " + p.getCarryWeight());
			c = input.next().charAt(0);
		}

	}

	/**
	 * Run the game!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MapGame game = new MapGame();
		game.play();
	}
}
