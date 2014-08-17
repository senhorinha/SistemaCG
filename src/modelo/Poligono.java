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
	public String getTipo() {
		return tipo;
	}

	@Override
	public ArrayList<Coordenada> obterCoordenadas() {
		return coordenadas;
	}

}
