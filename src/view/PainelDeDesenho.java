package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modelo.Direcao;
import modelo.DisplayFile;
import modelo.ObjetoGeometrico;
import modelo.Transformacao;
import modelo.TransformacaoDeViewport;
import modelo.Window;
import modelo.Zoom;

public class PainelDeDesenho extends JPanel {

	private Transformacao transformacaoDeViewport;
	private final Window window;

	public PainelDeDesenho() {
		super();
		window = new Window();
		transformacaoDeViewport = new TransformacaoDeViewport(window);
	}

	public void configurarViewportCom(int xMin, int yMin, int xMax, int yMax) {
		((TransformacaoDeViewport) this.transformacaoDeViewport)
				.setXvpMin(xMin);
		((TransformacaoDeViewport) this.transformacaoDeViewport)
				.setYvpMin(yMin);
		((TransformacaoDeViewport) this.transformacaoDeViewport)
				.setXvpMax(xMax);
		((TransformacaoDeViewport) this.transformacaoDeViewport)
				.setYvpMax(yMax);
	}

	public void configurarWindowCom(int xMin, int yMin, int xMax, int yMax) {
		window.setxMin(xMin);
		window.setyMin(yMin);
		window.setxMax(xMax);
		window.setyMax(yMax);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		DisplayFile instance = DisplayFile.obterInstancia();
		for (ObjetoGeometrico objetoGrafico : instance.getObjetos()) {
			try {
				ObjetoGeometrico clone = (ObjetoGeometrico) objetoGrafico
						.clone();
				clone.desenhar(g, Color.RED);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void aplicarZoom(Zoom zoom) {
		switch (zoom) {
		case IN:
			window.zoomIn();
			break;
		case OUT:
			window.zoomOut();
		}
	}

	public void moverWindow(Direcao direcao) {
		switch (direcao) {
		case CIMA:
			window.moverCima();
			break;
		case DIREITA:
			window.moverDireita();
			break;
		case BAIXO:
			window.moverBaixo();
			break;
		case ESQUERDA:
			window.moverEsquerda();
			break;
		}
	}

}
