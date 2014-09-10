package view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import modelo.Coordenada;
import modelo.Direcao;
import modelo.DisplayFile;
import modelo.Window;
import modelo.Zoom;
import modelo.objetos.ObjetoGeometrico;
import modelo.transformacoes.Transformacao;
import modelo.transformacoes.TransformacaoDeViewport;

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
			((TransformacaoDeViewport) this.transformacaoDeViewport).setXvpMin(0);
			((TransformacaoDeViewport) this.transformacaoDeViewport).setYvpMin(0);
			((TransformacaoDeViewport) this.transformacaoDeViewport).setXvpMax((int) medidas.getWidth());
			((TransformacaoDeViewport) this.transformacaoDeViewport).setYvpMax((int) medidas.getHeight());
			viewportConfigurado = true;
		}
	}

	public void configurarWindowCom() {
		if (!windowConfigurado) {
			Rectangle medidas = this.getBounds();
			window.setxMin(0);
			window.setyMin(0);
			window.setxMax((int) medidas.getWidth());
			window.setyMax((int) medidas.getHeight());
			window.setProporcaoX( (int) medidas.getWidth() / 10);
			window.setProporcaoY( (int) medidas.getHeight() / 10);
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
				ObjetoGeometrico copia = (ObjetoGeometrico) objetoGrafico.clone();
				copia.transformarCoordenadas(transformacaoDeViewport);
				copia.desenhar(g);
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
		this.repaint();
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
		this.repaint();
	}

}
