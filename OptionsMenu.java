package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class OptionsMenu extends Menu {

	public OptionsMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Back", Color.WHITE, Color.WHITE, Color.BLACK, 7, Game.HEIGHT/2+100));
		
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		try {
			if(game.getState()==Game.STATE.Help) {
				if(mouseOver(mx,my,buttons.get(0).getRectVal()[0],buttons.get(0).getRectVal()[1],buttons.get(0).getRectVal()[2],buttons.get(0).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
					game.setState(Game.STATE.Menu);
				}
			}
		}catch(Exception p) {
			System.out.println("Fuck NullPointerExceptions");
		}
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