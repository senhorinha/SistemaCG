package modelo.transformacoes;

import java.util.List;

import modelo.Coordenada;
import modelo.Window;

public class TransformacaoDeViewport implements Transformacao {

	private Coordenada minimo;
	private Coordenada maximo;
	private final Window window;

	public TransformacaoDeViewport(Window window) {
		this.window = window;
	}

	public TransformacaoDeViewport(Window window, Coordenada minimo, Coordenada maximo) {
		this.window = window;
		this.minimo = minimo;
		this.maximo = maximo;
	}

	@Override
	public void executar(List<Coordenada> coordenadas) {
		double xw, yw, xvp, yvp;
		float xwMin = (float) window.getMinimo().getX();
		float ywMin = (float) window.getMinimo().getY();
		float xwMax = (float) window.getMaximo().getX();
		float ywMax = (float) window.getMaximo().getY();
		for (Coordenada c : coordenadas) {
			xw = c.getX();
			yw = c.getY();
			xvp = ((xw - xwMin) / (xwMax - xwMin) * (maximo.getX() - minimo.getX()));
			yvp = ((1 - (yw - ywMin) / (ywMax - ywMin)) * (maximo.getY() - minimo.getY()));
			c.setX((int) xvp);
			c.setY((int) yvp);
		}
	}

}
