package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {

	private int x, y;
	private Color boja;

	public Objekat(int x, int y, Color boja) {
		this.x = x;
		this.y = y;
		this.boja = boja;
	}

	public void pomeriX(int xPomeraj) {
		x += xPomeraj;
	}

	public void pomeriY(int yPomeraj) {
		y += yPomeraj;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract void paint(Graphics g);
}
