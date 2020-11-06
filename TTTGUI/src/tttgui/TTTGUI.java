package tttgui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel; 

public class TTTGUI extends JFrame {
	// The extends keyword means that TTGUI inherits from JFrame,
	// so a TTGUI object "is a" JFrame
	Button[][] buttons; 
	
	static int ROWS = 3;
	static int COLS = 3;
	Player currentPlayer; // currentPlayer is a Player object

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
		// TODO: Add text to panel
		JPanel messagePanel = new JPanel();
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
		this.add(messagePanel);
		this.add(gridPanel);
		this.pack(); // Fits size of frame to contents
		
		currentPlayer = Player.X;
		
	}
	
	public void move(Button b) {
		if (!b.isClaimed()) {
			b.claim(currentPlayer);
		// if player is X, then change to O, otherwise (:) change to X
		// Ternary operator: is the stuff in the brackets true? "?" If so, ":" do stuff before ":". If not, do stuff after ":".
		currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
		}
	}
	
	// TODO: Make a winner method that checks if 
	// rows, cols, diagonals are all claimed, and then 
	// checks if the owner is the same for all 3 buttons
	
	public static void main(String[] args) {
		TTTGUI game = new TTTGUI();
		
	}
	
	
}
