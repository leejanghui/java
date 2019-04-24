import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {
	public CheckBoxEx() {
		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon charryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedcherryIcon = new ImageIcon("images/selectedcherry.jpg");
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��",true);
		JCheckBox cherry = new JCheckBox("ü��", charryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedcherryIcon);
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		setSize(250,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckBoxEx();
	}

}
