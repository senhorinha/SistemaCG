package modelo;

public class FabricaObjetos {

	static FabricaObjetos fabrica = null;

	private FabricaObjetos() {

	}

	static FabricaObjetos obterInstancia() {
		if (fabrica == null)
			return new FabricaObjetos();
		return fabrica;
	}

	Ponto criarPonto(int x, int y, String nome) {
		return new Ponto(x, y, nome);
	}

	Reta criarReta(Ponto a, Ponto b, String nome) {
		return new Reta(a, b, nome);
	}

}
