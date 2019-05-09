import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalagaGame extends JPanel implements KeyListener {

	private boolean running = true;

	private ArrayList sprites = new ArrayList();
	private Sprite starship;
	//private int mob = 0;
	private int bouns = 0;
	private int shott = 12;
	private int rerode = 14;
	private BufferedImage alienImage;
	private BufferedImage shotImage;
	private BufferedImage shipImage;
	private BufferedImage KingalienImage;
	private BufferedImage alienmobImage;

	public GalagaGame() {//�⺻ Ʋ
		JFrame frame = new JFrame("Galaga Game");

		frame.setSize(800, 600);
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {//�̹��� �ε�
			shotImage = ImageIO.read(new File("fire.jpg"));
			shipImage = ImageIO.read(new File("starship.jpg"));
			alienImage = ImageIO.read(new File("alien.png"));
			KingalienImage = ImageIO.read(new File("Kingalien.jpg"));
			alienmobImage = ImageIO.read(new File("alienmob.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.requestFocus();
		this.initSprites();
		addKeyListener(this);

	}

	private void initSprites() {
		starship = new StarShipSprite(this, shipImage, 370, 480);
		sprites.add(starship);
		for (int y = 0; y < 4; y++) {//���� ���� ��
			for (int x = 0; x < 10; x++) {
				Sprite alienmob1 = new AlienSprite(this, alienmobImage, 100 + ((x+1) * 30), (50) + (y+1) * 50);//���� ���� ��ġ
				Sprite alienmob2= new AlienSprite(this, alienmobImage, 100 + ((x+1) * 30), (50) + (y+1) * 50);
				Sprite alienmob3 = new AlienSprite(this, alienmobImage, 100 + ((x+1) * 30), (50) + (y+1) * 50);
				Sprite alienmob4 = new AlienSprite(this, alienmobImage, 100 + ((x+1) * 30), (50) + (y+1) * 50);
				sprites.add(alienmob1);
				sprites.add(alienmob2);
				sprites.add(alienmob3);
				sprites.add(alienmob4);
				Sprite Kingalien1 = new AlienSprite(this, KingalienImage, 100 + 30, 50 + 50);
				Sprite Kingalien2 = new AlienSprite(this, KingalienImage, 100 + 30, 50 + 50);
				sprites.add(Kingalien1);
				sprites.add(Kingalien2);
			}
		}
		/*
			if(mob == 15){
				for(int i = 0; i < 10; i++){
					
			}
		}
		*/
	}
	
	

	private void startGame() {
		sprites.clear();
		initSprites();
	}

	public void endGame() {
		System.exit(0);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}

	public void fire() {
		ShotSprite shot = new ShotSprite(this, shotImage, starship.getX() + 10, starship.getY() - 30);
		sprites.add(shot);
		ShotSprite shot1 = new ShotSprite(this, shotImage, starship.getX() + 20, starship.getY() - 30);
		sprites.add(shot1);
		ShotSprite shot2 = new ShotSprite(this, shotImage, starship.getX() + 0, starship.getY() - 30);
		sprites.add(shot2);
	}
	public void fire1() {
		ShotSprite shot = new ShotSprite(this, shotImage, starship.getX() + 10, starship.getY() - 30);
		sprites.add(shot);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);
		for (int i = 0; i < sprites.size(); i++) {
			Sprite sprite = (Sprite) sprites.get(i);
			sprite.draw(g);
		}
	}

	public void gameLoop() {

		while (running) {
			for (int i = 0; i < sprites.size(); i++) {
				Sprite sprite = (Sprite) sprites.get(i);
				sprite.move();
			}

			for (int p = 0; p < sprites.size(); p++) {
				for (int s = p + 1; s < sprites.size(); s++) {
					Sprite me = (Sprite) sprites.get(p);
					Sprite other = (Sprite) sprites.get(s);

					if (me.checkCollision(other)) {
						me.handleCollision(other);
						other.handleCollision(me);
					}
				}
			}

			repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			starship.setDx(-3);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.setDx(+3);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.setDy(-3);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.setDy(+3);
		
		if (shott > 0) {
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				bouns++;
				shott--;
				fire1();
			}
		}
		
		if (shott > 2) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				bouns++;
				bouns++;
				shott--;
				shott--;
				fire();
			}
		}
		
		if (bouns > 10) {
			if (e.getKeyCode() == KeyEvent.VK_E) {
				fire();
				fire();
				fire();
				bouns = bouns - 10;
			}
		}

		if (rerode > 0) {
			if (e.getKeyCode() == KeyEvent.VK_R) {
				shott = 10;
				rerode--;
			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.setDy(0);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.setDy(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public static void main(String argv[]) {
		GalagaGame g = new GalagaGame();
		g.gameLoop();
	}
}