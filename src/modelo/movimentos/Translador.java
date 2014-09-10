package modelo.movimentos;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;

public class Translador extends Movimentador {

	public Translador(ObjetoGeometrico objeto, Coordenada vetor) {
		super(objeto, vetor);
	}

	@Override
	public void movimentar() {
		double dx = coordenadaDeReferencia.getX();
		double dy = coordenadaDeReferencia.getY();
		List<Coordenada> novasCoordenadas = new ArrayList<Coordenada>();

		for (Coordenada coordenada : objeto.getCoordenadas()) {
			novasCoordenadas.add(new Coordenada(coordenada.getX() + dx, coordenada.getY() + dy));

		}

		objeto.setCoordenadas(novasCoordenadas);

	}

}
