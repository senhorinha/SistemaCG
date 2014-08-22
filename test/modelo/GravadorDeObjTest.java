package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GravadorDeObjTest {

	GravadorDeObj gravador;

	@Before
	public void setup() throws FileNotFoundException {
		gravador = new GravadorDeObj();
	}

	@Test
	public void deve_gravar_ponto_com_nome_um_vertice_e_uma_faceta() throws IOException {
		Ponto p = new Ponto("Ponto", new Coordenada(10, 10));
		List<ObjetoGeometrico> objetos = new ArrayList<ObjetoGeometrico>();
		objetos.add(p);
		gravador.executar(System.getProperty("user.dir").concat("/test/resources/test_gravacao_ponto.obj"), objetos);
	}

	@Test
	public void deve_gravar_reta_com_nome_dois_vertices_e_uma_faceta() throws IOException {
		Reta reta = new Reta("Reta", new Coordenada(10, 10), new Coordenada(20, 20));
		List<ObjetoGeometrico> objetos = new ArrayList<ObjetoGeometrico>();
		objetos.add(reta);
		gravador.executar(System.getProperty("user.dir").concat("/test/resources/test_gravacao_reta.obj"), objetos);
	}

	@Test
	public void deve_gravar_poligono_com_nome_cinco_vertices_e_uma_faceta() throws IOException {
		Poligono poligono = new Poligono();
		poligono.setNome("Poligono");
		Coordenada c1 = new Coordenada(1, 5);
		Coordenada c2 = new Coordenada(2, 4);
		Coordenada c3 = new Coordenada(3, 3);
		Coordenada c4 = new Coordenada(4, 2);
		Coordenada c5 = new Coordenada(5, 1);
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		coordenadas.add(c1);
		coordenadas.add(c2);
		coordenadas.add(c3);
		coordenadas.add(c4);
		coordenadas.add(c5);
		poligono.setCoordenadas(coordenadas);
		List<ObjetoGeometrico> objetos = new ArrayList<ObjetoGeometrico>();
		objetos.add(poligono);
		gravador.executar(System.getProperty("user.dir").concat("/test/resources/test_poligono_reta.obj"), objetos);
	}
}
