import java.awt.Image;

public class AlienSprite extends Sprite {
	private GalagaGame game;

	public AlienSprite(GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dx = -3;
		dy = +1;
	}

	@Override
	public void move() {
		if (((dx < 0) && (x < 10)) || ((dx > 0) && (x > 780))) {
			dx = -dx;
			if (((dy < 0) && (y < 10)) || ((dy > 0) && (y > 470))) {
				dy = -dy;
			}
		}
		super.move();
	}

}