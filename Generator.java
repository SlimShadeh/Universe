package gui;

import java.awt.Graphics;

public class Generator extends Thread {

	Svemir svemir;

	public Generator(Svemir svemir) {
		this.svemir = svemir;
	}

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				synchronized (this) {
					while (!svemir.work) {
						wait();
					}
					int x = (int) (Math.random() * 200);
					int r = 10 + (int) (Math.random() * 20);
					Kometa k = new Kometa(x, 0, r);
					svemir.dodajNebeskoTelo(k);
					sleep(900);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public synchronized void pokreni() {
		this.start();
		notify();
	}

	public synchronized void zaustavi() {
		this.interrupt();

	}
}
