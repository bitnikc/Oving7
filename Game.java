package oving7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name, if you dare: ");
		Player daPlayer = new Player(in.nextLine());
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
		while (move < 20){
			daBoard.get(move).moveHere(daPlayer);
			System.out.print(daPlayer.getName() + "'s turn!");
			System.out.println(" Press <ENTER> to roll die.");
			try {
				in.nextLine();
			} catch (Exception e) {
				System.out.print("Shutting down...");
			}
			int die = ((int)(Math.random()*6))+1;
			move = die + daPlayer.getPosition();
			System.out.println(daPlayer.getName() + " rolled " + die + ". ");
			if (move < 20) {
				System.out.println("Moving to square " + move);
				printDots(die);
			}
			else
				printDots(20-daPlayer.getPosition());
		}
		
		System.out.println();
		System.out.println(daPlayer.getName() + " wins!");
		in.close();
	}

}
