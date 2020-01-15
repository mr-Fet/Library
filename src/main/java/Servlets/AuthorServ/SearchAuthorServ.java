package Servlets.AuthorServ;

import Model.Authors;
import Services.AuthorService;
import Services.Classes.AuthorServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SearchAuthorServ")
public class SearchAuthorServ extends HttpServlet {

    Integer searchId;
    private AuthorService authorService = new AuthorServiceIMPL();
    private Authors author;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("authorId");
        try {
            searchId = Integer.parseInt(id);
            author = authorService.searchAuthor(searchId);
            if(author==null){
                writer.println("Автора с таким ID не существует");
            }
            else {
                writer.println(author);
                author=null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id автора");
        }
    }
}
