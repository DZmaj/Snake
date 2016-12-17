package snakeA1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeController implements KeyListener {
	
	private SnakeModel model;
	private SnakeView view;
	private SnakePanel panel;
	
	public SnakeController(SnakeView view, SnakeModel model){
		this.view = view;
		this.model = model;
		panel = view.getPanel();
	}
	
	
	/*
	 * Arrow keyCodes are 
	
	    38
	 37 40 39
	 
	 */
	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case 37: //left
				panel.setLeft();
				break;
		
			case 38: //up
				panel.setUp();
				break;
		
			case 39: //right
				panel.setRight();
				break;
		
			case 40: //down
				panel.setDown();
				break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
