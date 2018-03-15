package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;

public class OptionsMenu extends Menu {

	public OptionsMenu(Game game, Handler handler) {
		super(game, handler);
		
		
	}
	
	public void render(Graphics g) {
		for(int i=0;i<buttons.size();i++) {
			buttons.get(i).draw(g);
		}
		
		super.drawStringCenter(g, fnt, "OPTIES", Color.WHITE, Game.HEIGHT/2-100);
		super.drawStringCenter(g, fnt3, " Bestuur speler 1 met zqsd ", Color.WHITE, Game.HEIGHT/2-40);
		super.drawStringCenter(g, fnt3, " Bestuur speler 2 met pijltjes ", Color.WHITE, Game.HEIGHT/2);
		
	}
	
}