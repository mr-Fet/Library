package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;

public class ClientRepositoryIMPL implements ClientRepository {

    private Statement stmt;

    public void createClient(Integer newId, String newFirstname, String newLastname) {

        try (Connection con = ConnectWithBD.getConnection()) {
            stmt = con.createStatement();
            String query = "insert into clients (idClients, firstname, lastname)" + "VALUES (?,?,?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, newId);
            preparedStmt.setString(2, newFirstname);
            preparedStmt.setString(3, newLastname);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteClient(Integer clientId) {

        try (Connection con = ConnectWithBD.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM clients where idClients = ?");
            pstmt.setInt(1, clientId);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

   public void modifyClient(Integer clientId, String updateFirstname, String updateLastname) {

       try (Connection con = ConnectWithBD.getConnection()) {
           stmt = con.createStatement();
           String query = "update clients set firstname = ?, lastname = ? where idClients = ?";
           PreparedStatement preparedStmt = con.prepareStatement(query);
           preparedStmt.setString(1, updateFirstname);
           preparedStmt.setString(2, updateLastname);
           preparedStmt.setInt(3, clientId);
           preparedStmt.executeUpdate();
       } catch (Exception e) {
           System.out.println(e);
       }
    }
}

