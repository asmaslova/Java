import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Circle extends JComponent {
    Pic small_circle = new Pic("pics/circle_small.png");
    Pic big_circle = new Pic("pics/circle_big.png");
    int xs, ys, xb, yb;
    int small_size = 100;
    int big_size = 300;

    Circle (JFrame frame){
        Random rng = new Random();
        xs = 150 + rng.nextInt(350);
        ys = 150 + rng.nextInt(350);
        xb = xs - 100;
        yb = ys - 100;
        small_circle.setBounds(xs,ys,small_size,small_size);
        big_circle.setBounds(xb,yb,big_size,big_size);
        if (frame != null){
        frame.add(small_circle);
        frame.add(big_circle);}
        //Circle c = new Circle(xs, ys, xb, yb, small_size, big_size);
    }
    /*void add(JFrame frame){
        frame.add(small_circle);
        frame.add(big_circle);
    }*/
    void hide(JFrame frame){
        frame.remove(small_circle);
        frame.remove(big_circle);
    }
    void change(){
        this.big_circle.setBounds(xb,yb,big_size,big_size);

    }

}