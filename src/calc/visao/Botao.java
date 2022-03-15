package calc.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Botao extends JButton {
	public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true);
		setBackground(cor);
		setForeground(Color.WHITE);
		setFont(new Font("courier", Font.ROMAN_BASELINE, 20));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		
	}
}
