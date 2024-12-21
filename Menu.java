import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    static Colors color = new Colors();

    public void menu() {

        System.out.println(color.yellow + "=== Menu ===");
        System.out.println(color.white + "1 - add a book\n2 - show all books\n3 - find a book\n4 - modify a book\n5 - delete a book");
        System.out.println(color.green + "0 - Exit");
        System.out.print(color.blue + "=> enter your choice : " + color.white);
    }

    public int choice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int ch = sc.nextInt();
                if (ch >= 0 && ch <= 5 ) {
                    return ch;
                }
                System.out.print(color.red + "Invalid choice. Please select a valid option (0-5) : " + color.white);
            } catch (Exception e) {
                System.out.print(color.red + "Invalid input. Please enter a choice : " + color.white);
                sc.next();
            }
        }
    }
}

