package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class ObjetoGeometrico implements Cloneable {

	String nome;
	List<Coordenada> coordenadas;

	public abstract void desenhar(Graphics grafico, Color cor);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public void transformarCoordenadas(Transformacao transformacao) {
		transformacao.executar(this.coordenadas);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
