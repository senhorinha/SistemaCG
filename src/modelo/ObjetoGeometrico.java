package modelo;

import java.util.List;

public abstract class ObjetoGeometrico {

	String nome;
	String tipo;
	List<Coordenada> coordenadas;

	public abstract String getNome();

	public abstract String getTipo();

	public abstract List<Coordenada> obterCoordenadas();

}
