package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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
		int coordenadaX1 = reta.obterP1().getX();
		int coordenadaY1 = reta.obterP1().getY();
		int coordenadaX2 = reta.obterP2().getX();
		int coordenadaY2 = reta.obterP2().getY();
		grafico.drawLine(coordenadaX1, coordenadaY1, coordenadaX2, coordenadaY2);
	}

	public void desenhar(Ponto ponto, Color cor) {
		this.mudarCor(cor);
		int coordenadaX = ponto.obterCoordenadas().get(0).getX();
		int coordenadaY = ponto.obterCoordenadas().get(0).getY();
		grafico.drawLine(coordenadaX, coordenadaY, coordenadaX, coordenadaY);
	}

	public void desenhar(Poligono poligono, Color cor) {
		int nPoints = poligono.obterCoordenadas().size();
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];
		
		for (int i = 0; i < poligono.obterCoordenadas().size(); i++ ) {
			xPoints[i] = poligono.obterCoordenadas().get(i).getX();
			yPoints[i] = poligono.obterCoordenadas().get(i).getY();
		}
		
		grafico.drawPolygon(xPoints, yPoints, nPoints);
	}

	private void mudarCor(Color cor) {
		grafico.setColor(cor);
	}

}
