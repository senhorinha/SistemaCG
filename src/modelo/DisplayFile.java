package modelo;

import java.util.ArrayList;

public class DisplayFile {

	static DisplayFile displayFile = null;
	FabricaObjetos fabrica;
	ArrayList<ObjetoGeometrico> objetos;

	private DisplayFile() {

		objetos = new ArrayList<ObjetoGeometrico>();
		fabrica = FabricaObjetos.obterInstancia();

	}

	static DisplayFile obterInstancia() {
		if (displayFile == null)
			return new DisplayFile();
		return displayFile;
	}

	Ponto criarPonto(String nome, Coordenada c) {
		Ponto ponto = fabrica.criarPonto(nome, c);
		objetos.add(ponto);
		return ponto;
	}

	Reta criarReta(String nome, Coordenada a, Coordenada b) {
		Reta reta = fabrica.criarReta(nome, a, b);
		objetos.add(reta);
		return reta;
	}

}
