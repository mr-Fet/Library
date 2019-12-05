package Controller;

import Model.Books;
import Services.Classes.ReturnAllBooksServiceImpl;
import Services.ReturnAllBooksService;

import java.util.List;

public class ReturnAllBooksController {

    private ReturnAllBooksService returnAllBooksService = new ReturnAllBooksServiceImpl();

    public List<Books> returnAllClients(){

        return returnAllBooksService.retornAllBooks();

    }
}
