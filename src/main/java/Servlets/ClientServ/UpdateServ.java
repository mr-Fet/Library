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

@WebServlet(urlPatterns = "/UpdateServ")
public class UpdateServ extends HttpServlet {

    Integer updateId;
    String updateName;
    String updateLastName;
    private ClientService clientService = new ClientServiceImpl();
    private Client client;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        try {
            updateId = Integer.parseInt(id);
            updateName = req.getParameter("firstName");
            updateLastName = req.getParameter("lastName");

            client = clientService.searchClient(updateId);

            if(client==null){
                writer.println("Клиента с таким ID не существует");
            }
            else {
                clientService.modifyClient(updateId, updateName, updateLastName);
                writer.println("Клиент успешно обновлен" + "<br/>");
                writer.println(updateId + "<br/>");
                writer.println(updateName + "<br/>");
                writer.println(updateLastName + "<br/>");
                client = null;
            }
        } catch (NumberFormatException e) {
            writer.println("Перепроверьте id клиента" );
        }
    }
}
