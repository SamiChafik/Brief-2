
public class Main {
    static Library library = new Library();
    static Menu menu = new Menu();

    public static void main(String[] args) {
        boolean exit = true;
        while (exit) {

            menu.menu();

            switch(menu.choice()) {
                case 1 :
                    library.add();
                    break;
                case 2:
                    library.show();
                    break;
                case 3 :
                    library.find();
                    break;
                case 4 :
                    library.modify();
                    break;
                case 5 :
                    library.delete();
                    break;
                case 6 :
                    library.showAvailable();
                    break;
                case 0:
                    System.out.println("exiting program...");
                    exit = false;
                    break;
                default:
                    System.out.println("\nInvalid choice try again..");
            }
        }
    }
}
