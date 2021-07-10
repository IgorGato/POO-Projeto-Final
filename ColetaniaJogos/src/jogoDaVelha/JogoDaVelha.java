package jogoDaVelha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JogoDaVelha extends JFrame{
	final int JOGADOR_1 = 1;
	final int JOGADOR_2 = 2;
	
	
	JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
	JLabel lInformacao = new JLabel("Jogador "+JOGADOR_1);
	
	Bloco[] blocos = new Bloco[9];
	
	int jogadorVez = JOGADOR_1;
	int rodada = 0;
	
	
	ImageIcon iconO = new ImageIcon(getClass().getResource("O.png"));
	ImageIcon iconX = new ImageIcon(getClass().getResource("X.png"));
	
    public ImageIcon SetImageSize(ImageIcon icon){
    	Image img = icon.getImage();
    	Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    	ImageIcon newImc = new ImageIcon(newImg);
    	return newImc;
    }
	
	
	public JogoDaVelha() {
		iconO = SetImageSize(iconO);
		iconX = SetImageSize(iconX);
		configurarJanela();
		configurarTela();
	}
	
	public void mudarVez() {
		if(jogadorVez==JOGADOR_1) {
			jogadorVez = JOGADOR_2;
			lInformacao.setText("Jogador "+JOGADOR_2);
			lInformacao.setForeground(Color.RED);
		}
		else {
			jogadorVez = JOGADOR_1;
			lInformacao.setText("Jogador "+JOGADOR_1);
			lInformacao.setForeground(Color.BLUE);
		}
			
	}
	
	public boolean verificarVencedor(int JOGADOR) {
		int count = 0;
		for(int i = 1; i <= 9; i++) {
			if(blocos[i-1].quem == JOGADOR) {
				count++;
				if(count == 3)
					return true;
			}
			
			if(i%3 == 0)
				count=0;
		}
		
		for(int i = 0; i < 3; i++) {
			if(blocos[i*3].quem == JOGADOR && blocos[(i*3)+1].quem == JOGADOR && blocos[(i*3)+2].quem == JOGADOR)
				return true;
			if(blocos[i].quem == JOGADOR && blocos[i+3].quem == JOGADOR && blocos[i+6].quem == JOGADOR)
				return true;
		}
		
		if(blocos[0].quem == JOGADOR && blocos[4].quem == JOGADOR && blocos[8].quem == JOGADOR)
			return true;
		if(blocos[2].quem == JOGADOR && blocos[4].quem == JOGADOR && blocos[6].quem == JOGADOR)
			return true;
		
		return false;
	}
	
	public void configurarJanela() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void configurarTela() {
		
		add(BorderLayout.CENTER, pTela);
		add(BorderLayout.NORTH, lInformacao);
		pTela.setBackground(Color.BLACK);
		lInformacao.setFont(new Font("Arial", Font.BOLD, 30));
		lInformacao.setForeground(Color.BLUE);
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i = 0; i < 9; i++) {
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			pTela.add(bloco);
		}
		
	}
	
	public class Bloco extends JButton{
		int quem = 0; 
		public Bloco() {
			setBackground(Color.WHITE);
			addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(quem==0) {
							if(jogadorVez == JOGADOR_1) {
								setIcon(iconO);
								quem = JOGADOR_1;
							}else{
								setIcon(iconX);
								quem = JOGADOR_2;
							}
							if(verificarVencedor(jogadorVez)) {
								JOptionPane.showMessageDialog(null, "Jogador "+jogadorVez+" Venceu!");
								dispose();
							};
							rodada++;
							if(rodada == 9) {
								JOptionPane.showMessageDialog(null, "Empate! Deu Velha.");
								dispose();
							}
							mudarVez();
						}
					}
				}
			);
		}
	}
	
	
}
