package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jogoDaVelha.JogoDaVelha;
import jogoDaVelha.JogoDaVelha.Bloco;
import jogoDaVelha.SaibaMaisJogoDaVelha;

public class MenuJogoSelecionado extends JFrame{
	final int JOGODAVELHA = 1;
	
	JPanel pTela = new JPanel();
	JButton btnJogar = new JButton("Jogar");
	JButton btnSaibaMais = new JButton("Saiba Mais");
	JButton btnVoltar = new JButton("Voltar");
	JLabel lInformacao;
	String label;
	
	
	public MenuJogoSelecionado(int jogoEscolhido, String labelJogo) {
		label = labelJogo;
		
		configurarJanela();
		configurarTela();
		
		setJogo(jogoEscolhido);
		setSaibaMais(jogoEscolhido);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        new Menu().setVisible(true);
		        dispose();
			}
		});
	}

	public void configurarJanela() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void configurarTela() {
		
		pTela.setLayout(null);
		
		getContentPane().add(pTela);
		
		JLabel lInformacao = new JLabel(label);
		lInformacao.setBounds(173, 10, 71, 57);
		add(BorderLayout.NORTH, lInformacao);
		
		
		lInformacao.setFont(new Font("Arial", Font.BOLD, 30));
		lInformacao.setForeground(Color.BLUE);
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnJogar.setBounds(100, 75, 120, 30);
		btnSaibaMais.setBounds(225, 75, 120, 30);
		btnVoltar.setBounds(155, 120, 120, 30);
		
		pTela.add(btnJogar);
		pTela.add(btnSaibaMais);
		pTela.add(btnVoltar);
		
		
	}
	
	public void setJogo(int jogoEscolhido) {
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(jogoEscolhido) {
					case JOGODAVELHA:
						new JogoDaVelha().setVisible(true);
						dispose();
						break;
					default:
				}
			}
		});
	}
	
	public void setSaibaMais(int jogoEscolhido) {
		btnSaibaMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(jogoEscolhido) {
					case JOGODAVELHA:
						new SaibaMaisJogoDaVelha().setVisible(true);
						dispose();
						break;
					default:
				}
			}
		});
	}
	
}
