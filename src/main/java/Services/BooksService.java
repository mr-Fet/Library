package Services;

public interface BooksService {
    void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory);
    void deleteBook(Integer bookId);
    void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory);
}
