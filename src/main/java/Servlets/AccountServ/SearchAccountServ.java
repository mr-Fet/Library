package Servlets.AccountServ;

import Model.AcountingRecords;
import Services.AccountService;
import Services.AuthorService;
import Services.Classes.AccountServiceIMPL;
import Services.Classes.AuthorServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SearchAccountServ")
public class SearchAccountServ extends HttpServlet {

    Integer searchId;
    private AccountService accountService = new AccountServiceIMPL();
    private AcountingRecords acount;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("accountId");
        try {
            searchId = Integer.parseInt(id);
            acount = accountService.searchAccount(searchId);
            if (acount == null) {
                writer.println("Аккаунта с таким ID не существует");
            } else {
                writer.println(acount);
                acount = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id аакаунта");
        }
    }
}
