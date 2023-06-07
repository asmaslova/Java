import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Numbers extends JComponent {
    int x,y,a=150,b=150;

    Numbers (JFrame frame, int score){
        Random rng = new Random();
        if(score==300){
            JLabel super_good = new JLabel("300");
            super_good.setBounds(x,y,a,b);
            super_good.add(frame);
        } else if(score==200){
            JLabel good = new JLabel("200");
            good.setBounds(x,y,a,b);
            good.add(frame);
        } else if(score==100){
            JLabel okay = new JLabel("100");
            okay.setBounds(x,y,a,b);
            okay.add(frame);
        } else if(score==(-100)){
            JLabel bad = new JLabel("-100");
            bad.setBounds(x,y,a,b);
            bad.add(frame);
        } else if(score==(-300)){
            JLabel super_bad = new JLabel("-300");
            super_bad.setBounds(x,y,a,b);
            super_bad.add(frame);
        }
    }

}