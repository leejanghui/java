package pr;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculationServerFrame extends JFrame {
	private JTextField startTf = new JTextField(46);
	private JButton calcBtn = new JButton("전송");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private JTextArea log = new JTextArea(28, 53);
	public CalculationServerFrame() {
		super("멀티스레드 메신저 서버");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		c.add(startTf);
		c.add(calcBtn);
		setVisible(true);
		setupConnection();
		new ServerThread().start();
		calcBtn.addActionListener(new ActionListener() {//전송버튼에 들어갈 액션 리스너
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String startText = startTf.getText().trim();
					startTf.setText("");//전송후 채팅창 클리어
					if (startText.length() == 0)
						return;
					out.write(startText + "\n");
					out.flush();
					log.append("사용자 2 : " + startText + "\n");//전송후 로그 남김
				} catch (IOException e) {
					System.out.println("메신저로 부터 연결 종료");
					return;
				}

			}
		});
	}
	class ServerThread extends Thread {
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9998);
				while (true) {
					socket = listener.accept();
					log.append("사용자가 입장하였습니다.\n");
					new ServiceThread(socket).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (listener != null)
					listener.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		private ServiceThread(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run() {
			while (true) {
				try {
					String first = in.readLine();
					String resText = "";
					out.write(resText + "\n");
					out.flush();
					log.append("사용자 1 : " + first + "\n");
				} catch (IOException e) {
					log.append("사용자가 퇴장하였습니다.\n");
					System.out.println("메신저로 부터 연결 종료");
					return;
				}
			}
		}
	}
	public void setupConnection() {
		try {
			socket = new Socket("localhost", 9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new CalculationServerFrame();
	}
}
