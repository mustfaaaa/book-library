import java.util.ArrayList;
import java.util.List;

public class InMemoryLibraryStorage implements LibraryStorage {
    private List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void delete(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public List<Book> getAll() {
        return books;
    }
}
