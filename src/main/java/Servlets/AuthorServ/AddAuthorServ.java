package Servlets.AuthorServ;

import Model.Authors;
import Services.AuthorService;
import Services.Classes.AuthorServiceIMPL;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddAuthorServ")
public class AddAuthorServ extends HttpServlet {

    Integer authorId;
    String name;
    String lastName;
    private AuthorService authorService = new AuthorServiceIMPL();
    private Authors author;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("authorId");
        try {
            authorId = Integer.parseInt(id);
            name = req.getParameter("firstName");
            lastName = req.getParameter("lastName");
            author = authorService.searchAuthor(authorId);
            if(author!=null){
                writer.println("Автора с таким ID уже существует");
            }
            else {
                authorService.createNewAuthor(authorId,name,lastName);
                writer.println("Автор успешно создан" + "<br/>");
                writer.println(  authorId +  "<br/>");
                writer.println(  name +  "<br/>");
                writer.println( lastName +  "<br/>");
                author = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id автора");
        }
    }
}
