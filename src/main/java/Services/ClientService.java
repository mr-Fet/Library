package Services;

import Model.Client;
import com.sun.security.ntlm.NTLMException;

import java.util.List;

public interface ClientService {
    void createNewClient(Integer newId, String newFirstname, String newLastname) ;
    void deleteClient(Integer clientId);
    void modifyClient(Integer clientId, String updateFirstname, String updateLastname);
    List<Client> returnAllClients();
    Client searchClient(Integer clientId);
}
