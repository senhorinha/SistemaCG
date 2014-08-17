package view;

import java.awt.Color;
import java.awt.Graphics2D;

import modelo.Poligono;
import modelo.Ponto;
import modelo.Reta;

public class Desenhista {

	private final Graphics2D grafico;

	public Desenhista(Graphics2D grafico) {
		this.grafico = grafico;
	}

	public void desenhar(Reta reta, Color cor) {
		this.mudarCor(cor);
		int[] coordenadas = reta.getCoordenadasDosPontos();
		grafico.drawLine(coordenadas[0], coordenadas[1], coordenadas[2],
				coordenadas[3]);
	}

	public void desenhar(Ponto ponto, Color cor) {
		this.mudarCor(cor);
		grafico.drawLine(ponto.getX(), ponto.getY(), ponto.getX(), ponto.getY());
	}

	public void desenhar(Poligono poligono, Color cor) {
		for (Reta reta : poligono.getRetas()) {
			desenhar(reta, cor);
		}
	}

	private void mudarCor(Color cor) {
		grafico.setColor(cor);
	}

}
