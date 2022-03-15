package calc.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		
		URL caminhoIcone = getClass().getResource("/imagens/iconCalc.png");
		Image icone = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(icone);
		
		organizarLayout();
		setTitle("Calculadora");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(232, 322);
	}
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233,60));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new Calculadora();
	}
}
