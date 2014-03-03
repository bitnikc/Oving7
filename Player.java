package oving7;

public class Player {
	private String name;
	private int position;
	
	public Player(String name) {
		this.name = name;
		position = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	private int rollDie() {
		return ((int)(Math.random()*6))+1;
	}
	
	public int move() {
		return position + rollDie();
	}
}