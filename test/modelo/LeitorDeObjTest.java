package modelo;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import modelo.objetos.ObjetoGeometrico;
import modelo.objetos.Poligono;
import modelo.objetos.Ponto;
import modelo.objetos.Reta;
import modelo.utils.LeitorDeObj;

import org.junit.Test;

public class LeitorDeObjTest {

	LeitorDeObj analisador;

	public void construirAnalisador(String caminho) throws FileNotFoundException {
		analisador = new LeitorDeObj(System.getProperty("user.dir").concat(caminho));
	}

	@Test
	public void deve_reconhecer_f_como_ponto() throws IOException {
		construirAnalisador("/test/resources/teste_faceta_ponto.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(true, objetos.get(0) instanceof Ponto);
	}

	@Test
	public void deve_reconhecer_f_como_reta() throws IOException {
		construirAnalisador("/test/resources/teste_faceta_reta.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(true, objetos.get(0) instanceof Reta);
	}

	@Test
	public void deve_reconhecer_f_como_poligono() throws IOException {
		construirAnalisador("/test/resources/teste_faceta_poligono.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(true, objetos.get(0) instanceof Poligono);
	}

	@Test
	public void deve_reconhecer_f_com_quatro_vertices_como_poligono() throws IOException {
		construirAnalisador("/test/resources/teste_faceta_quatro_vertices_poligono.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(true, objetos.get(0) instanceof Poligono);
	}

	@Test
	public void deve_reconhecer_f_com_indice_negativo() throws IOException {
		construirAnalisador("/test/resources/teste_faceta_vertice_indice_negativo.obj");
		Coordenada a = new Coordenada(10, 10);
		Coordenada b = new Coordenada(20, 20);
		List<ObjetoGeometrico> objetos = analisador.executar();
		ObjetoGeometrico objeto = objetos.get(0);
		assertEquals(a.getX(), objeto.getCoordenadas().get(0).getX());
		assertEquals(a.getY(), objeto.getCoordenadas().get(0).getY());
		assertEquals(b.getX(), objeto.getCoordenadas().get(1).getX());
		assertEquals(b.getY(), objeto.getCoordenadas().get(1).getY());
	}

	@Test
	public void deve_reconhecer_comentario() throws IOException {
		construirAnalisador("/test/resources/teste_comentario.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(0, objetos.size());
	}

	@Test
	public void deve_saber_atribuir_nome() throws IOException {
		construirAnalisador("/test/resources/teste_nome.obj");
		List<ObjetoGeometrico> objetos = analisador.executar();
		assertEquals(true, objetos.get(0).getNome().equalsIgnoreCase("Nome"));
	}
}
