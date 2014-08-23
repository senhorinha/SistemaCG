package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Reta extends ObjetoGeometrico {

	public Reta() {

	}

	public Reta(String nome, Color cor, Coordenada a, Coordenada b) {
		this.nome = nome;
		this.cor = cor;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(a);
		this.coordenadas.add(b);
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
