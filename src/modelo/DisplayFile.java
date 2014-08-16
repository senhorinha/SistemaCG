package modelo;

import java.util.ArrayList;

public class DisplayFile {

	static DisplayFile displayFile = null;
	FabricaObjetos fabrica;
	ArrayList objetos;

	private DisplayFile() {

		objetos = new ArrayList();
		fabrica = FabricaObjetos.obterInstancia();

	}

	static DisplayFile obterInstancia() {
		if (displayFile == null)
			return new DisplayFile();
		return displayFile;
	}

	Ponto criarPonto(int x, int y, String nome) {
		Ponto ponto = fabrica.criarPonto(x, y, nome);
		objetos.add(ponto);
		return ponto;
	}

	Reta criarReta(Ponto a, Ponto b, String nome) {
		Reta reta = fabrica.criarReta(a, b, nome);
		objetos.add(reta);
		return reta;
	}

}
