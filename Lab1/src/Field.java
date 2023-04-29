import java.util.Random;

public class Field {
    int w, h;
    char [][] matrix;
    Field(int w, int h){
        this.w = w;
        this.h = h;
        matrix = new char[w][h];

    }

    void fill(){
        Random rng = new Random();
        for(int i=0; i<w; i++)
            for(int j=0; j<h; j++) {
                int dice = rng.nextInt(100);
                if (dice<50) matrix[i][j] = '_';
                else if (dice<70) matrix[i][j] = '$';
                else if (dice<90) matrix[i][j] = '|';
                else matrix[i][j] = '*';
            }
        matrix[0][0] = '_';
    }

    void output(Unit unit){
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++) {
                if (unit.x==j && unit.y==i){
                    System.out.print("&  ");
                }
                else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("HP: "+unit.hp+"     Score: "+unit.score);
    }

    boolean canGo(int x, int y){
        if (x<0||x>=w||y<0||y>=h) {
            return false;
        }
        return matrix[x][y]!=0;
    }
}
