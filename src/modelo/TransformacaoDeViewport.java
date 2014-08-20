package modelo;

import java.util.List;

public class TransformacaoDeViewport implements Transformacao {

	private int xvpMin, yvpMin, xvpMax, yvpMax;
	private final Window window;

	public TransformacaoDeViewport(Window window, int xvpMax, int yvpMax,
			int xwMax, int ywMax) {
		this.window = window;
		this.xvpMax = xvpMax;
		this.yvpMax = yvpMax;
	}

	@Override
	public void executar(List<Coordenada> coordenadas) {
		int xw, yw, xvp, yvp;
		int xwMin = window.getxMin();
		int ywMin = window.getyMin();
		int xwMax = window.getxMax();
		int ywMax = window.getyMax();
		for (Coordenada c : coordenadas) {

			xw = c.getX();
			yw = c.getY();
			xvp = (xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin);
			yvp = (1 - (yw - ywMin) / (ywMax - ywMin)) * (yvpMax - yvpMin);
			c.setX(xvp);
			c.setY(yvp);
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

	public TransformacaoDeViewport(Window window) {
		this.window = window;
	}

}
