package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.Main;


@SuppressWarnings("unused")
public class TelaDoMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel primeiroPlayerLabel;
	private JTextField primeiroPlayerField;
	private JButton jogarButton,sairButton,creditosButton,optionButton;
	private JLabel imagemLabel;
	public TelaDoMenu(){


		ImageIcon imagem = new ImageIcon("src/res/Menu.png");
		imagemLabel = new JLabel(imagem);
		add(imagemLabel);

		primeiroPlayerLabel = new JLabel(new ImageIcon("src/res/PlayerLabel.png"));
		imagemLabel.add(primeiroPlayerLabel);


		primeiroPlayerField = new JTextField(10);
		imagemLabel.add(primeiroPlayerField);

		jogarButton = new JButton();
		jogarButton.setIcon(new ImageIcon("src/res/StartButton.png"));
		imagemLabel.add(jogarButton);

		creditosButton = new JButton();
		creditosButton.setIcon(new ImageIcon("src/res/CreditosBar.png"));
		imagemLabel.add(creditosButton);

		sairButton = new JButton();
		sairButton.setIcon(new ImageIcon("src/res/QuitBar.png"));
		imagemLabel.add(sairButton);

		optionButton =new JButton();
		optionButton.setIcon(new ImageIcon("src/res/OpcoesButton.png"));
		imagemLabel.add(optionButton);

		jogarButton.addActionListener(this);
		creditosButton.addActionListener(this);
		sairButton.addActionListener(this);
		optionButton.addActionListener(this);

		imagemLabel.setBounds(1,1,1,1);

		primeiroPlayerLabel.setBounds(550, 510, 100, 30);
		primeiroPlayerField.setBounds(650, 510, 130, 30);

		jogarButton.setBounds(640,360 , 132, 40);
		jogarButton.setContentAreaFilled(false);
		jogarButton.setBorder(null);

		creditosButton.setBounds(641, 400, 132, 40);
		creditosButton.setContentAreaFilled(false);
		creditosButton.setBorder(null);

		sairButton.setBounds(641, 440, 132, 40);
		sairButton.setContentAreaFilled(false);
		sairButton.setBorder(null);

		optionButton.setBounds(700,10,43,38);
		optionButton.setContentAreaFilled(false);
		optionButton.setBorder(null);

		setUndecorated(true);
		setTitle("Lixeirinho");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("src/res/Icone.png").getImage());
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {

		if((e.getSource()==jogarButton)){

			if (primeiroPlayerField.getText().trim().equals("")) {  
					JOptionPane.showMessageDialog(null, "Por favor, Digite um nick!");
				} else {  
					Main.player.setNome(primeiroPlayerField.getText());
					
					setVisible(false);

					new TelaJogo();
				}
			}
		
		
		if((e.getSource()==creditosButton)){
			new Creditos();

		}

		if((e.getSource()==sairButton)){
			System.exit(0);

		}
		if((e.getSource()==optionButton)){
			new TelaOpcoes();

		}

	}

}
