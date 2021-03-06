import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileReceiverFrame extends JFrame{
	private JTextArea log = new JTextArea();
	private JLabel imageLabel =new JLabel();
	
	public FileReceiverFrame() {
		super("파일 받는 서버");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JScrollPane(log), BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
		startService();
		
	}
	
	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
		this.pack();
	}
	private void drawImage(String file) {
		ImageIcon icon = new ImageIcon(file);
		imageLabel.setIcon(icon);
		this.pack();
	}
	
	private class ServerThread extends Thread {
		@Override
		public void run() {
			BufferedInputStream fin = null;
			BufferedOutputStream fout = null;
			ServerSocket listener = null;
			Socket socket = null;
			String saveFileName = null;
			try {
				listener = new ServerSocket(9999);
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			while(true){
				try {
					socket = listener.accept();
					log.setText("연결됨\n");
					fin = new BufferedInputStream(socket.getInputStream());
					int cmd;
					String fileName = null;
					long length=0;
					cmd = fin.read();
					if (cmd == Command.FILE_NAME){
						int nameSize = receiveInt(fin);
						log.append("전송받은 파일 이름 길이 :" + nameSize + "\n");
						byte fname[] = new byte[nameSize];
						log.append("전송받은 파일 이름 :" + fileName + "\n");
						log.append("저장할 파일 이름 :" + saveFileName + "\n");
						fout = new BufferedOutputStream(new FileOutputStream(saveFileName));
					}
					else {
						log.append("명령어 수신 오류" + cmd + "\n");
						socket.close();
						listener.close();
						return;
					}
					cmd = fin.read();
					if(cmd == Command.FILE_SIZE) {
						int lenghLow = receiveInt(fin);
						int lenghHigh = receiveInt(fin);
						length = lenghHigh;
						length <<= 32;
						length += lenghLow;
						log.append("전송받은 파일 크기 :" + cmd + "\n");
					}
					else {
						log.append("명령어 수신 오류" + cmd + "\n");
						if (fout != null){
							fout.close();
						}
						socket.close();
						listener.close();
						return;
					}
					cmd = fin.read();
					if (cmd == Command.SEND_BEGIN) {
						int numberToRead;
						while (length > 0) {
							byte b[] = new byte[2048];
							if (length < b.length)
								numberToRead = (int)length;
							else
								numberToRead = b.length;
							int numRead = fin.read(b, 0, numberToRead);
							if (numRead <= 0){
								if (length > 0){
									log.append("전송 오류가 발생했습니다. 읽은 바이트 : " + numRead + "남은 바이트 :" + length + "\n");
								}
							}
							else {
								log.append(".");
								fout.write(b, 0, numRead);
								length -= numRead;
							}
						}
						cmd = fin.read();
						if(cmd == Command.SEND_END){
							log.append("\n파일 수신 성공. 현재 j폴더에 저장되었습니다.\n");
						}
						else {
							log.append("\n 명령 수신 오류"+ cmd + "\n");
						}
						if(fout != null)
							fout.close();
						socket.close();
						drawImage(saveFileName);
					}
				}
					catch (IOException e){
						e.printStackTrace();
						log.append("파일 수신 중 오류가 발생했습니다.\n");
				}
			}
		}
	}
	private int receiveInt(BufferedInputStream fin) throws IOException {
		int value;
		value = fin.read();
		value |= fin.read() << 8;
		value |= fin.read() << 16;
		value |= fin.read() << 24;
		return value;
	}
	
	
	public static void main(String[] args) {
		new FileReceiverFrame();
	}
}








