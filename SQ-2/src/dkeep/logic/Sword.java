package dkeep.logic;

public class Sword extends Entity {

	protected boolean pickedUp = false;
	protected boolean satOn = false;
	
	public Sword() {
		super();
		
	}

	public Sword(DragonsBane game, Position swordPosition) {
		super(game, swordPosition.getX(), swordPosition.getY(), 'S');
		
	}
	
}
