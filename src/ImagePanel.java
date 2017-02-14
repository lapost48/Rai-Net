import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Created by lapost48 on 2/13/2017.
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;
    private Card card;

    public ImagePanel(BufferedImage image, int index) {
        super();
        index = index % 16;
        this.image = image.getSubimage((index % 4) * 64, (index / 4) * 64, 64, 64);
        if(index < 4) {
            AffineTransform at = new AffineTransform();
            at.rotate(Math.PI, this.image.getWidth()/2, this.image.getHeight()/2);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            this.image = op.filter(this.image, null);
        }
    }

    public ImagePanel(BufferedImage image, int index, boolean rotate) {
        super();
        if(index < 4)
            rotate = true;
        index = index % 13;
        this.image = image.getSubimage((index % 4) * 64, (index / 4) * 64, 64, 64);
        if(rotate) {
            AffineTransform at = new AffineTransform();
            at.rotate(Math.PI, this.image.getWidth()/2, this.image.getHeight()/2);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            this.image = op.filter(this.image, null);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        if(card != null) {
            if (card instanceof OnlineCard) {
                g.drawImage(card.getImage(), 16, 0, null);
            } else {
                g.drawImage(card.getImage(), 0, 0, null);
            }
        }
    }

    public void placeCard(Card card) {
        this.card = card;
    }

}
