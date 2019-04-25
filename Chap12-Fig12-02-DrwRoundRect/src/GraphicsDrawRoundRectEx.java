import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawRoundRectEx extends JFrame{
	private Mypanel panel = new Mypanel();
	
	public GraphicsDrawRoundRectEx() {
		setTitle("DrawRoundRect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200, 170);
		setVisible(true);
	}
	class Mypanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRoundRect(20, 20, 120, 80, 40, 60);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawRoundRectEx();

	}

}
