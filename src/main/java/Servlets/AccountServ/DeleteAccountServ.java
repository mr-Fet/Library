package Servlets.AccountServ;

import Model.AcountingRecords;
import Services.AccountService;
import Services.Classes.AccountServiceIMPL;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteAccountServ")
public class DeleteAccountServ extends HttpServlet {

    Integer deleteId;
    private AccountService accountService = new AccountServiceIMPL();
    private AcountingRecords acount;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("accountId");
        try {
            deleteId = Integer.parseInt(id);
            acount = accountService.searchAccount(deleteId);
            if(acount==null){
                writer.println("Аккаунта с таким ID не существует");
            }
            else {
                accountService.deleteAccount(deleteId);
                writer.println("Аккаунт c id " + deleteId + " успешно удален");
                acount = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id аккаунта" );
        }
    }
}
