package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Menu extends MouseAdapter {
	protected Game game;
	protected Handler handler;
	String letterType = "Tahoma";
	Font fnt = new Font(letterType,1,50);
	Font fnt2 = new Font(letterType,1,30);
	Font fnt3 = new Font(letterType,1,20);				//Verschillende standaard fonts
	Font fnt4 = new Font(letterType,1,15);
	Font fnt5 = new Font(letterType,1,80);
	
	ArrayList<ClickButton> buttons;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
		buttons = new ArrayList<ClickButton>();			//Ieder menu heeft een lijst voor buttons
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx>x && mx< x + width){
			if(my < y && my > y + height) {				//Checkt waar de muis op dit moment klikt, en of dat overlapt met een knop
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
	}
	
	public void drawStringCenter(Graphics g, Font f, String s, Color c, int x, int y) {
		g.setFont(f);
		g.setColor(c);
		g.drawString(s, x - (g.getFontMetrics(f).stringWidth(s))/2, y);			//Zet een string gecentreerd in het midden
	}
	
	
	public void render(Graphics g) {
		
			
	}

	
}
