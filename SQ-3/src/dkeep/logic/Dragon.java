package dkeep.logic;

public class Dragon extends Entity {

	protected boolean dragonSlayed = false;
	public boolean immovable = false;
	protected int maxTeleports;
	
	public Dragon() {
		super();
		
	}

	public Dragon(DragonsBane game, Position dragonPosition, int nrTeleports) {
		super(game, dragonPosition.getX(), dragonPosition.getY(), 'D');
		maxTeleports = nrTeleports;
		
	}
	
	public Dragon(DragonsBane game, Position dragonPosition, int nrTeleports, boolean test) {
		super(game, dragonPosition.getX(), dragonPosition.getY(), 'D');
		maxTeleports = nrTeleports;
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
