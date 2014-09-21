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
import modelo.transformacoes.TransformacaoDeViewport;

public class PainelDeDesenho extends JPanel {

	private Window window;
	private boolean windowEViewportConfigurados;
	private DisplayFile displayFile;

	public PainelDeDesenho() {
		super();

	}

	public void configurarWindowEViewport() {
		if (!windowEViewportConfigurados) {
			Rectangle medidas = this.getBounds();
			window = new Window(new Coordenada(0, 0), new Coordenada(medidas.getWidth(), medidas.getHeight()));
			window.setProporcaoX((int) medidas.getWidth() / 10);
			window.setProporcaoY((int) medidas.getHeight() / 10);
			Coordenada minimaViewport = new Coordenada(0, 0);
			Coordenada maximaViewport = new Coordenada(medidas.getWidth() - 0, medidas.getHeight() - 0);
			windowEViewportConfigurados = true;
			this.displayFile = new DisplayFile(new TransformacaoDeViewport(window, minimaViewport, maximaViewport),
					minimaViewport, maximaViewport);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.configurarWindowEViewport();
		desenharBordaDaViewport(g);
		List<ObjetoGeometrico> objetosClipados = displayFile.getObjetosClipados();
		for (ObjetoGeometrico objeto : objetosClipados) {
			objeto.desenhar(g);
		}
	}

	private void desenharBordaDaViewport(Graphics g) {
		int largura = 700;
		int altura = 700;
		g.drawRoundRect(50, 65, largura, altura, 5, 5);
		g.drawRoundRect(55, 70, largura - 10, altura -10, 5, 5);
	}

	public void aplicarZoom(Zoom zoom) {
		switch (zoom) {
		case IN:
			window.zoomIn();
			break;
		case OUT:
			window.zoomOut();
		}
		this.displayFile.atualizarTodosOsObjetos();
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
		this.displayFile.atualizarTodosOsObjetos();
		this.repaint();
	}

	public DisplayFile getDisplayFile() {
		return displayFile;
	}

	public void removerObjetoDoIndice(int indiceSelecionado) {
		displayFile.remover(indiceSelecionado);
		this.repaint();
	}

	public void adicionarObjeto(ObjetoGeometrico objetoGeometrico) {
		displayFile.adicionar(objetoGeometrico);
		this.repaint();
	}

	public void trocarObjetoDoIndice(ObjetoGeometrico objetoGeometrico, int indice) {
		displayFile.trocarObjetoDoIndice(objetoGeometrico, indice);
		this.repaint();
	}

}
