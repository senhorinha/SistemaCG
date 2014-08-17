package modelo;

public class Reta {

	private Ponto a;
	private Ponto b;
	private String nome;

	public Reta(Ponto a, Ponto b, String nome) {
		this.a = a;
		this.b = b;
		this.nome = nome;
	}

	public Ponto getA() {
		return a;
	}

	public void setA(Ponto a) {
		this.a = a;
	}

	public Ponto getB() {
		return b;
	}

	public void setB(Ponto b) {
		this.b = b;
	}

	public int[] getCoordenadasDosPontos() {
		int[] coordenadas = { a.getX(), a.getY(), b.getX(), b.getY() };
		return coordenadas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
