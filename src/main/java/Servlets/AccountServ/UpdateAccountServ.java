package Servlets.AccountServ;

import Model.AcountingRecords;
import Services.AccountService;
import Services.Classes.AccountServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

@WebServlet(urlPatterns = "/UpdateAccountServ")
public class UpdateAccountServ extends HttpServlet {

    Integer accountId;
    Integer clientId;
    Integer bookId;
    java.sql.Date returnDate;
    String status;
    private AccountService accountService = new AccountServiceIMPL();
    private AcountingRecords account;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("accountId");
        String id2 = req.getParameter("clientId");
        String id3 = req.getParameter("bookId");
        String date = req.getParameter("date");
        try {
            accountId = Integer.parseInt(id);
            clientId = Integer.parseInt(id2);
            bookId = Integer.parseInt(id3);
            DateFormat dateFormat = new SimpleDateFormat( "yyyy.MM.dd" );
            Date myDate = dateFormat.parse(date);
            returnDate = new java.sql.Date(myDate.getTime());
            status = req.getParameter("status");

            Date dateGet = new Date();
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
            java.sql.Date sqlDate = new java.sql.Date(dateGet.getTime());

            account = accountService.searchAccount(accountId);

            if (account == null) {
                writer.println("Аккаунт с таким ID не существует");
            } else {
                accountService.modifyAccount(accountId,clientId,bookId,sqlDate,returnDate,status);

                writer.println("Аккаунт успешно обновлен " + "<br/>");
                writer.println(  accountId +  "<br/>");
                writer.println(  clientId +  "<br/>");
                writer.println(  bookId +  "<br/>");
                writer.println( sqlDate +  "<br/>");
                writer.println( date +  "<br/>");
                writer.println( status +  "<br/>");
                account=null;
            }
        }
        catch (NumberFormatException | InputMismatchException | ParseException e)
        {
            writer.println("Возможно вы ввели неккоректные данные");
        }
    }
}
