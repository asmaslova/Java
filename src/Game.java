import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;


class Game implements Runnable {
    private Clip backgroundMusic;
    int xs,ys;
    int xb,yb;
    int score, a_score;
    int small_size = 100;
    int big_size = 300;
    int diff = 100;
    JFrame help;
    ArrayList<Circle> circles = new ArrayList<Circle>();
    Pic score_bar_back = new Pic("pics/score_bar_back.png"); //50x50
    Pic score_bar = new Pic("pics/score_bar.png"); //30x30
    int time = 0;
    JLabel score_label;
    Random rng = new Random();

    Game(JFrame frame){
        help = frame;

        //xs = 150 + rng.nextInt(350);
        //ys = 150 + rng.nextInt(350);
        score = 0; a_score = 150;

        //xb = xs - diff;
        //yb = ys - diff;

        score_bar_back.setBounds(10,10,600, 50);
        score_bar.setBounds(33,10, a_score, 50);
        score_label=new JLabel("0");
        score_label.setBounds(650,10,40,40);
        frame.add(score_label);

        //circleSmall.setBounds(xs,ys,small_size,small_size);
        //circleBig.setBounds(xb,yb,big_size,big_size);

        //frame.add(circleSmall);
        //frame.add(circleBig);
        frame.add(score_bar_back);
        frame.add(score_bar);


    }
    public void playMusic() {
        try {
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(AudioSystem.getAudioInputStream(new File("music/super_beat1.wav")));
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){

        circles.add(new Circle(help));

        while(true){


            ArrayList<Circle> cc = new ArrayList<Circle>();
            if (time % 500 == 0) circles.add(new Circle(help));
            Circle round = circles.get(circles.size() - 1);
            round.small_circle.addMouseListener(new MouseListener() {
                //class Listener implements MouseListener {
                @Override
                public void mouseClicked(MouseEvent e) {

                    boolean clickProcessed = false;
                    //c this;
                    //this.
                    if (!clickProcessed) {
                        clickProcessed = true;

                        System.out.println("uwu");
                        if ((round.xs - round.xb) < 15) {
                            score += 300;
                            a_score += 10;
                        /*Numbers wow = new Numbers(help,score);
                        wow.setBounds(round.xs,round.ys,100,20);
                        wow.add(help);
                        wow.setVisible(true);
                        try{
                            Thread.sleep(70);
                        } catch(Exception a){
                            return;
                        };
                        wow.setVisible(false);*/
                        } else if (round.xs - round.xb < 25) {
                            score += 200;
                            a_score += 5;
                        /*Numbers wow = new Numbers(help,score);
                        wow.setBounds(round.xs,round.ys,100,20);
                        wow.add(help);
                        wow.setVisible(true);
                        try{
                            Thread.sleep(70);
                        } catch(Exception a){
                            return;
                        };
                        wow.setVisible(false);*/
                        } else if (round.xs - round.xb < 40) {
                            score += 100;
                            a_score += 2;
                        /*Numbers wow = new Numbers(help,score);
                        wow.setBounds(round.xs,round.ys,100,20);
                        wow.add(help);
                        wow.setVisible(true);
                        try{
                            Thread.sleep(70);
                        } catch(Exception a){
                            return;
                        };
                        wow.setVisible(false);*/
                        } else if (round.xs - round.xb < 60) {
                            //score -= 100;
                            a_score -= 2;
                        /*Numbers wow = new Numbers(help,score);
                        wow.setBounds(round.xs,round.ys,100,20);
                        wow.add(help);
                        wow.setVisible(true);
                        try{
                            Thread.sleep(130);
                        } catch(Exception a){
                            return;
                        };
                        wow.setVisible(false);*/
                        } else {
                            //score -= 300;
                            a_score -= 50;
                        /*Numbers wow = new Numbers(help,score);
                        wow.setBounds(round.xs,round.ys,100,20);
                        wow.add(help);
                        wow.setVisible(true);
                        try{
                            Thread.sleep(130);
                        } catch(Exception a){
                            return;
                        };
                        wow.setVisible(false);*/

                        }

                        round.big_circle.setVisible(false);
                        round.small_circle.setVisible(false);

                        if (a_score > 600) a_score = 600;
                        score_bar.setBounds(10, 10, a_score, 50);
                        score_bar.repaint();
                        System.out.println(a_score);
                    }}


                    @Override
                    public void mousePressed (MouseEvent e){

                    }

                    @Override
                    public void mouseReleased (MouseEvent e){

                    }

                    @Override
                    public void mouseEntered (MouseEvent e){

                    }

                    @Override
                    public void mouseExited (MouseEvent e){

                    }

            });
            score_label.setText(""+score);

            //if (a_score<=0) break;


            //Listener l = new Listener();
            //c.small_circle.addMouseListener(l);
            for (Circle c : circles) {

                if ((c.xs - c.xb < -15)) {
                    cc.add(c);
                    a_score -= 50;
                    score_bar.setBounds(10,10, a_score, 50);
                    score_bar.repaint();
                }
                c.big_size -= 10;
                c.xb += 5;
                c.yb += 5;
                c.change();
                help.repaint();
            }
            for (Circle c : cc) {
                c.hide(help);
                circles.remove(c);

            }
            try{
                time += 25;
                Thread.sleep(30);
            } catch(Exception e){
                return;
            };
        }

    }
}
