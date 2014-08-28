package modelo.transformacoes;

import java.util.List;

import modelo.Coordenada;
import modelo.Window;

public class TransformacaoDeViewport implements Transformacao {

	private int xvpMin, yvpMin, xvpMax, yvpMax;
	private final Window window;

	public TransformacaoDeViewport(Window window) {
		this.window = window;
	}

	public TransformacaoDeViewport(Window window, int xvpMin, int yvpMin,
			int xvpMax, int yvpMax) {
		this.window = window;
		this.xvpMin = xvpMin;
		this.yvpMin = yvpMin;
		this.xvpMax = xvpMax;
		this.yvpMax = yvpMax;
	}

	@Override
	public void executar(List<Coordenada> coordenadas) {
		float xw, yw, xvp, yvp;
		float xwMin = window.getxMin();
		float ywMin = window.getyMin();
		float xwMax = window.getxMax();
		float ywMax = window.getyMax();
		for (Coordenada c : coordenadas) {

			xw = c.getX();
			yw = c.getY();
			xvp = ((xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin));
			yvp = ((1 - (yw - ywMin) / (ywMax - ywMin)) * (yvpMax - yvpMin));
			c.setX((int) xvp);
			c.setY((int) yvp);
		}
	}

	public int getXvpMin() {
		return xvpMin;
	}

	public void setXvpMin(int xvpMin) {
		this.xvpMin = xvpMin;
	}

	public int getYvpMin() {
		return yvpMin;
	}

	public void setYvpMin(int yvpMin) {
		this.yvpMin = yvpMin;
	}

	public int getXvpMax() {
		return xvpMax;
	}

	public void setXvpMax(int xvpMax) {
		this.xvpMax = xvpMax;
	}

	public int getYvpMax() {
		return yvpMax;
	}

	public void setYvpMax(int yvpMax) {
		this.yvpMax = yvpMax;
	}

}
