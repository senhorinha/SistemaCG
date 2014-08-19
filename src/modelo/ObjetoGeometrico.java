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

	public void transformarCoordenadas(Transformacao transformacao) {
		transformacao.executar(this.coordenadas);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
