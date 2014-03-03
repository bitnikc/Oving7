package oving7;

public abstract class AbstractSquare implements Square {
	private int position;
	
	public AbstractSquare(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public void moveHere(Player thePlayer) {
		thePlayer.setPosition(this.position);
	}
	
}
