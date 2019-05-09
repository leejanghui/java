package assignment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		
		JMenu F = new JMenu("파일(F)");
		mb.add(F);
		F.add(new JMenu("새로 만들기(N)"));
		F.add(new JMenu("열기(O)…"));
		F.add(new JMenu("저장(S)"));
		F.add(new JMenu("다른 이름으로 저장(A)…"));
		F.add(new JMenu("페이지 설정(U)…"));
		F.add(new JMenu("인쇄(P)…"));
		F.add(new JMenu("끝내기(X)"));
		
		JMenu E = new JMenu("편집(E)");
		mb.add(E);
		E.add(new JMenu("실행 취소(U)"));
		E.add(new JMenu("잘라내기(T)"));
		E.add(new JMenu("복사(C)"));
		E.add(new JMenu("붙여넣기(P)"));
		E.add(new JMenu("삭제(L)"));
		E.add(new JMenu("Bing으로 검색(S)"));
		E.add(new JMenu("찾기(F)…"));
		E.add(new JMenu("다음 찾기(N)"));
		E.add(new JMenu("바꾸기(R)…"));
		E.add(new JMenu("이동(G)…"));
		E.add(new JMenu("모두 선택(A)"));
		E.add(new JMenu("날짜/시간(D)"));
		
		JMenu O = new JMenu("서식(O)");
		mb.add(O);
		O.add(new JMenu("자동 줄 바꿈(W)"));
		O.add(new JMenu("글꼴(F)…"));
		
		JMenu V =new JMenu("보기(V)");
		mb.add(V);
		JMenu other = new JMenu("확대하기/축소하기");
		V.add(other);
		other.add(new JMenu("확대하기"));
		other.add(new JMenu("축소하기"));
		other.add(new JMenu("확대하기/축소하기 기본값 복원"));
		V.add(new JMenu("상태 표시줄(S)"));
		
		JMenu H = new JMenu("도움말");
		mb.add(H);
		H.add(new JMenu("도움말 보기(H)"));
		H.add(new JMenu("메모장 정보(A)"));

		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new Notepad();
	}

}
