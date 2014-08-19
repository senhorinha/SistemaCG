package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Poligono extends ObjetoGeometrico {

	public Poligono(String nome, List<Coordenada> coordenadas) {
		this.nome = nome;
		this.coordenadas = coordenadas;
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
		int nPoints = this.obterCoordenadas().size();
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];
		
		for (int i = 0; i < this.obterCoordenadas().size(); i++ ) {
			xPoints[i] = this.obterCoordenadas().get(i).getX();
			yPoints[i] = this.obterCoordenadas().get(i).getY();
		}
		
		grafico.drawPolygon(xPoints, yPoints, nPoints);
	}

}
