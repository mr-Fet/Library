package Services;

import Model.Client;
import com.sun.security.ntlm.NTLMException;

public interface ClientService {
    Client createNewClient(Integer newId, String newFirstname, String newLastname) ;
    void deleteClient(int clientId);
    void modifyClient();
}
