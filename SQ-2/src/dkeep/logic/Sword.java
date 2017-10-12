package dkeep.logic;

public class Sword extends Entity {

	public Sword() {
		super();
		
	}

	public Sword(DragonsBane game, Position swordPosition) {
		super(game, swordPosition.getX(), swordPosition.getY(), 'S');
		
	}
	
}
