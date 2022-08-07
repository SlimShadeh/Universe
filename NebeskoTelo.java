package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {

	protected int r;

	public NebeskoTelo(int x, int y, int r, Color boja) {
		super(x, y, boja);
		this.r = r;
	}

}
