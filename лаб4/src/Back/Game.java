package Back;

import Back.Circle;
import UI.Cursor;
import UI.Pic;

import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;


public class Game implements Runnable {
    protected static int score = 0;
    protected static int a_score = 600;
    JFrame help;
    ArrayList<Circle> cc = new ArrayList<Circle>(0);
    ArrayList<Circle> circles = new ArrayList<Circle>();
    Pic label = new Pic("pics/2.jpg");
    Pic score_bar_back = new Pic("pics/score_bar_back.png"); 
    Pic score_bar = new Pic("pics/score_bar.png");
    int time = 0;
    JLabel score_label;
    Random rng = new Random();
    UI.Cursor cursor;

    public Game(JFrame frame){
        cursor = new Cursor();
        frame.add(cursor.curs);
        help = frame;
	score_label = new JLabel("0");
	    
        label.setBounds(0, 0, 1000, 600);
        score_bar_back.setBounds(10,10,600, 50);
        score_bar.setBounds(33,10, a_score, 50);     
        score_label.setBounds(650,10,40,40);

        frame.add(score_label);
        frame.add(score_bar_back);
        frame.add(score_bar);

    }


    public void run(){

        circles.add(new Circle(help, score, a_score, cc, score_bar));

        while(true){
		if (a_score<=0) {
			System.exit(0);
		}

            score_bar.setBounds(10, 10, a_score, 50);
            score_bar.repaint();
            final boolean[] clickProcessed = {false};

            ArrayList<Circle> cc = new ArrayList<Circle>();//list for deleting
            if (time % 500 == 0) circles.add(new Circle(help, score, a_score, cc, score_bar));//adding circle every 0.5s
            //score_label.setText(""+score);

            cursor.move(circles.get(0).xs+50, circles.get(0).ys+50);//checking how cursor works
            
            for (Circle c : circles) {
		//auto deleting in case of inactivity
                if ((c.xs - c.xb < -15)) {
                    cc.add(c);
                    a_score -= 50;
                    score_bar.setBounds(10,10, a_score, 50);
                    score_bar.repaint();
                }
		//decreasing distance between big and small
                c.big_size -= 10;
                c.xb += 5;
                c.yb += 5;
                c.change();
                help.repaint();
            }
	    //deleting
            for (Circle c : cc) {
                c.hide(help);
                circles.remove(c);
            }
            try{
                time += 25;
                Thread.sleep(25);
            } catch(Exception e){
                return;
            };
        }
    }
    static void setScore(int value){
        score = value;
    }
    static void setA_score(int value){
        a_score = value;
    }
}

