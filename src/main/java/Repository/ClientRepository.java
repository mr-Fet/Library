package Repository;

import Model.Client;

public interface ClientRepository {

    void createClient(Integer newId, String newFirstname, String newLastname);
    void deleteClient(Integer clientId);
    void modifyClient(Integer clientId, String updateFirstname, String updateLastname);
}
