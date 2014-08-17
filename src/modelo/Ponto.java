package modelo;

import java.util.List;

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
	public String getTipo() {
		return tipo;
	}

	@Override
	public List<Coordenada> obterCoordenadas() {
		return coordenadas;
	}

}
