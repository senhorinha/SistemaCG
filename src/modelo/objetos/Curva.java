package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;

// TODO: REFATORAR. Remover código duplicado.
public class Curva extends ObjetoGeometrico {

	double intervalo;
	double passo = .025;
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
		for (intervalo = passo; intervalo <= 1 + passo; intervalo += passo) {
			// @formatter:off
			x2 = (coordenadas.get(0).getX() + intervalo * (-coordenadas.get(0).getX() * 3 + intervalo * (3 * coordenadas.get(0).getX() - coordenadas.get(0).getX() * intervalo))) + intervalo
					* (3 * coordenadas.get(1).getX() + intervalo * (-6 * coordenadas.get(1).getX() + coordenadas.get(1).getX() * 3 * intervalo)) + intervalo * intervalo
					* (coordenadas.get(2).getX() * 3 - coordenadas.get(2).getX() * 3 * intervalo) + coordenadas.get(3).getX() * intervalo * intervalo * intervalo;
			y2 = (coordenadas.get(0).getY() + intervalo * (-coordenadas.get(0).getY() * 3 + intervalo * (3 * coordenadas.get(0).getY() - coordenadas.get(0).getY() * intervalo))) + intervalo
					* (3 * coordenadas.get(1).getY() + intervalo * (-6 * coordenadas.get(1).getY() + coordenadas.get(1).getY() * 3 * intervalo)) + intervalo * intervalo
					* (coordenadas.get(2).getY() * 3 - coordenadas.get(2).getY() * 3 * intervalo)
					+ coordenadas.get(3).getY()
					* intervalo * intervalo * intervalo;
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
		for (intervalo = passo; intervalo <= 1 + passo; intervalo += passo) {
			// @formatter:off
			x2 = (coordenadas.get(0).getX() + intervalo * (-coordenadas.get(0).getX() * 3 + intervalo * (3 * coordenadas.get(0).getX() - coordenadas.get(0).getX() * intervalo))) + intervalo
					* (3 * coordenadas.get(1).getX() + intervalo * (-6 * coordenadas.get(1).getX() + coordenadas.get(1).getX() * 3 * intervalo)) + intervalo * intervalo
					* (coordenadas.get(2).getX() * 3 - coordenadas.get(2).getX() * 3 * intervalo) + coordenadas.get(3).getX() * intervalo * intervalo * intervalo;
			y2 = (coordenadas.get(0).getY() + intervalo * (-coordenadas.get(0).getY() * 3 + intervalo * (3 * coordenadas.get(0).getY() - coordenadas.get(0).getY() * intervalo))) + intervalo
					* (3 * coordenadas.get(1).getY() + intervalo * (-6 * coordenadas.get(1).getY() + coordenadas.get(1).getY() * 3 * intervalo)) + intervalo * intervalo
					* (coordenadas.get(2).getY() * 3 - coordenadas.get(2).getY() * 3 * intervalo)
					+ coordenadas.get(3).getY()
					* intervalo * intervalo * intervalo;
			// @formatter:on
			Coordenada c1 = new Coordenada(x1, y1);
			Coordenada c2 = new Coordenada(x2, y2);
			Reta reta = new Reta("", this.cor, c1, c2);
			reta = reta.toClip(minima, maxima);
			if (reta != null) {
				retas.add(reta);
			}
			x1 = x2;
			y1 = y2;
		}
		return this;
	}

}
