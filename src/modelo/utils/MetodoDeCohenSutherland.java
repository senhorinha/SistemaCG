package modelo.utils;

import modelo.Coordenada;
import modelo.objetos.Reta;

public class MetodoDeCohenSutherland {

	private static RegiaoParaClipping formarCodigos(Coordenada coordenada, Coordenada minimo, Coordenada maximo) {
		int code = RegiaoParaClipping.CENTRO.valueOf();

		if (coordenada.getX() < minimo.getX()) {
			code |= RegiaoParaClipping.OESTE.valueOf();
		} else if (coordenada.getX() > maximo.getX()) {
			code |= RegiaoParaClipping.LESTE.valueOf();
		}
		if (coordenada.getY() < minimo.getY()) {
			code |= RegiaoParaClipping.SUL.valueOf();
		} else if (coordenada.getY() > maximo.getY()) {
			code |= RegiaoParaClipping.NORTE.valueOf();
		}

		return RegiaoParaClipping.toRegiao(code);
	}

	@SuppressWarnings("incomplete-switch")
	public static Reta clipar(Reta reta, Coordenada minimo, Coordenada maximo) {
		Coordenada c1 = reta.getCoordenadas().get(0);
		Coordenada c2 = reta.getCoordenadas().get(1);

		RegiaoParaClipping regiaoUm = formarCodigos(c1, minimo, maximo);
		RegiaoParaClipping regiaoDois = formarCodigos(c2, minimo, maximo);

		double x0 = reta.getCoordenadas().get(0).getX();
		double y0 = reta.getCoordenadas().get(0).getY();
		double x1 = reta.getCoordenadas().get(1).getX();
		double y1 = reta.getCoordenadas().get(1).getY();

		while (true) {
			switch (regiaoUm.valueOf() & regiaoDois.valueOf()) {
			case 0:
				if (regiaoUm != regiaoDois) {
					double x = 0, y = 0;
					RegiaoParaClipping regiaoFora = regiaoUm != RegiaoParaClipping.CENTRO ? regiaoUm : regiaoDois;
					switch (regiaoFora) {
					case SUL:
					case SUDOESTE:
					case SUDESTE:
						x = x0 + (x1 - x0) * (minimo.getY() - y0) / (y1 - y0);
						y = minimo.getY();
						break;
					case NORTE:
					case NOROESTE:
					case NORDESTE:
						x = x0 + (x1 - x0) * (maximo.getY() - y0) / (y1 - y0);
						y = maximo.getY();
						break;
					case LESTE:
						y = y0 + (y1 - y0) * (maximo.getX() - x0) / (x1 - x0);
						x = maximo.getX();
						break;
					case OESTE:
						y = y0 + (y1 - y0) * (minimo.getX() - x0) / (x1 - x0);
						x = minimo.getX();
						break;
					}
					if (regiaoFora == regiaoUm) {
						c1.setX(x);
						c1.setY(y);
						regiaoUm = formarCodigos(c1, minimo, maximo);
					} else {
						c2.setX(x);
						c2.setY(y);
						regiaoDois = formarCodigos(c2, minimo, maximo);
					}
				} else {
					return reta;
				}
				break;
			default:
				formarBordas(regiaoUm, c1, minimo, maximo);
				formarBordas(regiaoDois, c2, minimo, maximo);
				return reta;
			}
		}
	}

	private static void formarBordas(RegiaoParaClipping regiao, Coordenada coordenada, Coordenada minimo,
			Coordenada maximo) {
		switch (regiao) {
		case LESTE:
			coordenada.setX(maximo.getX());
			break;
		case NORDESTE:
			coordenada.setY(maximo.getY());
			coordenada.setX(maximo.getX());
			break;
		case NOROESTE:
			coordenada.setY(maximo.getY());
			coordenada.setX(minimo.getX());
			break;
		case NORTE:
			coordenada.setY(maximo.getY());
			break;
		case OESTE:
			coordenada.setX(minimo.getX());
			break;
		case SUDESTE:
			coordenada.setY(minimo.getX());
			coordenada.setX(maximo.getX());
			break;
		case SUDOESTE:
			coordenada.setY(minimo.getY());
			coordenada.setX(minimo.getX());
			break;
		case SUL:
			coordenada.setY(minimo.getY());
			break;
		}
	}
}
