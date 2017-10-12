package dkeep.logic;

import java.util.Random;

public class DragonsBane {

	protected Hero hero;
	protected Dragon dragon;
	protected Sword sword;
	protected Exit exit;
	
	private char[][] maze = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ','X',' ',' '},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}
	};
	
	public DragonsBane() {
		
		this.hero = new Hero(this, 1, 1);
		this.dragon = new Dragon(this, 3, 1);
		this.sword = new Sword(this, randomSwordPosition());
		this.exit = new Exit(this, 5, 9);
		
	}
	
	
	public boolean newTurn(String nextStep) {
		cleanMaze();
		hero.move(nextStep);
		dragon.move(getRandomDirection());
		return true;
		
	}
	
	private String getRandomDirection() {
		String[] direction = {"w", "a", "s", "d"};
		Random random = new Random();
		return direction[random.nextInt(4)];
	}
	
	public char[][] getMaze() {
		return maze;
	}

	public char[][] getPopulatedMaze() {
		maze[exit.getX()][exit.getY()] = exit.getTitle();
		maze[sword.getX()][sword.getY()] = sword.getTitle();
		maze[hero.getX()][hero.getY()] = hero.getTitle();
		maze[dragon.getX()][dragon.getY()] = dragon.getTitle();
		return maze;
	}
	
	private void cleanMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if(maze[i][j] != 'X')
					maze[i][j] = ' ';
			}
		}
	}


	private Position randomSwordPosition() {
		
		Position swordPosition = new Position();
		Random random = new Random();
		
		while(true) {
			swordPosition.setX(random.nextInt(8) + 1);
			swordPosition.setY(random.nextInt(8) + 1);
			
			if(maze[swordPosition.getX()][swordPosition.getY()] == ' ') {
				break;
			}
		}
		
		return swordPosition;
	}

}


