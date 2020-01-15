package Services.Classes;

import DataBase.ConnectWithDBLibrary;
import Model.Client;
import Repository.ClientRepository;
import Repository.ClientRepositoryIMPL;
import Services.ClientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ClientServiceImpl implements ClientService {

    private Statement stmt;
    private ResultSet rs;
    private List<Client> clientList;
    private ClientRepository clientRepository = new ClientRepositoryIMPL();

    public void createNewClient(Integer newId, String newFirstname, String newLastname) {clientRepository.createClient(newId,newFirstname,newLastname);}

    public void deleteClient(Integer clientId) {clientRepository.deleteClient(clientId);}

    public void modifyClient(Integer clientId, String updateFirstname, String updateLastname) {clientRepository.modifyClient(clientId, updateFirstname, updateLastname);}

    @Override
    public List<Client> returnAllClients() {
        try (Connection con = ConnectWithDBLibrary.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from clients";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            clientList = new ArrayList<>();
            while (rs.next()) {
                clientList.add(new Client.ClientBuilder(rs.getInt(1)).setFirstName(rs.getString(2)).setLastName(rs.getString(3)).build());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return clientList;
    }
    @Override
    public Client searchClient(Integer clientId) {

        return clientRepository.searchTheClient(clientId);
    }
}
