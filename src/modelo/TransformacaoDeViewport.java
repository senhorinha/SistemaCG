package modelo;

import java.util.List;

public class TransformacaoDeViewport implements Transformacao {

	private int xvpMin, yvpMin, xvpMax, yvpMax;
	private int xwMin, ywMin, xwMax, ywMax;

	public TransformacaoDeViewport(int xwMin, int ywMin, int xwMax, int ywMax) {
		this.yvpMin = 0;
		this.yvpMin = 0;
		this.xvpMax = 480;
		this.yvpMax = 480;

		this.xwMin = xwMin;
		this.ywMin = ywMin;
		this.xwMax = xwMax;
		this.ywMax = ywMax;
	}

	@Override
	public void executar(List<Coordenada> coordenada) {
		int xw;
		int yw;
		int xvp;
		int yvp;
		for (Coordenada c : coordenada) {
			xw = c.getX();
			yw = c.getY();
			xvp = (xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin);
			yvp = (1 - (yw - ywMin) / (ywMax - ywMin)) * (yvpMax - yvpMin);
			c.setX(xvp);
			c.setY(yvp);
		}
	}

}
