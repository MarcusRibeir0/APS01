package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Random;

import javax.swing.ImageIcon;

public class MissaoTeste {
	
	//private Random gerador = new Random();
	private int a, b;
  private int x, y;
	private int resultado;
	private String operador;
	private Image imagem;

	private ArrayList<ImageIcon> imagens;
		
	public MissaoTeste(int altura, int largura) {
		
		imagens = new ArrayList<>();

		imagens.add(new ImageIcon("src/res/metal.png"));
		imagens.add(new ImageIcon("src/res/Organico.png"));
		imagens.add(new ImageIcon("src/res/Plastico.png"));
		imagens.add(new ImageIcon("src/res/Papel.png"));
		imagens.add(new ImageIcon("src/res/Vidro.png"));

		int numeroAleatorio = new Random().nextInt(5);
		ImageIcon icone = imagens.get(numeroAleatorio);
		imagem = icone.getImage();

    this.x = new Random().nextInt(largura);
    this.y = new Random().nextInt(altura);
		
	}

	public boolean checarMissao(int resultado){
		boolean a = true;
		if(this.resultado==resultado){
			a = true;
		}
		if(this.resultado!=resultado){
			a = false;
		}
		return a;
	}
 
 //Geters e Seters

	public Image getImagem() {
		return this.imagem;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getResultado() {
		return resultado;
	}

	public String getOperador() {
		return operador;
	}

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

}
