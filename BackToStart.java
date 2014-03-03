package oving7;

public class BackToStart extends AbstractSquare {

	public BackToStart(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player thePlayer) {
		thePlayer.setPosition(0);
		System.out.println("Square "
				+ this.getPosition() + " is a wormhole.\n" + thePlayer.getName() 
				+ " has been teleported back to the beginning.");
	}

}
