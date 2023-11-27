package gorkemsPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GUtil {

	public static BufferedImage fetchImage(String source) {
        try {
            // Load an image from a file
            return ImageIO.read(new File(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
