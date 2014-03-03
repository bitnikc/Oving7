package oving7;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static void main(String[] args) {
		Player daPlayer = new Player("Bjarne");
		List<AbstractSquare> daBoard = new ArrayList<AbstractSquare>();

		for (int i = 0; i < 20; i++) {
			if ((Math.random()*10) > 8)
				daBoard.add(new BackToStart());
			else
				daBoard.add(new DefaultSquare());
		}
	}

}
