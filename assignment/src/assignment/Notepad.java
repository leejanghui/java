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
		setTitle("메모장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton();
		createMenu();
		add(new JTextField("text field"));
		setSize(1024, 700);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		mb.add(new JMenu("파일(F)"));
		mb.add(new JMenu("편집(E)"));
		mb.add(new JMenu("서식(O)"));
		mb.add(new JMenu("보기(V)"));
		mb.add(new JMenu("도움말(H)"));

		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new Notepad();
	}

}
