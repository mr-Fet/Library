package Controller;

import Model.Books;
import Services.BooksService;
import Services.Classes.BooksServiceImpl;

import java.util.List;

public class BooksController {
    private BooksService booksService = new BooksServiceImpl();

    public void addBook(Integer newBookId, String newBookName, Integer newAuthorId, String newCategory){
              booksService.createBook(newBookId,newBookName,newAuthorId,newCategory);

    }
    public void deleteBook (Integer bookId){
        booksService.deleteBook(bookId);
    }

    public void updateBook(Integer bookId, String updateBookName, Integer updateAuthorId, String updateCategory){
        booksService.modifyBook(bookId,updateBookName,updateAuthorId,updateCategory);
    }

    public List<Books> returnAllBooks(){

        return booksService.returnAllBooks();
    }

    public Books searchBookById (Integer bookId){
        return booksService.searchBookById(bookId);
    }
    public Books searchBookByAuthor (String authorLastName){
        return booksService.searchBookByAuthor(authorLastName);
    }
    public Books searchBookByName (String bookName){
        return booksService.searchBookByName(bookName);
    }
}
