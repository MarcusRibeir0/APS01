package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


import main.Main;
import model.MissaoTeste;
import model.Vida;
import model.Missao;
import model.PanelMenu;

import model.Lixeiro;

public class Fase extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final int LARGURA = 625;
	private final int ALTURA = 580;
	private final int LIXO_TAMANHO = 20;
	private final int TAMANHOMATRIZ = 960;
	private int VELOCIDADE = 140;


	private JButton recomecar = new JButton("Recome�ar");
	private JButton sair = new JButton("Sair");


	private Random gerador = new Random();

	private Image fundo;

	private int maissaoX,maissaoY;

	private int aparencia=0;
	private int missaoResultado;

	private boolean ativo = true;

	private JFrame j;
	private PanelMenu menuzinho = new PanelMenu();
	private Missao missao;
	private MissaoTeste missaoTeste;


	private Vida vida2;

	private Color azula = new Color(204);

	private Timer timer;



	
	private Lixeiro LixeirinhoJogados1;
	
	public Fase() {

		fundo = new ImageIcon("src/res/FaseFundo.png").getImage();

		setFocusable(true);
		setDoubleBuffered(true);

		addKeyListener(new AdaptadorTeclado());


		iniciarGame();

		missao = new Missao();

		Main.opcoes.carregarConfiguracoes(this, missao);

		vida2 = new Vida();
		vida2.start();
		vida2.hide();
	}

	private void iniciarGame() {
		LixeirinhoJogados1 = new Lixeiro(TAMANHOMATRIZ, 0, 0, "direita");

		Main.player.carregarQuantidade();
		gerarMissaoLocal();	
		timer = new Timer(VELOCIDADE, this);
		timer.start();

	}

	/**
	 * 
	 * ======================================Area de desenho==================================
	 * 
	 * */


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(azula);

		g.drawImage(fundo, 0, -5, this);

		missaoTela(missao,g);

		doDrawing(g);

		g.setColor(Color.blue);
		g.fillRect(640, 0, 260, 600);


		menuzinho.menudesenhar(g,LixeirinhoJogados1.getScore(),LixeirinhoJogados1.getVida(),missao);
		sprite();

	}


	private void doDrawing(Graphics g) {

		if (ativo) {
			g.drawImage(vida2.getImagem(), vida2.getX(), vida2.getY(), this);
			LixeirinhoJogados1.desenharLixeiro(g);

		}     
	}

	private void missaoTela(Missao missao,Graphics g) {
		var image = missao.getImagem();

		g.drawImage(image, maissaoX, maissaoY,this);


	}

	 //Area de checar posi��es

	private void checarMissaoHit() {

		if ((LixeirinhoJogados1.getCabeca().x  == this.missaoTeste.getX()) && (LixeirinhoJogados1.getCabeca().y == this.missaoTeste.getY())) {
			missaoResultado=missao.getResultado();


			if(missao.checarMissao(missaoResultado)){
				LixeirinhoJogados1.setScore(LixeirinhoJogados1.getScore()+1);
				LixeirinhoJogados1.addCorpo();
				geradores();
			}
		}
	}

	public void geradores(){
		gerarMissaoLocal();
	}

	private void checarColisao() {

		if ((LixeirinhoJogados1.getCabeca().y >= ALTURA)||(LixeirinhoJogados1.getCabeca().y < 0)) {
			LixeirinhoJogados1.menosVida();
			checarVida();
			LixeirinhoJogados1.recomecar();
		}

		if ((LixeirinhoJogados1.getCabeca().x >= LARGURA)||(LixeirinhoJogados1.getCabeca().x < 0)) {
			LixeirinhoJogados1.menosVida();
			checarVida();
			LixeirinhoJogados1.recomecar();
		}

		if(!ativo) {
			timer.stop();
		}
	}

	public boolean checarMissao(int resultado){

		boolean a = true;
		if(this.missao.getResultado()==resultado){
			a = true;
		}
		if(this.missao.getResultado()!=resultado){
			a = false;
		}
		return a;
	}

	private void checarvida2() {

		if ((LixeirinhoJogados1.getCabeca().x  == vida2.getX()) && (LixeirinhoJogados1.getCabeca().y == vida2.getY())) {
			if(LixeirinhoJogados1.getVida()<=2){
				LixeirinhoJogados1.maisVida();}
			vida2.setAtivo(false);
			vida2.hide();
		}

	}
	
	private void checarVida(){
		if(LixeirinhoJogados1.getVida()<=0){
			ativo=false;
			missaoResultado=missao.getResultado();
			vida2.hide();
			recomecar();
		}
	}
	//Area de Atualiz�o
	 
	private void recomecar(){

		j = new JFrame();
		j.setTitle("Mais uma vez?");
		j.setSize(220,65);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setIconImage(new ImageIcon("src/res/Icone.png").getImage());
		j.setLocationRelativeTo(null);
		j.setResizable(false);
		j.add(recomecar);
		j.add(sair);
		j.setLayout(new FlowLayout());
		recomecar.addActionListener(this);
		sair.addActionListener(this);
		j.setVisible(true);
	}

	private void sprite(){
		this.aparencia++;
		if(this.aparencia>=5){
			this.aparencia=0;
		}
		menuzinho.setAparencia(this.aparencia);
	}

	private void gerarMissaoLocal() {

		this.missaoTeste = new MissaoTeste(ALTURA, LARGURA);

		// int r = gerador.nextInt(32);
		// maissaoX = ((r * LIXO_TAMANHO));

		// r = gerador.nextInt(32);
		// maissaoY = ((r * LIXO_TAMANHO));

		// if((maissaoX<0)||(maissaoX>=LARGURA)||(maissaoY<0)||(maissaoY>=ALTURA)){
		// 	gerarMissaoLocal();
		// }
	}
	 //Area de eventos
	 
	private class AdaptadorTeclado extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!LixeirinhoJogados1.isDireita())) {
				LixeirinhoJogados1.lado("esquerda");
			}

			if ((key == KeyEvent.VK_RIGHT) && (!LixeirinhoJogados1.isEsquerda())) {
				LixeirinhoJogados1.lado("direita");
			}

			if ((key == KeyEvent.VK_UP) && (!LixeirinhoJogados1.isBaixo())) {
				LixeirinhoJogados1.lado("cima");
			}

			if ((key == KeyEvent.VK_DOWN) && (!LixeirinhoJogados1.isCima())) {
				LixeirinhoJogados1.lado("baixo");
			}

			if (key == KeyEvent.VK_P){
				if(ativo){
					ativo=false;
				}else{
					ativo=true;
				}
			}

		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==recomecar){

			LixeirinhoJogados1.recomecar();
			
			LixeirinhoJogados1.setScore(0);
			ativo=true;
			LixeirinhoJogados1.setTamanhoLixeiro(3);
			j.dispose();
			timer.start();
			LixeirinhoJogados1.setVida(3);
		}if(e.getSource()==sair){
		
			System.exit(0);
		}

		if (ativo) {
			checarVida();
			if(ativo){
				checarMissaoHit();
				checarvida2();
				checarColisao();
				LixeirinhoJogados1.mover();
				repaint();
			}
		}
	}

	public void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

}
