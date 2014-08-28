package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import modelo.Coordenada;
import modelo.transformacoes.Transformacao;

public abstract class ObjetoGeometrico implements Cloneable {

	String nome;
	List<Coordenada> coordenadas;
	Color cor;

	public abstract void desenhar(Graphics grafico);

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

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public void transformarCoordenadas(Transformacao transformacao) {
		transformacao.executar(this.coordenadas);
	}

	public Coordenada getCentroGeometrico() {
		int x = 0, y = 0;
		for (Coordenada coordenada : coordenadas) {
			x = x + coordenada.getX();
			y = y + coordenada.getY();
		}
		x = x / coordenadas.size();
		y = y / coordenadas.size();
		return new Coordenada(x, y);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
