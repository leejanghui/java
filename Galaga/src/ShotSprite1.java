import java.awt.Image;

public class ShotSprite1 extends Sprite{
	private GalagaGame game;

	public ShotSprite1(GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dy = +3;
	}

	@Override
	public void move() {
		super.move();
		if (y < 0) {//ȭ�鳡���� ź�� ������� �κ�
			game.removeSprite(this);
		}
	}

	@Override
	public void handleCollision(Sprite other) {

		if (other instanceof AlienSprite) {//�ǰ� ������ �߻��ϴ� �κ�
			game.removeSprite(this);
			game.removeSprite(other);
			
		}
	}
}
