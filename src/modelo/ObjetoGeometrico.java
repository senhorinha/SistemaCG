package modelo;

import java.util.ArrayList;

public abstract class ObjetoGeometrico {

	String nome;
	String tipo;
	ArrayList<Coordenada> coordenadas;

	public abstract String getNome();

	public abstract String getTipo();

	public abstract ArrayList<Coordenada> obterCoordenadas();

}
