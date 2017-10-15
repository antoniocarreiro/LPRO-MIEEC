package dkeep.logic;

public class Dragon extends Entity {

	protected boolean dragonSlayed = false;
	
	public Dragon() {
		super();
		
	}

	public Dragon(DragonsBane game, int x, int y) {
		super(game, x, y, 'D');
		
	}
	
	public void satOnSword() {
		if(position.getX() == game.sword.getX() && position.getY() == game.sword.getY()) {
			this.title = 'F';
			game.sword.satOn = true;
		}
		else {
			game.sword.satOn = false;
			this.title = 'D';
		}
	}
	
}
