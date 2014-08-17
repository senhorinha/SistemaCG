package modelo;

public class Viewport {

	int xvpMin, yvpMin, xvpMax, yvpMax;

	Viewport() {
		this.yvpMin = 0;
		this.yvpMin = 0;
		this.xvpMax = 480;
		this.yvpMax = 480;
	}

	void transformada(int xw, int yw) {
		int xvp = (xw - xwMin) / (xwMax - xwMin) * (xvpMax - xvpMin);
		int yvp = (1 - (yw - yxMin) / (ywMax - ywMin)) * (yvpMax - yvpMin);
	}

}
