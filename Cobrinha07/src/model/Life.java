package model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Life {
	BufferedImage spriteSheet = ImageIO.read(new File("src/res/life2.png"));   

	int largura = 30, tamanho = 28;
	int rows=1, columns=5;
	public int posX;

	public int posY;
	public BufferedImage[] sprites;
	public int aparencia=3;
	
	public Life( int posX, int posY) throws IOException {
		this.posX=posX;
		this.posY=posY;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * largura, j * tamanho, largura, tamanho);
			}
		}
		if(aparencia>=5){
			aparencia++;
		}
	}

}
