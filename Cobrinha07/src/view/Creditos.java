package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Creditos extends JFrame implements ActionListener{
		
	private static final long serialVersionUID = 1L;
	private Image imagemIcone;
	private ImageIcon referencia,a;
	private JLabel label;
	private JButton voltar;
	
	public Creditos(){
		
			//referencia = new ImageIcon("src/res/SnakeIcon.png");
			imagemIcone = referencia.getImage();
			
			//a= new ImageIcon("src/res/eblema.png");
			
			repaint();
			
			add(label = new JLabel());
			voltar = new JButton();
			label.add(voltar);
				voltar.addActionListener(this);
			
			voltar.setBounds(640, 430, 144, 40);
			voltar.setIcon(new ImageIcon("src/res/QuitBar.png"));
			voltar.setBorder(null);
			voltar.setContentAreaFilled(false);
			
			setUndecorated(true);
			setTitle("Lixeirinho");
			setSize(800,500);
			setIconImage(imagemIcone);
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 500);
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.drawImage(a.getImage(), 10, 15, this);
		g.setColor(Color.BLACK);
		g.drawString("UNIVERSIDADE PAULISTA - UNIP", 150, 50);
		g.drawString("CURSO: CIENCIA DA COMPUTACAO ", 150, 100);
		g.drawString("ALUNO: MARCUS VINICIUS F DE A RIBEIRO", 150, 150);
		g.drawString("PROFESSOR: NATHAN CIRILO E SILVA", 150, 200);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}
}
