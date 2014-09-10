package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.Coordenada;

public class Reta extends ObjetoGeometrico {

	public Reta() {
		this.cor = Color.BLACK;
	}

	public Reta(String nome, Color cor, Coordenada a, Coordenada b) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(a);
		this.coordenadas.add(b);
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}
	}

	@Override
	public String getNome() {
		return nome;
	}

	public Coordenada obterP1() {
		return coordenadas.get(0);
	}

	public Coordenada obterP2() {
		return coordenadas.get(1);
	}

	@Override
	public void desenhar(Graphics grafico) {
		grafico.setColor(cor);
		int coordenadaX1 = this.obterP1().getX();
		int coordenadaY1 = this.obterP1().getY();
		int coordenadaX2 = this.obterP2().getX();
		int coordenadaY2 = this.obterP2().getY();
		grafico.setColor(cor);
		grafico.drawLine(coordenadaX1, coordenadaY1, coordenadaX2, coordenadaY2);
	}

}