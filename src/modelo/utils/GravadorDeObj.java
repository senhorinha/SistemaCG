package modelo.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;

public class GravadorDeObj {

	private FileWriter escritor;
	private String caractereDeNovaLinha;

	public void executar(String caminhoDoArquivo, List<ObjetoGeometrico> objetos)
			throws IOException {
		escritor = new FileWriter(caminhoDoArquivo);
		caractereDeNovaLinha = System.getProperty("line.separator");
		for (ObjetoGeometrico objeto : objetos) {
			gravarNome(objeto.getNome());
			gravarCoordenadas(objeto.getCoordenadas());
			gravarFaceta(objeto.getCoordenadas().size());
		}
		escritor.close();
	}

	private void gravarFaceta(int numeroDeCoordenadas) throws IOException {
		int indice;
		escritor.write(ComandoObj.FACETA.toString().concat(" "));
		for (int i = numeroDeCoordenadas; i != 0; i--) {
			indice = (i * -1);
			if (indice == -1) {
				escritor.write(String.valueOf(indice).concat(
						caractereDeNovaLinha));
			} else {
				escritor.write(String.valueOf(indice).concat(" "));
			}
		}
	}

	private void gravarCoordenadas(List<Coordenada> coordenadas)
			throws IOException {
		for (Coordenada coordenada : coordenadas) {
			String coordenadaX = String.valueOf(coordenada.getX());
			String coordenadaY = String.valueOf(coordenada.getY());
			escritor.write(ComandoObj.VERTICE.toString().concat(" ")
					.concat(coordenadaX).concat(" ").concat(coordenadaY)
					.concat(caractereDeNovaLinha));
		}
	}

	private void gravarNome(String nome) throws IOException {
		if (nome != null) {
			escritor.write(ComandoObj.NOME.toString().concat(" ").concat(nome)
					.concat(caractereDeNovaLinha));
		}
	}
}
