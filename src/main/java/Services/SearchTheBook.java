package Services;

import java.awt.print.Book;

public interface SearchTheBook {
    Book searchBookByTitle(String bookName);
    Book searchBookByAuthor(int bookAuthorId);
}
