package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Client> localClientsMap = new HashMap<Integer, Client>();
    static SpisokOfEntity sp = new SpisokOfEntity();
    static SearchRepositoryIMPL searchTheObject = new SearchRepositoryIMPL();
    static Connection con;
    static Statement stmt;// = con.createStatement();
    static ResultSet rs;// = stmt.executeQuery("select * from clients");

    public static void main(String[] args) throws SQLException {
        //ClientView clientView = new ClientView();
        // clientView.showMenu();
        // clientView.addClient();
//        Client client = new Client(18,"qwerty","asd");
//        Client client1 = new Client(212,"Jack","Sparrow");
//        Client client2 = new Client( 32,"God","Of WAR");
////        sp.clientsMap.put(1,client);
//        sp.clientsMap.put(2,client1);
//        sp.clientsMap.put(3,client2);
//       // sp.setClientsMap(localClientsMap);
////        System.out.println(sp.clientsMap);
        //System.out.println(searchTheObject.searchTheClient(2,sp.clientsMap));
        ConnectWithBD connectWithBD = new ConnectWithBD();
//connectWithBD.connect();
 try {
     stmt = connectWithBD.getConnection().createStatement();
     ResultSet rs = stmt.executeQuery("select * from clients");
     while (rs.next())
         System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
     connectWithBD.closeConnect();
 }
 catch (Exception e) {
     System.out.println(e);
 }

    }
}
