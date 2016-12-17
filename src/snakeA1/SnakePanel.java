package snakeA1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements Runnable{
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	private Thread thread;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	private Food food;
	
	
	private int x = 10, y = 10, size = 5;
	private boolean right = false, left = false, up = false, down = false;
	public SnakePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		snake = new ArrayList<BodyPart>();
		thread = new Thread(this, "game lop");
		thread.start();
		food = new Food();
	}
	
	private void tick() {
		b = new BodyPart(x, y, 10);
		snake.add(b);
		if(left)x--;
		if(right)x++;
		if(up)y--;
		if(down)y++;
		
		if (snake.size() > size){
			snake.remove(0);
		}
		
		for (int i = 0; i < snake.size(); i++){
			int xDiff = Math.abs(snake.get(i).getX() - food.getX());
			int yDiff = Math.abs(snake.get(i).getY() - food.getY());
			
			if (xDiff < 1 && yDiff < 1){
				size++;
				food = new Food();
			}
		}
		
	}
	
	public void paint(Graphics g){
		// this line deletes everything then redraws
		super.paintComponent(g);
		for (int i = 0; i < snake.size(); i++){
			snake.get(i).draw(g);
		}
		food.draw(g);
		
	}
	
	public void run(){
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				tick();
				repaint();
			}
		}, 0, 70);
		
	}

	public void setLeft() {
		left = true;
		right = false;
		up = false;
		down = false;
	}
	
	public void setRight() {
		left = false;
		right = true;
		up = false;
		down = false;
	}
	
	public void setUp() {
		left = false;
		right = false;
		up = true;
		down = false;
	}
	
	public void setDown() {
		left = false;
		right = false;
		up = false;
		down = true;
	}
}
