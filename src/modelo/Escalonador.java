package modelo;

import java.util.ArrayList;
import java.util.List;

public class Escalonador extends Movimentador {

	public Escalonador(ObjetoGeometrico objeto, Coordenada fatorDeEscala) {
		super(objeto, fatorDeEscala);
	}

	@Override
	public void movimentar() {
		Coordenada centroDoObjeto = objeto.getCentroGeometrico();
		int cx = centroDoObjeto.getX();
		int cy = centroDoObjeto.getY();
		int sx = coordenadaDeReferencia.getX();
		int sy = coordenadaDeReferencia.getY();
		List<Coordenada> novasCoordenadas = new ArrayList<Coordenada>();

		for (Coordenada coordenada : objeto.getCoordenadas()) {
			int x = coordenada.getX();
			int y = coordenada.getY();
			novasCoordenadas.add(new Coordenada((x - cx) * sx + cx, (y - cy) * sy + cy));

		}

		objeto.setCoordenadas(novasCoordenadas);

	}

}
