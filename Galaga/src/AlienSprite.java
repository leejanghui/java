import java.awt.Image;

public class AlienSprite extends Sprite {
	private GalagaGame game;

	public AlienSprite(GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dx = -8;
		dy = +4;
	}

	@Override
	public void move() {
		if (((dx < 0) && (x < 10)) || ((dx > 0) && (x > 1800))) {
			dx = -dx;
			if (((dy < 200) && (y < 0)) || ((dy > 0) && (y > 900))) {
				dy = -dy;
			}
		}
		super.move();
	}

}