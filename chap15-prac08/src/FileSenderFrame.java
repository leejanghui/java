import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSenderFrame extends JFrame{
	private JTextField fileNameTf = new JTextField(30);
	private JButton selBtn = new JButton("이미지 선택");
	private JButton sendBtn = new JButton("전송");
	private String filePath = null;
	
	public FileSenderFrame() {
		setTitle("파일 전송 클리아언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(fileNameTf);
		c.add(selBtn);
		c.add(sendBtn);
		
		selBtn.addActionListener(new FilchooseActionListener());
		sendBtn.addActionListener(new MyActionListener());
		setSize(350,150);
		setVisible(true);
	}
	
	class FilchooseActionListener implements ActionListener {
		private JFileChooser chooser;
		public FilchooseActionListener(){
			chooser = new JFileChooser();
		}
		@Override
		public void actionPerformed(ActionEvent e){
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION){
				JOptionPane.showMessageDialog(FileSenderFrame.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath();
			fileNameTf.setText(filePath);
		}
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			if(filePath == null)
				return;
			
			FileInputStream fin = null;
			File f = null;
			BufferedOutputStream fout = null;
			Scanner scanner = new Scanner(System.in);
			Socket socket = null;
			try{
				socket = new Socket("localhost", 9999);
				f = new File(filePath);
				long length = f.length();
				fin = new FileInputStream(f);
				fout = new BufferedOutputStream(socket.getOutputStream());
				
				byte[] fname = f.getName().getBytes();
				int nameSize = fname.length;
				fout.write(Command.FILE_NAME);
				sentInt(fout, nameSize);
				fout.write(fname);
				
				fout.write(Command.FILE_SIZE);
				sentInt(fout, (int)length);
				sentInt(fout, (int)length >>> 32);
				
				fout.write(Command.SEND_BEGIN);
				int count = 0;
				byte b[] = new byte[512];
				while (length > 0) {
					int numRead = fin.read(b,0,b.length);
					if (numRead <= 0) { 
						if (length > 0) { 
							System.out.println("전송 오류가 발생했습니다. 읽은 바이트: " + count + " 남은 바이트:" + length);					
							break;
						} 
					} else {
						fout.write(b, 0, numRead);
						length -= numRead;
						fout.flush();
						count += numRead;
					}
				}
				fout.write(Command.SEND_END);
				fout.flush();
				fin.close();
				socket.close();
				System.out.println("파일 전송이 완료 되었습니다.");
			}
			catch(IOException e2){
				System.out.println("파일 전송중 오류가 발생했습니다.");
			}
		}
	}
	
	private void sentInt(BufferedOutputStream fout, int value) throws IOException {
		fout.write(value & 0x000000ff);
		fout.write((value & 0x0000ff00)>>8);
		fout.write((value & 0x00ff0000)>>16);
		fout.write((value & 0xff000000)>>24);
	}
	
	public static void main(String[] args) {
		new FileSenderFrame();
	}

}



















