package Servlets.ClientServ;

import Model.Client;
import Services.AccountService;
import Services.BooksService;
import Services.Classes.AccountServiceIMPL;
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

@WebServlet(urlPatterns = "/SearchClientServ")
public class SearchClientServ extends HttpServlet {

    Integer searchId;
    private ClientService clientService = new ClientServiceImpl();
    private Client client;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("clientId");
        try {
            searchId = Integer.parseInt(id);
            client = clientService.searchClient(searchId);
            if(client==null){
                writer.println("Клиента с таким ID не существует");
            }
            else {
            writer.println(client);
            client=null;
        }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id клиента" );
        }
    }
}

