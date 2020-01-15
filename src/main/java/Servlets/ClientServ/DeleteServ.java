package Servlets.ClientServ;

import Model.Client;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteServ")
public class DeleteServ extends HttpServlet {

    Integer deleteId;
    private ClientService clientService = new ClientServiceImpl();
    private Client client;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        try {
            deleteId = Integer.parseInt(id);
            client = clientService.searchClient(deleteId);

            if(client==null){
                writer.println("Клиента с таким ID не существует");
                client = null;
            }
            else {
                clientService.deleteClient(deleteId);
                writer.println("Клиент c id " + deleteId + " успешно удален");
                client = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id клиента " + e);
        }



    }
}
