package calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calc.modelo.Memoria;
import calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {
	//Uma área de exibição 
	//para uma sequência de texto curta ou uma imagem, ou ambas
	private JLabel label;
	
	public Display() {
		//adiciona o Dipslay na lista de observadores
		Memoria.getMemoria().registrarObservador(this);
		
		setBackground(new Color(46, 49, 50));
		
		label = new JLabel(Memoria.getMemoria().getValorAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.ROMAN_BASELINE, 25));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		add(label);
	}
	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
		
	}
	
}
