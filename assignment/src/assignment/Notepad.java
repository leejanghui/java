package assignment;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class Notepad extends JFrame{
	public Notepad() {
		setTitle("�޸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton();
		createMenu();
		add(new JTextField("text field"));
		setSize(1024, 700);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		mb.add(new JMenu("����(F)"));
		mb.add(new JMenu("����(E)"));
		mb.add(new JMenu("����(O)"));
		mb.add(new JMenu("����(V)"));
		mb.add(new JMenu("����(H)"));

		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new Notepad();
	}

}
