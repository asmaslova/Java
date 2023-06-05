import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

class Game implements Runnable {
    int xs,ys,as=25,bs=25;
    int xb,yb,ab=50,bb=50, xbi, ybi;
    int score, a_score;
    Pic circleSmall = new Pic("pics/circle_small.png"); //24x24
    Pic circleBig = new Pic("pics/circle_big.png");//50x50
    Pic score_bar_back = new Pic("pics/score_bar_back.png"); //50x50
    Pic score_bar = new Pic("pics/score_back.png"); //30x30

    Random rng = new Random();

    /*void genBars(){
        Random rng = new Random();
        int h = 50 + rng.nextInt(100);
        //scoreBar.setBounds(200, 0, 50, 200-h);
    }*/

    Game(JFrame frame){
        xs=rng.nextInt(500);
        ys=rng.nextInt(500);
        xbi=xb=xs-25; ybi=yb=ys-25;
        score=0; a_score=10;

        score_bar_back.setBounds(10,10,600, 50);
        score_bar_back.setBounds(10,20,a_score, 50);
        score_bar_back.setSize(600,50);
        score_bar.setSize(a_score,30);


        circleSmall.setBounds(xs,ys,as,bs);
        circleBig.setBounds(xb,yb,ab,bb);

        frame.add(circleSmall);
        frame.add(circleBig);
        frame.add(score_bar_back);
        frame.add(score_bar);

        //scoreBar = new PIc(""); //раз в полсекунды появл., сеукнда на схождение
        //когда большой круг = маленький круг - 300
        //когда большой круг внутри маленького круга - -очки
        //когда большой круг-маленький круг=50 - 50
        //когда большой круг-маленький круг = 25 - 100

    }

    public void run(){
        while(true){

            for(int i=0;i<1000;i+=100){
                circleBig.setSize(ab-5,bb-5);
                circleBig.setLocation(xb-5,yb-5);
                circleBig.repaint();
                circleSmall.repaint();
                score_bar.repaint();

                try{
                    Thread.sleep(i);
                } catch(Exception e){
                    return;
                };
            }
        }
    }

}
