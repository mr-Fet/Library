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

@WebServlet(urlPatterns = "/UpdateBookServ")
public class UpdateBookServ extends HttpServlet {

    Integer bookId;
    String bookName;
    Integer authorId;
    String category;
    private BooksService booksService = new BooksServiceImpl();
    private Books book;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("bookId");
        String id2 = req.getParameter("authorId");
        try {
            bookId = Integer.parseInt(id);
            authorId = Integer.parseInt(id2);
            bookName = req.getParameter("bookName");
            category = req.getParameter("category");

            book = booksService.searchBookById(bookId);
            if (book==null) {
                writer.println("Книги с таким ID не существует");
            }
            else {

                booksService.modifyBook(bookId, bookName, authorId, category);

                writer.println("Книга успешно обновлена" + "<br/>");
                writer.println(bookId + "<br/>");
                writer.println(bookName + "<br/>");
                writer.println(authorId + "<br/>");
                writer.println(category + "<br/>");
                book = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id книги/автора");
        }
    }
}
