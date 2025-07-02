import java.util.List;

public class LibraryComponent implements LibraryService {
    private LibraryStorage storage;
    private Logger logger;

    public LibraryComponent(LibraryStorage storage, Logger logger) {
        this.storage = storage;
        this.logger = logger;
    }

    @Override
    public void addBook(Book book) {
        storage.save(book);
        logger.log("Added book: " + book.getDetails());
    }

    @Override
    public void removeBook(String title) {
        storage.delete(title);
        logger.log("Deleted book: " + title);
    }

    @Override
    public List<Book> listBooks() {
        return storage.getAll();
    }
}
