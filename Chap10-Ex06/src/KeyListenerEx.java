import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx extends JFrame {
	private JLabel[] keyMessage;

	public KeyListenerEx() {
		setTitle("KeListener ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		keyMessage = new JLabel [3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for(int i=0;i<keyMessage.length;i++){
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300, 150);
		setVisible(true);
	}

	class MyKeyListener extends KeyAdapter {
		public void KeyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keychar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Integer.toString(keychar));
			keyMessage[2].setText(Integer.toString(keyCode));
			System.out.println("KeyPressed");
		}

		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}

		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped");
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
