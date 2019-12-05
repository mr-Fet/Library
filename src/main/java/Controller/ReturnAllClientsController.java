package Controller;

import Model.Client;
import Services.Classes.ReturnAllClientsServiceIMPL;
import Services.ReturnAllClientsService;

import java.util.List;

public class ReturnAllClientsController {

   private ReturnAllClientsService returnAllClientsService = new ReturnAllClientsServiceIMPL();

    public List<Client> returnAllClients(){

        return returnAllClientsService.returnAllClients();

    }
}
