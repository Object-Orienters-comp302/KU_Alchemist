package Models;

import DataTypes.CircularLinkedList;
import Utils.GUtil;
import Utils.KawaseBlur;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Token {
    public static ArrayList<Token>                  tokenList        = new ArrayList<Token>();
    public static CircularLinkedList<BufferedImage> tokenImages      = new CircularLinkedList<BufferedImage>();
    public static CircularLinkedList<BufferedImage> tokenBackgrounds = new CircularLinkedList<BufferedImage>();
    private       String                            name;
    private       BufferedImage                     image;
    private       BufferedImage                     background;
    
    
    public Token (String name, String imgUrl, String backgroundUrl) {
        this.name  = name;
        image      = GUtil.fetchImage(imgUrl);
        background = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(backgroundUrl)), 3, 2);
        tokenList.add(this);
        tokenImages.add(image);
        tokenBackgrounds.add(background);
    }
    
    public Token (String name, BufferedImage img, BufferedImage back) {
        this.name  = name;
        image      = img;
        background = back;
        tokenList.add(this);
        tokenImages.add(image);
        tokenBackgrounds.add(background);
    }
    
}
