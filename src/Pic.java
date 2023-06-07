import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Pic extends JComponent {
    Image img;
    Pic(String path){
        img = new ImageIcon(path).getImage();
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img,0,0, getWidth(),getHeight(),null);
    }


}
