package dkeep.logic;

public class Hero extends Entity {
	
	public boolean immovable = false;
	
	public Hero() {
		super();
		
	}

	public Hero(DragonsBane game, int x, int y) {
		super(game, x, y, 'H');
		
	}
	
	public Hero(DragonsBane game, int x, int y, boolean test) {
		super(game, x, y, 'H');
		immovable = test;
		
	}
	
	public boolean checkArmed() {
		if(position.getX() == game.sword.getX() && position.getY() == game.sword.getY()) {
			this.title = 'A';
			game.sword.pickedUp = true;
			return true;
		}
		
		return false;
	}
	
}
