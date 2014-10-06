package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.objetos.ObjetoGeometrico;
import modelo.transformacoes.Transformacao;

public class DisplayFile {

	public List<ObjetoGeometrico> objetos;
	private List<ObjetoGeometrico> objetosClipados;

	private final Transformacao transformacaoDeViewport;
	private final Coordenada minimaViewport;
	private final Coordenada maximaViewport;

	public DisplayFile(Transformacao transformacaoDeViewport, Coordenada minimaViewport, Coordenada maximaViewport) {
		this.transformacaoDeViewport = transformacaoDeViewport;
		this.minimaViewport = minimaViewport;
		this.maximaViewport = maximaViewport;
		objetos = new ArrayList<ObjetoGeometrico>();
		objetosClipados = new ArrayList<ObjetoGeometrico>();
	}

	public void iniciarCom(List<ObjetoGeometrico> objetos) {
		this.objetos = objetos;
		for (ObjetoGeometrico objetoGeometrico : objetos) {
			ObjetoGeometrico objetoClonado = objetoGeometrico.clone();
			objetoClonado.transformarCoordenadas(transformacaoDeViewport);
			this.objetosClipados.add(objetoClonado.toClip(minimaViewport, maximaViewport));
		}
	}

	public void adicionar(ObjetoGeometrico objeto) {
		objetos.add(objeto);
		ObjetoGeometrico objetoClonado = objeto.clone();
		objetoClonado.transformarCoordenadas(transformacaoDeViewport);
		objetosClipados.add(objetoClonado.toClip(minimaViewport, maximaViewport));
	}

	public void trocarObjetoDoIndice(ObjetoGeometrico objeto, int indice) {
		objetos.set(indice, objeto);
		ObjetoGeometrico objetoClonado = objeto.clone();
		objetoClonado.transformarCoordenadas(transformacaoDeViewport);
		objetosClipados.set(indice, (objetoClonado.toClip(minimaViewport, maximaViewport)));
	}

	public void remover(int indice) {
		objetos.remove(indice);
		objetosClipados.remove(indice);
	}

	public List<ObjetoGeometrico> getObjetos() {
		return objetos;
	}

	public List<ObjetoGeometrico> getObjetosClipados() {
		return objetosClipados;
	}

	public void atualizarTodosOsObjetos() {
		objetosClipados.clear();
		for (ObjetoGeometrico objeto : objetos) {
			ObjetoGeometrico objetoClonado = objeto.clone();
			objetoClonado.transformarCoordenadas(transformacaoDeViewport);
			objetosClipados.add(objetoClonado.toClip(minimaViewport, maximaViewport));
		}
	}

	public void atualizarObjeto(ObjetoGeometrico objeto) {
		int indice = objetos.indexOf(objeto);
		ObjetoGeometrico objetoClonado = objeto.clone();
		objetoClonado.transformarCoordenadas(transformacaoDeViewport);
		objetosClipados.set(indice, (objetoClonado.toClip(minimaViewport, maximaViewport)));
	}

}
