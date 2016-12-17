package snakeA1;

public class SnakeGame {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SnakeGame();
			}
		});
	}

	private SnakeModel model;
	private SnakeView view;
	private SnakeController controller;

	private SnakeGame() {
		this.model = new SnakeModel();
		this.view = new SnakeView();
		this.controller = new SnakeController(this.view, this.model);
		this.view.addKeyListener(this.controller);
		//this.model.addObserver(this.view);
	}
}
