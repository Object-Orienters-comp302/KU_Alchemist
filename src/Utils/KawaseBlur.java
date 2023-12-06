package Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.stream.IntStream;

public class KawaseBlur {
    
    public static BufferedImage applyKawaseBlur (BufferedImage image, int iterations, int blurSize) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        BufferedImage currentImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage blurredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2 = currentImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        
        for (int i = 0; i < iterations; i++) {
            int radius = blurSize * (i + 1);
            int[] sourcePixels = ((DataBufferInt) currentImage.getRaster()
                    .getDataBuffer()).getData();
            int[] destPixels = ((DataBufferInt) blurredImage.getRaster()
                    .getDataBuffer()).getData();
            
            IntStream range = width * height < 10000 ? IntStream.range(0, height) : IntStream.range(0, height)
                    .parallel();
            range.forEach(y -> {
                for (int x = 0; x < width; x++) {
                    int sumA = 0, sumR = 0, sumG = 0, sumB = 0, count = 0;
                    
                    for (int dy = -radius; dy <= radius; dy++) {
                        int ny = y + dy;
                        if (ny < 0 || ny >= height) { continue; }
                        
                        for (int dx = -radius; dx <= radius; dx++) {
                            int nx = x + dx;
                            if (nx < 0 || nx >= width) { continue; }
                            
                            int color = sourcePixels[ny * width + nx];
                            sumA += (color >> 24) & 0xff;
                            sumR += (color >> 16) & 0xff;
                            sumG += (color >> 8) & 0xff;
                            sumB += color & 0xff;
                            count++;
                        }
                    }
                    
                    int avgA = sumA / count;
                    int avgR = sumR / count;
                    int avgG = sumG / count;
                    int avgB = sumB / count;
                    destPixels[y * width + x] = (avgA << 24) | (avgR << 16) | (avgG << 8) | avgB;
                }
            });
            
            // Swap images
            BufferedImage temp = currentImage;
            currentImage = blurredImage;
            blurredImage = temp;
        }
        
        return currentImage;
    }
}