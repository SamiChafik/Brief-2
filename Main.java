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

    static void displayBook(Book book) {
        System.out.println("title : " + book.title);
        System.out.println("author : " + book.author);
        System.out.println("ISBN : " + book.ISBN);
    }

    static void show() {

        if (books.isEmpty()) {
            System.out.println("No books stored.");
            return;
        }

        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\n1 - show all books\n2 - show a specific book\n0 - Return\nenter your choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("\n=== list of books ===");
                    for (int i = 0; i < books.size(); i++) {

                        Book book = books.get(i);

                        System.out.println("\n== book " + (i + 1) + " ==");
                        displayBook(book);
                        if (book.available) {
                            System.out.println("this book is available.\n");
                        } else System.out.println("this book is not available.\n");
                    }
                    break;

                case 2:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("ISBN : ");
                    int scISBN = sc2.nextInt();
                    for (Book book : books) {
                        if (book.ISBN == scISBN) {
                            displayBook(book);
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

    static void find_modify() {
        int ch;
        boolean exit = true;
        while (exit) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Search by :\n1 - Title\n2 - Author\n3 - ISBN\n4 - Return\n=> ");
            ch = sc.nextInt();

            if (books.isEmpty()) {
                System.out.print("No books stored.\n");
                return;
            }
            Scanner sc2 = new Scanner(System.in);
            boolean found;

            switch (ch) {
                case 1:
                    System.out.print("Enter the book name : ");
                    String title = sc2.nextLine();
                    found = false;

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(title)) {
                            displayBook(book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("this book doesnt exist");
                    }
                    break;

                case 2:
                    System.out.print("Enter the book's Author : ");
                    String author = sc2.nextLine();
                    found = false;

                    for (Book book : books) {
                        if (book.author.equalsIgnoreCase(author)) {
                            displayBook(book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("this book doesnt exist");
                    }
                    break;

                case 3:
                    System.out.println("Entre the book ISBN : ");
                    int isbn = sc2.nextInt();
                    found = false;

                    for (Book book : books) {
                        if (book.ISBN == isbn) {
                            displayBook(book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("this book doesnt exist");
                    }
                    break;

                case 4:
                    exit = false;
                    break;

                default:
                    System.out.println("invalid choice try again !");
            }
        }
    }

    static void delete(){
        int ch;
        boolean exit = true;

        if (books.isEmpty()) {
            System.out.print("No books stored.\n");
            return;
        }

        while (exit){
            Scanner sc = new Scanner(System.in);
            System.out.print("\n1 - delete all books\n2 - delete a book by ISBN\n0 - Return\n=> ");
            ch = sc.nextInt();

            switch (ch){
                case 1 :
                    books.clear();
                    System.out.println("All books deleted successfully !");
                    exit = false;
                    break;

                case 2 :
                    System.out.print("Entre the ISBN of the book you want to delete : ");
                    int isbn = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).ISBN == isbn) {
                            books.remove(i);
                            found = true;
                            System.out.println("book deleted successfully !");
                        }
                    }

                    if (!found) {
                        System.out.println("No book found with this ISBN " + isbn + ".");
                    }
                    break;

                case 0 :
                    exit = false;
                        break;
                default:
                    System.out.println("invalid choice try again !");
            }
        }
    }

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
