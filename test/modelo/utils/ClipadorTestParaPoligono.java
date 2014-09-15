package modelo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Poligono;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipadorTestParaPoligono {

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

	private Coordenada criarCoordenada(double x, double y) {
		return new Coordenada(x, y);
	}

	private void criarPoligonoAdicionarNaListaExecutarClipador(Coordenada... coordenadas) {
		List<Coordenada> coordenadasEmLista = Arrays.asList(coordenadas);
		objeto = new Poligono("", null, coordenadasEmLista, false);
		objetos.add(objeto);
		objetos = Clipador.executar(objetos, minimaViewport, maximaViewport);
	}

	@Test
	public void deve_saber_identificar_poligono_fora_da_window() {
		criarPoligonoAdicionarNaListaExecutarClipador(criarCoordenada(-10, -10), criarCoordenada(-100, -100),
				criarCoordenada(-10, -100));
		Assert.assertTrue(objetos.isEmpty());

	}

	@Test
	public void deve_saber_identificar_reta_dentro_da_window() {
		criarPoligonoAdicionarNaListaExecutarClipador(criarCoordenada(10, 10), criarCoordenada(100, 100),
				criarCoordenada(200, 10));
		Assert.assertFalse(objetos.isEmpty());
	}
}
