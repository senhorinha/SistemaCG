package modelo;

import java.util.ArrayList;
import java.util.List;

public class DisplayFile {

	private static DisplayFile displayFile = null;
	private List<ObjetoGeometrico> objetos;

	private DisplayFile() {
		objetos = new ArrayList<ObjetoGeometrico>();
	}

	public static DisplayFile obterInstancia() {
		if (displayFile == null) {
			displayFile = new DisplayFile();
		}
		return displayFile;
	}

	public boolean adicionar(ObjetoGeometrico objeto) {
		return objetos.add(objeto);
	}

	public void remover(int indice) {
		objetos.remove(indice);
	}

	public List<ObjetoGeometrico> getObjetos() {
		return objetos;
	}

}
