package modelo.utils;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.Window;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Poligono;
import modelo.objetos.Ponto;
import modelo.objetos.Reta;

public class Clipador {

	public List<ObjetoGeometrico> executar(List<ObjetoGeometrico> objetos, final Window window) {
		List<ObjetoGeometrico> objetosClipados = new ArrayList<ObjetoGeometrico>();
		for (ObjetoGeometrico objetoGeometrico : objetos) {
			if (objetoGeometrico instanceof Ponto) {
				objetoGeometrico = cliparPonto((Ponto) objetoGeometrico, window);
			} else if (objetoGeometrico instanceof Reta) {
				objetoGeometrico = cliparReta((Reta) objetoGeometrico, window);
			} else if (objetoGeometrico instanceof Poligono) {
				objetoGeometrico = cliparPoligono((Poligono) objetoGeometrico, window);
			}
			if (objetoGeometrico != null) {
				objetosClipados.add(objetoGeometrico);
			}
		}
		return objetosClipados;
	}

	private Ponto cliparPonto(Ponto ponto, final Window window) {
		Coordenada coordenada = ponto.getCoordenadas().get(0);
		if (coordenada != null) {
			if (estaNoIntervalo(coordenada.getX(), window.getxMin(), window.getxMax())
					&& estaNoIntervalo(coordenada.getY(), window.getyMin(), window.getyMax())) {
				return ponto;
			}
		}
		return null;
	}

	private boolean estaNoIntervalo(double valor, double minimo, double maximo) {
		return (valor >= minimo) && (valor <= maximo);
	}

	private Reta cliparReta(Reta reta, final Window window) {
		return MetodoDeCohenSutherland.clipar(reta, window);
	}

	private Poligono cliparPoligono(Poligono poligono, final Window window) {
		return poligono;
	}

}
