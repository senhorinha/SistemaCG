package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorDeObj {

	private FileInputStream stream;
	private List<ObjetoGeometrico> objetos;
	private List<Coordenada> coordenadas;
	private String nome;

	public AnalisadorDeObj(String caminhoDoArquivo) throws FileNotFoundException {
		stream = new FileInputStream(caminhoDoArquivo);
		objetos = new ArrayList<ObjetoGeometrico>();
		coordenadas = new ArrayList<Coordenada>();
	}

	public List<ObjetoGeometrico> executar() throws IOException {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(stream));
		String linha;
		while ((linha = leitor.readLine()) != null) {
			ComandoObj comando = descobrirComando(linha);
			switch (comando) {
			case NOME:
				adicionarNome(linha);
				break;
			case VERTICE:
				adicionarVertice(linha);
				break;
			case FACETA:
				adicionarFaceta(linha);
				break;
			case COMENTARIO:
			case QUALQUER_OUTRO:
				break;
			}
		}
		leitor.close();
		return objetos;
	}

	private ComandoObj descobrirComando(String linha) {
		for (ComandoObj comando : ComandoObj.values()) {
			if (linha.startsWith(comando.toString())) {
				return comando;
			}
		}
		return ComandoObj.QUALQUER_OUTRO;
	}

	private String[] separarEntreEspacos(String linha) {
		return linha.split(" ");
	}

	private void adicionarNome(String linha) {
		String[] tokens = separarEntreEspacos(linha);
		if (tokens.length >= 2) {
			this.nome = tokens[1];
		}
	}

	private void adicionarVertice(String linha) {
		String[] tokens = separarEntreEspacos(linha);
		if (tokens.length >= 3) {
			int x = Integer.valueOf(tokens[1]);
			int y = Integer.valueOf(tokens[2]);
			coordenadas.add(new Coordenada(x, y));
		}
	}

	private void adicionarFaceta(String linha) {
		String[] tokens = separarEntreEspacos(linha);
		List<Coordenada> coordenadasDaFaceta = new ArrayList<Coordenada>();
		int numeroDeVerticesAdicionados = coordenadas.size();
		for (int i = 1; i < tokens.length; i++) {
			int indice = Integer.valueOf(tokens[i]);
			if (isIndiceDentroDoLimite(indice)) {
				if (indice < 0) {
					coordenadasDaFaceta.add(coordenadas.get(indice + numeroDeVerticesAdicionados));
				} else {
					coordenadasDaFaceta.add(coordenadas.get(indice - 1));
				}
			} else {
				return;
			}
		}
		adicionarObjetoComAsCoordenadas(coordenadasDaFaceta);
	}

	private void adicionarObjetoComAsCoordenadas(List<Coordenada> coordenadasDaFaceta) {
		ObjetoGeometrico objeto;
		switch (coordenadasDaFaceta.size()) {
		case 0:
			return;
		case 1:
			objeto = new Ponto();
			break;
		case 2:
			objeto = new Reta();
			break;
		default:
			objeto = new Poligono();
			break;
		}
		objeto.setNome(nome);
		objeto.setCoordenadas(coordenadasDaFaceta);
		objetos.add(objeto);
	}

	private boolean isIndiceDentroDoLimite(int indice) {
		if (indice > 0) {
			indice -= 1;
		}
		int numeroDeVerticesAdicionados = coordenadas.size();
		if (indice >= numeroDeVerticesAdicionados || indice + numeroDeVerticesAdicionados < 0) {
			return false;
		}
		return true;
	}

}
