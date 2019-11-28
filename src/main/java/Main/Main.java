package Main;

import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Client> localClientsMap = new HashMap<Integer, Client>();
    static SpisokOfEntity sp = new SpisokOfEntity();
   static SearchRepositoryIMPL searchTheObject = new SearchRepositoryIMPL();
    public static void main(String[] args) {
        //ClientView clientView = new ClientView();
       // clientView.showMenu();
       // clientView.addClient();
//        Client client = new Client(18,"qwerty","asd");
//        Client client1 = new Client(212,"Jack","Sparrow");
//        Client client2 = new Client( 32,"God","Of WAR");
//
//        sp.clientsMap.put(1,client);
//        sp.clientsMap.put(2,client1);
//        sp.clientsMap.put(3,client2);
//       // sp.setClientsMap(localClientsMap);
//
//        System.out.println(sp.clientsMap);


        //System.out.println(searchTheObject.searchTheClient(2,sp.clientsMap));
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useUnicode=true&serverTimezone=UTC","root","fetOlegovich134911996");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from clients");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}

        System.out.println("Hello");
    }
}
