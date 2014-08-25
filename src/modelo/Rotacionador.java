package modelo;

import java.util.ArrayList;
import java.util.List;

public class Rotacionador extends Movimentador {

	int angulo;
	double seno, cosseno, radiano;

	public Rotacionador(ObjetoGeometrico objeto, Coordenada vetor, int angulo) {
		super(objeto, vetor);
		this.angulo = angulo;
	}

	@Override
	public void movimentar() {
		radiano = Math.toRadians(angulo);
		seno = Math.sin(radiano);
		cosseno = Math.cos(radiano);
		int dx = coordenadaDeReferencia.getX();
		int dy = coordenadaDeReferencia.getY();

		List<Coordenada> novasCoordenadas = new ArrayList<Coordenada>();

		for (Coordenada coordenada : objeto.getCoordenadas()) {
			novasCoordenadas.add(new Coordenada(
					(int) ( (coordenada.getX() - dx) * cosseno + (coordenada.getY() - dy) * seno + dx ),
					(int) ( (coordenada.getX() - dx) * -seno + (coordenada.getY() - dy) * cosseno + dy ) ));

		}

		objeto.setCoordenadas(novasCoordenadas);

	}

}
