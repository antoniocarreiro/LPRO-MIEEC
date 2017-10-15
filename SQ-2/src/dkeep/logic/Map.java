package dkeep.logic;

public class Map {

	private DragonsBane game;
	
	protected char[][] maze = {
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
	
	public Map(DragonsBane game) {	
		this.game = game;	
	}
	
	public char[][] getMaze() {
		return maze;
	}
	
	public char[][] getPopulatedMaze() {
		maze[game.exit.getX()][game.exit.getY()] = game.exit.getTitle();
		
		if(!game.sword.pickedUp)
			maze[game.sword.getX()][game.sword.getY()] = game.sword.getTitle();
		
		maze[game.hero.getX()][game.hero.getY()] = game.hero.getTitle();
		maze[game.dragon.getX()][game.dragon.getY()] = game.dragon.getTitle();
		return maze;
	}
	
	public void cleanMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if(maze[i][j] != 'X')
					maze[i][j] = ' ';
			}
		}
	}
	
}
