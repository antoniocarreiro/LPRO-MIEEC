package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.DragonsBane;
import dkeep.logic.Position;

public class UserInteraction {
	
	
	public static void main(String[] args) {

		UserInteraction UI = new UserInteraction();
		UI.run();

	}

	public String getInput() {
		Scanner s = new Scanner(System.in);
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

		
		
	}

}
