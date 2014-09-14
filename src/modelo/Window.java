package modelo;

public class Window {

	private Coordenada minimo;
	private Coordenada maximo;
	private int proporcaoX, proporcaoY;

	public Window(int xMax, int yMax) {
		minimo = new Coordenada(0, 0);
		maximo = new Coordenada(xMax, yMax);
	}

	public Window(Coordenada minimo, Coordenada maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public Window() {
	}

	public void zoomIn() {
		maximo.somarAoX(-proporcaoX);
		maximo.somarAoY(-proporcaoY);
		minimo.somarAoX(proporcaoX);
		minimo.somarAoY(proporcaoY);
	}

	public void zoomOut() {
		maximo.somarAoX(proporcaoX);
		maximo.somarAoY(proporcaoY);
		minimo.somarAoX(-proporcaoX);
		minimo.somarAoY(-proporcaoY);
	}

	public void moverEsquerda() {
		maximo.somarAoX(-10);
		minimo.somarAoX(-10);
	}

	public void moverDireita() {
		maximo.somarAoX(10);
		minimo.somarAoX(10);
	}

	public void moverCima() {
		maximo.somarAoY(10);
		minimo.somarAoY(10);
	}

	public void moverBaixo() {
		maximo.somarAoY(-10);
		minimo.somarAoY(-10);
	}

	public void setProporcaoX(int proporcaoX) {
		this.proporcaoX = proporcaoX;
	}

	public void setProporcaoY(int proporcaoY) {
		this.proporcaoY = proporcaoY;
	}

	public Coordenada getMinimo() {
		return minimo;
	}

	public Coordenada getMaximo() {
		return maximo;
	}

}
