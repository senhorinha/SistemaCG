package modelo.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Reta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipadorTestParaReta {

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

	public void criarRetaAdicionarNaListaExecutarClipador(double x1, double y1, double x2, double y2) {
		objeto = new Reta("teste", null, new Coordenada(x1, y1), new Coordenada(x2, y2));
		objetos.add(objeto);
		objetos = Clipador.executar(objetos, minimaViewport, maximaViewport);
	}

	@Test
	public void deve_saber_identificar_reta_dentro_da_window() {
		criarRetaAdicionarNaListaExecutarClipador(10, 10, 10, 10);
		Assert.assertFalse(objetos.isEmpty());
	}

	@Test
	public void deve_saber_identificar_reta_fora_da_window() {
		criarRetaAdicionarNaListaExecutarClipador(110, 110, 110, 110);
		Assert.assertTrue(objetos.isEmpty());
	}

	@Test
	public void deve_saber_clipar_a_regiao_norte_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(10, 10, 10, 200);
		Coordenada coordenadaClipada = objetos.get(0).getCoordenadas().get(1);
		assertEquals(10, (int) coordenadaClipada.getX());
		assertEquals(100, (int) coordenadaClipada.getY());
	}

	@Test
	public void deve_saber_clipar_a_regiao_sul_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(10, 10, 10, -10);
		Coordenada coordenadaClipada = objetos.get(0).getCoordenadas().get(1);
		assertEquals(10, (int) coordenadaClipada.getX());
		assertEquals(0, (int) coordenadaClipada.getY());
	}

	@Test
	public void deve_saber_clipar_a_regiao_oeste_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(10, 10, 200, 10);
		Coordenada coordenadaClipada = objetos.get(0).getCoordenadas().get(1);
		assertEquals(100, (int) coordenadaClipada.getX());
		assertEquals(10, (int) coordenadaClipada.getY());
	}

	@Test
	public void deve_saber_clipar_a_regiao_leste_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(10, 10, 200, 10);
		Coordenada coordenadaClipada = objetos.get(0).getCoordenadas().get(1);
		assertEquals(100, (int) coordenadaClipada.getX());
		assertEquals(10, (int) coordenadaClipada.getY());
	}

	@Test
	public void deve_saber_clipar_a_regiao_oeste_e_leste_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(-100, 10, 200, 10);
		Coordenada cordenadaClipadaNoOeste = objetos.get(0).getCoordenadas().get(0);
		Coordenada cordenadaClipadaNoLeste = objetos.get(0).getCoordenadas().get(1);
		assertEquals(0, (int) cordenadaClipadaNoOeste.getX());
		assertEquals(10, (int) cordenadaClipadaNoOeste.getY());
		assertEquals(100, (int) cordenadaClipadaNoLeste.getX());
		assertEquals(10, (int) cordenadaClipadaNoLeste.getY());
	}

	@Test
	public void deve_saber_clipar_a_regiao_sul_e_norte_da_reta() {
		criarRetaAdicionarNaListaExecutarClipador(10, -100, 10, 200);
		Coordenada cordenadaClipadaNoOeste = objetos.get(0).getCoordenadas().get(0);
		Coordenada cordenadaClipadaNoLeste = objetos.get(0).getCoordenadas().get(1);
		assertEquals(10, (int) cordenadaClipadaNoOeste.getX());
		assertEquals(0, (int) cordenadaClipadaNoOeste.getY());
		assertEquals(10, (int) cordenadaClipadaNoLeste.getX());
		assertEquals(100, (int) cordenadaClipadaNoLeste.getY());
	}

}
