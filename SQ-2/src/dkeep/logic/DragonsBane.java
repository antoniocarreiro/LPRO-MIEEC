package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class DragonsBane {

	protected Hero hero;
	protected ArrayList<Dragon> dragons = new ArrayList<>();
	protected Sword sword;
	protected Exit exit;
	protected Map map;
	
	protected boolean gameOver = false;
	protected int dragonsCount;
	
	
	public DragonsBane(int dragonsCount) {
		this.dragonsCount = dragonsCount;
		this.map = new Map(this);
		this.hero = new Hero(this, 1, 1);
		
		for(int i = 0; i < dragonsCount; ++i) {
			this.dragons.add(new Dragon(this, randomDragonPosition()));
		}
		
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
		for(Dragon dragon : dragons) { 
			dragon.move(getRandomDirection());
			dragon.satOnSword();
			checkDuel(dragon);
		}
			
		
	}

	public boolean checkWinner() {
		if(hero.getX() == exit.getX() && hero.getY() == exit.getY() && dragonsCount == 0)
			return true;
		return false;
			
	}
	
	public void checkDuel(Dragon dragon) {

		if(checkAdjacent(hero, dragon) && sword.pickedUp && !dragon.dragonSlayed) {
			dragon.dragonSlayed = true;
			dragonsCount--;
		}
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
			
			if(map.maze[swordPosition.getX()][swordPosition.getY()] == ' '
			&& swordPosition.getX() != hero.getX()
			&& swordPosition.getY() != hero.getY()) {
				break;
			}
		}
		
		return swordPosition;
	}

	private Position randomDragonPosition() {
		
		Position dragonPosition = new Position();
		Random random = new Random();
		
		while(true) {
			dragonPosition.setX(random.nextInt(8) + 1);
			dragonPosition.setY(random.nextInt(8) + 1);
			
			if(map.maze[dragonPosition.getX()][dragonPosition.getY()] == ' ')
				if((dragonPosition.getX()-1 != hero.getX() && dragonPosition.getY() != hero.getY()) &&
						(dragonPosition.getX()+1 != hero.getX() && dragonPosition.getY() != hero.getY()) &&
						(dragonPosition.getX() != hero.getX() && dragonPosition.getY()-1 != hero.getY()) &&
						(dragonPosition.getX() != hero.getX() && dragonPosition.getY()+1 != hero.getY()))
							break;
		}
		
		return dragonPosition;
	}
	
}


