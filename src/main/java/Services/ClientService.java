package Services;

import Model.Client;
import com.sun.security.ntlm.NTLMException;

public interface ClientService {
    void createNewClient(Integer newId, String newFirstname, String newLastname) ;
    void deleteClient(Integer clientId);
    void modifyClient();
}
