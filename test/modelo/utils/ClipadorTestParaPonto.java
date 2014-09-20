package modelo.utils;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Ponto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipadorTestParaPonto {

	private Coordenada minimaViewport;
	private Coordenada maximaViewport;
	private ObjetoGeometrico objeto;

	@Before
	public void setup() {
		minimaViewport = new Coordenada(0, 0);
		maximaViewport = new Coordenada(100, 100);
	}

	public void criarPontoAdicionarNaListaExecutarClipador(Coordenada coordenada) {
		objeto = new Ponto("teste", null, coordenada);
		objeto = objeto.toClip(minimaViewport, maximaViewport);
	}

	@Test
	public void deve_saber_identificar_ponto_dentro_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(30, 30));
		Assert.assertFalse(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(110, 10));
		Assert.assertTrue(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window_em_x_y() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(110, 110));
		Assert.assertTrue(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_x_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(100, 10));
		Assert.assertFalse(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_x_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(0, 10));
		Assert.assertFalse(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_y_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(10, 100));
		Assert.assertFalse(objeto == null);
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_y_da_window() {
		criarPontoAdicionarNaListaExecutarClipador(new Coordenada(10, 0));
		Assert.assertFalse(objeto == null);
	}
}
