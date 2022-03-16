package calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	//define a unica instancia da classe
	private static final Memoria memoria = new Memoria();
	
	private Comandos operacao;
	private boolean substituir = false;
	private String valorBuffer = "";
	private String valorAtual ="";
	
	private List<MemoriaObservador> observadores = new ArrayList<>();
	
	private enum Comandos{
		ZERAR,SINAL,NUMERO,SOMAR,SUB,MULT,DIV,RAIZ,VIRGULA,IGUAL;
	}

	private Memoria() {
		
	}

	public static Memoria getMemoria() {
		return memoria;
	}
	public String getValorAtual() {
		
		return valorAtual.isEmpty() ? "0":valorAtual;
	}

	public void registrarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public void processarComando(String valor) {
		Comandos comando = detectarComando(valor);
		if(comando == null) {
			return;
		}else if(comando == Comandos.ZERAR) {
			valorAtual = "";
			valorBuffer = "";
			substituir = false;
			operacao = null;
		}else if(comando == Comandos.NUMERO || comando == Comandos.VIRGULA) {
			valorAtual = substituir ? valor : valorAtual + valor;
			substituir = false;
		}else if(comando == Comandos.SINAL && valorAtual.contains("-")) {
			valorAtual = valorAtual.substring(1);
		}else if(comando == Comandos.SINAL && !valorAtual.contains("-")) {
			valorAtual = "-" + valorAtual;
		}else {
			substituir = true;
			valorAtual = obterResultadoOperacao();
			valorBuffer = valorAtual;
			operacao = comando;
		}
		
	
		observadores.forEach(o -> o.valorAlterado(getValorAtual()));
		
	}

	private String obterResultadoOperacao() {
		if(operacao == null || operacao == Comandos.IGUAL) {
			return valorAtual;
		}
		
		double numeroBuffer = Double.parseDouble(valorBuffer.replace(",", "."));
		double numeroAtual = Double.parseDouble(valorAtual.replace(",", "."));
		double resultado = 0;
		
		
		if(operacao == Comandos.SOMAR) {
			resultado = numeroBuffer + numeroAtual;
		}else if(operacao == Comandos.SUB) {
			resultado = numeroBuffer - numeroAtual;
		}else if(operacao == Comandos.MULT) {
			resultado = numeroBuffer * numeroAtual;
		}else if(operacao == Comandos.DIV) {
			resultado = numeroBuffer / numeroAtual;
		}else if(operacao == Comandos.RAIZ) {
			resultado = Math.sqrt(numeroBuffer);
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		
		boolean isInteiro = resultadoString.endsWith(",0");
		
		return isInteiro ? resultadoString.replace(",0","") : resultadoString;
	}

	private Comandos detectarComando(String valor) {
		if(valorAtual.isEmpty() && valorAtual == "0") {
			return null;
		}
		
		try {
			Integer.parseInt(valor);
			return Comandos.NUMERO;
		} catch (NumberFormatException e) {

			if("C".equals(valor)) {
				return Comandos.ZERAR;			
			}else if("+".equals(valor)) {
				return Comandos.SOMAR;
			}else if("-".equals(valor)) {
				return Comandos.SUB;
			}else if("*".equals(valor)) {
				return Comandos.MULT;
			}else if("/".equals(valor)) {
				return Comandos.DIV;
			}else if("=".equals(valor)) {
				return Comandos.IGUAL;
			}else if("±".equals(valor)) {
				return Comandos.SINAL;
			}else if(",".equals(valor) && !valorAtual.contains(",")) {
				return Comandos.VIRGULA;
			}else if("√".equals(valor)) {
				return Comandos.RAIZ;
			}
			
		}
		return null;
	}
	
}
