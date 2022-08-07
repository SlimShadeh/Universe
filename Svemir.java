package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {

	private ArrayList<NebeskoTelo> tela = new ArrayList<>();
	boolean work = false;
	Thread thread = new Thread(this);

	public Svemir() {
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g) {

	}

	public synchronized void pokreni() {
		work = true;
		thread.start();
		notify();
	}

	public synchronized void zaustavi() {
		work = false;
		thread.interrupt();

	}

	public void run() {
		try {
			while (!thread.isInterrupted()) {
				synchronized (this) {
					while (!work) {
						wait();
					}
					for (int i = 0; i < tela.size(); i++) {
						tela.get(i).paint(getGraphics());
						tela.get(i).pomeriY(5);

					}

					repaint();
					Thread.sleep(100);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public synchronized void dodajNebeskoTelo(NebeskoTelo nb) {
		tela.add(nb);
	}
}
