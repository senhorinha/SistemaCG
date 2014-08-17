package modelo;

import java.util.ArrayList;

public class Poligono extends ObjetoGeometrico {

	public Poligono(String nome, ArrayList<Coordenada> coordenadas) {
		this.nome = nome;
		this.tipo = "poligono";
		this.coordenadas = coordenadas;
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

}
