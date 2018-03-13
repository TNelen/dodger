package SoftwareProject.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ClickButton {
	
	
	private Graphics g;
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
		
		
		
	}
	
	public void draw(Graphics g) {
		int sWidth=g.getFontMetrics(f).stringWidth("PLAY");
		int sHeight=((int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent() + (int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent())*2;
		
		border = new Rectangle(Game.WIDTH/2-(sWidth/2)-(40+thick),y+(20+thick),sWidth+(40+thick)*2, -sHeight - (20+thick)*2);
		button = new Rectangle(Game.WIDTH/2-(sWidth/2)-40,y+20,sWidth+80, -sHeight - 40);
		
		g.setColor(boc);
		g.fillRect((int) border.getX(), (int) border.getY(), (int) border.getWidth(), (int) border.getHeight());
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
		values[2] = (int) border.getWidth();
		values[3] = (int) border.getHeight();
		
		return values;
	}
	

}
