import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Choose the storage type
LibraryStorage storage = new FileLibraryStorage();

        // You can also use: LibraryStorage storage = new FileLibraryStorage();

        Logger logger = new ConsoleLogger();
        LibraryService library = new LibraryComponent(storage, logger);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Book Library ---");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Show All Books");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case "2":
                    System.out.print("Enter Title to Delete: ");
                    String delTitle = scanner.nextLine();
                    library.removeBook(delTitle);
                    break;
                case "3":
                    System.out.println("Books in Library:");
                    for (Book book : library.listBooks()) {
                        System.out.println(book.getDetails());
                    }
                    break;
                case "0":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
