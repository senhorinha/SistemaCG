package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modelo.Coordenada;
import modelo.DisplayFile;
import modelo.ObjetoGeometrico;
import modelo.Reta;

public class PainelDeDesenho extends JPanel {

	public PainelDeDesenho() {
		DisplayFile.obterInstancia().adicionar(
				new Reta("reta", new Coordenada(10, 10), new Coordenada(100,
						100)));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(100, 100, 500, 500);
		for (ObjetoGeometrico objetoGrafico : DisplayFile.obterInstancia()
				.getObjetos()) {
			objetoGrafico.desenhar(g, Color.BLACK);
		}
	}

}
