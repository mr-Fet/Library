package com.Library.Services.Classes;

import com.Library.Model.Clients;
import com.Library.Repository.ClientRepository;
import com.Library.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public void createNewClient(Clients client) {

        clientRepository.save(client);
    }

    public void deleteClient(Integer client) {
        clientRepository.deleteById(client);
    }

    public void modifyClient(Clients client) {

        clientRepository.save(client);
        }

    @Override
    public List<Clients> returnAllClients() {
        return (List<Clients>) clientRepository.findAll();
        }

    @Override
    public List<Clients> searchClient(String lastName) {

        return clientRepository.findAllByLastName(lastName);
    }
}
