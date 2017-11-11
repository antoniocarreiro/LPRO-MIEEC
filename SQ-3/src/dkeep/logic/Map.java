package dkeep.logic;

public class Map {

	private DragonsBane game;
	
	public char[][] maze;
	public char[][] lvl1 = {
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
	
	public char[][] lvl2 = {
			{'X','X','X','X','X'}, 
			{'X',' ',' ','X','X'},
			{'X','X','X','X',' '},
			{'X','X','X','X','X'},
			{'X','X','X','X','X'},
	};
	
	public char[][] lvl3 = {
			{'X','X','X','X','X'}, 
			{'X',' ',' ',' ','X'},
			{'X','X','X',' ',' '},
			{'X','X','X','X','X'},
			{'X','X','X','X','X'},
	};
	
	public char[][] lvl4 = {
			{'X','X','X','X','X'}, 
			{'X',' ',' ',' ','X'},
			{'X','X','X',' ',' '},
			{'X',' ','X','X','X'},
			{'X','X','X','X','X'},
	};
	
	public char[][] lvl5 = {
			{'X','X','X','X','X'}, 
			{'X',' ','X','X','X'},
			{'X','X','X','X',' '},
			{'X',' ','X','X','X'},
			{'X','X','X','X','X'},
	};
	
	public Map(DragonsBane game, int lvl) {	
		this.game = game;
		switch(lvl) {
			case 1:
				maze = lvl1;
				break;
			case 2:
				maze = lvl2;
				break;
			case 3:
				maze = lvl3;
				break;
			case 4:
				maze = lvl4;
				break;
			case 5:
				maze = lvl4;
				break;
			case 6:
				maze = lvl5;
				break;
		};
	}
	
	public char[][] getMaze() {
		return maze;
	}
	
	public char[][] setMaze(char[][] maze) {
		return this.maze = maze;
	}
	
	public char[][] getPopulatedMaze() {
		maze[game.exit.getX()][game.exit.getY()] = game.exit.getTitle();
		
		if(!game.sword.pickedUp)
			maze[game.sword.getX()][game.sword.getY()] = game.sword.getTitle();
		
		maze[game.hero.getX()][game.hero.getY()] = game.hero.getTitle();
		
		for(Dragon dragon : game.dragons) {
			if(!dragon.dragonSlayed)
			maze[dragon.getX()][dragon.getY()] = dragon.getTitle();
		}
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
