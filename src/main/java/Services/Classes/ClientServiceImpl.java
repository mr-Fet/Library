package Services.Classes;

import ConnectWithBD.ConnectWithBD;
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
    private List<Client> clientList = new ArrayList<>();
    private ClientRepository clientRepository = new ClientRepositoryIMPL();

    public void createNewClient(Integer newId, String newFirstname, String newLastname) {clientRepository.createClient(newId,newFirstname,newLastname);}

    public void deleteClient(Integer clientId) {clientRepository.deleteClient(clientId);}

    public void modifyClient(Integer clientId, String updateFirstname, String updateLastname) {clientRepository.modifyClient(clientId, updateFirstname, updateLastname);}

    @Override
    public List<Client> returnAllClients() {
        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from clients";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                clientList.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3)));
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
