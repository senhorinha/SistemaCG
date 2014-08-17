package modelo;

import java.util.ArrayList;

public abstract class ObjetoGeometrico {

	String nome;
	String tipo;
	ArrayList<Coordenada> coordenadas;

	abstract String getNome();

	abstract String getTipo();

	abstract ArrayList<Coordenada> obterPontos();

}
