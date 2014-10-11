package modelo.objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;

//TODO: REFATORAR. Remover código duplicado.
public class CurvaBSpline extends ObjetoGeometrico {

	private int precisao;
	private double matrizE[][] = new double[4][4];
	private static double mult = 1.0 / 6.0;
	private List<Coordenada> coordenadas;
	private List<Reta> retas;

	//@formatter:off
	private static double matrizBSpline[][] = {
		{    -mult, 3 * mult,-3 * mult, mult},
		{ 3 * mult,-6 * mult, 3 * mult,    0},
		{-3 * mult,        0, 3 * mult,    0},
		{     mult, 4 * mult,     mult,    0}
	};
	//@formatter:on

	public CurvaBSpline(String nome, Color cor, List<Coordenada> coordenadas, int precisao) {
		this.nome = nome;
		this.coordenadas = coordenadas;
		this.precisao = precisao;
		retas = new ArrayList<Reta>();
		if (cor == null) {
			this.cor = Color.BLACK;
		} else {
			this.cor = cor;
		}
		formarMatrizE(precisao);
		formarRetas();
	}

	private void formarMatrizE(int precisao) {

		double delta = 1.0 / precisao;

		matrizE[0][0] = 0;
		matrizE[0][1] = 0;
		matrizE[0][2] = 0;
		matrizE[0][3] = 1;

		matrizE[1][2] = delta;
		matrizE[1][1] = matrizE[1][2] * delta;
		matrizE[1][0] = matrizE[1][1] * delta;
		matrizE[1][3] = 0;

		matrizE[2][0] = 6 * matrizE[1][0];
		matrizE[2][1] = 2 * matrizE[1][1];
		matrizE[2][2] = 0;
		matrizE[2][3] = 0;

		matrizE[3][0] = matrizE[2][0];
		matrizE[3][1] = 0;
		matrizE[3][2] = 0;
		matrizE[3][3] = 0;
	}

	private double[][] multiplicarMatrizes(double m[][], double g[][]) {
		double resultado[][] = new double[4][2];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 4; k++) {
					resultado[i][j] = resultado[i][j] + (m[i][k] * g[k][j]);
				}
			}
		}
		return resultado;
	}

	private void formarRetas() {
		int np = coordenadas.size();
		double geom[][] = new double[4][2];
		double mg[][];
		double plot[][] = new double[4][2];

		for (int i = 0; i < np - 3;) {
			for (int j = 3; j >= 0; j--) {
				geom[3 - j][0] = coordenadas.get(i + j).getX();
				geom[3 - j][1] = coordenadas.get(i + j).getY();
			}
			mg = multiplicarMatrizes(matrizBSpline, geom);
			i++;
			plot = multiplicarMatrizes(matrizE, mg);
			double startX = plot[0][0];
			double x = startX;
			double startY = plot[0][1];
			double y = startY;
			for (int j = 0; j < precisao; j++) {
				x += plot[1][0];
				plot[1][0] += plot[2][0];
				plot[2][0] += plot[3][0];
				y += plot[1][1];
				plot[1][1] += plot[2][1];
				plot[2][1] += plot[3][1];
				Coordenada c1 = new Coordenada(startX, startY);
				Coordenada c2 = new Coordenada(x, y);
				retas.add(new Reta("", this.cor, c1, c2));
				startX = x;
				startY = y;
			}
		}
	}

	@Override
	public void desenhar(Graphics grafico) {
		for (Reta reta : retas) {
			reta.desenhar(grafico);
		}
	}

	@Override
	public ObjetoGeometrico toClip(Coordenada minima, Coordenada maxima) {
		int np = coordenadas.size();
		double geom[][] = new double[4][2];
		double mg[][];
		double plot[][] = new double[4][2];

		for (int i = 0; i < np - 3;) {
			for (int j = 3; j >= 0; j--) {
				geom[3 - j][0] = coordenadas.get(i + j).getX();
				geom[3 - j][1] = coordenadas.get(i + j).getY();
			}
			mg = multiplicarMatrizes(matrizBSpline, geom);
			i++;

			plot = multiplicarMatrizes(matrizE, mg);
			double xInicial = plot[0][0];
			double xFinal = xInicial;
			double yInicial = plot[0][1];
			double yFinal = yInicial;
			for (int j = 0; j < precisao; j++) {
				xFinal += plot[1][0];
				plot[1][0] += plot[2][0];
				plot[2][0] += plot[3][0];
				yFinal += plot[1][1];
				plot[1][1] += plot[2][1];
				plot[2][1] += plot[3][1];
				Coordenada c1 = new Coordenada(xInicial, yInicial);
				Coordenada c2 = new Coordenada(xFinal, yFinal);
				Reta reta = new Reta("", this.cor, c1, c2).toClip(minima, maxima);
				if (reta != null) {
					retas.add(reta);
				}
				xInicial = xFinal;
				yInicial = yFinal;
			}
		}
		return this;
	}
}
