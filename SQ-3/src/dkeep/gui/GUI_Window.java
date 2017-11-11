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
	
	private int noDragons;
	private int noLevel;
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
				
				NewGame(new DragonsBane(noDragons, nrLevel, nrTeleports));
				
			}
		});
		NewGame.setBounds(511, 46, 97, 25);
		frmTheMazeAnd.getContentPane().add(NewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(511, 369, 97, 25);
		frmTheMazeAnd.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 128, 332, 267);
		frmTheMazeAnd.getContentPane().add(textArea);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUp.setBounds(526, 127, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnUp);
		
		btnLeft = new JButton("Left");
		btnLeft.setBounds(489, 165, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnLeft);
		
		btnRight = new JButton("Right");
		btnRight.setBounds(568, 165, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnRight);
		
		btnDown = new JButton("Down");
		btnDown.setBounds(526, 203, 71, 25);
		frmTheMazeAnd.getContentPane().add(btnDown);
		
	
	}
	
	public void NewGame(DragonsBane game)
	{
		btnUp.setEnabled(false);
		btnDown.setEnabled(false);
		btnLeft.setEnabled(false);
		btnRight.setEnabled(false);
		dragonsBane = game;
		GameState.setText("You can now play!");
}
}
