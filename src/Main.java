import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    Main () {
        super("UWU");
        //Cursor cursor = getCursor();
        //setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setSize(1000,600);
        setDefaultCloseOperation(3);
        setLayout(null);
        Game game = new Game(this);
        Music music = new Music();
        Thread g = new Thread(game);
        g.start();
        System.out.println(game.a_score);
        music.playMusic();
        setVisible(true);

    }
    public static void main(String[] args) { Main main = new Main();
            //System.out.println(game.score);}
}}
