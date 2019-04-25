import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawPolygonEx extends JFrame{
	private Mypanel panel = new Mypanel();
	public GraphicsDrawPolygonEx(){
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200, 300);
		setVisible(true);
	}
	class Mypanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawArc(20, 100, 80, 80, 90, 270);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawPolygonEx();
	}

}
