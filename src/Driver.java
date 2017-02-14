import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by lapost48 on 2/13/2017.
 */
public class Driver {

    public static void main(String[] args) {

        BufferedImage boardImage = null;
        try {
            boardImage = ImageIO.read(new File("resources/Rai-Net.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        BufferedImage cardImage = null;
        try {
            cardImage = ImageIO.read(new File("resources/Rai-Net_Cards.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        JFrame f = new JFrame("Rai-Net Access Battlers");
        f.setLayout(new GridLayout(10, 8));
        f.setSize(512, 660);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel[][] panelMatrix = new ImagePanel[10][8];

        panelMatrix[0][0] = new ImagePanel(boardImage, 12, true);
        panelMatrix[0][1] = new ImagePanel(boardImage, 12, true);
        panelMatrix[0][2] = new ImagePanel(boardImage, 3);
        panelMatrix[0][3] = new ImagePanel(boardImage, 2);
        panelMatrix[0][4] = new ImagePanel(boardImage, 1);
        panelMatrix[0][5] = new ImagePanel(boardImage, 0);
        panelMatrix[0][6] = new ImagePanel(boardImage, 13);
        panelMatrix[0][7] = new ImagePanel(boardImage, 13);

        panelMatrix[1][3] = new ImagePanel(boardImage, 7);
        panelMatrix[1][4] = new ImagePanel(boardImage, 7);
        panelMatrix[1][0] = new ImagePanel(boardImage, 5);
        panelMatrix[1][1] = new ImagePanel(boardImage, 5);
        panelMatrix[1][2] = new ImagePanel(boardImage, 5);
        panelMatrix[1][5] = new ImagePanel(boardImage, 5);
        panelMatrix[1][6] = new ImagePanel(boardImage, 5);
        panelMatrix[1][7] = new ImagePanel(boardImage, 5);
        panelMatrix[2][3] = new ImagePanel(boardImage, 5);
        panelMatrix[2][4] = new ImagePanel(boardImage, 5);

        panelMatrix[8][3] = new ImagePanel(boardImage, 7, true);
        panelMatrix[8][4] = new ImagePanel(boardImage, 7, true);
        panelMatrix[8][0] = new ImagePanel(boardImage, 6);
        panelMatrix[8][1] = new ImagePanel(boardImage, 6);
        panelMatrix[8][2] = new ImagePanel(boardImage, 6);
        panelMatrix[8][5] = new ImagePanel(boardImage, 6);
        panelMatrix[8][6] = new ImagePanel(boardImage, 6);
        panelMatrix[8][7] = new ImagePanel(boardImage, 6);
        panelMatrix[7][3] = new ImagePanel(boardImage, 6);
        panelMatrix[7][4] = new ImagePanel(boardImage, 6);

        panelMatrix[9][0] = new ImagePanel(boardImage, 13);
        panelMatrix[9][1] = new ImagePanel(boardImage, 13);
        panelMatrix[9][2] = new ImagePanel(boardImage, 8);
        panelMatrix[9][3] = new ImagePanel(boardImage, 9);
        panelMatrix[9][4] = new ImagePanel(boardImage, 10);
        panelMatrix[9][5] = new ImagePanel(boardImage, 11);
        panelMatrix[9][6] = new ImagePanel(boardImage, 12);
        panelMatrix[9][7] = new ImagePanel(boardImage, 12);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 8; j++) {
                if(panelMatrix[i][j] == null)
                    panelMatrix[i][j] = new ImagePanel(boardImage, 4);
                f.add(panelMatrix[i][j]);
            }
        }
        panelMatrix[1][0].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[1][1].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[1][2].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[1][5].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[1][6].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[1][7].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[2][3].placeCard(new OnlineCard(cardImage, 2));
        panelMatrix[2][4].placeCard(new OnlineCard(cardImage, 2));

        panelMatrix[8][0].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[8][1].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[8][2].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[8][5].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[8][6].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[8][7].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[7][3].placeCard(new OnlineCard(cardImage, 3));
        panelMatrix[7][4].placeCard(new OnlineCard(cardImage, 3));
        f.setVisible(true);
    }

}
