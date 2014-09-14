package modelo.utils;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Poligono;
import modelo.objetos.Ponto;
import modelo.objetos.Reta;

public class Clipador {

	public static List<ObjetoGeometrico> executar(List<ObjetoGeometrico> objetos, final Coordenada minimo,
			final Coordenada maximo) {
		List<ObjetoGeometrico> objetosClipados = new ArrayList<ObjetoGeometrico>();
		for (ObjetoGeometrico objetoGeometrico : objetos) {
			if (objetoGeometrico instanceof Ponto) {
				objetoGeometrico = cliparPonto((Ponto) objetoGeometrico, minimo, maximo);
			} else if (objetoGeometrico instanceof Reta) {
				objetoGeometrico = cliparReta((Reta) objetoGeometrico, minimo, maximo);
			} else if (objetoGeometrico instanceof Poligono) {
				objetoGeometrico = cliparPoligono((Poligono) objetoGeometrico, minimo, maximo);
			}
			if (objetoGeometrico != null) {
				objetosClipados.add(objetoGeometrico);
			}
		}
		return objetosClipados;
	}

	private static Ponto cliparPonto(Ponto ponto, Coordenada minimo, Coordenada maximo) {
		Coordenada coordenada = ponto.getCoordenadas().get(0);
		if (coordenada != null) {
			if (estaNoIntervalo(coordenada.getX(), minimo.getX(), maximo.getX())
					&& estaNoIntervalo(coordenada.getY(), minimo.getY(), maximo.getY())) {
				return ponto;
			}
		}
		return null;
	}

	private static boolean estaNoIntervalo(double valor, double minimo, double maximo) {
		return (valor >= minimo) && (valor <= maximo);
	}

	private static Reta cliparReta(Reta reta, Coordenada minimo, Coordenada maximo) {
		return MetodoDeCohenSutherland.clipar(reta, minimo, maximo);
	}

	private static Poligono cliparPoligono(Poligono poligono, Coordenada minimo, Coordenada maximo) {
		return poligono;
	}

}
