package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
		final int JOGODAVELHA = 1;
		
		JPanel pTela = new JPanel();
		JLabel lInformacao = new JLabel("Menu Principal");
		
		JButton btnJogoDaVelha = new JButton("Jogo da Velha");
		
		
		public Menu() {
			configurarJanela();
			configurarTela();
			setBtns();
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
			
			JLabel lInformacao = new JLabel("Menu Inicial");
			lInformacao.setBounds(173, 10, 71, 57);
			
			add(BorderLayout.NORTH, lInformacao);
			lInformacao.setFont(new Font("Arial", Font.BOLD, 30));
			lInformacao.setForeground(Color.BLUE);
			lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			btnJogoDaVelha.setBounds(155, 75, 120, 30);
			
			pTela.add(btnJogoDaVelha);
			
		}
		
		public void setBtns(){
			
			btnJogoDaVelha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			        new MenuJogoSelecionado(JOGODAVELHA, "Jogo da velha").setVisible(true);
			        dispose();
				}
			});
		}
}
