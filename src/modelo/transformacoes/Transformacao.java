package modelo.transformacoes;

import java.util.List;

import modelo.Coordenada;

public interface Transformacao {

	public void executar(List<Coordenada> coordenada);

}
