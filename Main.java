import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Book> books = new ArrayList<>();

    static void add(){
        //Book obj = new Book();
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre a book name : ");
        String title = sc.nextLine();
        System.out.print("Entre a book author : ");
        String author = sc.nextLine();
        System.out.print("Entre a book's ISBN : ");
        int ISBN = sc.nextInt();
        books.add(new Book(title, author, ISBN));
        System.out.println("Book added successfully!\n");
    }

    static void show() {
        if (books.isEmpty()){
            System.out.println("No books stored.");
        }
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println("\n=== list of books ===");
            System.out.println("book " + (i + 1) + " :");
            System.out.println("title : " + book.title);
            System.out.println("author : " + book.author);
            System.out.println("ISBN : " + book.ISBN);
        }
    }
    public static void main(String[] args) {
        int ch;
        do {

            Scanner ch1 = new Scanner(System.in);
            System.out.print("=== Menu ===\n1-add a book\n2-show a book\n0-exit\n=> enter your choice : ");
            ch = ch1.nextInt();
            switch(ch) {
                case 1 :
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 0:
                    System.out.println("exiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice try again..");
            }
        } while (ch != 0);
    }
}
