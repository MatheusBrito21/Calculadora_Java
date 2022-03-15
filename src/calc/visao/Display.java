package calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Display extends JPanel {
	//Uma área de exibição 
	//para uma sequência de texto curta ou uma imagem, ou ambas
	private JLabel label;
	
	public Display() {
		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memoria.getMemoria().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.ROMAN_BASELINE, 25));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(label);
	}
}
