package Repository;

import Model.Books;

public interface BooksRepository {
    void createBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory);
    void deleteBook(Integer bookId);
    void modifyBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory);
    Books searchTheBooks(int booksId);
}
