package com.Library.Services;

import com.Library.Model.Clients;


import java.util.List;

public interface ClientService {
    void createNewClient(Clients client) ;
    void deleteClient(Integer client);
    void modifyClient(Clients client);
    List<Clients> returnAllClients();
    List<Clients> searchClient(String lastName);
}
