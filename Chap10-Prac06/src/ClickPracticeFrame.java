import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickPracticeFrame extends JFrame{
	public ClickPracticeFrame() {
		super("클릭 연습 용 응용 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel label = new JLabel("C");
		c.add(label);
		label.setLocation(100,100);
		label.setSize(20,20);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				Container c = la.getParent();
				int xBound = c.getWidth() - la.getWidth();
				int yBound = c.getHeight()- la.getHeight();
				int x = (int)(Math.random()*xBound);
				int y = (int)(Math.random()*yBound);
				la.setLocation(x,y);
			}
		});
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();

	}

}
