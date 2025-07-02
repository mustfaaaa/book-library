import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLibraryStorage implements LibraryStorage {
    private static final String FILE_PATH = "books.txt";

    @Override
    public void save(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(book.getTitle() + "|" + book.getDetails().split(" by ")[1]);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving book: " + e.getMessage());
        }
    }

    @Override
    public void delete(String title) {
        List<Book> books = getAll();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                if (!book.getTitle().equalsIgnoreCase(title)) {
                    writer.write(book.getTitle() + "|" + book.getDetails().split(" by ")[1]);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Book not found: " + title);
            }
        } catch (IOException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    books.add(new Book(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading books: " + e.getMessage());
        }

        return books;
    }
}
