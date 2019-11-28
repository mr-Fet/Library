package Services.Classes;

import Model.Client;
import Model.SpisokOfEntity;
import Repository.ClientRepository;
import Repository.ClientRepositoryIMPL;
import Services.ClientService;
import com.sun.security.ntlm.NTLMException;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository = new ClientRepositoryIMPL();

    public Client createNewClient(Integer newId, String newFirstname, String newLastname) {

        return clientRepository.createClient(newId,newFirstname,newLastname);
    }

    public void deleteClient(int clientId) {

        clientRepository.deleteClient(clientId);
    }

    public void modifyClient() {

    }
}
