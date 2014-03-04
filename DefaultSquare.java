package oving7;

public class DefaultSquare extends AbstractSquare {

	public DefaultSquare(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player thePlayer) {
		super.moveHere(thePlayer);
		if (this.getPosition() > 0)
			System.out.println(thePlayer.getName()
					+ " has moved safely to square " 
					+ this.getPosition());
		else
			System.out.println(thePlayer.getName()
					+ " carefully places a token on the\n"
					+ "initial square, prepaired for action.");
	}

}
