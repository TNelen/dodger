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
		int[][] values = new int[4][10];
		
		for(int i=0;i<buttons.size();i++) {
			values[i]=buttons.get(i).getRectVal();
		}
		
		if(game.getState()==Game.STATE.Help) {
			if(mouseOver(mx,my,values[0][0],values[0][1],values[0][2],values[0][3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Menu);
			}
		}
		
	}
	
	public void render(Graphics g) {
		/*g.setColor(Color.DARK_GRAY);				//Achtergrond
		g.fillRect(0,0, WIDTH, HEIGHT);	
		*/
		for(int i=0;i<buttons.size();i++) {
			buttons.get(i).draw(g);
		}
		
		super.drawStringCenter(g, fnt, "OPTIES", Color.WHITE, Game.WIDTH/2,Game.HEIGHT/2-100);
		super.drawStringCenter(g, fnt3, " Bestuur speler 1 met zqsd ", Color.WHITE, Game.WIDTH/2, Game.HEIGHT/2-40);
		super.drawStringCenter(g, fnt3, " Bestuur speler 2 met pijltjes ", Color.WHITE, Game.WIDTH/2, Game.HEIGHT/2);
		
	}
	
}