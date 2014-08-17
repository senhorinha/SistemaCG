package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ponto extends ObjetoGeometrico {

	public Ponto(String nome, Coordenada c) {
		this.nome = nome;
		this.coordenadas = new ArrayList<Coordenada>();
		this.coordenadas.add(c);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public List<Coordenada> obterCoordenadas() {
		return coordenadas;
	}

}
