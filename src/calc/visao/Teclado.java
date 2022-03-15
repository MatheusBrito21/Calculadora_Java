package calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	//collor picker
	private final Color CINZA_ESCURO = new Color(68,68,68);
	private final Color CINZA_CLARO = new Color(99,99,99);
	private final Color LARANJA = new Color(242,163,60);

	public Teclado() {
		setBackground(CINZA_ESCURO);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		//preenche o conteiner Teclado nos dois eixos
		c.weighty = 1;
		c.weightx = 1;
		//preenche os espaços entre os elementos
		c.fill = GridBagConstraints.BOTH;
		//layout de grade com linhas e colunas
		//setLayout(new GridLayout(5,4));
		
		//linha1
		/*define o o tamanho da grid
		*/
		c.gridwidth = 2;
		adicionarBotao("AC" ,CINZA_ESCURO, c ,0,0);
		c.gridwidth = 1;//retorna a configuração anterior da grid
		adicionarBotao("√", CINZA_CLARO, c, 2, 0);
		adicionarBotao("+", LARANJA, c, 3, 0);
		
		//linha2
		adicionarBotao("7" ,CINZA_CLARO, c ,0,1);
		adicionarBotao("8", CINZA_CLARO, c, 1, 1);
		adicionarBotao("9" ,CINZA_CLARO, c ,2,1);
		adicionarBotao("-", LARANJA, c, 3, 1);
		//linha3
		adicionarBotao("6" ,CINZA_CLARO, c ,0,2);
		adicionarBotao("5", CINZA_CLARO, c, 1, 2);
		adicionarBotao("4" ,CINZA_CLARO, c ,2,2);
		adicionarBotao("*", LARANJA, c, 3, 2);
		//linha4
		adicionarBotao("3" ,CINZA_CLARO, c ,0,3);
		adicionarBotao("2", CINZA_CLARO, c, 1, 3);
		adicionarBotao("1" ,CINZA_CLARO, c ,2,3);
		adicionarBotao("/", LARANJA, c, 3, 3);
		//linha5
		c.gridwidth = 2;
		adicionarBotao("0", CINZA_CLARO, c, 0, 4);
		c.gridwidth = 1;
		adicionarBotao("," ,CINZA_CLARO, c ,2,4);
		adicionarBotao("=", LARANJA, c, 3, 4);
		
		
	}

	private void adicionarBotao(String texto, 
			Color cor, GridBagConstraints c, int i, int j) {	
		
		c.gridx=i;
		c.gridy=j;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton)e.getSource();
		System.out.println(botao.getText());
		}
	}
	
}
