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

@WebServlet(urlPatterns = "/DeleteAuthorServ")
public class DeleteAuthorServ extends HttpServlet {

    Integer deleteId;
    private AuthorService authorService = new AuthorServiceIMPL();
    private Authors author;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("authorId");
        try {
            deleteId = Integer.parseInt(id);
            author = authorService.searchAuthor(deleteId);

            if(author==null){
                writer.println("Автора с таким ID не существует");
                author = null;
            }
            else {
                authorService.deleteAuthor(deleteId);
                writer.println("Автор c id " + deleteId + " успешно удален");
                author = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id автора");
        }
    }
}
