package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class ObjetoGeometrico {

	String nome;
	List<Coordenada> coordenadas;

	public abstract String getNome();

	public abstract List<Coordenada> obterCoordenadas();
	
	public abstract void desenhar(Graphics grafico, Color cor);

}
