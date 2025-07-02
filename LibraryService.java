import java.util.List;

public interface LibraryService {
    void addBook(Book book);
    void removeBook(String title);
    List<Book> listBooks();
}
