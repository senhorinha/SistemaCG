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
	private final List<Reta> retas;

	public Curva(String nome, Color cor, List<Coordenada> coordenadasDeControle, List<Coordenada> coordenadasNormais) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(0, coordenadasDeControle.get(0));
		coordenadas.addAll(coordenadasNormais);
		coordenadas.add(3, coordenadasDeControle.get(1));
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}
		retas = new ArrayList<Reta>();
		formarRetas();
	}

	private void formarRetas() {
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
			Coordenada c1 = new Coordenada(x1, y1);
			Coordenada c2 = new Coordenada(x2, y2);
			retas.add(new Reta("reta clipada", this.cor, c1, c2));
			x1 = x2;
			y1 = y2;
			// @formatter:on
		}
	}

	@Override
	public void desenhar(Graphics grafico) {
		for (Reta reta : retas) {
			reta.desenhar(grafico);
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
	public Curva toClip(Coordenada minima, Coordenada maxima) {
		retas.clear();
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
			Coordenada c1 = new Coordenada(x1, y1);
			Coordenada c2 = new Coordenada(x2, y2);
			Reta reta = new Reta("", this.cor, c1, c2);
			reta = reta.toClip(minima, maxima);
			if (reta == null) {
				break;
			}
			retas.add(reta);
			x1 = x2;
			y1 = y2;
		}
		return this;
	}

}
