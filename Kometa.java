package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {

	private double angle = Math.random() * 0.4 * Math.PI;

	public Kometa(int x, int y, int r) {
		super(x, y, r, Color.GRAY);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		int nizX[] = new int[5];
		int nizY[] = new int[5];
		int xP = this.getX();
		int yP = this.getY();

		double step = 72. / 180 * Math.PI;
		for (int i = 0; i < 5; i++) {
			nizX[i] = xP + (int) (r * Math.cos(angle + i * step));
			nizY[i] = yP + (int) (r * Math.sin(angle + i * step));
		}
		g.fillPolygon(nizX, nizY, 5);
	}
}
