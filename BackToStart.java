package oving7;

public class BackToStart extends AbstractSquare {
	
	public BackToStart() {
		super();
	}

	@Override
	public void moveHere(Player thePlayer) {
		thePlayer.setPosition(0);
		System.out.println("Square " + this.getPosition() + " is unaccessable."
				+ "\nYou have been sent back to the beginning.");
	}

}
