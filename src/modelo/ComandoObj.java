package modelo;

public enum ComandoObj {

	COMENTARIO("#"), VERTICE("v"), FACETA("f"), NOME("o"), QUALQUER_OUTRO("qu@lu3r");

	String comando;

	private ComandoObj(String comando) {
		this.comando = comando;
	}

	@Override
	public String toString() {
		return comando;
	}

}
