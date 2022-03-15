package calc.modelo;

public class Memoria {
	//define a unica instancia da classe
	private static final Memoria memoria = new Memoria();
	private final String textoAtual ="";
	

	public static Memoria getMemoria() {
		return memoria;
	}
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0":textoAtual;
	}

	private Memoria() {

	}
}
