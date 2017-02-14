import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Created by lapost48 on 2/13/2017.
 */
public class OnlineCard extends Card {

    public OnlineCard(BufferedImage image, int index) {
        super(image, index);
        if(index % 2 == 0) {
            AffineTransform at = new AffineTransform();
            at.rotate(Math.PI, this.image.getWidth()/2, this.image.getHeight()/2);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            this.image = op.filter(this.image, null);
        }
    }

}
