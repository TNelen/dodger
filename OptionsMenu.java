package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class OptionsMenu extends Menu {

	public OptionsMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Back", Color.WHITE, Color.WHITE, Color.BLACK, 7, Game.HEIGHT/2+100));			//Back-button
		
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		int[][] values = new int[4][10];
		
		
		for(int i=0;i<buttons.size();i++) {
			values[i]=buttons.get(i).getRectVal();
		}
		
		if(game.getState()==Game.STATE.Help) {
			if(mouseOver(mx,my,values[0][0],values[0][1],values[0][2],values[0][3])) {		//Als tijdens de optionsstate op de backbutton gedrukt wordt, gaan we terug naar startmenu
				game.setState(Game.STATE.Menu);
				buttons.remove(0);					//Back-button terug verwijderd tegen overlaps
			}
		}
		
	}
	
	public void render(Graphics g) {
		
		/*g.setColor(Color.DARK_GRAY);				//Makkelijk aanpassen van de achtergrond
		g.fillRect(0,0, WIDTH, HEIGHT);	
		*/
		
		if(buttons.isEmpty()) {
			buttons.add(new ClickButton(fnt2, "Back", Color.WHITE, Color.WHITE, Color.BLACK, 7, Game.HEIGHT/2+100));		//Back-button terug toegevoegd als deze al eens verwijderd is
		}else {
			for(int i=0;i<buttons.size();i++) {
				buttons.get(i).draw(g);				//Drawt alle knoppen
			}
		}
		
		super.drawStringCenter(g, fnt, "OPTIONS", Color.WHITE, Game.WIDTH/2,Game.HEIGHT/2-100);
		super.drawStringCenter(g, fnt3, " Move player 1 with ZQSD ", Color.BLACK, Game.WIDTH/2, Game.HEIGHT/2-40);			//Middentekst
		super.drawStringCenter(g, fnt3, " Move player 2 with the Arrow Keys ", Color.BLACK, Game.WIDTH/2, Game.HEIGHT/2);
		
	}
	
}