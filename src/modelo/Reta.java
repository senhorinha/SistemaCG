package modelo;

import java.util.ArrayList;

public class Reta extends ObjetoGeometrico {

	public Reta(String nome, Coordenada a, Coordenada b) {
		this.nome = nome;
		this.tipo = "reta";
		this.coordenadas.add(a);
		this.coordenadas.add(b);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	String getTipo() {
		return tipo;
	}

	@Override
	ArrayList<Coordenada> obterPontos() {
		return coordenadas;
	}

	public Coordenada obterP1() {
		return coordenadas.get(0);
	}

	public Coordenada obterP2() {
		return coordenadas.get(1);
	}

}
