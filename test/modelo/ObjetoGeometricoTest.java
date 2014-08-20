package modelo;

import org.junit.Assert;
import org.junit.Test;

public class ObjetoGeometricoTest {

	@Test
	public void test() {
	}

	@Test
	public void deveSaberClonar() throws CloneNotSupportedException {
		Coordenada a = new Coordenada(10, 10);
		Coordenada b = new Coordenada(20, 20);
		Reta reta = new Reta("Reta", a, b);
		Reta retaClone = (Reta) reta.clone();
		Assert.assertEquals(reta.getNome(), retaClone.getNome());
		Assert.assertEquals(reta.getCoordenadas(),
				retaClone.getCoordenadas());
	}
}
