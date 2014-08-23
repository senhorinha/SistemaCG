package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ponto extends ObjetoGeometrico {

	public Ponto() {

	}

	public Ponto(String nome, Color cor, Coordenada c) {
		this.nome = nome;
		this.cor = cor;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(c);
	}

	@Override
	public void desenhar(Graphics grafico) {
		grafico.setColor(cor);
		int coordenadaX = this.getCoordenadas().get(0).getX();
		int coordenadaY = this.getCoordenadas().get(0).getY();
		grafico.setColor(cor);
		grafico.drawLine(coordenadaX, coordenadaY, coordenadaX, coordenadaY);
	}

}
