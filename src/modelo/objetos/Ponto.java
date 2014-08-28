package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.Coordenada;

public class Ponto extends ObjetoGeometrico {

	public Ponto() {
		this.cor = Color.BLACK;
	}

	public Ponto(String nome, Color cor, Coordenada c) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(c);
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}

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
