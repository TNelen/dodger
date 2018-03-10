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
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //zorgt ervoor dat kruisje rechtsboven werkt
		frame.setResizable(false); //je kan scherm niet herschalen
		frame.setLocationRelativeTo(null); //hierdoor opent window in midden van scherm
		frame.add(game); 	//game in frame zetten
		frame.setVisible(true);
		game.start();	
		
	}	

}
