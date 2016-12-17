package snakeA1;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
	
	private int x, y, width, height;
	
	public BodyPart(int x, int y, int tileSize){
		this.x = x;
		this.y = y;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick(){
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x*width, y*height, width, height);
		//g.setColor(Color.GREEN);
		//g.fillRect(x*width +2, y*height +2, width -4, height -4);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}


}
