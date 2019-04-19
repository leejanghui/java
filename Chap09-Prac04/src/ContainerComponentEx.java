import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerComponentEx extends JFrame {
	public ContainerComponentEx() {
		setTitle("Container & Component");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		this.setBackground(Color.gray);
		
		panel1 p1 = new panel1();
		p1.setSize(150, 150);
		p1.setLocation(10, 10);
		add(p1);
		panel2 p2 = new panel2();
		p2.setSize(150, 150);
		p2.setLocation(170, 10);
		add(p2);
		
		JButton btn = new JButton("OK");
		btn.setLocation(130, 170);
		btn.setSize(70, 30);
		add(btn);
		setSize(350, 250);
		setVisible(true);
	}
	
	private class panel1 extends JPanel {
		panel1() {
			setBackground(Color.yellow);
			add(new JLabel("Type ID"));
			add(new JTextField(10));
			add(new JLabel("Type Password"));
			add(new JTextField(10));
		}
	}
	
	private class panel2 extends JPanel {
		panel2() {
			setBackground(Color.green);
			add(new JLabel("Please Check!!"));
			add(new JCheckBox("C# JCheckBox"));
			add(new JCheckBox("C++ JCheckBox"));
		}
	}

	public static void main(String[] args) {
		new ContainerComponentEx();

	}

}
