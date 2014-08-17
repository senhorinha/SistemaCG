package modelo;

public class Window {

	int xwMin, ywMin, xwMax, ywMax;

	Window(int xMax, int yMax) {
		this.xwMin = 0;
		this.ywMin = 0;
		this.xwMax = xMax;
		this.ywMax = yMax;
	}

	void zoomIn() {
		int proporcaoX = xwMax / 10;
		int proporcaoY = ywMax / 10;
		xwMax = xwMax - proporcaoX;
		ywMax = ywMax - proporcaoY;

	}

	void zoomOut() {
		int proporcaoX = xwMax / 10;
		int proporcaoY = ywMax / 10;
		xwMax = xwMax + proporcaoX;
		ywMax = ywMax + proporcaoY;
	}

	void moverEsquerda() {
		xwMin = xwMin + 1;
		xwMax = xwMax + 1;
	}

	void moverDireita() {
		xwMin = xwMin - 1;
		xwMax = xwMax - 1;
	}

	void moverCima() {
		ywMin = ywMin - 1;
		ywMax = ywMax - 1;
	}

	void moverBaixo() {
		ywMin = ywMin + 1;
		ywMax = ywMax + 1;
	}
}
