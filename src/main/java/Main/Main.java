package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;
import View.ClientView;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static SearchRepositoryIMPL searchTheObject = new SearchRepositoryIMPL();
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        // clientView.showMenu();
         //clientView.addClient();
        clientView.deleteClient();
       ConnectWithBD connectWithBD = new ConnectWithBD();

 try {
     stmt = connectWithBD.getConnection().createStatement();

     ResultSet rs = stmt.executeQuery("select * from clients ");
     while (rs.next())
        System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

     connectWithBD.closeConnect();
 }
 catch (Exception e) {
     System.out.println(e);
 }


    }
}
