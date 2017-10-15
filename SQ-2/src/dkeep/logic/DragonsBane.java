package dkeep.logic;

import java.util.Random;

import dkeep.logic.Position;

public class DragonsBane {

	protected Hero hero;
	protected Dragon dragon;
	protected Sword sword;
	protected Exit exit;
	protected Map map;
	
	protected boolean gameOver = false;
	
	public DragonsBane() {
		
		this.map = new Map(this);
		this.hero = new Hero(this, 1, 1);
		this.dragon = new Dragon(this, 3, 1);
		this.sword = new Sword(this, randomSwordPosition());
		this.exit = new Exit(this, 5, 9);
		
	}
	
	public Map getMap() {
		return map;
	}
	
	public boolean checkGameOver() {
		return gameOver;
	}
	
	public void newTurn(String nextStep) {
		map.cleanMaze();
		if(!hero.move(nextStep))
			return;
		hero.checkArmed();
		dragon.move(getRandomDirection());
		dragon.satOnSword();
		checkDuel();		
	}
	
	public void checkDuel() {

		if(checkAdjacent(hero, dragon) && sword.pickedUp)
			dragon.dragonSlayed = true;
		else if(checkAdjacent(hero, dragon) && !sword.pickedUp)
			gameOver = true; 
	}
	
	private boolean checkAdjacent(Entity entity1, Entity entity2) {
		if((entity1.getX()-1 == entity2.getX() && entity1.getY() == entity2.getY()) ||
				(entity1.getX()+1 == entity2.getX() && entity1.getY() == entity2.getY()) ||
				(entity1.getX() == entity2.getX() && entity1.getY()-1 == entity2.getY()) ||
				(entity1.getX() == entity2.getX() && entity1.getY()+1 == entity2.getY()))
			return true;
		
		return false;
	}
	
	private String getRandomDirection() {
		String[] direction = {"w", "a", "s", "d"};
		Random random = new Random();
		return direction[random.nextInt(4)];
	}


	private Position randomSwordPosition() {
		
		Position swordPosition = new Position();
		Random random = new Random();
		
		while(true) {
			swordPosition.setX(random.nextInt(8) + 1);
			swordPosition.setY(random.nextInt(8) + 1);
			
			if(map.maze[swordPosition.getX()][swordPosition.getY()] == ' ') {
				break;
			}
		}
		
		return swordPosition;
	}

}


