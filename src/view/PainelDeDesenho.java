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
		DisplayFile instance = DisplayFile.obterInstancia();
		instance.adicionar(new Reta("reta", new Coordenada(100, 100),
				new Coordenada(400, 400)));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		DisplayFile instance = DisplayFile.obterInstancia();
		for (ObjetoGeometrico objetoGrafico : instance.getObjetos()) {
			objetoGrafico.desenhar(g, Color.GREEN);
		}
	}

}
