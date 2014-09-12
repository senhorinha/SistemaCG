package modelo.utils;

import modelo.Coordenada;
import modelo.Window;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Ponto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipadorTest {

	private Window window;
	private Clipador clipador;
	private ObjetoGeometrico objeto;

	@Before
	public void setup() {
		window = new Window(100, 100);
		clipador = new Clipador();
	}

	@Test
	public void deve_saber_identificar_ponto_dentro_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(30, 30));
		Assert.assertTrue(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(110, 10));
		Assert.assertFalse(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_fora_da_window_em_x_y() {
		objeto = new Ponto("teste", null, new Coordenada(110, 110));
		Assert.assertFalse(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_x_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(100, 10));
		Assert.assertTrue(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_x_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(0, 10));
		Assert.assertTrue(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_superior_de_y_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(10, 100));
		Assert.assertTrue(clipador.executar((Ponto) objeto, window));
	}

	@Test
	public void deve_saber_identificar_ponto_no_limite_inferior_de_y_da_window() {
		objeto = new Ponto("teste", null, new Coordenada(10, 0));
		Assert.assertTrue(clipador.executar((Ponto) objeto, window));
	}
}
