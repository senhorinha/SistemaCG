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
	private TransformacaoDeViewport transformacaoDeViewport;
	private java.awt.List listaDeObjetos;

	public PainelDeDesenho(java.awt.List listaDeObjetos) {
		super();
		this.listaDeObjetos = listaDeObjetos;

	}

	public void configurarWindowEViewport() {
		if (!windowEViewportConfigurados) {
			Rectangle medidas = this.getBounds();
			window = new Window(new Coordenada(0, 0), new Coordenada(medidas.getWidth(), medidas.getHeight()));
			window.setProporcaoX((int) medidas.getWidth() / 10);
			window.setProporcaoY((int) medidas.getHeight() / 10);
			Coordenada minimaViewport = new Coordenada(55, 70);
			Coordenada maximaViewport = new Coordenada(680, 680);
			windowEViewportConfigurados = true;
			transformacaoDeViewport = new TransformacaoDeViewport(window, minimaViewport, maximaViewport);
			this.displayFile = new DisplayFile(transformacaoDeViewport, minimaViewport, maximaViewport);
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
		int largura = 635;
		int altura = 620;
		g.drawRoundRect(50, 65, largura, altura, 5, 5);
		g.drawRoundRect(55, 70, largura - 10, altura - 10, 0, 0);
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
		listaDeObjetos.remove(indiceSelecionado);
		this.repaint();
	}

	public void adicionarObjeto(ObjetoGeometrico objetoGeometrico) {
		displayFile.adicionar(objetoGeometrico);
		listaDeObjetos.add(objetoGeometrico.getNome());
		this.repaint();
	}

	public void trocarObjetoDoIndice(ObjetoGeometrico objetoGeometrico, int indice) {
		displayFile.trocarObjetoDoIndice(objetoGeometrico, indice);
		listaDeObjetos.remove(indice);
		listaDeObjetos.add(objetoGeometrico.getNome(), indice);
		this.repaint();
	}

	public List<ObjetoGeometrico> getObjetos() {
		return displayFile.getObjetos();
	}

	public void iniciarCom(List<ObjetoGeometrico> objetos) {
		displayFile.iniciarCom(objetos);
		for (ObjetoGeometrico objetoGeometrico : objetos) {
			listaDeObjetos.add(objetoGeometrico.getNome());
		}
		this.repaint();
	}

	public void atualizarObjeto(ObjetoGeometrico objeto) {
		displayFile.atualizarObjeto(objeto);
		this.repaint();
	}

}
