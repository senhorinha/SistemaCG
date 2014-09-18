package view;

import java.awt.Graphics;
import java.awt.Rectangle;
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
import modelo.utils.Clipador;

public class PainelDeDesenho extends JPanel {

	private Transformacao transformacaoDeViewport;
	private Window window;
	private boolean windowEViewportConfigurados;
	private Coordenada minimaViewport;
	private Coordenada maximaViewport;

	public PainelDeDesenho() {
		super();

	}

	public void configurarWindowEViewport() {
		if (!windowEViewportConfigurados) {
			Rectangle medidas = this.getBounds();
			window = new Window(new Coordenada(0, 0), new Coordenada(medidas.getWidth(), medidas.getHeight()));
			window.setProporcaoX((int) medidas.getWidth() / 10);
			window.setProporcaoY((int) medidas.getHeight() / 10);
			minimaViewport = new Coordenada(0, 0);
			maximaViewport = new Coordenada(medidas.getWidth() - 0, medidas.getHeight() - 0);
			transformacaoDeViewport = new TransformacaoDeViewport(window, minimaViewport, maximaViewport);
			windowEViewportConfigurados = true;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.configurarWindowEViewport();
		DisplayFile instance = DisplayFile.obterInstancia();
		List<ObjetoGeometrico> objetosClonados;
		try {
			objetosClonados = instance.clonarObjetos();
			for (ObjetoGeometrico objeto : objetosClonados) {
				objeto.transformarCoordenadas(transformacaoDeViewport);
				objeto = Clipador.executar(objeto, minimaViewport, maximaViewport);
				if (objeto != null) {
					objeto.desenhar(g);
				}
			}
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
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
