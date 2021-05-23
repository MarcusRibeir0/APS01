package control;

import model.Missao;
import view.Fase;
import view.TelaOpcoes;

public class Opcoes {
	private boolean tudo;

	private int velocidadeBaixa = 190;
	private int velocidadeNormal = 140;
	private int velocidadeRapida = 90;
	private int quantidadeDePerguntas = 100;

	private boolean veloBaixa;
	private boolean veloNorma;
	private boolean veloRapida;

	public Opcoes(){
		veloBaixa = false;
		veloNorma = true;
		veloRapida = false;
	}

	public void carregarConfiguracoes(Fase fase,Missao missao){
		if(veloBaixa){
			fase.setVELOCIDADE(velocidadeBaixa);
		}
		if(veloNorma){
			fase.setVELOCIDADE(velocidadeNormal);
		}
		if(veloRapida){
			fase.setVELOCIDADE(velocidadeRapida);
		}

		  //Carregar Operações 
		
		if(tudo){
		}
	}

	public void receberConfiguracoes(TelaOpcoes tela){

		if(tela.getVelocidadeBaixa().isSelected()){
			veloBaixa = true;
			veloNorma = false;
			veloRapida = false;
		}
		if(tela.getVelocidadeNormal().isSelected()){
			veloBaixa = false;
			veloNorma = true;
			veloRapida = false;
		}
		if(tela.getVelocidadeRapida().isSelected()){
			veloBaixa = false;
			veloNorma = false;
			veloRapida = true;
		}

		 //configurações de operações
		
		if(tela.getTudo().isSelected()){
			tudo = true;
		}
	}

	//Gets e sets dos booleans
	 
	public boolean isTudo() {
		return tudo;
	}

	public void setTudo(boolean tudo) {
		this.tudo = tudo;
	}

	 //get e sets dos inteiros

	public int getVelocidadeBaixa() {
		return velocidadeBaixa;
	}

	public void setVelocidadeBaixa(int velocidadeBaixa) {
		this.velocidadeBaixa = velocidadeBaixa;
	}

	public int getVelocidadeNormal() {
		return velocidadeNormal;
	}

	public void setVelocidadeNormal(int velocidadeNormal) {
		this.velocidadeNormal = velocidadeNormal;
	}

	public int getVelocidadeRapida() {
		return velocidadeRapida;
	}

	public void setVelocidadeRapida(int velocidadeRapida) {
		this.velocidadeRapida = velocidadeRapida;
	}

	public int getQuantidadeDePerguntas() {
		return quantidadeDePerguntas;
	}

	public void setQuantidadeDePerguntas(int quantidadeDePerguntas) {
		this.quantidadeDePerguntas = quantidadeDePerguntas;
	}

}
