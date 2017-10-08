package lpro.logic;
import java.util.Random;
import java.util.Scanner;

public class HereBeDragons {

	private boolean hasKey = false;
	private boolean hasWon = false;
	private Position keyPosition;
	private Position exitPosition;


	public void PrintMap(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	//	public static char NextStep() {
	//		Scanner reader = new Scanner(System.in);  // Reading from System.in
	//		System.out.println("Enter a direction: ");
	//		char step = reader.nextLine().toCharArray()[0];
	//		reader.close();
	//		return step;
	//		
	//	}

	private void randomKeyPosition(char[][] maze) {
		
		Random random = new Random();
		
		while(true) {
			int randomX = random.nextInt(8) + 1;
			int randomY = random.nextInt(8) + 1;
			
			if(maze[randomX][randomY] == ' ') {
				maze[randomX][randomY] = 'K';
				break;
			}
		}
	}
	
	public String nextStep() {
		Scanner s = new Scanner(System.in);
		return s.nextLine();
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

	public static void main(String[] args) {

		HereBeDragons hBD = new HereBeDragons();
		hBD.run();

	}

	public void run(){

		char[][] maze = {{'X','X','X','X','X','X','X','X','X','X'},
				{'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','D','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','E'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}
		};

		randomKeyPosition(maze);		
		keyPosition = getKeyPosition(maze);
		exitPosition = getExitPosition(maze);
		while(true)
		{
			PrintMap(maze);
			System.out.print("Please enter a direction: ");
			String step = nextStep();
			Position heroPosition = getHeroPosition(maze);
			switch(step) {
			case "w":
				if(heroPosition.getX() > 0) {
					if(maze[heroPosition.getX() - 1][heroPosition.getY()] != 'X') {
						maze[heroPosition.getX()][heroPosition.getY()] = ' ';
						heroPosition.setX(heroPosition.getX()-1);
						maze[heroPosition.getX()][heroPosition.getY()] = 'H';
					}
				}
				break;

			case "a":
				if(heroPosition.getY() > 0) {
					if(maze[heroPosition.getX()][heroPosition.getY() - 1] != 'X') {
						maze[heroPosition.getX()][heroPosition.getY()] = ' ';
						heroPosition.setY(heroPosition.getY()-1);
						maze[heroPosition.getX()][heroPosition.getY()] = 'H';
					}
				}
				break;

			case "s":
				if(heroPosition.getX() < 9) {
					if(maze[heroPosition.getX() + 1][heroPosition.getY()] != 'X') {
						maze[heroPosition.getX()][heroPosition.getY()] = ' ';
						heroPosition.setX(heroPosition.getX()+1);
						maze[heroPosition.getX()][heroPosition.getY()] = 'H';
					}
				}
				break;

			case "d":
				if(heroPosition.getX() == exitPosition.getX() && heroPosition.getY() == exitPosition.getY() && hasKey) {
					System.out.println("Winner");
					hasWon = true;
					break;
				}
				if(heroPosition.getY() < 9) {
					if(heroPosition.getX() == exitPosition.getX() && heroPosition.getY() == exitPosition.getY()-1 && !hasKey)
						break;
					if(maze[heroPosition.getX()][heroPosition.getY() + 1] != 'X') {
						maze[heroPosition.getX()][heroPosition.getY()] = ' ';
						heroPosition.setY(heroPosition.getY()+1);
						maze[heroPosition.getX()][heroPosition.getY()] = 'H';
					}
				}
				break;
			}

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

