import java.util.Random;


class Field{
    int height;
    int width;
    int pos;
    char [][] cells;
    char [] cell = {'_', '*', '#', '$', ' '};
    public Field(int height, int width){
        this.height = height;
        this.width = width;
        cells = new char[height][width];
    }
    void fill_the_field(){
        Random rng = new Random();
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (i == 0 || j == 0 || i == height-1 || j == width-1) cells[i][j] = '#';
                else{
                int dice = rng.nextInt(100);
                if (dice < 50) cells[i][j] = '_';
                else if (dice < 75) cells[i][j] = '#';
                else if (dice < 90) cells[i][j] = '$';
                else cells[i][j] = '*';
            }}}
        if (width % 2 == 0){
            pos = (width - 2) / 2;
            cells[height - 1][pos] = ' '; 
            cells[height - 1][pos + 1] = ' ';
            cells[0][pos] = ' '; 
            cells[0][pos + 1] = ' ';
        }
        else {
            pos = (width - 2) / 2 + 1;
            cells[height - 1][pos] = ' ';
            cells[0][pos] = ' ';
        }
    }
    void show_the_field(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.print(cells[i][j] + "  ");}
            System.out.print("\n");
        }
    }
    void update_the_field(int nx, int ny, int x, int y){
        cells[ny][nx] = '&';
        cells[y][x] = '_';    
    }
    boolean can_move(int x_next, int y_next){
        if (cells[y_next][x_next] != '#') return true;
        else return false;
    }
    int how_many_dollars(){
        int dollars = 0;
        for (int i = 1; i < height-1; i++)
        for (int j = 1; j < width-1; j++)
        if (cells[i][j] == '$') dollars ++;
        return dollars;
    }
}
