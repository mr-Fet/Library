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

@WebServlet(urlPatterns = "/UpdateAuthorServ")
public class UpdateAuthorServ extends HttpServlet {

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
            if(author==null){
                writer.println("Автора с таким ID не существует");
            }
            else {
                authorService.modifyAuthor(authorId,name,lastName);
                writer.println("Автор успешно обновлен" + "<br/>");
                writer.println(  authorId +  "<br/>");
                writer.println(  name +  "<br/>");
                writer.println( lastName +  "<br/>");
                author = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id автора" + e);
        }
    }
}
