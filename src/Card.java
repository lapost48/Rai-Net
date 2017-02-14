import java.awt.image.BufferedImage;

/**
 * Created by lapost48 on 2/13/2017.
 */
public class Card {

    protected BufferedImage image;

    public Card(BufferedImage image, int index) {
        this.image = image.getSubimage(index * 32, 0, 32, 64);
    }

    public BufferedImage getImage() {
        return image;
    }

}
