import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class Simulator{
    int score, a_score;
    int small_size = 100;
    JFrame help;
    ArrayList<Circle> circles = new ArrayList<Circle>();
    int time = 0;
    Random rng = new Random();
    Cursor cursor = new Cursor();

    Simulator(){
        score = 0; a_score = 600;

    }
    boolean isCircle(int x, int y){
        for(Circle c: circles){
            if((x < c.xs + c.small_size) && (x > c.xs)){
                if((y < c.ys + c.small_size) && (y > c.ys)){
                     if (x*x + y*y <= (small_size/2)*(small_size/2)){
                         return true;
                     }
                }
            }
        }
        return false;
    }

    public int run(AI ai){

        circles.add(new Circle(help));
        int time_left=500;
        int total_time = 0;
        while(score<100000) {
            //every 25 ms: -20pixels
//time_left = c.xs - c.xb / 5 * 25
            if (a_score <= 0) {
                return total_time;
            }
            ArrayList<Circle> cc = new ArrayList<Circle>();
            Circle round = circles.get(0);
            if (time % 500 == 0) circles.add(new Circle(help));

            int[] tmp = ai.shouldClick(cursor.curs.getX(), cursor.curs.getY(), round.xs, round.ys, time_left);
            cursor.move(tmp[1],tmp[2]);
            if ((tmp[0] == 1) && (isCircle(cursor.curs.getX(),cursor.curs.getY()))){
                time += 2;
                if (((round.xs - round.xb) < 15)) {
                    score += 300 / 20;
                    a_score += 40 / 10;
                } else if (round.xs - round.xb < 25) {
                    score += 13;
                    a_score += 20 / 10;
                } else if (round.xs - round.xb < 40) {
                    score += 7;
                    a_score += 1;
                } else if (round.xs - round.xb < 60) {
                    a_score -= 2;
                } else {
                    a_score -= 50;
                }
                cc.add(round);
            }

            for (Circle c : circles) {

                if ((c.xs - c.xb < -15)) {
                    cc.add(c);
                    a_score -= 50;
                }
                c.big_size -= 10;
                c.xb += 5;
                c.yb += 5;
                c.change();

            }
            for (Circle c : cc) {
                //c.hide(help);
                circles.remove(c);

            }
            time += 25;
            total_time += 25;
        }
        return total_time;

    }
}
