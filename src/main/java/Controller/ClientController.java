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
        System.out.println(service.createNewClient(newId,newFirstname,newLastname));

    }

}
