package modelo;

public class Window {

	private int xMin, yMin, xMax, yMax;

	public Window(int xMax, int yMax) {
		this.xMin = 0;
		this.yMin = 0;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public Window() {
	}

	public void zoomIn() {
		int proporcaoX = xMax / 10;
		int proporcaoY = yMax / 10;
		xMax = xMax - proporcaoX;
		yMax = yMax - proporcaoY;
		xMin = xMin - proporcaoX;
		yMin = yMin - proporcaoY;
	}

	public void zoomOut() {
		int proporcaoX = xMax / 10;
		int proporcaoY = yMax / 10;
		xMax = xMax + proporcaoX;
		yMax = yMax + proporcaoY;
		xMin = xMin + proporcaoX;
		yMin = yMin + proporcaoY;
	}

	public void moverEsquerda() {
		xMin = xMin + 10;
		xMax = xMax + 10;
	}

	public void moverDireita() {
		xMin = xMin - 10;
		xMax = xMax - 10;
	}

	public void moverCima() {
		yMin = yMin - 10;
		yMax = yMax - 10;
	}

	public void moverBaixo() {
		yMin = yMin + 10;
		yMax = yMax + 10;
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

}
