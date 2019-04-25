import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame{
	private Mypanel panel = new Mypanel();
	public GraphicsDrawLineMouseEx() {
		setTitle("drawing Line by Mouse ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 300);
		setVisible(true);
	}
	class Mypanel extends JPanel{
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>();
		public Mypanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e){
					Point staetP = e.getPoint();
					vStart.add(staetP);					
				}
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint();
					vEnd.add(endP);
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i=0;i<vStart.size();i++){
				Point s = vStart.elementAt(i);
				Point e = vEnd.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
	}
	

	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();

	}

}
