package modelo.movimentos;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;

public class Escalonador extends Movimentador {

	public Escalonador(ObjetoGeometrico objeto, Coordenada fatorDeEscala) {
		super(objeto, fatorDeEscala);
	}

	@Override
	public void movimentar() {
		Coordenada centroDoObjeto = objeto.getCentroGeometrico();
		double cx = centroDoObjeto.getX();
		double cy = centroDoObjeto.getY();
		double sx = coordenadaDeReferencia.getX();
		double sy = coordenadaDeReferencia.getY();
		List<Coordenada> novasCoordenadas = new ArrayList<Coordenada>();

		for (Coordenada coordenada : objeto.getCoordenadas()) {
			double x = coordenada.getX();
			double y = coordenada.getY();
			novasCoordenadas.add(new Coordenada((x - cx) * sx + cx, (y - cy) * sy + cy));

		}

		objeto.setCoordenadas(novasCoordenadas);

	}

}
