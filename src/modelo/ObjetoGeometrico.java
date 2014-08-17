package modelo;

import java.util.List;

public abstract class ObjetoGeometrico {

	String nome;
	List<Coordenada> coordenadas;

	public abstract String getNome();

	public abstract List<Coordenada> obterCoordenadas();

}
