package main;

import control.Opcoes;
import model.Player;
import view.TelaDoMenu;

public class Main {
	public static Opcoes opcoes = new Opcoes();
	public static Player player = new Player();
	
	public static void main(String[] args) {
		new TelaDoMenu();
	}

}
