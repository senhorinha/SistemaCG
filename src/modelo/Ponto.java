package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Ponto extends ObjetoGeometrico {

	public Ponto(String nome, Coordenada c) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(c);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public List<Coordenada> obterCoordenadas() {
		return coordenadas;
	}

	@Override
	public void desenhar(Graphics grafico, Color cor) {
		grafico.setColor(cor);
		int coordenadaX = this.obterCoordenadas().get(0).getX();
		int coordenadaY = this.obterCoordenadas().get(0).getY();
		grafico.drawLine(coordenadaX, coordenadaY, coordenadaX, coordenadaY);
	}

}
