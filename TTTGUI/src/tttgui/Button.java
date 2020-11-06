package tttgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class Button extends JButton {
	private boolean claimed;
	private Player owner;
	// default value for owner is null!
	
	public Button() {
		this.setPreferredSize(new Dimension(100,100));	
		this.setBackground(Color.WHITE);
		this.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		claimed = false;
		
	}
	
	// getter method to give indirect access to a private variable (claimed)
	public boolean isClaimed() {
		return claimed;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void claim(Player current) {
		if (current == Player.X) {
			this.setText("X");
			owner = Player.X;
		} else {
			this.setText("O");
			owner = Player.O;
		}
		claimed = true;
	}
	
	
}
