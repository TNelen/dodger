package SoftwareProject.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	//deze klasse maakt de window
	
	private static final long serialVersionUID = 2113572777292841818L;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  			//Zorgt ervoor dat kruisje rechtsboven werkt
		frame.setResizable(false); 										//Je kan het scherm niet herschalen
		frame.setLocationRelativeTo(null); 								//Hierdoor opent window in het midden van scherm
		frame.add(game); 												//Zet de game in het frame
		frame.setVisible(true);
		game.start();	
		
	}	

}
