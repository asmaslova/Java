import java.util.Scanner;

//////////////////////////MAIN//////////////////////////
public class Main
{
    public static void main(String[] args) {
        System.out.println("Welcome! You can move using keys listed below:\n" + "'W' for moving forward\n" + "'S' for moving back");
        System.out.println("'A' for moving left\n" + "'D' for moving right");
        System.out.println("Please, enter keys one per input. Enjoy the game!");
        Field field1 = new Field(11, 11);
        field1.fill_the_field();
        Unit Bob = new Goblin(field1.pos, field1.height - 1, field1);
        Unit Jon = new Elf(field1.pos, field1.height - 1, field1);
        field1.show_the_field();
        Bob.playable  = false;
        Jon.playable = true;

        //в общем, мем. проблема видимо именно в while, но я не знаю где. при нажатии Q он просто не возвращается обратно в начало while.
        while(!Bob.game_over && !Jon.game_over){
            while(Bob.playable && !Jon.playable) {
                System.out.println("Your character is Goblin");
                System.out.println("Your hp is: ");
                System.out.println(Bob.health);
                System.out.println("Your score is: ");
                System.out.println(Bob.score);
                System.out.println("Your mana is: ");
                System.out.println(Bob.mana);
                System.out.println("Press the key");
                Scanner key = new Scanner(System.in);
                Bob.move(key.nextLine());
                field1.show_the_field();
                Bob.is_game_over();
                break;
            }
            while(Jon.playable && !Bob.playable){
                System.out.println("Your character is Elf");
                System.out.println("Your hp is: ");
                System.out.println(Jon.health);
                System.out.println("Your score is: ");
                System.out.println(Jon.score);
                System.out.println("Your mana is: ");
                System.out.println(Jon.mana);
                System.out.println("Press the key");
                Scanner key = new Scanner(System.in);
                Jon.move(key.nextLine());
                field1.show_the_field();
                Jon.is_game_over();
                break;
            }


        }
    }
}
