package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import java.io.IOException;
import java.sql.*;

public class ClientRepositoryIMPL implements ClientRepository {

    private Statement stmt;
    private ResultSet rs;
    private Client selectClient;

    public void createClient(Integer newId, String newFirstname, String newLastname) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into clients (idClients, firstname, lastname)" + "VALUES (?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newId);
            preparedStmt.setString(2, newFirstname);
            preparedStmt.setString(3, newLastname);
            preparedStmt.execute();
        }
        catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Клиент с таким ID уже существует");
        }
        catch (SQLException | IOException e) {
            System.out.println(e);
        }

    }

    public void deleteClient(Integer clientId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = ("select * FROM clients where idClients = ?");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, clientId);
            rs = pst.executeQuery();
               if(rs.next()){
                   PreparedStatement pstmt = con.prepareStatement("DELETE FROM clients where idClients = ?");
                   pstmt.setInt(1, clientId);
                   pstmt.executeUpdate();
               }
               else{
                   System.out.println("Клиента с таким ID не существует");
               }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

   public void modifyClient(Integer clientId, String updateFirstname, String updateLastname) {

       try (Connection con = ConnectWithBD.getConnection()) {
           stmt = con.createStatement();
           String query1 = ("select * FROM clients where idClients = ?");
           PreparedStatement pst = con.prepareStatement(query1);
           pst.setInt(1, clientId);
           rs = pst.executeQuery();
           if(rs.next()) {
               String query = "update clients set firstname = ?, lastname = ? where idClients = ?";
               PreparedStatement preparedStmt = con.prepareStatement(query);
               preparedStmt.setString(1, updateFirstname);
               preparedStmt.setString(2, updateLastname);
               preparedStmt.setInt(3, clientId);
               preparedStmt.executeUpdate();
           }
           else{
                   System.out.println("Клиента с таким ID не существует");
               }

       } catch (Exception e) {
           System.out.println(e);
       }
    }
    @Override
    public Client searchTheClient(int clientId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "select * from clients where idClients = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, clientId);
            rs = preparedStmt.executeQuery();
            boolean z = rs.next();
               if(z){
                while (z) {
                    int id = rs.getInt(1);
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    selectClient = new Client.ClientBuilder(id).setFirstName(firstname).setLastName(lastname).build();
                    z = false;
                }
}
               else {
                   System.out.println("Клиента с таким ID не существует");
               }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return selectClient;
    }
}

