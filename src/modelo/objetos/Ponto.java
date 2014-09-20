package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.Coordenada;

public class Ponto extends ObjetoGeometrico {

	public Ponto() {
		this.cor = Color.BLACK;
	}

	public Ponto(String nome, Color cor, Coordenada c) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(c);
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}

	}

	@Override
	public void desenhar(Graphics grafico) {
		grafico.setColor(cor);
		int coordenadaX = (int) this.getCoordenadas().get(0).getX();
		int coordenadaY = (int) this.getCoordenadas().get(0).getY();
		grafico.setColor(cor);
		grafico.drawLine(coordenadaX, coordenadaY, coordenadaX, coordenadaY);
	}

	@Override
	public ObjetoGeometrico toClip(Coordenada minimo, Coordenada maximo) {
		Coordenada coordenada = coordenadas.get(0);
		if (coordenada != null) {
			if (estaNoIntervalo(coordenada.getX(), minimo.getX(), maximo.getX())
					&& estaNoIntervalo(coordenada.getY(), minimo.getY(), maximo.getY())) {
				return this;
			}
		}
		return null;
	}

	private boolean estaNoIntervalo(double valor, double minimo, double maximo) {
		return (valor >= minimo) && (valor <= maximo);
	}

}
