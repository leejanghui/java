package pr;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pr.CalculationServerFrame.ServerThread;
import pr.CalculationServerFrame.ServiceThread;

public class CalculationClientFrame extends JFrame {
	private JTextField Tf = new JTextField(46);
	private JButton calcBtn = new JButton("전송");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private JTextArea log = new JTextArea(28, 53);

	public CalculationClientFrame() {

		super("1:1메신저 클라이언트");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		c.add(Tf);
		c.add(calcBtn);
		setVisible(true);
		new ServerThread().start();
		setupConnection();

		calcBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String startText = Tf.getText().trim();
					if (startText.length() == 0)
						return;
					out.write(startText + "\n");
					out.flush();
					String result = in.readLine();
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
				listener = new ServerSocket(9997);
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
					int a = Integer.parseInt(first);
					String resText = "";
					int res = 0;
					out.write(resText + "\n");
					out.flush();
					log.append(first + "\n"
							+ "");
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
			socket = new Socket("localhost", 9998);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CalculationClientFrame();
	}

}
