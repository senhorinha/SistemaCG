package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Poligono extends ObjetoGeometrico {

	public Poligono() {

	}

	public Poligono(String nome, List<Coordenada> coordenadas) {
		this.nome = nome;
		this.coordenadas = coordenadas;
	}

	@Override
	public void desenhar(Graphics grafico, Color cor) {
		int nPoints = this.getCoordenadas().size();
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];

		for (int i = 0; i < this.getCoordenadas().size(); i++) {
			xPoints[i] = this.getCoordenadas().get(i).getX();
			yPoints[i] = this.getCoordenadas().get(i).getY();
		}

		grafico.drawPolygon(xPoints, yPoints, nPoints);
	}

}
