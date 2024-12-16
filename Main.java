import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book obj = new Book();
        Scanner sc = new Scanner(System.in);
        //Scanner sc2 = new Scanner(System.in);
        System.out.print("Entre a book name : ");
        obj.title = sc.nextLine();
        System.out.print("Entre a book author : ");
        obj.author = sc.nextLine();
        System.out.print("Entre a book's ISBN : ");
        obj.ISBN = sc.nextInt();

        System.out.println(obj.title);
        System.out.println(obj.author);
        System.out.println(obj.ISBN);
    }
}
