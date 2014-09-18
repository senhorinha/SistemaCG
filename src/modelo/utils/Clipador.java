package modelo.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

	public static ObjetoGeometrico executar(ObjetoGeometrico objeto, final Coordenada minimo, final Coordenada maximo) {
		if (objeto instanceof Ponto) {
			objeto = cliparPonto((Ponto) objeto, minimo, maximo);
		} else if (objeto instanceof Reta) {
			objeto = cliparReta((Reta) objeto, minimo, maximo);
		} else if (objeto instanceof Poligono) {
			objeto = cliparPoligono((Poligono) objeto, minimo, maximo);
		}
		return objeto;
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
		System.out.printf("Polígono original: %s", poligono);
		List<Reta> retasClipadas = separarPoligonoEmRetas(poligono);
		Set<Coordenada> novasCoordenadas = new LinkedHashSet<Coordenada>();
		for (Reta reta : retasClipadas) {
			try {
				reta = cliparReta((Reta) reta.clone(), minimo, maximo);
				if (reta != null) {
					novasCoordenadas.add(reta.getCoordenadas().get(0));
					novasCoordenadas.add(reta.getCoordenadas().get(1));
				}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		poligono.setCoordenadas(new ArrayList<Coordenada>(novasCoordenadas));
		System.out.printf("Polígono clipado: %s", poligono);
		return novasCoordenadas.size() < 2 ? null : poligono;
	}

	private static List<Reta> separarPoligonoEmRetas(Poligono poligono) {
		List<Reta> retas = new ArrayList<Reta>();
		List<Coordenada> coordenadas = poligono.getCoordenadas();
		Coordenada c1;
		Coordenada c2;
		for (int i = 0; i < coordenadas.size(); i++) {
			c1 = coordenadas.get(i);
			c2 = i == coordenadas.size() - 1 ? coordenadas.get(0) : coordenadas.get(i + 1);
			retas.add(new Reta("", null, c1, c2));
		}
		return retas;
	}
}
