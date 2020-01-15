package Servlets.BooksServ;

import Model.Books;
import Services.BooksService;
import Services.Classes.BooksServiceImpl;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteBookServ")
public class DeleteBookServ extends HttpServlet {

    Integer deleteBookId;
    private BooksService booksService = new BooksServiceImpl();
    private Books book;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("bookId");
        try {
            deleteBookId = Integer.parseInt(id);
            book = booksService.searchBookById(deleteBookId);
            if(book==null){
                writer.println("Книги с таким ID не существует");
            }
            else {
                booksService.deleteBook(deleteBookId);
                writer.println("Книга c id " + deleteBookId + " успешно удалена");
                book = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id книги");
        }
    }
}
