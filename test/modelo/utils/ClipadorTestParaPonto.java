package modelo.utils;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Ponto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipadorTestParaPonto {

	private Coordenada minimaViewport;
	private Coordenada maximaViewport;
	List<ObjetoGeometrico> objetos;
	private ObjetoGeometrico objeto;

	@Before
	public void setup() {
		minimaViewport = new Coordenada(0, 0);
		maximaViewport = new Coordenada(100, 100);
		objetos = new ArrayList<ObjetoGeometrico>();
	}

	public void criarPontoAdicionarNaListaExecutarClipador(Coordenada coordenada) {
		objeto = new Ponto("teste", null, coordenada);
		objetos.add(objeto);
		objetos = Clipador.executar(objetos, minimaViewport, maximaViewport);
	}

	@Test
	public void deve_saber_identificar_ponto_dentro_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(30, 30));
		Assert.assertFalse(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(110, 10));
		Assert.assertTrue(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window_em_x_y() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(110, 110));
		Assert.assertTrue(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_x_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(100, 10));
		Assert.assertFalse(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_x_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(0, 10));
		Assert.assertFalse(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_y_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(10, 100));
		Assert.assertFalse(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_y_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(10, 0));
		Assert.assertFalse(objetos.isEmpty());
	}
}
