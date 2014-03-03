package oving7;

public class DefaultSquare extends AbstractSquare {

	public DefaultSquare(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player thePlayer) {
		super.moveHere(thePlayer);
		System.out.println(thePlayer.getName() 
				+ " has moved safely to square " 
				+ this.getPosition());
	}

}
