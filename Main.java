import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Book> books = new ArrayList<>();

    static void add(){
        //Book obj = new Book();
        boolean available = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre a book name : ");
        String title = sc.nextLine();
        System.out.print("Entre a book author : ");
        String author = sc.nextLine();
        System.out.print("Entre a book's ISBN : ");
        int ISBN = sc.nextInt();

        books.add(new Book(title, author, ISBN, available));
        System.out.println("Book added successfully!\n");
    }

    static void show() {
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\n1 - show all books\n2 - show a specific book\n0 - Exit\nenter your choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    if (books.isEmpty()) {
                        System.out.println("No books stored.");
                        return;
                    }

                    for (int i = 0; i < books.size(); i++) {
                        System.out.println("\n=== list of books ===");
                        Book book = books.get(i);

                        System.out.println("book " + (i + 1) + " :");
                        System.out.println("title : " + book.title);
                        System.out.println("author : " + book.author);
                        System.out.println("ISBN : " + book.ISBN);
                        if (!book.available) {
                            System.out.println("this book is available.");
                        } else System.out.println("this book is not available");
                    }
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books stored.");
                        return;
                    }

                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("ISBN : ");
                    int scISBN = sc2.nextInt();
                    for (Book book : books) {
                        if (book.ISBN == scISBN) {
                            System.out.println("title : " + book.title);
                            System.out.println("author : " + book.author);
                            System.out.println("ISBN : " + book.ISBN);
                            if (book.available) {
                                System.out.println("this book is available.");
                            } else System.out.println("this book is not available");
                            System.out.println("\nwant to change availability ?\n1-yes\n2-no/exit");
                            ch = sc.nextInt();
                            if (ch == 1) {
                                book.available = !book.available; // Toggle availability
                                System.out.println("Book updated successfully!");
                            }
                            break;
                        }
                    }
                    break;

                case 0:
                    break;
                default:
                    System.out.println("invalid choice try again !\n");
            }
        }while (ch < 0 || ch > 2);
    }

    static void find_modify(){}
    static void delete(){}

    public static void main(String[] args) {
        int ch;
        do {
            Scanner ch1 = new Scanner(System.in);
            System.out.print("=== Menu ===\n1 - add a book\n2 - show all books\n3 - find/modify a book\n4 - delete a book\n0 - exit\n=> enter your choice : ");
            ch = ch1.nextInt();
            switch(ch) {
                case 1 :
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3 :
                    find_modify();
                    break;
                case 4 :
                    delete();
                case 0:
                    System.out.println("exiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice try again..");
            }
        } while (ch != 0);
    }
}
