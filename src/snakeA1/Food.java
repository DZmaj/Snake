package snakeA1;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
private int x;
private int y;
private int width = 10, height = 10;
	
	public Food(){
		x = (int) (Math.random()*40);
		y = (int) (Math.random()*40);
	}
	
	public void tick(){
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
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