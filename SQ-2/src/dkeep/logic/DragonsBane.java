package dkeep.logic;

import java.util.Random;
import java.util.Scanner;

public class DragonsBane {

	protected Hero hero;
	protected Dragon dragon;
	protected Sword sword;
	
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
		
	}



	private void randomKeyPosition(char[][] maze) {
		
		Random random = new Random();
		
		while(true) {
			int randomX = random.nextInt(8) + 1;
			int randomY = random.nextInt(8) + 1;
			
			if(maze[randomX][randomY] == ' ' && maze[randomX+1][randomY] != 'D' && maze[randomX-1][randomY] != 'D') {
				maze[randomX][randomY] = 'K';
				break;
			}
		}
	}
	


	public static Position getHeroPosition(char[][] maze) {
		Position position = new Position();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 'H') {
					position.setX(i);
					position.setY(j);
					return position;
				}
			}
		}

		return null;
	}

	public static Position getExitPosition(char[][] maze) {
		Position position = new Position();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 'E') {
					position.setX(i);
					position.setY(j);
					return position;
				}
			}
		}

		return null;
	}

	
	public static Position getDragonPosition(char[][] maze) {
		Position position = new Position();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 'D') {
					position.setX(i);
					position.setY(j);
					return position;
				}
			}
		}

		return null;
	}

	public boolean checkGameOver(char[][] maze) {
		Position heroPosition = getHeroPosition(maze);
		Position dragonPosition = getDragonPosition(maze);

		if((dragonPosition.getX()-1 == heroPosition.getX() && dragonPosition.getY() == heroPosition.getY()) ||
				(dragonPosition.getX()+1 == heroPosition.getX() && dragonPosition.getY() == heroPosition.getY()) ||
				(dragonPosition.getX() == heroPosition.getX() && dragonPosition.getY()-1 == heroPosition.getY()) ||
				(dragonPosition.getX() == heroPosition.getX() && dragonPosition.getY()+1 == heroPosition.getY()))
			return true;

		return false;
	}

	public static Position getKeyPosition(char[][] maze) {
		Position position = new Position();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 'K') {
					position.setX(i);
					position.setY(j);
					return position;
				}
			}
		}

		return null;
	}

	public void checkPickedUpKey(char[][] maze) {
		Position heroPosition = getHeroPosition(maze);

		if(keyPosition.getX() == heroPosition.getX() && keyPosition.getY() == heroPosition.getY())
			hasKey = true;
	}

	public void run(){



		randomKeyPosition(maze);		
		keyPosition = getKeyPosition(maze);
		exitPosition = getExitPosition(maze);
		while(true)
		{
			PrintMap(maze);
			System.out.print("Please enter a direction: ");
			

			checkPickedUpKey(maze);
			
			if(hasWon)
				break;
			
			if(checkGameOver(maze)) {
				System.out.println("Game Over");
				break;
			}

		}
	}

}


