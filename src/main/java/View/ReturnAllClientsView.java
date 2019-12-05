package View;

import Controller.ReturnAllClientsController;
import Model.Client;

import java.util.List;

public class ReturnAllClientsView {

    ReturnAllClientsController returnAllClientsController = new ReturnAllClientsController();

    public void showMenu(){
        System.out.println("Все наши клиенты: ");
        System.out.println("\n");
    }

    public void returnAllClients(){
        List<Client> clientList = returnAllClientsController.returnAllClients();
        for(Client x : clientList){
            System.out.println(x + "\n");
        }
    }
}
