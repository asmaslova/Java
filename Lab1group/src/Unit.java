import java.util.Scanner;

//////////////////////////////UNIT////////////////////////
abstract class Unit{
    int health;
    int mana;
    int score;
    String name;
    int x;
    int y;
    Field floor;
    boolean game_over = false;
    boolean playable = false;
    ////////////////////////CONSTRUCTOR//////////////////////
    Unit(int x, int y, Field field){
        this.x = x;
        this.y = y;
        floor = field;
        floor.cells[y][x] = '&';
    }
////////////////////////////UPDATE//////////////////////////    

    /////////////////////////////MOVE/////////////////////////
    abstract void move(String key);
/////////////////////////////CAN/MOVE//////////////////////    

////////////////////////////////////////////////////////////

    /////////////////////////////GAME/OVER//////////////////////
    abstract void is_game_over();


}

class Elf extends Unit{
    Elf(int x, int y, Field cells){
        super(x, y, cells);
        this.health = 10;
        this.mana = 70;
        this.score = 0;
    }
    @Override
    void move(String key){
        int x_next = x;
        int y_next = y;

        switch (key){
            case "W": y_next = y_next-2; break;
            case "S": y_next = y_next+2; break;
            case "D": x_next = x_next+2; break;
            case "A": x_next = x_next-2; break;
            case "E":
                if (mana == 0) System.out.println("You have no mana for this action!");
                else destroy();
                break;
            case "Q":
                if(this.playable) {System.out.println("Character is switched."); this.playable = false;}
                else this.playable = true;
                break;
            default:
                System.out.println("Incorrect input! Try again!"); return;
        }

        if (!floor.can_move(x_next, y_next)) System.out.println("There is a wall!");
        else{

            if (floor.cells[y_next][x_next] == '*'){
                this.health -= 10;
            }
            else if (floor.cells[y_next][x_next] == '$'){
                this.score += 10;
            }
            if (x_next != x || y_next != y){
                floor.update_the_field(x_next, y_next, x, y);
                x = x_next;
                y = y_next;
            }
        }
    }

    void remove(int nx, int ny){

        if(nx < floor.width && ny < floor.height){
            if (floor.cells[ny][nx] == '*'){
                floor.cells[ny][nx] = '_';
                this.mana -= 5;
            }
            else{
                System.out.println("There is noN traps!");
            }
        }
        else{
            System.out.println("There is no traps!");
        }
    }
    void destroy(){
        System.out.println("Please enter the direction of action.");
        Scanner sc = new Scanner(System.in);
        String direction = sc.nextLine();
        switch (direction){
            case "W": remove(x, y - 2); break;
            case "S": remove(x, y + 2); break;
            case "D": remove(x + 2, y); break;
            case "A": remove(x - 2, y); break;
            default: System.out.println("Incorrect input! Try again!"); return;
        }
    }
    void is_game_over(){
        if (health <= 0){
            System.out.println("You're DEADGE. Your score is: " + Integer.toString(score));
            game_over = true;}
        else if (floor.how_many_dollars() == 0 || (x == floor.pos || x == floor.pos + 1) & y == 0 || score == 100){
            System.out.println("Congratulation! This floor is completed. Your score is: " + Integer.toString(score));
            game_over = true;
        }
    }
}


class Goblin extends Unit{
    Goblin(int x, int y, Field cells){
        super(x, y, cells);
        this.health = 40;
        this.mana = 20;
        this.score = 10;
    }
    @Override
    void move(String key){
        int x_next = x;
        int y_next = y;

        switch (key){
            case "W": y_next --; break;
            case "S": y_next ++; break;
            case "D": x_next ++; break;
            case "A": x_next --; break;
            case "E":
                if (mana == 0) System.out.println("You have no mana for this action!");
                else disassemble();
                break;
            case "Q":
                if(this.playable == true) {System.out.println("Character is switched.");  this.playable = false;}
                else this.playable = true;
                break;
            default:
                System.out.println("Incorrect input! Try again!"); return;
        }

        if (!floor.can_move(x_next, y_next)) System.out.println("There is a wall!");
        else{

            if (floor.cells[y_next][x_next] == '*'){
                this.health -= 10;
            }
            else if (floor.cells[y_next][x_next] == '$'){
                this.score += 10;
            }
            if (x_next != x || y_next != y){
                floor.update_the_field(x_next, y_next, x, y);
                x = x_next;
                y = y_next;
            }
        }
    }

    void sell_the_wall(int nx, int ny){

        if(nx < floor.width && ny < floor.height){
            if (floor.cells[ny][nx] == '#'){
                floor.cells[ny][nx] = '_';
                this.score += 10;
                this.mana -= 5;
            }
            else{
                System.out.println("There is no walls!");
            }
        }
        else{
            System.out.println("There is no walls!");
        }
    }
    void disassemble(){
        System.out.println("Please enter the direction of action.");
        Scanner sc = new Scanner(System.in);
        String direction = sc.nextLine();
        switch (direction){
            case "W": sell_the_wall(x, y - 1); break;
            case "S": sell_the_wall(x, y + 1); break;
            case "D": sell_the_wall(x + 1, y); break;
            case "A": sell_the_wall(x - 1, y); break;
            default: System.out.println("Incorrect input! Try again!"); return;
        }
    }
    void is_game_over(){
        if (health <= 0){
            System.out.println("You're DEADGE. Your score is: " + Integer.toString(score));
            game_over = true;}
        else if (floor.how_many_dollars() == 0 || (x == floor.pos || x == floor.pos + 1) & y == 0 || score == 100){
            System.out.println("Congratulation! This floor is completed. Your score is: " + Integer.toString(score));
            game_over = true;
        }
    }
}
  