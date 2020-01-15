package Controller;

import Model.Client;
import Services.Classes.ClientServiceImpl;
import Services.ClientService;

import java.util.List;

public class ClientController {

    private ClientService clientService = new ClientServiceImpl();

    public void registration(Integer newId, String newFirstname, String newLastname){
        clientService.createNewClient(newId,newFirstname,newLastname);
    }

    public void deleteClient (Integer clientId){
        clientService.deleteClient(clientId);
    }

    public void updateClient(Integer clientId, String updateFirstname, String updateLastname){
        clientService.modifyClient(clientId, updateFirstname, updateLastname);
    }

    public List<Client> returnAllClients(){

        return clientService.returnAllClients();

    }

    public Client searchClient(Integer clientId){return clientService.searchClient(clientId);    }
}
