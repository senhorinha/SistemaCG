package modelo;

import java.util.List;

public class Poligono extends ObjetoGeometrico {

	public Poligono(String nome, List<Coordenada> coordenadas) {
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
	public List<Coordenada> obterCoordenadas() {
		return coordenadas;
	}

}
