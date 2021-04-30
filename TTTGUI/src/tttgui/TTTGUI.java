package tttgui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.JLabel;


public class TTTGUI extends JFrame {
	// The extends keyword means that TTGUI inherits from JFrame,
	// so a TTGUI object "is a" JFrame
	Button[][] buttons; 
	
	static int ROWS = 3;
	static int COLS = 3;
	Player currentPlayer; // currentPlayer is a Player object
	JLabel message;
	boolean gameOver;

	public TTTGUI() {
		// Sends a title to the JFrame constructor.
		/* Instead of using "JFrame(String title)", 
		 we use the keyword "super", which calls 
		 the class one level up. */
		super("Tic Tac Toe"); 
		
		// this. refers to the current class we're in. 
		/* However, this. and JFrame. are technically not necessary 
		 because we have already inherited the JFrame class. */
				
		// Set the X button to exit the program.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// Make JPanels
		JPanel messagePanel = new JPanel();
		message = new JLabel();
		message.setText("Player X's turn");
		messagePanel.add(message);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(ROWS,COLS));
		
		// Make JButtons using Button() constructor
		buttons = new Button[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				Button b = new Button();
				buttons[i][j] = b;
				gridPanel.add(b);
				b.addActionListener(new ClickHandler(this));
			}
		}
		
		// Add JPanels to JFrame
		this.add(messagePanel, BorderLayout.NORTH);
		this.add(gridPanel, BorderLayout.SOUTH);
		this.pack(); // Fits size of frame to contents
		
		currentPlayer = Player.X;
		gameOver = false;
		
	}
	
	public void move(Button b) {
		if (!b.isClaimed() && !gameOver) {
			b.claim(currentPlayer);
			
			Player winner = winner();
			b.claim(currentPlayer);
			if (winner!= null) {
				String winningPlayer = (winner == Player.X) ? "X" : "O";
				message.setText("Congratulations, player " + winner + ", you've won!");
				gameOver = true;
				
			} else {
				// if player is X, then change to O, otherwise (:) change to X
				// Ternary operator: is the stuff in the brackets true? "?" If so, ":" do stuff before ":". If not, do stuff after ":".
				currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
				String player = (currentPlayer == Player.X) ? "X" : "O";
				message.setText("Player " + player + "'s turn.");
			}
		}
	}	
	
	public Player winner() {
		Player winner = null;
		// Rows
		for (int i = 0; i < ROWS; i++) {
			if (buttons[i][0].isClaimed() && buttons[i][1].isClaimed() && buttons[i][2].isClaimed()) {
				boolean cond1 = buttons[i][0].getOwner() == buttons[i][1].getOwner();
				boolean cond2 = buttons[i][1].getOwner() == buttons[i][2].getOwner();
				if (cond1 && cond2) {
					return buttons[i][0].getOwner();
				}
			}
		}
		
		// Columns
		for (int j = 0; j < COLS; j++) {
			if (buttons[0][j].isClaimed() && buttons[1][j].isClaimed() && buttons[2][j].isClaimed()) {
				boolean cond1 = buttons[0][j].getOwner() == buttons[1][j].getOwner();
				boolean cond2 = buttons[1][j].getOwner() == buttons[2][j].getOwner();
				if (cond1 && cond2) {
					return buttons[0][j].getOwner();
				}
			}
		}
		
		// Diagonals
		if (buttons[0][0].isClaimed() && buttons[1][1].isClaimed() && buttons[2][2].isClaimed()) {
			boolean cond1 = buttons[0][0].getOwner() == buttons[1][1].getOwner();
			boolean cond2 = buttons[1][1].getOwner() == buttons[2][2].getOwner();
			if (cond1 && cond2) {
				return buttons[0][0].getOwner();
			}
		}
		
		if (buttons[0][2].isClaimed() && buttons[1][1].isClaimed() && buttons[2][0].isClaimed()) {
			boolean cond1 = buttons[0][2].getOwner() == buttons[1][1].getOwner();
			boolean cond2 = buttons[1][1].getOwner() == buttons[2][0].getOwner();
			if (cond1 && cond2) {
				return buttons[0][2].getOwner();
			}
		}
		
		return winner;
	}
	
	
	public static void main(String[] args) {
		TTTGUI game = new TTTGUI();
		
	}
	
	
}
