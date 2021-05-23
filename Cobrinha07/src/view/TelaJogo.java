package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TelaJogo extends JFrame{
	private static final long serialVersionUID = 1L;
	public TelaJogo(){
		add(new Fase());
		
		setTitle("Lixeirinho");
		setSize(900,615);
		setIconImage(new ImageIcon("src/res/Icone.png").getImage());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
