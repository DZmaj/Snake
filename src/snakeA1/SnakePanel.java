package snakeA1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements Runnable{
	
	public static int WIDTH = 400;
	public static int HEIGHT = 400;
	private Thread thread;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	private Food food;
	
	
	private int x = 10, y = 10, size = 30;
	private boolean right = true, left = false, up = false, down = false;
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
		
		//movement
		if(left)x--;
		if(right)x++;
		if(up)y--;
		if(down)y++;
		
		//when you go of screen
		if (x < 0){
			x = WIDTH/10;
		}
		else if (x > WIDTH/10){
			x = 0;
		}
		
		if (y < 0){
			y = HEIGHT/10;
		}
		else if (y > HEIGHT/10){
			y = 0;
		}
		
		//set max size, size increases as you eat
		
		if (snake.size() > size){
			for (int i = size; i < snake.size(); i++){
				snake.remove(0);
			}
		}
		
		/*
		if (snake.size() > size){
			snake.remove(0);
		}
		*/
		
		
		for (int i = 0; i < snake.size(); i++){
			//collision with food
			int xDiff = Math.abs(snake.get(i).getX() - food.getX());
			int yDiff = Math.abs(snake.get(i).getY() - food.getY());
			
			if (xDiff < 1 && yDiff < 1){
				size++;
				food = new Food();
			}
			
			//collision with self
			/*
			for (int j = i+1; j < snake.size(); j++){
				if (snake.get(i).getX() == snake.get(j).getX() && snake.get(i).getY() == snake.get(j).getY()){
					for (int k = j; k < snake.size(); k++){
						snake.remove(k);
					}
				}
			}
			
			
			if (i != 0 && i != 1 && snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()){
				for (int k = i; k < snake.size(); k++){
					//snake.remove(k);
					//size--;
				}
			}
			*/
		}
		
		for (int j = 1; j < snake.size(); j++){
			if (snake.get(0).getX() == snake.get(j).getX() && snake.get(0).getY() == snake.get(j).getY()){
				size = size - (size - j);
				System.out.println("collision" + size);
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
		if (!right){
			left = true;
			right = false;
		}
		up = false;
		down = false;
	}
	
	public void setRight() {
		if (!left){
			left = false;
			right = true;
		}
		up = false;
		down = false;
	}
	
	public void setUp() {
		left = false;
		right = false;
		if (!down){
			up = true;
			down = false;
		}
	}
	
	public void setDown() {
		left = false;
		right = false;
		if (!up){
			up = false;
			down = true;
		}
	}

	public void changeDimensions(Dimension newSize) {
		WIDTH = (int) newSize.getWidth();
		HEIGHT = (int) newSize.getHeight();
		setPreferredSize(new Dimension(newSize));
		
	}
}
