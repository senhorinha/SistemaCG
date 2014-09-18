package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import modelo.Coordenada;

public class Poligono extends ObjetoGeometrico {

	private boolean preenchido;

	public Poligono() {
		this.cor = Color.BLACK;
	}

	public Poligono(String nome, Color cor, List<Coordenada> coordenadas, boolean preenchido) {
		this.nome = nome;
		this.coordenadas = coordenadas;
		this.preenchido = preenchido;
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
		if (preenchido) {
			grafico.fillPolygon(xPoints, yPoints, nPoints);
		} else {
			grafico.drawPolygon(xPoints, yPoints, nPoints);
		}
	}

	@Override
	public String toString() {
		// StringBuilder stringBuilder = new
		// StringBuilder(this.getClass().getSimpleName());
		// stringBuilder.append(": ").append(nome).append(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for (Coordenada coordenada : coordenadas) {
			stringBuilder.append(coordenada);
		}
		return stringBuilder.toString();
	}
	
}
