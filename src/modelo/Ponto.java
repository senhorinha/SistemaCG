package modelo;

import java.util.ArrayList;

public class Ponto extends ObjetoGeometrico {

	public Ponto(String nome, Coordenada c) {
		this.nome = nome;
		this.tipo = "ponto";
		this.coordenadas.add(c);
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
