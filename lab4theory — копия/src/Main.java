import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    Main () {
        super("UWU");
        Cursor cursor = getCursor();
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setSize(1000,600);
        setDefaultCloseOperation(3);
        setLayout(null);
        Game game = new Game(this);
        new Thread(game).start();
        //yourImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        game.circleSmall.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((game.xs-game.xb)>(game.xs-5) && (game.xs-game.xb)>(game.xs+5)){
                    game.ab=50; game.bb=50;
                    game.score+=300;
                    game.a_score+=30;
                    game.xs = game.rng.nextInt(500);
                    game.ys = game.rng.nextInt(500);
                    game.xbi = game.xb = game.xs-25;
                    game.ybi = game.yb = game.ys-25;
                } else if((game.xs-game.xb)<(game.xs-5) && (game.xs-game.xb)>game.xbi){
                    game.ab=50; game.bb=50;
                    game.score+=200;
                    game.a_score+=10;
                    game.xs = game.rng.nextInt(500);
                    game.ys = game.rng.nextInt(500);
                    game.xbi = game.xb = game.xs-25;
                    game.ybi = game.yb = game.ys-25;
                } else if((game.xs-game.xb)>(game.xs+5)){
                    game.ab=50; game.bb=50;
                    game.score-=100;
                    game.a_score-=20;
                    game.xs = game.rng.nextInt(500);
                    game.ys = game.rng.nextInt(500);
                    game.xbi = game.xb = game.xs-25;
                    game.ybi = game.yb = game.ys-25;
                } else if((game.xs-game.xb)<game.xbi){
                    game.ab=50; game.bb=50;
                    game.score-=100;
                    game.a_score-=20;
                    game.xs = game.rng.nextInt(500);
                    game.ys = game.rng.nextInt(500);
                    game.xbi = game.xs-25;
                    game.xb = game.xs-25;
                    game.ybi =  game.ys-25;
                    game.yb = game.ys-25;
                }
                game.score_bar.repaint();
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setVisible(true);
    }
    public static void main(String[] args) { new Main();}
}