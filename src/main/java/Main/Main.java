package Main;

import ConnectWithBD.ConnectWithBD;
import Model.Client;
import Model.SpisokOfEntity;
import Repository.SearchRepositoryIMPL;
import View.BooksView;
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
        BooksView view = new BooksView();
        view.addBook();

 try(Connection con = ConnectWithBD.getConnection()) {

     stmt = con.createStatement();

     rs = stmt.executeQuery("select * from books ");
     while (rs.next())
        System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + " " + rs.getString(4));

     //connectWithBD.closeConnect();
 }
 catch (Exception e) {
     System.out.println(e);
 }


    }
}
