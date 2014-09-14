package modelo.utils;

public enum RegiaoParaClipping {

	CENTRO("0000"), NORTE("1000"), NORDESTE("1010"), LESTE("0010"), SUDESTE("0110"), SUL("0100"), SUDOESTE("0101"), OESTE(
			"0001"), NOROESTE("1001");

	String bits;

	private RegiaoParaClipping(String bits) {
		this.bits = bits;
	}

	public int valueOf() {
		return Integer.parseInt(bits, 2);
	}

	@Override
	public String toString() {
		return bits;
	}

}
