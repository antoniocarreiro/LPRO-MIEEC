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
	
	//inicializar as variáveis
	public DragonsBane(int dragonsCount) {
		this.dragonsCount = dragonsCount;
		this.map = new Map(this);
		this.hero = new Hero(this, 1, 1);
		this.sword = new Sword(this, randomSwordPosition());
		
		for(int i = 0; i < dragonsCount; ++i) {
			this.dragons.add(new Dragon(this, randomDragonPosition()));
			this.dragons.get(i).satOnSword();
		}
		
		this.exit = new Exit(this, 5, 9);
		
	}
	//UI
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
			if(!dragon.dragonSlayed) {
				Random random = new Random();

				if(random.nextInt(100) < 20)
					dragon.position = randomTeleportPosition(dragon);
				else
					dragon.move(getRandomDirection());

				dragon.satOnSword();
				checkDuel(dragon);
			}
		}


	}

	public boolean checkWinner() {
		if(hero.getX() == exit.getX() && hero.getY() == exit.getY() && dragonsCount == 0)
			return true;
		return false;
			
	}
	
	public void checkDuel(Dragon dragon) {

		if(checkAdjacent(hero, dragon) && sword.pickedUp && !dragon.dragonSlayed) {

			Random random = new Random();

			if(random.nextInt(100) < 35) {
				dragon.position = randomTeleportPosition(dragon);
				checkDuel(dragon);
			}
			else {
				dragon.dragonSlayed = true;
				dragonsCount--;
			}

		}
		else if(checkAdjacent(hero, dragon) && !sword.pickedUp && !dragon.dragonSlayed)
			gameOver = true; 
	}
	
	private boolean checkAdjacent(Entity entity1, Entity entity2) {
		if((entity1.getX()-1 == entity2.getX() && entity1.getY() == entity2.getY()) ||
				(entity1.getX()+1 == entity2.getX() && entity1.getY() == entity2.getY()) ||
				(entity1.getX() == entity2.getX() && entity1.getY()-1 == entity2.getY()) ||
				(entity1.getX() == entity2.getX() && entity1.getY()+1 == entity2.getY()) ||
				(entity1.getX() == entity2.getX() && entity1.getY() == entity2.getY()))
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
				if(!(dragonPosition.getX()-1 == hero.getX() && dragonPosition.getY() == hero.getY()) &&
						!(dragonPosition.getX()+1 == hero.getX() && dragonPosition.getY() == hero.getY()) &&
						!(dragonPosition.getX() == hero.getX() && dragonPosition.getY()-1 == hero.getY()) &&
						!(dragonPosition.getX() == hero.getX() && dragonPosition.getY()+1 == hero.getY()) &&
						!(dragonPosition.getX() == hero.getX() && dragonPosition.getY() == hero.getY()))
							break;
		}
		
		return dragonPosition;
	}
	
	
	private Position randomTeleportPosition(Dragon dragon) {

		Position dragonPosition = new Position();
		Random random = new Random();

			while(true) {
				dragonPosition.setX(random.nextInt(8) + 1);
				dragonPosition.setY(random.nextInt(8) + 1);

				if(map.maze[dragonPosition.getX()][dragonPosition.getY()] == ' ')
					if(dragonPosition.getX() != hero.getX() && dragonPosition.getY() != hero.getY()
					&& dragonPosition.getX() != dragon.getX() && dragonPosition.getY() != dragon.getY())
						break;
			}

			return dragonPosition;
	}
}


