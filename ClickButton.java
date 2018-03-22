package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ClickButton {
	
	
	private Font f;
	private Color tc, boc, buc;
	int y, thick;
	String s;
	Rectangle border,button;

	public ClickButton( Font f, String s, Color tc, Color boc, Color buc, int thick, int y) {
		this.s=s;
		this.f=f;
		this.tc=tc;
		this.boc=boc;
		this.buc=buc;
		this.thick=thick;
		this.y=y;
		
		border = new Rectangle();
		button = new Rectangle();			//Vierkant van de knop en diens rand
		
		
		
		
	}
	
	public void draw(Graphics g) {
																			//De knoppen zijn gecentreerd en hebben een vaste grootte, gebaseerd op het meegegeven font.
		int sWidth=g.getFontMetrics(f).stringWidth("PLAY");				
		int sHeight=((int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent() + (int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent())*2;
		
		if(border.getX()==0.0) {
			border = new Rectangle(Game.WIDTH/2-(sWidth/2)-(40+thick),y+(20+thick),sWidth+(40+thick)*2, -sHeight - (20+thick)*2);		//Eenmalig opgeroepen bij de aanmaak van een nieuw menu
			button = new Rectangle(Game.WIDTH/2-(sWidth/2)-40,y+20,sWidth+80, -sHeight - 40);
		}
		
		g.setColor(boc);
		g.fillRect((int) border.getX(), (int) border.getY(), (int) border.getWidth(), (int) border.getHeight());		//De vierkanten worden getekend op het scherm
		g.setColor(buc);
		g.fillRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
		
		g.setFont(f);
		g.setColor(tc);
		g.drawString(s, Game.WIDTH/2 - (g.getFontMetrics(f).stringWidth(s))/2, y);
	}
	
	
	public int[] getRectVal() {
		int[] values = new int[4];
		values[0] = (int) border.getX();
		values[1] = (int) border.getY();
		values[2] = (int) border.getWidth();		//Geeft waardes van de knop terug in handig arrayformaat
		values[3] = (int) border.getHeight();
		/*for(int i=0;i<4;i++) {
		System.out.println(values[i]);
		}
		System.out.println();*/
		return values;
	}
	
	public String getStr() {
		return s;				//Returnt de knoptekst
	}

}
