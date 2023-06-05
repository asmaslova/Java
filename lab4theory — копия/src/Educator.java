class Educator {

    public static void main(String []args){
        AI start = new AI(new float[]{0,0,0,0,0});
        AI best = start;
        int res = result(best);
        while(res<1000000){
            for(int i=0; i<100; i++){
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
            res += new Simulator().run(ai);
        }
        return res/5;
    }
}
