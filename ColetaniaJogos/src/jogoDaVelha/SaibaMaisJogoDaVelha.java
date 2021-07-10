package jogoDaVelha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import menu.MenuJogoSelecionado;

public class SaibaMaisJogoDaVelha extends JFrame{
	JPanel pTela = new JPanel();
	JLabel lInformacao, lInformacao2, lInformacao3;
	
	JButton btnVoltar = new JButton("Voltar");
	
	final int JOGODAVELHA = 1;
	
	
	public SaibaMaisJogoDaVelha() {
		configurarJanela();
		configurarTela();
		
	}

	public void configurarJanela() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 420);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void configurarTela() {
		lInformacao = new JLabel("Jogo da Velha");
		String text = "Conhecido por jogo da velha no Brasil ou jogo do galo em Portugal, "
					+ "pode encontrar-se em diversas culturas ao longo do tempo e com v�rias vers�es. "
					+ "Por exemplo, na China, no Egito ou na Am�rica. Na China era conhecido como luk isut "
					+ "k-i e nos pa�ses de l�ngua inglesa, chama-se tic-tac-toe.\n";
	    
	    lInformacao2 = new JLabel("<html><div style='text-align: justify; padding: 15px'>" + text 
	    		+ "<br>" + "Este jogo tradicional infantil, para al�m de ser muito divertido e din�mico, desenvolve algumas compet�ncias:\r\n"
	    		+ "<br>" + ""
	    		+ "<br>" + "->Desenvolvimento do racioc�nio l�gico;"
	    		+ "<br>" + "->Aperfei�oamento da capacidades espacial e visual;"
	    		+ "<br>" + "->Intera��o e competitividade saud�vel;"
	    		+ "<br>" + "->Bem estar psicol�gico geral."
	    		+ "</div></html>");
	    
		pTela.setLayout(null);
		
		getContentPane().add(pTela);
		
		
		add(BorderLayout.NORTH, lInformacao);
		
		lInformacao2.setBounds(0, -100, 435, 450);
		pTela.add(lInformacao2);
		
		lInformacao.setFont(new Font("Arial", Font.BOLD, 30));
		lInformacao.setForeground(Color.BLUE);
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnVoltar.setBounds(300, 280, 120, 30);
		pTela.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        new MenuJogoSelecionado(JOGODAVELHA, "Jogo da Velha").setVisible(true);
		        dispose();
			}
		});
	}
}
