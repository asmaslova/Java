import java.util.Random;

class Simulator{
    Pic topBar, botBar, bird;
    float by = 0;
    Simulator(){
        topBar = new Pic("images/bar.png");
        botBar = new Pic("images/bar.png");
        bird = new Pic("images/bird.png");
        bird.setBounds(80,150,20,20);
        genBars();

    }

    void genBars(){
        Random rng = new Random();
        int h = 50+rng.nextInt(100);
        topBar.setBounds(200,0,50,200-h);
        botBar.setBounds(200, 300-h,50,h);

    }

    public int run(AI ai){
        int delay = 30;
        int total_time = 0;
        while(total_time < 1000000){
            total_time+=delay;
            bird.setLocation(bird.getX(), (int)(bird.getY()+by*delay/1000));
            by+=3;
            topBar.setLocation(topBar.getX()-1, topBar.getY());
            botBar.setLocation(botBar.getX()-1, botBar.getY());
            if(bird.getBounds().intersects(topBar.getBounds()) || bird.getBounds().intersects(botBar.getBounds()) || bird.getY()<=0 || bird.getY()>=280){
                return delay;
            }
            if(topBar.getX()<-50){
                genBars();
            }
        }
        return total_time;
    }
}
