import java.awt.Image;

import javax.swing.Spring;

public class ShotSprite extends Sprite {
	private GalagaGame game;

	public ShotSprite(GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dy = -3;
	}

	@Override
	public void move() {
		super.move();
		if (y < 0) {//화면끝에서 탄이 사라지는 부분
			game.removeSprite(this);
		}
	}

	@Override
	public void handleCollision(Sprite other) {

		if (other instanceof AlienSprite) {//피격 판정이 발생하는 부분
			game.removeSprite(this);
			game.removeSprite(other);
			
		}
	}
}