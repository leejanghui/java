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
	private JButton calcBtn = new JButton("����");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private JTextArea log = new JTextArea(28, 53);
	public CalculationServerFrame() {
		super("��Ƽ������ �޽��� ����");
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
		calcBtn.addActionListener(new ActionListener() {//���۹�ư�� �� �׼� ������
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String startText = startTf.getText().trim();
					startTf.setText("");//������ ä��â Ŭ����
					if (startText.length() == 0)
						return;
					out.write(startText + "\n");
					out.flush();
					log.append("����� 2 : " + startText + "\n");//������ �α� ����
				} catch (IOException e) {
					System.out.println("�޽����� ���� ���� ����");
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
					log.append("����ڰ� �����Ͽ����ϴ�.\n");
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
					log.append("����� 1 : " + first + "\n");
				} catch (IOException e) {
					log.append("����ڰ� �����Ͽ����ϴ�.\n");
					System.out.println("�޽����� ���� ���� ����");
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
