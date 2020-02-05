package com.Library.Services;

import com.Library.Model.Books;

import java.util.List;

public interface BooksService {
    void createBook(Books book);
    void deleteBook(Integer bookId);
    void modifyBook(Books book);
    List<Books> returnAllBooks();
    List<Books> searchBookById(Integer bookId);
    List<Books> searchBookByAuthor(String authorLastName);
    List<Books> searchBookByName(String bookName);
}
