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
	
	public void printMaze(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void run(){

		DragonsBane game = new DragonsBane();
		
		while(true) {
			printMaze(game.getMap().getPopulatedMaze());
			game.newTurn(getInput()); 
			if(game.checkGameOver()) {
				System.out.print("Game Over");
				break;
			}
		}
		//s.close();
		
	}

}
