package Controller;

import Services.Classes.ClientServiceImpl;
import Services.ClientService;
import View.ClientView;

public class ClientController {

    private ClientService service = new ClientServiceImpl();
    private ClientView view;

    public void registration(Integer newId, String newFirstname, String newLastname){
        //view.addClient();
        //view.refistration();sout
       // System.out.println("work");
        service.createNewClient(newId,newFirstname,newLastname);

    }
    public void deleteClient (Integer clientId){
        service.deleteClient(clientId);
    }

    public void updateClient(Integer clientId, String updateFirstname, String updateLastname){
        service.modifyClient(clientId, updateFirstname, updateLastname);
    }

}
