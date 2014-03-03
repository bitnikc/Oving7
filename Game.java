package oving7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Player daPlayer = new Player("Bjarne");
		List<AbstractSquare> daBoard = new ArrayList<AbstractSquare>();

		daBoard.add(new DefaultSquare(0));
		for (int i = 1; i < 20; i++) {
			if ((Math.random()*10+1) > 8)
				daBoard.add(new BackToStart(i));
			else
				daBoard.add(new DefaultSquare(i));
		}
		
		for(AbstractSquare board: daBoard)
			System.out.println(board);
		
		while (daPlayer.getPosition() < 20){
			System.out.println(daPlayer.getName() + "'s turn! Press <ENTER> to roll!");
			in.nextLine();
			daBoard.get(daPlayer.move()).moveHere(daPlayer);
		}
			
		
	}

}
