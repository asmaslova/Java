package Back.ML;

import Back.ML.AI;
import Back.ML.Simulator;

class Educator {

    public static void main(String []args){
        AI start = new AI(new float[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});

        int res = result(start);
        while(res<100000){
            AI best = start;
            for(int i=0; i<2000; i++){
                AI child = new AI(start, 1f);
                int child_res = result(child);
                if(res<child_res){
                    res=child_res;
                    best=child;
                }
            }
            start = best;
            start.output();
            System.out.println(res);
        }
    }

    static int result(AI ai){
        int res = 0;
        for (int i=0; i<5; i++){
            res += new Simulator(ai).run();
        }
        return res/5;
    }
}
