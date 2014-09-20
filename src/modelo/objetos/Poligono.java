package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import modelo.Coordenada;
import modelo.utils.MetodoDeCohenSutherland;

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

	@Override
	public ObjetoGeometrico toClip(Coordenada minima, Coordenada maxima) {
		System.out.printf("Polígono original: %s", this);
		List<Reta> retasClipadas = separarEmRetas();
		Set<Coordenada> novasCoordenadas = new LinkedHashSet<Coordenada>();
		for (Reta reta : retasClipadas) {
			reta = MetodoDeCohenSutherland.clipar(reta, minima, maxima);
			if (reta != null) {
				novasCoordenadas.add(reta.getCoordenadas().get(0));
				novasCoordenadas.add(reta.getCoordenadas().get(1));
			}
		}
		coordenadas = new ArrayList<Coordenada>(novasCoordenadas);
		System.out.printf("Polígono clipado: %s", this);
		return novasCoordenadas.size() < 2 ? null : this;
	}

	private List<Reta> separarEmRetas() {
		List<Reta> retas = new ArrayList<Reta>();
		Coordenada c1;
		Coordenada c2;
		for (int i = 0; i < coordenadas.size(); i++) {
			c1 = coordenadas.get(i);
			c2 = i == coordenadas.size() - 1 ? coordenadas.get(0) : coordenadas.get(i + 1);
			retas.add(new Reta("", null, c1, c2));
		}
		return retas;
	}

}
