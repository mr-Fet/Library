package View;

import Model.Books;
import Services.Classes.ReturnAllBooksServiceImpl;
import Services.ReturnAllBooksService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.List;

public class ReturnAllBooksView {
  private ReturnAllBooksService returnAllBooksService = new ReturnAllBooksServiceImpl();

    public void showMenu(){
        System.out.println("Все наши клиенты: ");
        System.out.println("\n");
    }

    public void returnAllBooks(){
        List<Books> bookList = returnAllBooksService.retornAllBooks();
        bookList.stream().map((x)->x+"\n").forEach(System.out::println);
    }
}
