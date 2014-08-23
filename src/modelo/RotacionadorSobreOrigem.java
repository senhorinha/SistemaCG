package modelo;

import java.util.ArrayList;
import java.util.List;

public class RotacionadorSobreOrigem extends Movimentador {

	int angulo;
	double seno, cosseno, radiano;

	public RotacionadorSobreOrigem(ObjetoGeometrico objeto, Coordenada origem, int angulo) {
		super(objeto, origem);
		this.angulo = angulo;
	}

	@Override
	public void movimentar() {
		radiano = Math.toRadians(angulo);
		seno = Math.sin(radiano);
		cosseno = Math.cos(radiano);

		List<Coordenada> novasCoordenadas = new ArrayList<Coordenada>();

		for (Coordenada coordenada : objeto.getCoordenadas()) {
			novasCoordenadas.add(new Coordenada(
					(int) (coordenada.getX() * cosseno + coordenada.getY() * seno),
					(int) (coordenada.getX() * -seno + coordenada.getY() * cosseno) ));

		}

		objeto.setCoordenadas(novasCoordenadas);

	}

}
