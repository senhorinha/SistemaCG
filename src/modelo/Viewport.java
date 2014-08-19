package modelo;

public class Viewport {

	int xvpMin, yvpMin, xvpMax, yvpMax;
	int xwMin, ywMin, xwMax, ywMax;

	public Viewport(int xwMin, int ywMin, int xwMax, int ywMax) {
		this.yvpMin = 0;
		this.yvpMin = 0;
		this.xvpMax = 480;
		this.yvpMax = 480;

		this.xwMin = xwMin;
		this.ywMin = ywMin;
		this.xwMax = xwMax;
		this.ywMax = ywMax;
	}

	public Coordenada transformada(int xw, int yw) {
		int xvp = (xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin);
		int yvp = (1 - (yw - ywMin) / (ywMax - ywMin)) * (yvpMax - yvpMin);
		return new Coordenada(xvp, yvp);
	}
}
