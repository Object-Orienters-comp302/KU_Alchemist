package Models;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import DataTypes.CircularLinkedList;
import Utils.GUtil;

public class Token {
	private String name;
	private BufferedImage image;
	private BufferedImage background;
	
	public static ArrayList<Token> tokenList = new ArrayList<Token>();
	public static CircularLinkedList<BufferedImage> tokenImages = new CircularLinkedList<BufferedImage>();
	public static CircularLinkedList<BufferedImage> tokenBackgrounds = new CircularLinkedList<BufferedImage>();
	
	
	public Token(String name,String imgUrl,String backgroundUrl) {
		this.name=name;
		image=GUtil.fetchImage(imgUrl);
		background=GUtil.fetchImage(backgroundUrl);
		tokenList.add(this);
		tokenImages.add(image);
		tokenBackgrounds.add(background);
	}
	
	public Token(String name,BufferedImage img,BufferedImage back) {
		this.name=name;
		image=img;
		background=back;
		tokenList.add(this);
		tokenImages.add(image);
		tokenBackgrounds.add(background);
	}

}