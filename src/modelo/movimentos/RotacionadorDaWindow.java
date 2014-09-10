package modelo.movimentos;

import java.util.List;

import modelo.DisplayFile;
import modelo.objetos.ObjetoGeometrico;

public class RotacionadorDaWindow {

	int angulo;
	double seno, cosseno, radiano;
	List<ObjetoGeometrico> objetos = DisplayFile.obterInstancia().getObjetos();
	Rotacionador rotacionador;

	public RotacionadorDaWindow(int angulo) {
		this.angulo = -angulo;
	}

	public void executar() {

		for (ObjetoGeometrico objeto : objetos) {
			rotacionador = new Rotacionador(objeto, objeto.getCentroGeometrico(), angulo);
			rotacionador.movimentar();
		}

	}

}
