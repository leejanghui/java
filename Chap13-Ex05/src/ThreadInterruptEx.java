import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable implements Runnable {
	private JLabel timerJLabel;

	public TimerRunnable(JLabel timerLabel) {
		this.timerJLabel = timerLabel;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			timerJLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadInterruptEx extends JFrame {
	private Thread th;

	public ThreadInterruptEx() {
		setTitle("ThreadInterruptEx ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		c.add(timerLabel);

		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton btButton = (JButton) e.getSource();
				btn.setEnabled(false);
			}
		});
		c.add(btn);
		setSize(300, 170);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadInterruptEx();

	}

}
