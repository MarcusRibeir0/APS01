package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.Main;

public class TelaOpcoes extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;

		private Image imagemIcone;
		
		private ImageIcon referencia;
		
		private JRadioButton velocidadeNormal,velocidadeBaixa,VelocidadeRapida;
		private JRadioButton tudo;
		
		private JLabel label;
		private JLabel velocidade,veloNormal,veloBaixa,veloRapida;
		private JTextField quantidade;
		
		private JButton voltar;
		
		private ButtonGroup grupoA;
		
		public TelaOpcoes(){
				
			
				referencia = new ImageIcon("src/res/Icone.png");
				imagemIcone = referencia.getImage();
				add(label = new JLabel(new ImageIcon("src/res/FaseFundo.png")));
				
				//Inicialização
				
				velocidade = new JLabel(new ImageIcon("src/res/Velocidade.png"));
				veloBaixa = new JLabel(new ImageIcon("src/res/Devagar.png"));
				veloNormal = new JLabel(new ImageIcon("src/res/Normal.png"));
				veloRapida = new JLabel(new ImageIcon("src/res/Rapido.png"));
				
				tudo = new JRadioButton();
				tudo.setSelected(true);
				velocidadeBaixa = new JRadioButton();
				velocidadeNormal = new JRadioButton();
				VelocidadeRapida = new JRadioButton();
				velocidadeNormal.setSelected(true);

				voltar = new JButton();
				
				
				grupoA = new ButtonGroup();
			 
				//Adicionando ao Label
				 
				label.add(velocidade);
				label.add(veloBaixa);
				label.add(veloNormal);
				label.add(veloRapida);
				label.add(velocidade);
		
				//caixa de selecionar as velocidades
				label.add(velocidadeBaixa);
				label.add(velocidadeNormal);
				label.add(VelocidadeRapida);
				
			
			label.add(voltar);
				
				//Setando local, retirando bordas, deichando transparente, adicionando a grupos
				
				velocidade.setBounds(80, 50, 100, 30);
				veloBaixa.setBounds(80, 80, 100, 30);
				veloNormal.setBounds(80, 110, 110, 33);
				veloRapida.setBounds(80, 140, 100, 30);
				
			
				//Posições das bolinha de escolha de velocidade
				velocidadeBaixa.setBounds(155, 80, 100, 30);
				velocidadeBaixa.setBorder(null);
				velocidadeBaixa.setContentAreaFilled(false);
				
				velocidadeNormal.setBounds(152, 110, 110, 33);
				velocidadeNormal.setBorder(null);
				velocidadeNormal.setContentAreaFilled(false);
				
				VelocidadeRapida.setBounds(150, 140, 100, 30);
				VelocidadeRapida.setBorder(null);
				VelocidadeRapida.setContentAreaFilled(false);
				
				grupoA.add(velocidadeBaixa);
				grupoA.add(velocidadeNormal);
				grupoA.add(VelocidadeRapida);
				
				
				voltar.addActionListener(this);
				voltar.setBounds(490, 555, 144, 40);
				voltar.setIcon(new ImageIcon("src/res/QuitBar.png"));
				voltar.setBorder(null);
				voltar.setContentAreaFilled(false);
					
				 //Construindo Tela
				 
				setUndecorated(true);
				setTitle("Lixeirinho");
				setSize(640,600);
				setIconImage(imagemIcone);
				setVisible(true);
				setLocationRelativeTo(null);
				setResizable(false);
		}
			
		public JRadioButton getVelocidadeNormal() {
			return velocidadeNormal;
		}

		public JRadioButton getVelocidadeBaixa() {
			return velocidadeBaixa;
		}

		public JRadioButton getVelocidadeRapida() {
			return VelocidadeRapida;
		}
		
		public JRadioButton getTudo() {
			return tudo;
		}
		
		public JTextField getQuantidade() {
			return quantidade;
		}
		
		public void actionPerformed(ActionEvent e) {
			Main.opcoes.receberConfiguracoes(this);
			dispose();
		}

	}


