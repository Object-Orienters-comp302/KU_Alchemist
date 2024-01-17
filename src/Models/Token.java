package Models;

import Utils.AssetLoader;
import Utils.CircularLinkedList;
import Utils.GUtil;
import Utils.KawaseBlur;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Token implements Serializable {
    public static ArrayList<Token>          tokenList         = new ArrayList<Token>();
    public static CircularLinkedList<Token> tokenCircularList = new CircularLinkedList<Token>();
    private String                name;
    private AssetLoader.AssetPath image;
    private AssetLoader.AssetPath background;
    
    public Token(String name, AssetLoader.AssetPath imgUrl, AssetLoader.AssetPath backgroundUrl) {
        this.name  = name;
        image      = imgUrl;
        background = backgroundUrl;
        tokenList.add(this);
        tokenCircularList.add(this);
    }
    public Token(String name, AssetLoader.AssetPath imgUrl) {
        this.name  = name;
        image      = imgUrl;
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
        return GUtil.fetchImage(AssetLoader.getAssetPath(image));
    }
    
    public void setImage(AssetLoader.AssetPath image) {
        this.image = image;
    }
    
    public BufferedImage getBackground() {
        return GUtil.fetchImage(AssetLoader.getAssetPath(background));
    }
    
    public BufferedImage getBluredBackground() {
        return KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(AssetLoader.getAssetPath(background))),
                                          3, 2);
    }
    
    public void setBackground(AssetLoader.AssetPath background) {
        this.background = background;
    }
    
}
