package modelo.utils;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.Window;
import modelo.objetos.Reta;

public class MetodoDeCohenSutherland {

	public static Reta clipar(Reta reta, Window window) {
		List<RegiaoParaClipping> regioes = formarCodigos(reta, window);
		RegiaoParaClipping regiaoUm = regioes.get(0);
		RegiaoParaClipping regiaoDois = regioes.get(1);
		switch (regioes.get(0).valueOf() & regioes.get(1).valueOf()) {
		case 0:
			if (regiaoUm != regiaoDois) {
				double x1 = reta.getCoordenadas().get(0).getX();
				double y1 = reta.getCoordenadas().get(0).getY();
				double x2 = reta.getCoordenadas().get(1).getX();
				double y2 = reta.getCoordenadas().get(1).getY();
				int alturaDaWindow = window.getyMax();
				int larguraDaWindow = window.getxMax();
				for (int i = 0; i < regioes.size(); i++) {
					double x = 0;
					double y = 0;
					switch (regioes.get(i)) {
					case CENTRO:
						continue;
					case NORTE:
					case NORDESTE:
					case NOROESTE:
						x = x1 + (x2 - x1) * (alturaDaWindow - y1) / (y2 - y1);
						y = alturaDaWindow;
						break;
					case SUL:
					case SUDOESTE:
					case SUDESTE:
						x = x1 + (x2 - x1) * -y1 / (y2 - y1);
						y = 0;
						break;
					case LESTE:
						y = y1 + (y2 - y1) * (larguraDaWindow - x1) / (x2 - x1);
						x = larguraDaWindow;
						break;
					case OESTE:
						y = y1 + (y2 - y1) * -x1 / (x2 - x1);
						x = 0;
						break;
					}
					Coordenada coordenada = reta.getCoordenadas().get(i);
					coordenada.setX(x);
					coordenada.setY(y);
				}
			}
			break;
		default:
			reta = null;
		}
		return reta;
	}

	private static List<RegiaoParaClipping> formarCodigos(Reta reta, Window window) {
		List<Coordenada> coordenadas = reta.getCoordenadas();
		List<RegiaoParaClipping> regioes = new ArrayList<RegiaoParaClipping>();
		double x;
		double y;
		for (Coordenada coordenada : coordenadas) {
			String codigo = "";
			x = coordenada.getX();
			y = coordenada.getY();
			codigo += y > window.getyMax() ? "1" : "0";
			codigo += y < window.getyMin() ? "1" : "0";
			codigo += x > window.getxMax() ? "1" : "0";
			codigo += x < window.getxMin() ? "1" : "0";
			regioes.add(transformarEmRegiao(codigo));
		}
		return regioes;
	}

	private static RegiaoParaClipping transformarEmRegiao(String codigo) {
		for (RegiaoParaClipping regiao : RegiaoParaClipping.values()) {
			if (codigo.equals(regiao.toString())) {
				return regiao;
			}
		}
		throw new IllegalArgumentException("Não existe região correspondente para o código informado: {" + codigo + "}");
	}

}
