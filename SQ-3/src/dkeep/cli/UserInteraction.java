package dkeep.cli; 

import java.util.Scanner;

import dkeep.logic.DragonsBane;

public class UserInteraction {
	
	
	private Scanner s; 
	public static void main(String[] args) {

		UserInteraction UI = new UserInteraction();
		UI.run();

	}

	public String getInput() {
		s = new Scanner(System.in);
		return s.nextLine();
	}
	
	public String[] getInitialConditions() {
		s = new Scanner(System.in);
		String string = s.nextLine ();
		String[] values = string.split(" ");
		return values;
	}	
	
	public int getLevel() {
		s = new Scanner(System.in);
		return Integer.parseInt(s.nextLine());
	}	
	
	public void printMaze(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void run(){
		System.out.print("Enter number of dragons and level: ");
		String[] initCond = getInitialConditions();
		DragonsBane game = new DragonsBane(Integer.valueOf(initCond[0]), Integer.valueOf(initCond[1]));
		
		while(true) {
			printMaze(game.getMap().getPopulatedMaze());
			game.newTurn(getInput());
			if(game.checkGameOver()) {
				printMaze(game.getMap().getPopulatedMaze());
				System.out.print("Game Over");
				break;
			}
			if(game.checkWinner()) {
				printMaze(game.getMap().getPopulatedMaze());
				System.out.print("Winner");
				break;
			}
		}
		//s.close();
		
	}

}
