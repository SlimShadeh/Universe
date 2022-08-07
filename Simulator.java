package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {

	private Panel bottomPanel = new Panel();
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);

	public Simulator() {
		setBounds(700, 200, 200, 400);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				svemir.zaustavi();
				generator.zaustavi();
				dispose();
			}
		});

		Button pokreni = new Button("Pokreni!");
		pokreni.addActionListener((ae) -> {
			svemir.pokreni();
			generator.pokreni();
			pokreni.setEnabled(false);
		});

		bottomPanel.add(pokreni);
		add(bottomPanel, BorderLayout.SOUTH);
		add(svemir, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Simulator();
	}
}
