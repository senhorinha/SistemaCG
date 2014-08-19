package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class ObjetoGeometrico implements Cloneable {

	String nome;
	List<Coordenada> coordenadas;

	public abstract String getNome();

	public abstract List<Coordenada> obterCoordenadas();

	public abstract void desenhar(Graphics grafico, Color cor);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
