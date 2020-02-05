package com.Library.Controller;

import com.Library.Model.Books;
import com.Library.Services.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Books")
@Controller
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;
    Books books;

    @RequestMapping(value = "/mainBooksMenu", method = RequestMethod.GET)
    public String mainClientMenu(Model model){
        List<Books> list = booksService.returnAllBooks();

        model.addAttribute("allBooks", list);
        model.addAttribute("newBook", new Books());
        model.addAttribute("deleteBook", new Books());

        return "book/mainBooksMenu";
    }

    @RequestMapping(value="/addBook", method=RequestMethod.POST)
    public ResponseEntity addBook(@ModelAttribute Books book){
              booksService.createBook(book);

              return ResponseEntity.ok("Книга: ID " + book.getBookId() + "\n"
                      + "bookName " + book.getBookName() + "\n"
                      + "authorId " + book.getAuthorId() + "\n"
                      + "category " + book.getCategory() + " успешно добавлена");
    }

    @GetMapping(value="/deleteBook/{bookId}")
    public ResponseEntity deleteBook (@PathVariable Integer bookId) {

        try {
                booksService.deleteBook(bookId);
        }
        catch (Exception e){
                return ResponseEntity.ok("Нельзя удалить книгу. Она связана с записью в таблице аккаунтов.");
        }
        return ResponseEntity.ok("Книга с ID " + bookId + "успешно удалена");
    }



    @GetMapping(value="/updateBook/{bookId}")
    public String updateBook1(@PathVariable Integer bookId, Model model){

        books = new Books();
        books.setBookId(bookId);
        model.addAttribute("updateBook", books);
        return "book/updateBook";
    }

    @RequestMapping(value="/updateBook2", method= RequestMethod.POST)
    public ResponseEntity updateBook2(@ModelAttribute Books book){
        books.setBookName(book.getBookName());
       books.setAuthorId(book.getAuthorId());
        books.setCategory(book.getCategory());
        booksService.modifyBook(books);
                return ResponseEntity.ok("Книга успешно обновлена. Новые данные: ID " + books.getBookId() + "\n"
                + "bookName " + books.getBookName() + "\n"
                + "authorId " + books.getAuthorId() + "\n"
                + "category " + books.getCategory());
    }


    @RequestMapping( value = "/searchBookById", method = RequestMethod.GET)
    public String searchBookById (@RequestParam(value = "bookId") Integer bookId, Model model){
        List<Books> searchList1 = booksService.searchBookById(bookId);
        model.addAttribute("searchBooks", searchList1);
        return "book/searchTheBook";
    }

    @RequestMapping(value = "/searchBookByName", method = RequestMethod.GET)
    public String searchBookByName (@RequestParam(value = "bookName") String bookName, Model model){
        List<Books> searchList2 = booksService.searchBookByName(bookName);
        model.addAttribute("searchBooks", searchList2);
        return "book/searchTheBook";
    }

    @RequestMapping(value = "/searchBookByAuthor", method = RequestMethod.GET)
    public String searchBookByAuthor  (@RequestParam(value = "authorLastName") String authorLastName, Model model){
        List<Books> searchList3 = booksService.searchBookByAuthor(authorLastName);
        model.addAttribute("searchBooks", searchList3);
       return "book/searchTheBook";
    }

    @GetMapping(value = "/returnAllBooks")
    public String returnAllBooks(Model model){
        List<Books> bookList = booksService.returnAllBooks();
        model.addAttribute("returnAllBooks", bookList);
        return "book/returnAllBooks";
    }
}
