package modelo;

import java.util.List;

public class Poligono {

	private String nome;
	private List<Reta> retas;

	public Poligono(List<Reta> retas, String nome) {
		this.nome = nome;
		this.retas = retas;
	}

	public Poligono(String nome, List<Ponto> pontosExtremos) {
		this.nome = nome;
		criarRetas(pontosExtremos);
	}

	// TODO: Implementar um algoritmo que transforme os pontos em retas.
	private void criarRetas(List<Ponto> pontosExtremos) {

	}

	public String getNome() {
		return nome;
	}

	public List<Reta> getRetas() {
		return retas;
	}

}
