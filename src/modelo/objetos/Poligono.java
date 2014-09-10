package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import modelo.Coordenada;

public class Poligono extends ObjetoGeometrico {

	public Poligono() {
		this.cor = Color.BLACK;
	}

	public Poligono(String nome, Color cor, List<Coordenada> coordenadas) {
		this.nome = nome;
		this.coordenadas = coordenadas;
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}
	}

	@Override
	public void desenhar(Graphics grafico) {
		int nPoints = this.getCoordenadas().size();
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];

		for (int i = 0; i < this.getCoordenadas().size(); i++) {
			xPoints[i] = (int) this.getCoordenadas().get(i).getX();
			yPoints[i] = (int) this.getCoordenadas().get(i).getY();
		}
		grafico.setColor(cor);
		grafico.drawPolygon(xPoints, yPoints, nPoints);
	}

}
