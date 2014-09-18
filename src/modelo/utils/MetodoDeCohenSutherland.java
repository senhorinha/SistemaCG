package modelo.utils;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.Reta;

public class MetodoDeCohenSutherland {

	public static Reta clipar(Reta reta, Coordenada minimo, Coordenada maximo) {
		System.out.println("Reta Original: " + reta.getCoordenadas().get(0) + " " + reta.getCoordenadas().get(1));
		List<RegiaoParaClipping> regioes = formarCodigos(reta, minimo, maximo);
		RegiaoParaClipping regiaoUm = regioes.get(0);
		RegiaoParaClipping regiaoDois = regioes.get(1);
		switch (regioes.get(0).valueOf() & regioes.get(1).valueOf()) {
		case 0:
			if (regiaoUm != regiaoDois) {
				double x1 = reta.getCoordenadas().get(0).getX();
				double y1 = reta.getCoordenadas().get(0).getY();
				double x2 = reta.getCoordenadas().get(1).getX();
				double y2 = reta.getCoordenadas().get(1).getY();
				int altura = (int) maximo.getY();
				int largura = (int) maximo.getX();
				for (int i = 0; i < regioes.size(); i++) {
					double x = 0;
					double y = 0;
					switch (regioes.get(i)) {
					case CENTRO:
						continue;
					case NORTE:
					case NORDESTE:
					case NOROESTE:
						x = x1 + (x2 - x1) * (altura - y1) / (y2 - y1);
						y = altura;
						break;
					case SUL:
					case SUDOESTE:
					case SUDESTE:
						x = x1 + (x2 - x1) * -y1 / (y2 - y1);
						y = 0;
						break;
					case LESTE:
						y = y1 + (y2 - y1) * (largura - x1) / (x2 - x1);
						x = largura;
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
		if (reta != null) {
			System.out.println("Reta Clipada: " + reta.getCoordenadas().get(0) + " " + reta.getCoordenadas().get(1));
		} else {
			System.out.println("Reta Clipada: null");
		}
		return reta;
	}

	private static List<RegiaoParaClipping> formarCodigos(Reta reta, Coordenada minimo, Coordenada maximo) {
		List<Coordenada> coordenadas = reta.getCoordenadas();
		List<RegiaoParaClipping> regioes = new ArrayList<RegiaoParaClipping>();
		double x;
		double y;
		for (Coordenada coordenada : coordenadas) {
			String codigo = "";
			x = coordenada.getX();
			y = coordenada.getY();
			codigo += y > maximo.getY() ? "1" : "0";
			codigo += y < minimo.getY() ? "1" : "0";
			codigo += x > maximo.getX() ? "1" : "0";
			codigo += x < minimo.getX() ? "1" : "0";
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
