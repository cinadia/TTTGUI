package tttgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickHandler implements ActionListener { 

	// Keyword "implements" is for using an interface. 
	// Interface is an abstract class - has empty methods, no preset code
	// "Clickhandler 'uses' ActionListener."

	TTTGUI game;
	
	public ClickHandler(TTTGUI game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button b = (Button)e.getSource();
		game.move(b);
		
	} 
	

}
