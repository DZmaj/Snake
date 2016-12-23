package snakeA1;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ResizeListener implements ComponentListener {
	private SnakeView view;
	private SnakePanel panel;
	
	public ResizeListener(SnakeView view){
		this.view = view;
		panel = view.getPanel();
	}
	
    public void componentHidden(ComponentEvent e) {}
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}

    public void componentResized(ComponentEvent e) {
        Dimension newSize = e.getComponent().getBounds().getSize();
        panel.changeDimensions(newSize);
    }
}

