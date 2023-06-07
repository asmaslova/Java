import java.util.Random;

class AI {
    float [] k = new float[5];
    boolean shouldJump(float x, float y, float h, float w){
        return k[0]*x+k[1]*y+k[2]*h+k[3]*w+k[4]<0;
    }

    AI(float[]k){
        for(int i=0; i<5; i++) this.k[i] = k[i];
    }

    AI(AI parent, float delta){
        Random rng = new Random();
        for(int i=0; i<5; i++) k[i] = parent.k[i]-delta+rng.nextFloat(delta*2);
    }

    void output(){
        for(int i=0; i<5; i++){
            System.out.print(k[i]+"f, ");
            System.out.println();
        }
    }
}
