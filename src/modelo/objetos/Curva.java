package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;

/**
 * Curva de Bézier
 * 
 */
public class Curva extends ObjetoGeometrico {

	double t; // the time interval
	double k = .025; // time step value for drawing curve
	private List<Coordenada> coordenadasDeControle;

	public Curva() {
		this.cor = Color.BLACK;
	}

	public Curva(String nome, Color cor, List<Coordenada> coordenadasDeControle, List<Coordenada> coordenadasNormais) {
		this.nome = nome;
		this.coordenadasDeControle = coordenadasDeControle;
		this.coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(coordenadasDeControle.get(0));
		coordenadas.addAll(coordenadasNormais);
		coordenadas.add(coordenadasDeControle.get(1));
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}
	}
	
	@Override
	public void desenhar(Graphics grafico) {
		double x1, x2, y1, y2;
		x1 = coordenadas.get(0).getX();
		y1 = coordenadas.get(0).getY();
		for (t = k; t <= 1 + k; t += k) {
			// @formatter:off
			x2 = (coordenadas.get(0).getX() + t * (-coordenadas.get(0).getX() * 3 + t * (3 * coordenadas.get(0).getX() - coordenadas.get(0).getX() * t))) + t
					* (3 * coordenadas.get(1).getX() + t * (-6 * coordenadas.get(1).getX() + coordenadas.get(1).getX() * 3 * t)) + t * t
					* (coordenadas.get(2).getX() * 3 - coordenadas.get(2).getX() * 3 * t) + coordenadas.get(3).getX() * t * t * t;
			y2 = (coordenadas.get(0).getY() + t * (-coordenadas.get(0).getY() * 3 + t * (3 * coordenadas.get(0).getY() - coordenadas.get(0).getY() * t))) + t
					* (3 * coordenadas.get(1).getY() + t * (-6 * coordenadas.get(1).getY() + coordenadas.get(1).getY() * 3 * t)) + t * t
					* (coordenadas.get(2).getY() * 3 - coordenadas.get(2).getY() * 3 * t)
					+ coordenadas.get(3).getY()
					* t * t * t;
			// @formatter:on
			grafico.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
			x1 = x2;
			y1 = y2;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Coordenada coordenada : coordenadas) {
			stringBuilder.append(coordenada);
		}
		return stringBuilder.toString();
	}

	@Override
	public ObjetoGeometrico toClip(Coordenada minima, Coordenada maxima) {
		return null;
	}

}
