package assignment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		
		JMenu F = new JMenu("����(F)");
		mb.add(F);
		F.add(new JMenu("���� �����(N)"));
		F.add(new JMenu("����(O)��"));
		F.add(new JMenu("����(S)"));
		F.add(new JMenu("�ٸ� �̸����� ����(A)��"));
		F.add(new JMenu("������ ����(U)��"));
		F.add(new JMenu("�μ�(P)��"));
		F.add(new JMenu("������(X)"));
		
		JMenu E = new JMenu("����(E)");
		mb.add(E);
		E.add(new JMenu("���� ���(U)"));
		E.add(new JMenu("�߶󳻱�(T)"));
		E.add(new JMenu("����(C)"));
		E.add(new JMenu("�ٿ��ֱ�(P)"));
		E.add(new JMenu("����(L)"));
		E.add(new JMenu("Bing���� �˻�(S)"));
		E.add(new JMenu("ã��(F)��"));
		E.add(new JMenu("���� ã��(N)"));
		E.add(new JMenu("�ٲٱ�(R)��"));
		E.add(new JMenu("�̵�(G)��"));
		E.add(new JMenu("��� ����(A)"));
		E.add(new JMenu("��¥/�ð�(D)"));
		
		JMenu O = new JMenu("����(O)");
		mb.add(O);
		O.add(new JMenu("�ڵ� �� �ٲ�(W)"));
		O.add(new JMenu("�۲�(F)��"));
		
		JMenu V =new JMenu("����(V)");
		mb.add(V);
		JMenu other = new JMenu("Ȯ���ϱ�/����ϱ�");
		V.add(other);
		other.add(new JMenu("Ȯ���ϱ�"));
		other.add(new JMenu("����ϱ�"));
		other.add(new JMenu("Ȯ���ϱ�/����ϱ� �⺻�� ����"));
		V.add(new JMenu("���� ǥ����(S)"));
		
		JMenu H = new JMenu("����");
		mb.add(H);
		H.add(new JMenu("���� ����(H)"));
		H.add(new JMenu("�޸��� ����(A)"));

		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new Notepad();
	}

}
