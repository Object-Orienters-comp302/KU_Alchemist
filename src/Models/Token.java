package Models;

import Utils.CircularLinkedList;
import Utils.GUtil;
import Utils.KawaseBlur;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Token {
    public static ArrayList<Token>          tokenList         = new ArrayList<Token>();
    public static CircularLinkedList<Token> tokenCircularList = new CircularLinkedList<Token>();
    private       String                    name;
    private       BufferedImage             image;
    private       BufferedImage             background;
    
    
    public Token(String name, String imgUrl, String backgroundUrl) {
        this.name  = name;
        image      = GUtil.fetchImage(imgUrl);
        background = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(backgroundUrl)), 3, 2);
        tokenList.add(this);
        tokenCircularList.add(this);
    }
    public Token(String name, String imgUrl) {
        this.name  = name;
        image      = GUtil.fetchImage(imgUrl);
        tokenList.add(this);
        tokenCircularList.add(this);
    }
    
    public Token(String name, BufferedImage img, BufferedImage back) {
        this.name  = name;
        image      = img;
        background = back;
        tokenList.add(this);
        tokenCircularList.add(this);
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage getBackground() {
        return background;
    }
    
    public void setBackground(BufferedImage background) {
        this.background = background;
    }
    
}
