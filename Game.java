package oving7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static void write(String s) {
		System.out.print(s);
	}
	
	public static void write(int n) {
		System.out.print(n);
	}
	
	public static void printDots(int d) {
		int speed = 200;
		for (int i = 0; i<d; i++) {
			try {
			    Thread.sleep(speed);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.print(". ");
			try {
			    Thread.sleep(speed);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		System.out.println();
	}
	
	public static List<Player> players(Scanner in) {
		List<Player> daList = new ArrayList<Player>();
		write("Welcome bold heroes, the quest that \nlies before you"
				+ "will be full of dangers.\n");
		write("Tell me, what are your names? [Ex. Joe Sue Xaviera]\n");
		String[] names = in.nextLine().split(" ");
		for (int i = 0; i<names.length;i++)
			daList.add(new Player(names[i]));
		return daList;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Player> players = players(in);
		List<AbstractSquare> daBoard = new ArrayList<AbstractSquare>();

		daBoard.add(new DefaultSquare(0));
		boolean tooManyWormholes = false;
		int wormholeCooldown = 0;
		for (int i = 1; i < 20; i++) {
			if (Collections.frequency(daBoard, new BackToStart(0)) > 3)
				tooManyWormholes = true;
			if ((Math.random()*10+1) < 8 || tooManyWormholes || wormholeCooldown > 0) {
				daBoard.add(new DefaultSquare(i));
				wormholeCooldown--;
			}
			else {
				daBoard.add(new BackToStart(i));
				wormholeCooldown = 3;
			}
		}
		
		/*
		 * Testing wormholes (squares of BackToStart type)
		 * 
		for(AbstractSquare board: daBoard)
			System.out.println(board);
		
		System.out.println(Collections.frequency(daBoard, new BackToStart(0)));
		*/
		int move = 0;
		int die = 0;
		int winner = 0;
		while (move < daBoard.size()){
			for (int turn=0; turn<players.size(); turn++) {
				
				// NEW ROUND STARTS HERE!!!!
				write("\n#Player###Position#######");
				write("\n# " + players.get(turn).getName() + "\t# " + players.get(turn).getPosition() + "\t\t#");
				write("\n#########################\n\n");
				/*
				System.out.println("\n" + players.get(turn).getName()
						+ "'s turn! You're token is on square "
						+ players.get(turn).getPosition());
						*/
				System.out.print("Press <ENTER> to roll die.");
				try {in.nextLine();} catch (Exception e) {
					System.out.print("Shutting down...");
				}
				die = ((int)(Math.random()*6))+1;
				move = die + players.get(turn).getPosition();
				System.out.println(players.get(turn).getName() + " rolled " + die + ". ");
				if (move < daBoard.size()) {
					System.out.println("Moving to square " + move);
					printDots(die);
					daBoard.get(move).moveHere(players.get(turn));
				}
				else {
					printDots(daBoard.size()-players.get(turn).getPosition());
					winner = turn;
					break;
				}
			}
		}
		
		System.out.println();
		System.out.println(players.get(winner).getName() + " wins!");
		in.close();
	}

}
