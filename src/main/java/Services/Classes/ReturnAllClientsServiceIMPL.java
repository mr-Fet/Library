package Services.Classes;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Services.ReturnAllClientsService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReturnAllClientsServiceIMPL implements ReturnAllClientsService {

    private Statement stmt;
    private ResultSet rs;
    private List<Client> clientList = new ArrayList<>();

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
}
