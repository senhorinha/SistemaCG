package modelo;

import java.util.List;

public class TransformacaoDeViewport implements Transformacao {

	private int xvpMin, yvpMin, xvpMax, yvpMax;
	private int xwMin, ywMin, xwMax, ywMax;

	public TransformacaoDeViewport(int xvpMax, int yvpMax, int xwMax, int ywMax) {
		this.yvpMin = 0;
		this.yvpMin = 0;
		this.xvpMax = xvpMax;
		this.yvpMax = yvpMax;

		this.xwMin = 0;
		this.ywMin = 0;
		this.xwMax = xwMax;
		this.ywMax = ywMax;
	}

	@Override
	public void executar(List<Coordenada> coordenadas) {
		int xw;
		int yw;
		int xvp;
		int yvp;
		for (Coordenada c : coordenadas) {
			xw = c.getX();
			yw = c.getY();
			xvp = (xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin);
			yvp = (1 - (yw - ywMin) / (ywMax - ywMin)) * (yvpMax - yvpMin);
			c.setX(xvp);
			c.setY(yvp);
		}
	}

}
