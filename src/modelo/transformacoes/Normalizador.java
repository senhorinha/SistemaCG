package modelo.transformacoes;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.DisplayFile;
import modelo.Window;
import modelo.objetos.ObjetoGeometrico;

public class Normalizador {

	Window window;
	double fatorDeEscalaX;
	double fatorDeEscalaY;
	public static final int AJUSTE = 1;
	List<ObjetoGeometrico> objetos = DisplayFile.obterInstancia().getObjetos();

	public Normalizador(Window window) {
		this.window = window;

	}

	public void gerarDescricaoEmSCN() {

		fatorDeEscalaX = (window.getxMax() - window.getxMin()) / 2;
		fatorDeEscalaY = (window.getyMax() - window.getyMin()) / 2;
		double xNormalizado, yNormalizado;
		List<Coordenada> coordenadasNormalizadas;

		for (ObjetoGeometrico objeto : objetos) {

			coordenadasNormalizadas = new ArrayList<Coordenada>();

			for (Coordenada coordenada : objeto.getCoordenadas()) {

				xNormalizado = (coordenada.getX() - objeto.getCentroGeometrico().getX()) * fatorDeEscalaX
						+ objeto.getCentroGeometrico().getX() - AJUSTE;

				yNormalizado = (coordenada.getY() - objeto.getCentroGeometrico().getY()) * fatorDeEscalaY
						+ objeto.getCentroGeometrico().getY() - AJUSTE;

				coordenadasNormalizadas.add(new Coordenada(xNormalizado, yNormalizado));
			}
			objeto.setCoordenadasNormalizadas(coordenadasNormalizadas);
		}

	}

}
