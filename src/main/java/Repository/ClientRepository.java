package Repository;

import Model.Client;

public interface ClientRepository {

    Client createClient(Integer newId, String newFirstname, String newLastname);
    void deleteClient(int clientId);
    void modifyClient(int clientId);
}
