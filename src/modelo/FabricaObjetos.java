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

	public Ponto criarPonto(int x, int y, String nome) {
		return new Ponto(x, y, nome);
	}

	public Reta criarReta(Ponto a, Ponto b, String nome) {
		return new Reta(a, b, nome);
	}

	public Poligono criarPoligono() {
		return null;
	}

}
