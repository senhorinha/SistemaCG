package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
	private boolean viewportConfigurado;
	private boolean windowConfigurado;

	public PainelDeDesenho() {
		super();
		window = new Window();
		transformacaoDeViewport = new TransformacaoDeViewport(window);
	}

	public void configurarViewport() {
		if (!viewportConfigurado) {
			Rectangle medidas = this.getBounds();
			((TransformacaoDeViewport) this.transformacaoDeViewport)
					.setXvpMin((int) medidas.getMinX());
			((TransformacaoDeViewport) this.transformacaoDeViewport)
					.setYvpMin((int) medidas.getMinY());
			((TransformacaoDeViewport) this.transformacaoDeViewport)
					.setXvpMax((int) medidas.getMaxX());
			((TransformacaoDeViewport) this.transformacaoDeViewport)
					.setYvpMax((int) medidas.getMaxY());
			viewportConfigurado = true;
		}
	}

	public void configurarWindowCom() {
		if (!windowConfigurado) {
			Rectangle medidas = this.getBounds();
			window.setxMin((int) medidas.getMinX());
			window.setyMin((int) medidas.getMinY());
			window.setxMax((int) medidas.getMaxX());
			window.setyMax((int) medidas.getMaxY());
			windowConfigurado = true;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.configurarViewport();
		this.configurarWindowCom();
		DisplayFile instance = DisplayFile.obterInstancia();
		for (ObjetoGeometrico objetoGrafico : instance.getObjetos()) {
			try {
				ObjetoGeometrico clone = (ObjetoGeometrico) objetoGrafico
						.clone();
				clone.transformarCoordenadas(transformacaoDeViewport);
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
