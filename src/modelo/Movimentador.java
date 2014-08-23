package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Movimentador {

	ObjetoGeometrico objeto;
	Coordenada coordenadaDeReferencia;

	public Movimentador(ObjetoGeometrico objeto, Coordenada coordenadaDeReferencia) {
		super();
		this.objeto = objeto;
		this.coordenadaDeReferencia = coordenadaDeReferencia;
	}

	public List<CoordenadaHomogenea> obterCoordenadasHomogeneas() {

		List<CoordenadaHomogenea> coordenadasHomogeneas = new ArrayList<CoordenadaHomogenea>();
		for (Coordenada coordenada : objeto.getCoordenadas()) {
			coordenadasHomogeneas.add(new CoordenadaHomogenea(
					coordenada.getX(), coordenada.getY(), 1));
		}
		return coordenadasHomogeneas;
	}

	public abstract void movimentar();

}
