package View;

import Model.Books;
import Services.Classes.ReturnAllBooksServiceImpl;
import Services.ReturnAllBooksService;

import java.util.List;

public class ReturnAllBooksView {
    ReturnAllBooksService returnAllBooksService = new ReturnAllBooksServiceImpl();

    public void showMenu(){
        System.out.println("Все наши клиенты: ");
        System.out.println("\n");
    }

    public void returnAllBooks(){
        List<Books> clientList = returnAllBooksService.retornAllBooks();
        for(Books x : clientList){
            System.out.println(x + "\n");
        }
    }
}
