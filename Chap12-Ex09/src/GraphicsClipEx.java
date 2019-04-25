import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClipEx extends JFrame{
	private Mypanel panel = new Mypanel();
	public GraphicsClipEx() {
		setTitle("클리핑 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 400);
		setVisible(true);
	}
	class Mypanel extends JPanel {
		private ImageIcon icon = new ImageIcon("/.");
		private Image img = icon.getImage();
		public void printComponent(Graphics g){
			super.paintComponent(g);
			g.setClip(100,20,150,150);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("Go Gator", 10, 150);
		}
	}

	public static void main(String[] args) {
		new GraphicsClipEx();

	}

}
