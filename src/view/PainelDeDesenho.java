package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modelo.DisplayFile;
import modelo.ObjetoGeometrico;

public class PainelDeDesenho extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		DisplayFile instance = DisplayFile.obterInstancia();
		for (ObjetoGeometrico objetoGrafico : instance.getObjetos()) {
			objetoGrafico.desenhar(g, Color.RED);
		}
	}

}
