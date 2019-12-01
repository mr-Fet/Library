package Repository;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;

public class ClientRepositoryIMPL implements ClientRepository {

    private ConnectWithBD connectWithBD = new ConnectWithBD();

    private Statement stmt;

    public void createClient(Integer newId, String newFirstname, String newLastname) {

        try {
            stmt = connectWithBD.getConnection().createStatement();
            String query = "insert into clients (idClients, firstname, lastname)" + "VALUES (?,?,?);";
            PreparedStatement preparedStmt = connectWithBD.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, newId);
            preparedStmt.setString(2, newFirstname);
            preparedStmt.setString(3, newLastname);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteClient(Integer clientId) {

        try {
            PreparedStatement pstmt = connectWithBD.getConnection().prepareStatement("DELETE FROM clients where idClients = ?");
            pstmt.setInt(1, clientId);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
//        SpisokOfEntity spisok = new SpisokOfEntity();
//        Map<Integer,Client> newMap = spisok.getClientsMap();
//        Iterator<Map.Entry<Integer,Client>> iterator = spisok.getClientsMap().entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, Client> entry = iterator.next();
//            if(entry.getKey().equals(clientId)){
//                newMap.remove(clientId);
//            }
//            spisok.setClientsMap(newMap);
//        }
//    }

//    public void modifyClient() {
//
//    }
    }

