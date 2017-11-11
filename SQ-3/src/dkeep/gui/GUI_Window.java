package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

import dkeep.logic.DragonsBane;

public class GUI_Window {

	private JFrame frmTheMazeAnd;
	private JTextField nrDragons;
	private JLabel Level;
	private JTextField nrLevel;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnDown;
	private JLabel GameState;
	private JLabel Teleports;
	private JTextArea gameBoard;
	
	private int noDragons;
	private int noLevel;
	private int noTeleports;
	private DragonsBane dragonsBane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Window window = new GUI_Window();
					window.frmTheMazeAnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheMazeAnd = new JFrame();
		frmTheMazeAnd.setTitle("The Maze and The Dragon");
		frmTheMazeAnd.setBounds(100, 100, 723, 538);
		frmTheMazeAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheMazeAnd.getContentPane().setLayout(null);
		
		GameState = new JLabel("Game State");
		GameState.setBounds(38, 415, 332, 16);
		frmTheMazeAnd.getContentPane().add(GameState);
		
		JLabel Dragons = new JLabel("Number of Dragons");
		Dragons.setBounds(119, 50, 126, 16);
		frmTheMazeAnd.getContentPane().add(Dragons);
		
		nrDragons = new JTextField();
		nrDragons.setBounds(242, 47, 28, 22);
		frmTheMazeAnd.getContentPane().add(nrDragons);
		nrDragons.setColumns(10);
		
		Level = new JLabel("Level");
		Level.setBounds(38, 50, 41, 16);
		frmTheMazeAnd.getContentPane().add(Level);
		
		nrLevel = new JTextField();
		nrLevel.setBounds(79, 47, 28, 22);
		frmTheMazeAnd.getContentPane().add(nrLevel);
		nrLevel.setColumns(10);
		
		Teleports = new JLabel("Dragon Teleportation Limit");
		Teleports.setBounds(38, 82, 169, 16);
		frmTheMazeAnd.getContentPane().add(Teleports);
		
		JSpinner nrTeleports = new JSpinner();
		nrTeleports.setBounds(200, 79, 30, 22);
		frmTheMazeAnd.getContentPane().add(nrTeleports);
		
		JButton NewGame = new JButton("New Game");
		NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					noDragons = Integer.parseInt(nrDragons.getText());
				} catch (NumberFormatException e) {
					GameState.setText("Invalid number of dragons!");
					return;
				}

				if (noDragons < 0 || noDragons > 5) {
					GameState.setText("Invalid number of dragons! Must be between 0 and 5.");
					return;
				}

				try {
					noLevel = Integer.parseInt(nrLevel.getText());
				} catch (NumberFormatException e) {
					GameState.setText("Invalid level!");
					return;
				}

				if (noLevel < 1 || noLevel > 6) {
					GameState.setText("Invalid level! Must be between 1 and 6.");
					return;
				}
				
				try {
					noTeleports = (Integer) nrTeleports.getValue();
				} catch (NumberFormatException e) {
					GameState.setText("Invalid level!");
					return;
				}

				if (noTeleports < 0) {
					GameState.setText("Invalid number of teleports! Must be at least 0.");
					return;
				}
				
				startGame(new DragonsBane(noDragons, noLevel, noTeleports));
				
			}
		});
		NewGame.setBounds(511, 46, 97, 25);
		frmTheMazeAnd.getContentPane().add(NewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(511, 369, 97, 25);
		frmTheMazeAnd.getContentPane().add(btnExit);
		
		JTextArea gameBoard = new JTextArea();
		gameBoard.setBounds(38, 128, 332, 267);
		frmTheMazeAnd.getContentPane().add(gameBoard);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameState.setText("Hero's attempt to move Up!");
				dragonsBane.newTurn("w");
				printMaze(dragonsBane.getMap().getPopulatedMaze());
				checkGameOver();
			}
		});
		btnUp.setBounds(526, 127, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnUp);
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameState.setText("Hero's attempt to move Left!");
				dragonsBane.newTurn("a");
				printMaze(dragonsBane.getMap().getPopulatedMaze());
				checkGameOver();
				
			}
		});
		btnLeft.setBounds(489, 165, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnLeft);
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameState.setText("Hero's attempt to move Right!");
				dragonsBane.newTurn("d");
				printMaze(dragonsBane.getMap().getPopulatedMaze());
				checkGameOver();
			}
		});
		btnRight.setBounds(568, 165, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnRight);
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameState.setText("Hero's attempt to move Down!");
				dragonsBane.newTurn("s");
				printMaze(dragonsBane.getMap().getPopulatedMaze());
				checkGameOver();
			}
		});
		btnDown.setBounds(526, 203, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnDown);
		
	}
	
	public void printMaze(char[][] maze) {
		String mazeString = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				mazeString += maze[i][j] + "  ";
			}
			mazeString += "\n";
		}
		gameBoard.setText(mazeString);
	}
	
	public void startGame(DragonsBane game) {
		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
		btnLeft.setEnabled(true);
		btnRight.setEnabled(true);
		dragonsBane = game;
		printMaze(dragonsBane.getMap().getPopulatedMaze());
		GameState.setText("You can now play!");
	}
	

	private void checkGameOver() {
		boolean gameOver = dragonsBane.checkGameOver();
		boolean winner = dragonsBane.checkWinner();
		if (gameOver || winner) {
			btnUp.setEnabled(false);
			btnDown.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
			if (gameOver)
				GameState.setText("   Game Over!");
			else
				GameState.setText("   Victory!");
	}
}
	
}
