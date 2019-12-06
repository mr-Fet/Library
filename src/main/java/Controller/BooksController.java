package Controller;

import Model.Books;
import Services.BooksService;
import Services.Classes.BooksServiceImpl;
import View.BooksView;
import View.ClientView;

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
    public Books searchBook (Integer bookId){
        return booksService.searchBook(bookId);
    }
}
