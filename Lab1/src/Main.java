import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[]arcs) {
        Field field = new Field(10,10);
        field.fill();
        Unit unit = new Unit (field, 0, 0);
        field.output(unit);
        char key;
        Scanner reader = new Scanner(System.in);
        do {
            key = reader.next().charAt(0);
            unit.move(key);
            field.output(unit);
        }while(key!='e' && unit.hp > 0);

    }
}