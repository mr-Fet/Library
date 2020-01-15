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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ShowAllBooksServ")
public class ShowAllBooksServ extends HttpServlet {

    List<Books> bookList;
    private BooksService booksService = new BooksServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

                bookList = booksService.returnAllBooks();


                for (Books x : bookList) {
                    writer.println();
                        writer.println(x + "<br>");
                }
    }
}