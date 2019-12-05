package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;
import Services.ReturnAllBooksService;
import View.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static SearchRepositoryIMPL searchTheObject = new SearchRepositoryIMPL();
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) throws ParseException {

//      ReturnAllClientsView returnAllClientsView = new ReturnAllClientsView();
//      returnAllClientsView.returnAllClients();
        ReturnAllBooksView returnAllBooksView = new ReturnAllBooksView();
        returnAllBooksView.returnAllBooks();
// try(Connection con = ConnectWithBD.getConnection()) {
//
//     stmt = con.createStatement();
//
//     rs = stmt.executeQuery("select * from clients");
//     while (rs.next())
//        System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
//
//    // System.out.println(rs);
//     //connectWithBD.closeConnect();
// }
// catch (Exception e) {
//     System.out.println(e);
// }


    }
}
