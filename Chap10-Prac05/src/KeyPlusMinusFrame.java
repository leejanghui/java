import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyPlusMinusFrame extends JFrame{
	public KeyPlusMinusFrame(){
		super("+,- 키로 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel label = new JLabel("Love Java");
		c.add(label);
		label.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '+'){
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("timesRoman", Font.PLAIN, size+5));
				}
					else if(e.getKeyChar() == '-'){
						JLabel la = (JLabel)e.getSource();
						Font f = la.getFont();
						int size = f.getSize();
						if(size <= 5)
							return;
						la.setFont(new Font("timesRoman", Font.PLAIN, size-5));
				}
			}
		});
		setSize(300,150);
		setVisible(true);
		label.setFocusable(true);
		label.requestFocus();
	}

	public static void main(String[] args) {
		new KeyPlusMinusFrame();

	}

}
