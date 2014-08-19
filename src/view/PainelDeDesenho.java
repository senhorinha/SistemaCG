package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import modelo.DisplayFile;
import modelo.ObjetoGeometrico;
import modelo.Transformacao;
import modelo.TransformacaoDeViewport;

public class PainelDeDesenho extends JPanel {

	private Transformacao transformacaoDeViewport;

	public PainelDeDesenho() {
		int x = this.getX();
		int y = this.getY();
		Rectangle tamanhoDaViewport = this.getBounds();
		// tamanhoDaViewport.getMaxX();
		transformacaoDeViewport = new TransformacaoDeViewport(0, 0, 0, 0);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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

}
