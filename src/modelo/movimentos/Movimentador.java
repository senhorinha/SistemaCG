package modelo.movimentos;

import java.util.ArrayList;
import java.util.List;

import modelo.Coordenada;
import modelo.objetos.ObjetoGeometrico;

public abstract class Movimentador {

	ObjetoGeometrico objeto;
	Coordenada coordenadaDeReferencia;

	public Movimentador(ObjetoGeometrico objeto, Coordenada coordenadaDeReferencia) {
		super();
		this.objeto = objeto;
		this.coordenadaDeReferencia = coordenadaDeReferencia;
	}

	public abstract void movimentar();

}