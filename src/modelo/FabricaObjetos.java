package modelo;

public class FabricaObjetos {

	private static FabricaObjetos fabrica;

	private FabricaObjetos() {

	}

	public static FabricaObjetos obterInstancia() {
		if (fabrica == null) {
			return new FabricaObjetos();
		}
		return fabrica;
	}

	public Ponto criarPonto(String nome, Coordenada c) {
		return new Ponto(nome, c);
	}

	public Reta criarReta(String nome, Coordenada a, Coordenada b) {
		return new Reta(nome, a, b);
	}

	public Poligono criarPoligono() {
		return null;
	}

}
