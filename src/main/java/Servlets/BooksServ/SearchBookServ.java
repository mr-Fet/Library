package Servlets.BooksServ;

import Model.Books;
import Services.AuthorService;
import Services.BooksService;
import Services.Classes.AuthorServiceIMPL;
import Services.Classes.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SearchBookServ")
public class SearchBookServ extends HttpServlet {

    int intKey;
    private BooksService booksService = new BooksServiceImpl();
    private Books book;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String key = req.getParameter("key");

try {
    switch (req.getParameter("searchMethod")) {

        case ("byId"):
            try {
                intKey = Integer.parseInt(key);
            } catch (NumberFormatException e) {
                writer.println("Перепроверьте id автора " + e);
            }
            //writer.println(booksService.searchBookById(intKey));
            book = booksService.searchBookById(intKey);
            if(book==null){
                writer.println("Книги с таким ID не существует");
            }
            else{
                writer.println(book);
                book = null;
            }
            break;

        case ("byAuthor"):
             book = booksService.searchBookByAuthor(key);
             if(book==null){
                 writer.println("Книги с таким автором не существует");
             }
             else{
                 writer.println(book);
                 book = null;
             }
            break;

        case ("byName"):
            //writer.println(booksService.searchBookByName(key));
            book = booksService.searchBookByName(key);
            if(book==null){
                writer.println("Книги с таким названием не существует");
            }
            else{
                writer.println(book);
                book = null;
            }
            break;
    }
}
catch (NumberFormatException e){
    writer.println("Проверьте корректность вводимого значения");
}
    }
}
