package model;

import main.Main;

@SuppressWarnings("unused")

public class Player implements Comparable<Player>{

	private String nome;
	private int a;
	private int i=0;
	private int j=0;
	private int d=0;
	private int g=0;

	public Player(){

	}

	public Player(String nome){
		this.nome=nome;
	}

	public void carregarQuantidade(){
		a=Main.opcoes.getQuantidadeDePerguntas();}

	public void receberAcerto(Missao missao,int resultado ){
		d=missao.getA();
		g=missao.getB();
	}

	public void receberErro(Missao missao,int resultado ){
		d=missao.getA();
		g=missao.getB();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Player o) {
		return 0;
	}


}
