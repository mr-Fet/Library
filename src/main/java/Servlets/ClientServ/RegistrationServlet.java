package Servlets.ClientServ;

import Model.Client;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    Integer newId;
    String name;
    String lastName;
   private ClientService clientService = new ClientServiceImpl();
   private Client client;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        try {
            newId = Integer.parseInt(id);
            name = req.getParameter("firstName");
            lastName = req.getParameter("lastName");

            client = clientService.searchClient(newId);
            if(client!=null){
                writer.println("Клиент с таким Id уже существует");
            }
            else {
                clientService.createNewClient(newId,name,lastName);

                writer.println("Клиент успешно создан" + "<br/>");
                writer.println(  newId +  "<br/>");
                writer.println(  name +  "<br/>");
                writer.println( lastName +  "<br/>");
                client = null;
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id клиента ");
        }

    }
}

