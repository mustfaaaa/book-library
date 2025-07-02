import java.util.List;

public interface LibraryStorage {
    void save(Book book);
    void delete(String title);
    List<Book> getAll();
}
