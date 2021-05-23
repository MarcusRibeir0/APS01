package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Lixeiro {
	private Image cabeca;
	private Image corpo;
	
	private int tamanhoLixeiro = 3;
	private int vida=3;
	private int xInicial, yInicial;
	private int score=0;
	
	private boolean esquerda = false;
	private boolean direita = false;
	private boolean cima = false;
	private boolean baixo = false;
	
	private final int x[];
	private final int y[];
	private String ladoInicial;
	public Lixeiro(int TAMANHOMATRIZ, int x, int y, String lado) {
		
		this.x= new int[TAMANHOMATRIZ];
		this.y = new int[TAMANHOMATRIZ];
		xInicial = x; 
		yInicial=y;
		ladoInicial=lado;
		this.lado(lado);
		criaCorpo(); 
	
	}
	public void criaCorpo(){
		
		for (int z = 0; z < tamanhoLixeiro; z++) {
			this.x[z] = xInicial - z * 20;
			this.y[z] = yInicial;
		}
	}
	public void lado(String lado){
		switch (lado){
		case "cima":{
			esquerda = false;
			direita = false;
			cima = true;
			baixo = false;
			break;
		}
		case "baixo":{
			esquerda = false;
			direita = false;
			cima = false;
			baixo = true;
			break;
		}
		case "direita":{
			esquerda = false;
			direita = true;
			cima = false;
			baixo = false;
			break;
		}
		case "esquerda":{
			esquerda = true;
			direita = false;
			cima = false;
			baixo = false;
			break;
		}
		
		}
	}
	private void carregarImagens() {
		if(cima){
			cabeca = new ImageIcon("src/res/lix.png").getImage();
		}
		if(esquerda){
			cabeca = new ImageIcon("src/res/lix.png").getImage();
		}
		if(direita){
			cabeca = new ImageIcon("src/res/lix.png").getImage();
		}	
		if(baixo){
			cabeca = new ImageIcon("src/res/lix.png").getImage();
		}
		
		if(cima){
			corpo = new ImageIcon("src/res/corpo.png").getImage();
		}
		if(esquerda){
			corpo = new ImageIcon("src/res/corpo.png").getImage();
		}
		if(direita){
			corpo = new ImageIcon("src/res/corpo.png").getImage();
		}	
		if(baixo){
			corpo = new ImageIcon("src/res/corpo.png").getImage();
		}
	}
	public void desenharLixeiro(Graphics g){
		carregarImagens();
		
		for (int z = 0; z < tamanhoLixeiro; z++) {
			if (z == 0) {
				g.drawImage(cabeca, x[z], y[z], null);
			} else {
				g.drawImage(corpo, x[z], y[z], null);
			}
		}
	}
	public void addCorpo(){
		tamanhoLixeiro++;
	}
	public void retiraCorpo(){
		tamanhoLixeiro--;
	}
	public Point getCabeca(){
		Point p = new Point(x[0], y[0]);
		return p;
	}
	public void recomecar(){
		lado(ladoInicial);
		criaCorpo();
	}
	public void mover() {

		for (int z = tamanhoLixeiro; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (esquerda) {
			x[0] -= 20;
		}

		if (direita) {
			x[0] += 20;
		}

		if (cima) {
			y[0] -= 20;
		}

		if (baixo) {
			y[0] += 20;
		}
	}
	
	public boolean isEsquerda() {
		return esquerda;
	}
	public boolean isDireita() {
		return direita;
	}
	public boolean isCima() {
		return cima;
	}
	public boolean isBaixo() {
		return baixo;
	}
	public void setTamanhoLixeiro(int tamanhoLixeiro) {
		this.tamanhoLixeiro = tamanhoLixeiro;
	}
	public int getVida() {
		return vida;
	}
	public void menosVida() {
		this.vida --;
	}
	public void maisVida() {
		this.vida ++;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
