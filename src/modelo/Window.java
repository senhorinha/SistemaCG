package modelo;

public class Window {

	int xwMin, ywMin, xwMax, ywMax;

	Window(int xMax, int yMax) {
		this.xwMin = 0;
		this.ywMin = 0;
		this.xwMax = xMax;
		this.ywMax = yMax;
	}

	public void zoomIn() {
		int proporcaoX = xwMax / 10;
		int proporcaoY = ywMax / 10;
		xwMax = xwMax - proporcaoX;
		ywMax = ywMax - proporcaoY;
		xwMin = xwMin - proporcaoX;
		ywMin = ywMin - proporcaoY;
	}

	public void zoomOut() {
		int proporcaoX = xwMax / 10;
		int proporcaoY = ywMax / 10;
		xwMax = xwMax + proporcaoX;
		ywMax = ywMax + proporcaoY;
		xwMin = xwMin + proporcaoX;
		ywMin = ywMin + proporcaoY;
	}

	public void moverEsquerda() {
		xwMin = xwMin + 10;
		xwMax = xwMax + 10;
	}

	public void moverDireita() {
		xwMin = xwMin - 10;
		xwMax = xwMax - 10;
	}

	public void moverCima() {
		ywMin = ywMin - 10;
		ywMax = ywMax - 10;
	}

	public void moverBaixo() {
		ywMin = ywMin + 10;
		ywMax = ywMax + 10;
	}
}
