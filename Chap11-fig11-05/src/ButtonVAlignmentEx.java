import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ButtonVAlignmentEx extends JFrame{
	public ButtonVAlignmentEx(){
		setTitle("버튼 정렬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		ImageIcon normalIcon = new ImageIcon("images/nomalIcon.gif");
		JButton btn = new JButton("Call~~", normalIcon);
		btn.setHorizontalAlignment(SwingConstants.TOP);
		c.add(btn);
		setSize(250, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonVAlignmentEx();

	}

}
