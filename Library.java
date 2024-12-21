import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    static Colors color = new Colors();

     public void add() {

         boolean available = true;
         Scanner sc = new Scanner(System.in);
         System.out.print("Entre a book name : ");
         String title = sc.nextLine();
         System.out.print("Entre a book author : ");
         String author = sc.nextLine();
         System.out.print("Entre a book's ISBN : ");
         String ISBN = sc.nextLine();

         books.add(new Book(title, author, ISBN, available));
         System.out.println(color.green + "Book added successfully!\n" + color.white);
     }

//    static void displayBook(Book book) {
//        System.out.println("title : " + book.getTitle());
//        System.out.println("author : " + book.author);
//        System.out.println("ISBN : " + book.ISBN);
//    }

//    static void add(){
//        //Book obj = new Book();
//        boolean available = true;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Entre a book name : ");
//        String title = sc.nextLine();
//        System.out.print("Entre a book author : ");
//        String author = sc.nextLine();
//        System.out.print("Entre a book's ISBN : ");
//        int ISBN = sc.nextInt();
//
//        books.add(new Book(title, author, ISBN, available));
//        System.out.println("Book added successfully!\n");
//    }

//    static void displayBook(Book book) {
//        System.out.println("title : " + book.getTitle());
//        System.out.println("author : " + book.author);
//        System.out.println("ISBN : " + book.ISBN);
//    }

     public void show() {

         if (books.isEmpty()) {
             System.out.println(color.magenta + "No books stored." + color.white);
             return;
         }

         System.out.println(color.yellow + "\n=== list of books ===" + color.white);
         for (Book book : books) {
             System.out.println(book);
             if (book.available) {
                 System.out.println(color.green + "this book is available\n" + color.white);
             } else System.out.println(color.red + "this book is not available\n" + color.white);
         }
//         for (int i = 0; i < books.size(); i++) {
//
//             Book book = books.get(i);
//
//             System.out.println("\n== book " + (i + 1) + " ==");
//             displayBook(book);
//             if (book.available) {
//                 System.out.println("this book is available.\n");
//             } else System.out.println("this book is not available.\n");
//         }
     }

     public void find() {

         if (books.isEmpty()) {
             System.out.println(color.magenta + "No books stored." + color.white);
             return;
         }

         ArrayList<Book> temp = new ArrayList<>();
         System.out.print(color.cyan + "search for a book (title or author or ISBN) : " + color.white);
         String isbn = sc.nextLine();

         for (Book book : books) {
             if (isbn.equals(book.getISBN()) || isbn.equalsIgnoreCase(book.getTitle()) || isbn.equalsIgnoreCase(book.getAuthor())) {
                 temp.add(book);
             }
         }

         if (temp.isEmpty()) {
             System.out.print(color.red + "No books found.\n" + color.red);
         }else {
             for (Book book : temp) {
                 System.out.println(book);
             }
         }
//         int ch;
//         boolean exit = true;
//         while (exit) {
//             Scanner sc = new Scanner(System.in);
//             System.out.print("Search by :\n1 - Title\n2 - Author\n3 - ISBN\n4 - Return\n=> ");
//             ch = sc.nextInt();
//
//             if (books.isEmpty()) {
//                 System.out.print("No books stored.\n");
//                 return;
//             }
//             Scanner sc2 = new Scanner(System.in);
//             boolean found;
//
//             switch (ch) {
//                 case 1:
//                     System.out.print("Enter the book name : ");
//                     String title = sc2.nextLine();
//                     found = false;
//
//                     for (Book book : books) {
//                         if (book.getTitle().equalsIgnoreCase(title)) {
//                             displayBook(book);
//                             found = true;
//                         }
//                     }
//                     break;
//
//                 case 2:
//                     System.out.print("Enter the book's Author : ");
//                     String author = sc2.nextLine();
//                     found = false;
//
//                     for (Book book : books) {
//                         if (book.author.equalsIgnoreCase(author)) {
//                             displayBook(book);
//                             found = true;
//                         }
//                     }
//                     break;
//
//                 case 3:
//                     System.out.print("Entre the book ISBN : ");
//                     int isbn = sc2.nextInt();
//                     found = false;
//
//                     for (Book book : books) {
//                         if (book.ISBN == isbn) {
//                             displayBook(book);
//                             found = true;
//                         }
//                     }
//                     break;
//
//                 case 4:
//                     exit = false;
//                     break;
//
//                 default:
//                     System.out.println("invalid choice try again !");
//             }
//             if (!found) {
//                 System.out.println("this book doesnt exist");
//             }
//         }
     }

     public void modify() {

         if (books.isEmpty()) {
             System.out.println(color.magenta + "No books stored." + color.white);
             return;
         }

         boolean found = false;
         Scanner sc = new Scanner(System.in);
         System.out.print(color.cyan + "Enter ISBN of the book you want to modify : " + color.white);
         String isbn = sc.nextLine();

         for (Book book : books) {
             if(book.getISBN().equalsIgnoreCase(isbn)) {
                 found = true;
                 System.out.println(color.green + "== book found ! ==" + color.white);
                 System.out.println(book);
                 System.out.println(color.cyan + "Modify :" + color.white);
                 System.out.println("1 - Title\n2 - Author\n3 - availability");
                 System.out.println(color.green + "0 - Return");
                 System.out.print(color.blue + "=> " + color.white);
                 int ch = sc.nextInt();

                 switch(ch){
                     case 1 :
                         System.out.print("Enter the new title : ");
                         book.setTitle(sc.nextLine());
                         break;

                     case 2 :
                         System.out.print("Enter the new author : ");
                         book.setAuthor(sc.nextLine());
                         break;

                     case 3 :
                         System.out.println("1 - mark as available\n2 - mark as unavailable");
                         System.out.print(color.blue + "=> " + color.white);
                         int ch2 = sc.nextInt();
                         book.setAvailable(ch2 == 1);
                         break;

                     case 0 :
                         break;

                     default:
                         System.out.println(color.red + "Invalid choice try again !" + color.white);
                 }
             }
         }

         if (!found) {
             System.out.println(color.magenta + "No book found" + color.white);
         }
     }

     public void delete() {
        int ch;
        boolean exit = true;

        if (books.isEmpty()) {
            System.out.print(color.magenta + "No books stored. \n" + color.white);
            return;
        }

        while (exit){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1 - delete all books\n2 - delete a book by ISBN");
            System.out.println(color.green + "0 - Return");
            System.out.print(color.blue + "=> " + color.white);
            ch = sc.nextInt();

            switch (ch){
                case 1 :
                    books.clear();
                    System.out.println(color.green + "All books deleted successfully !" + color.white);
                    exit = false;
                    break;

                case 2 :
                    System.out.print("Entre the ISBN of the book you want to delete : ");
                    String isbn = sc.next();
                    sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).ISBN.equals(isbn)) {
                            books.remove(i);
                            found = true;
                            System.out.println(color.green + "book deleted successfully !" + color.white);
                        }
                    }

                    if (!found) {
                        System.out.println(color.magenta + "No book found with this ISBN " + color.cyan + isbn + color.magenta + "." + color.white);
                    }
                    break;

                case 0 :
                    exit = false;
                    break;
                default:
                    System.out.println(color.red + "invalid choice try again !" + color.red);
            }
        }
    }

    public void showAvailable() {

        if (books.isEmpty()) {
            System.out.println(color.magenta + "No books stored." + color.white);
            return;
        }

         ArrayList<Book> available = new ArrayList<>();
         ArrayList<Book> unavailable = new ArrayList<>();
         boolean exit = true;

         while (exit){
             System.out.println("1 - Show available books");
             System.out.println("2 - show unavailable books");
             System.out.println(color.green + "0 - Return");
             System.out.print(color.blue + "=> " + color.white);
             Scanner sc = new Scanner(System.in);
             int ch = sc.nextInt();

             for (Book book : books) {
                 if (book.available) {
                     available.add(book);
                 }else unavailable.add(book);
             }

             if (ch == 1) {
                 if (!available.isEmpty()) {
                     for (Book book : available) {
                         System.out.println(color.yellow + "\n=== list of available books ===" + color.white);
                         System.out.println(book);
                         System.out.println("\n");
                     }
                     available.clear();
                 }else System.out.println(color.magenta + "no available books." + color.white);
             }

             if (ch == 2) {
                 if (!unavailable.isEmpty()) {
                     for (Book book : unavailable) {
                         System.out.println(color.yellow + "\n=== list of unavailable books ===" + color.white);
                         System.out.println(book);
                         System.out.println("\n");
                     }
                     unavailable.clear();
                 } else System.out.println(color.magenta + "This list is empty." + color.white);
             }
             if (ch == 0){
                 exit = false;
             }
         }
    }


}
