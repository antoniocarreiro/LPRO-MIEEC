package dkeep.logic;

public class Hero extends Entity {

	public Hero() {
		super();
		
	}

	public Hero(DragonsBane game, int x, int y) {
		super(game, x, y, 'H');
		
	}
	
	public boolean move(String direction) {
		switch(direction) {
		case "w":
			if(position.getX() > 0) {
				if(maze[position.getX() - 1][position.getY()] != 'X') {
					maze[position.getX()][position.getY()] = ' ';
					position.setX(position.getX()-1);
					maze[position.getX()][position.getY()] = 'H';
				}
			}
			return false;

		case "a":
			if(position.getY() > 0) {
				if(maze[position.getX()][position.getY() - 1] != 'X') {
					maze[position.getX()][position.getY()] = ' ';
					position.setY(position.getY()-1);
					maze[position.getX()][position.getY()] = 'H';
				}
			}
			return false;

		case "s":
			if(position.getX() < 9) {
				if(maze[position.getX() + 1][position.getY()] != 'X') {
					maze[position.getX()][position.getY()] = ' ';
					position.setX(position.getX()+1);
					maze[position.getX()][position.getY()] = 'H';
				}
			}
			break;

		case "d":
			if(position.getX() == exitPosition.getX() && position.getY() == exitPosition.getY() && hasKey) {
				System.out.println("Winner");
				hasWon = true;
				break;
			}
			if(position.getY() < 9) {
				if(position.getX() == exitPosition.getX() && position.getY() == exitPosition.getY()-1 && !hasKey)
					break;
				if(maze[position.getX()][position.getY() + 1] != 'X') {
					maze[position.getX()][position.getY()] = ' ';
					position.setY(position.getY()+1);
					maze[position.getX()][position.getY()] = 'H';
				}
			}
			break;
		}
	}
	
}
