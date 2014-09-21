package modelo.movimentos;

import java.util.List;

import modelo.objetos.ObjetoGeometrico;

public class RotacionadorDaWindow {

	private int angulo;
	private double seno, cosseno, radiano;
	private Rotacionador rotacionador;

	public RotacionadorDaWindow(int angulo) {
		this.angulo = -angulo;
	}

	public void executar(List<ObjetoGeometrico> objetos) {
		for (ObjetoGeometrico objeto : objetos) {
			rotacionador = new Rotacionador(objeto, objeto.getCentroGeometrico(), angulo);
			rotacionador.movimentar();
		}
	}

}
