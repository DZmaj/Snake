package snakeA1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SnakeView extends JFrame{
	private SnakePanel s;
	
	public SnakeView() {
		super("Snake"); // set the title and do other JFrame init
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 1, 0, 0));
		s = new SnakePanel();
		add(s);
		
		pack();
		
		//setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public SnakePanel getPanel(){
		return s;
	}
}
