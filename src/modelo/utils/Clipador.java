package modelo.utils;

import modelo.Coordenada;
import modelo.Window;
import modelo.objetos.Ponto;

public class Clipador {

	public boolean executar(Ponto ponto, Window window) {
		Coordenada coordenada = ponto.getCoordenadas().get(0);
		if (coordenada != null) {
			return (estaNoIntervalo(coordenada.getX(), window.getxMin(), window.getxMax()) && estaNoIntervalo(
					coordenada.getY(), window.getyMin(), window.getyMax()));
		}
		return false;
	}

	private boolean estaNoIntervalo(double valor, double minimo, double maximo) {
		return (valor >= minimo) && (valor <= maximo);
	}

}
