package dkeep.logic;

public class Dragon extends Entity {

	protected boolean dragonSlayed = false;
	public boolean immovable = false;
	
	public Dragon() {
		super();
		
	}

	public Dragon(DragonsBane game, Position dragonPosition) {
		super(game, dragonPosition.getX(), dragonPosition.getY(), 'D');
		
	}
	
	public Dragon(DragonsBane game, Position dragonPosition, boolean test) {
		super(game, dragonPosition.getX(), dragonPosition.getY(), 'D');
		immovable = test;
	}
	
	@Override
	protected boolean validMove(int x, int y) {
		if(immovable)
			return false;
		if(game.exit.getX() == x && game.exit.getY() == y)
			return false;
		return true;
	}
	
	public void satOnSword() {
		if(position.getX() == game.sword.getX() && position.getY() == game.sword.getY() && game.sword.pickedUp == false) {
			this.title = 'F';
			game.sword.satOn = true;
		}
		else {
			game.sword.satOn = false;
			this.title = 'D';
		}
	}
	
}
